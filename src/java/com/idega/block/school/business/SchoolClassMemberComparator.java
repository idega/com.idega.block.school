package com.idega.block.school.business;

import java.rmi.RemoteException;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import javax.ejb.FinderException;
import com.idega.block.school.data.SchoolClassMember;
import com.idega.core.location.data.Address;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.Gender;
import com.idega.user.data.GenderHome;
import com.idega.user.data.User;
import com.idega.util.Age;
import com.idega.util.LocaleUtil;

/**
 * @author laddi
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class SchoolClassMemberComparator implements Comparator {

  public static final int NAME_SORT = 1;
  public static final int GENDER_SORT = 2;
  public static final int ADDRESS_SORT = 3;
  public static final int PERSONAL_ID_SORT = 4;
  public static final int LANGUAGE_SORT = 5;
  public static final int AGE_SORT = 6;
  
  private Locale locale;
  private UserBusiness business;
  private Collator collator;
  private Map students;
  private int sortBy = NAME_SORT;
  
  private Comparator genderComparatorForUser = null;
  
  /** 
   * If a special gender comparator is used (e.g. for swedish applications) 
   * */
  static public Comparator getComparatorSortByUseGenderComparator(int sortBy, Comparator genderComparatorForUser, Locale locale, UserBusiness business, Map students) {
  	return new SchoolClassMemberComparator(sortBy, genderComparatorForUser, locale, business, students);
  }  

  /**
   * Depends on defined gender ids (IC_GENDER table).
   * If the table IC_GENDER has no entries the simple gender comparator is taken.
   * AdvancedGenderComparator sorts male first.
   * 
   * @param sortBy
   * @param locale
   * @param business
   * @param students
   * @return
   */
  static public Comparator getComparatorWithGenderComparatorSortBy(int sortBy, Locale locale, UserBusiness business, Map students) {
	  return new SchoolClassMemberComparator(sortBy, getAdvancedGenderComparator(), locale, business, students);
  }
  
  /**
   * Depends NOT on defined gender ids (IC_GENDER table).
   * Works with simple gender comparator.
   * 
   * If genders are defined (that is IC_GENDER has entries) method
   * <code>getInstanceWithGenderComparatorSortBy()</code> should be used.
   * 
   * If genders are not defined use this method.
   * 
   * Since in most cases id for male is "1" and id for female is "2" SimpleGenderComparator sorts male first.
   * 
   * @param sortBy
   * @param locale
   * @param business
   * @param students
   * @return
   */
  static public Comparator getComparatorSortBy(int sortBy, Locale locale, UserBusiness business, Map students) {
	  return new SchoolClassMemberComparator(sortBy, getSimpleGenderComparator(), locale, business, students);
  }
  
  static public Comparator getComparatorSortByName(Locale locale, UserBusiness business, Map students) {
	  return new SchoolClassMemberComparator(NAME_SORT, locale, business, students);
  }  
  
  /**
   * Depends NOT on defined gender ids (IC_GENDER table).
   * Just compares the gender ids that the users have without 
   * checking what id represent female or male. 
   * 
   * In that way it is not clear if female or male comes first (in most cases male id is "1" and female id is "2". 
   * Therefore sorts male first.
   * 
   * @return
   */
  
	static private Comparator getSimpleGenderComparator() {
		return new Comparator() {
		 	public int compare(Object o1, Object o2) {
		 		return ((User) o1).getGenderID() - ((User) o2).getGenderID();
		 	}
		 };
	}

	/**
	 * Depends on the defined gender ids (IC_GENDER table).
	 * If such entries are missing the simple comparator is returned.
	 * 
	 * @return
	 */
	static private Comparator getAdvancedGenderComparator() {
		try {
			return new Comparator() {
				
				private int femaleID = -1;  
				
				{
					init();
				}
					
				public int compare(Object o1, Object o2) {
					boolean isFemale1 = (femaleID == (((User)o1).getGenderID()));
					boolean isFemale2 = (femaleID == ((User)o2).getGenderID());

					if (isFemale1 && !isFemale2) {
						return 1;
					}
					if (!isFemale1 && isFemale2) {
						return -1;
					}
					return 0;
				}
						
				private void init() throws IDOLookupException, FinderException  {
					Gender female = ((GenderHome) IDOLookup.getHome(Gender.class)).getFemaleGender();
					femaleID = ((Integer)female.getPrimaryKey()).intValue();
				}
			};
		}
		catch (IDOLookupException e) {
			System.err.println("[SchoolClassMemberComparator] Could not look up Gender");
			e.printStackTrace(System.err);
		}
		catch (FinderException e) {
			System.err.println("[SchoolClassMemberComparator] Could not find Gender");
			e.printStackTrace(System.err);
		}
		return getSimpleGenderComparator();
	}

	private SchoolClassMemberComparator(int sortBy, Locale locale, UserBusiness business, Map students) {
	  	this.sortBy = sortBy;
	  	this.locale = locale;
	  	this.business = business;
	  	this.students = students;
	}
	
	private SchoolClassMemberComparator(int sortBy, Comparator genderComparator, Locale locale, UserBusiness business, Map students) {
		this(sortBy, locale, business, students);
		this.genderComparatorForUser = (genderComparator == null) ? getAdvancedGenderComparator() : genderComparator;
	}
   
	/**
	 * @see java.util.Comparator#compare(Object, Object)
	 */
	public int compare(Object o1, Object o2) {
		this.collator = Collator.getInstance(this.locale);
		int result = 0;
		
    try {
    	switch (this.sortBy) {
				case NAME_SORT :
					result = nameSort(o1, o2);
					break;
				case GENDER_SORT :
					result = genderSort(o1,o2);
					break;
				case ADDRESS_SORT :
					result = addressSort(o1,o2);
					break;
				case LANGUAGE_SORT :
					result = languageSort(o1,o2);
					break;
				case PERSONAL_ID_SORT :
					result = personalIDSort(o1,o2);
					break;
				case AGE_SORT :
					result = ageSort(o1,o2);
					break;
			}
    }
    catch (RemoteException re) {
    	result = 0;
    }
    
    return result;
	}
	
	public int nameSort(Object o1, Object o2) {
		if (this.locale.equals(LocaleUtil.getIcelandicLocale())) {
			return firstNameSort(o1,o2);
		}
		return lastNameSort(o1,o2);
		
	}
	
	public int lastNameSort(Object o1, Object o2) {
		User p1 = (User) this.students.get(new Integer(((SchoolClassMember)o1).getClassMemberId()));
		User p2 = (User) this.students.get(new Integer(((SchoolClassMember)o2).getClassMemberId()));
		
		// check null values because of corrupt data: user was deleted but not the student
		int nullResult = compareNullValues(p1, p2);
		if (nullResult != 0) {
			return nullResult;
		}
		
		String one = p1.getLastName()!=null?p1.getLastName():"";
		String two = p2.getLastName()!=null?p2.getLastName():"";
		int result = this.collator.compare(one,two);
		
		if (result == 0){
		  one = p1.getFirstName()!=null?p1.getFirstName():"";
		  two = p2.getFirstName()!=null?p2.getFirstName():"";
		  result = this.collator.compare(one,two);
		}

		if (result == 0){
		  //result = p1.getMiddleName().compareTo(p2.getMiddleName());
		  one = p1.getMiddleName()!=null?p1.getMiddleName():"";
		  two = p2.getMiddleName()!=null?p2.getMiddleName():"";
		  result = this.collator.compare(one,two);
		}
		
		return result;
	}	

	public int firstNameSort(Object o1, Object o2) {
		User p1 = (User) this.students.get(new Integer(((SchoolClassMember)o1).getClassMemberId()));
		User p2 = (User) this.students.get(new Integer(((SchoolClassMember)o2).getClassMemberId()));
		
		// check null values because of corrupt data: user was deleted but not the student
		int nullResult = compareNullValues(p1, p2);
		if (nullResult != 0) {
			return nullResult;
		}
		
		String one = p1.getFirstName()!=null?p1.getFirstName():"";
		String two = p2.getFirstName()!=null?p2.getFirstName():"";
		int result = this.collator.compare(one,two);
		
		if (result == 0){
		  //result = p1.getMiddleName().compareTo(p2.getMiddleName());
		  one = p1.getMiddleName()!=null?p1.getMiddleName():"";
		  two = p2.getMiddleName()!=null?p2.getMiddleName():"";
		  result = this.collator.compare(one,two);
		}
		
		if (result == 0){
		  one = p1.getLastName()!=null?p1.getLastName():"";
		  two = p2.getLastName()!=null?p2.getLastName():"";
		  result = this.collator.compare(one,two);
		}

		return result;
	}	

	public int genderSort(Object o1, Object o2) {
		User p1 = (User) this.students.get(new Integer(((SchoolClassMember)o1).getClassMemberId()));
		User p2 = (User) this.students.get(new Integer(((SchoolClassMember)o2).getClassMemberId()));
		
		// check null values because of corrupt data: user was deleted but not the student
		int nullResult = compareNullValues(p1, p2);
		if (nullResult != 0) {
			return nullResult;
		}
		
		int result = this.genderComparatorForUser.compare(p1, p2);
		
		if (result == 0){
			if (this.locale.equals(LocaleUtil.getIcelandicLocale())) {
				result = firstNameSort(o1,o2);
			}
			else {
				result = lastNameSort(o1,o2);
			}
		}
		return result;
	}	

	public int addressSort(Object o1, Object o2) throws RemoteException {
		User u1 = (User) this.students.get(new Integer((((SchoolClassMember)o1).getClassMemberId())));
		User u2 = (User) this.students.get(new Integer((((SchoolClassMember)o2).getClassMemberId())));
		
		// check null values because of corrupt data: user was deleted but not the student
		int nullResult = compareNullValues(u1, u2);
		if (nullResult != 0) {
			return nullResult;
		}
		
		Address p1 = this.business.getUsersMainAddress(u1);
		Address p2 = this.business.getUsersMainAddress(u2);
		
		if (p1 == null || p2 == null) {
			if (p1 == null && p2 != null) {
				return 1;
			}
			else if (p1 != null && p2 == null) {
				return -1;
			}
			return 0;
		}
			
		String one = p1.getStreetAddress()!=null?p1.getStreetAddress():"";
		String two = p2.getStreetAddress()!=null?p2.getStreetAddress():"";
		int result = this.collator.compare(one,two);
				
		return result;
	}	

	public int personalIDSort(Object o1, Object o2) {
		User p1 = (User) this.students.get(new Integer((((SchoolClassMember)o1).getClassMemberId())));
		User p2 = (User) this.students.get(new Integer((((SchoolClassMember)o2).getClassMemberId())));
		
		// check null values because of corrupt data: user was deleted but not the student
		int nullResult = compareNullValues(p1, p2);
		if (nullResult != 0) {
			return nullResult;
		}
		
		String pID1 = p1.getPersonalID() != null ? p1.getPersonalID() : "";
		String pID2 = p2.getPersonalID() != null ? p2.getPersonalID() : "";
		
		return this.collator.compare(pID1,pID2);
	}	

	public int languageSort(Object o1, Object o2) {
		SchoolClassMember p1 = (SchoolClassMember) o1;
		SchoolClassMember p2 = (SchoolClassMember) o2;
		
		// check null values because of corrupt data: user was deleted but not the student
		int nullResult = compareNullValues(p1, p2);
		if (nullResult != 0) {
			return nullResult;
		}
		
		String one = p1.getLanguage()!=null?p1.getLanguage():"";
		String two = p2.getLanguage()!=null?p2.getLanguage():"";
		int result = this.collator.compare(one,two);
				
		if (result == 0){
		  result = lastNameSort(o1,o2);
		}

		return result;
	}	
	
	public int ageSort(Object o1, Object o2) {
		User p1 = (User) this.students.get(new Integer(((SchoolClassMember)o1).getClassMemberId()));
		User p2 = (User) this.students.get(new Integer(((SchoolClassMember)o2).getClassMemberId()));
		
		// check null values because of corrupt data: user was deleted but not the student
		int nullResult = compareNullValues(p1, p2);
		if (nullResult != 0) {
			return nullResult;
		}
		
		Age age1 = new Age(p1.getDateOfBirth());
		Age age2 = new Age(p2.getDateOfBirth());
		
		int result = age1.getYears() - age2.getYears();

		if (result == 0){
		  result = firstNameSort(o1, o2);
		}

		return result;
	}	
	
	// returns 0 if both values are not null, moves null values up
	private int compareNullValues(Object p1, Object p2) {
		if (p1 == null) {
			return 1;
		}
		if (p2 == null) {
			return -1;
		}
		return 0;
	}
}