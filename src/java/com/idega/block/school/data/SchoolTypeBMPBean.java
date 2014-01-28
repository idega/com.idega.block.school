package com.idega.block.school.data;

import is.idega.idegaweb.egov.course.data.CourseProviderType;
import is.idega.idegaweb.egov.course.data.CourseProviderTypeBMPBean;
import is.idega.idegaweb.egov.course.data.CourseProviderTypeHome;

import java.util.Collection;
import java.util.logging.Level;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.data.IDOStoreException;
import com.idega.data.query.MatchCriteria;
import com.idega.data.query.OR;
import com.idega.data.query.SelectQuery;
import com.idega.data.query.Table;
import com.idega.data.query.WildCardColumn;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      idega.is
 * @author 2002 - idega team - <br><a href="mailto:aron@idega.is">Aron Birkir</a><br>
 * @version 1.0
 */

public class SchoolTypeBMPBean extends CourseProviderTypeBMPBean implements SchoolType {

  public static final String INFO = "type_info";
  public static final String SCHOOLTYPE = "sch_school_type";
  public static final String MAXSCHOOLAGE = "max_school_age";
	public static final String IS_FREETIME_TYPE = "is_freetime_type";
	public static final String IS_FAMILY_FREETIME_TYPE = "is_family_freetime_type";
	public static final String IS_SELECTABLE = "is_selectable";
	public static final String ORDER = "type_order";
	public static final String TYPE_STRING_ID = "type_string_id";

  public void initializeAttributes() {
    this.addAttribute(getIDColumnName());
    this.addAttribute(COLUMN_NAME,"Schooltype",true,true,String.class);
    this.addAttribute(INFO,"Info",true,true,String.class);
    this.addAttribute(MAXSCHOOLAGE,"Max school age",true,true,Integer.class);
    this.addAttribute(COLUMN_LOC_KEY,"Localization key",String.class);
		this.addAttribute(IS_FREETIME_TYPE,"Is freetime type",Boolean.class);
		this.addAttribute(IS_FAMILY_FREETIME_TYPE,"Is freetime type",Boolean.class);
		this.addAttribute(IS_SELECTABLE,"Is selectable",Boolean.class);
		this.addAttribute(ORDER,"Order",true,true,Integer.class);
		this.addAttribute(TYPE_STRING_ID,"Extra school type ID",true,true,String.class);
    
    addManyToOneRelationship(COLUMN_SCHOOL_CATEGORY, SchoolCategory.class);
    getEntityDefinition().setBeanCachingActiveByDefault(true);
  }

  public String getEntityName() {
    return SCHOOLTYPE;
  }

  public String getName(){
    return getSchoolTypeName();
  }

   public void setSchoolTypeInfo(String info){
    setColumn(INFO,info);
  }

  public String getSchoolTypeInfo(){
    return getStringColumnValue(INFO);
  }

  public SchoolCategory getCategory(){
	  return (SchoolCategory) getColumnValue(COLUMN_SCHOOL_CATEGORY);
  }
  public int getMaxSchoolAge(){
    return getIntColumnValue(MAXSCHOOLAGE);
  }

  public void setMaxSchoolAge(int maxAge){
    setColumn(MAXSCHOOLAGE,maxAge);
  }
  
  public boolean getIsFreetimeType() {
  	return getBooleanColumnValue(IS_FREETIME_TYPE, false);
  }
  
  public void setIsFreetimeType(boolean isFreetimeType) {
  	setColumn(IS_FREETIME_TYPE, isFreetimeType);
  }

  public boolean isSelectable() {
  		return getBooleanColumnValue(IS_SELECTABLE, false);
  }
  
  public void setSelectable(boolean isSelectable) {
  		setColumn(IS_SELECTABLE, isSelectable);
  }

  public boolean getIsFamilyFreetimeType() {
  	return getBooleanColumnValue(IS_FAMILY_FREETIME_TYPE, false);
  }

	@Override
	public String getSchoolCategory() {
		return getStringColumnValue(COLUMN_SCHOOL_CATEGORY);
	}

	@Override
	public void setSchoolCategory(String category) {
		setColumn(COLUMN_SCHOOL_CATEGORY, category);
	}
  
  public void setIsFamilyFreetimeType(boolean isFamilyFreetimeType) {
  	setColumn(IS_FAMILY_FREETIME_TYPE, isFamilyFreetimeType);
  }

  public int getOrder(){
		return getIntColumnValue(ORDER);
	}

	public void setOrder(int order){
		setColumn(ORDER,order);
	}

	public String getTypeStringId(){
		return getStringColumnValue(TYPE_STRING_ID);
	}

	public void setTypeStringId(String typeStringId){
		setColumn(TYPE_STRING_ID, typeStringId);
	}

	public Collection ejbFindAllByCategory(String category, boolean showFreetimeTypes) throws javax.ejb.FinderException {
	    Table table = new Table(this);
	    SelectQuery query = new SelectQuery(table);
	    query.addColumn(new WildCardColumn());
	    query.addCriteria(new MatchCriteria(table,COLUMN_SCHOOL_CATEGORY,MatchCriteria.EQUALS,category,true));
	    if(!showFreetimeTypes){
	        query.addCriteria(new OR(new MatchCriteria(table,IS_FREETIME_TYPE,MatchCriteria.EQUALS,false),new MatchCriteria(table,IS_FREETIME_TYPE,MatchCriteria.IS,MatchCriteria.NULL)));
	    }
	    return super.idoFindPKsByQuery(query);
	    /*
		IDOQuery query = this.idoQueryGetSelect();
		query.appendWhereEqualsQuoted(SCHOOLCATEGORY,category);
		if (!showFreetimeTypes) {
			query.appendAnd().appendLeftParenthesis().appendEquals(IS_FREETIME_TYPE, false).appendOr().append(IS_FREETIME_TYPE).appendIsNull().appendRightParenthesis();
		}
		return super.idoFindPKsByQuery(query);*/
	}
  
  /**
	 *	Finds one SchoolType from a typeString.
	 *	@throws javax.ejb.FinderException if no SchoolType is found.	
	 */
public Integer ejbFindByTypeString(String typeString) throws javax.ejb.FinderException{
    Table table = new Table(this);
	  SelectQuery query = new SelectQuery(table);
	  query.addColumn(new WildCardColumn());
	  query.addCriteria(new MatchCriteria(table,TYPE_STRING_ID,MatchCriteria.EQUALS,typeString,true));
	  return (Integer)super.idoFindOnePKByQuery(query);
}
  
  public Collection ejbFindAllFreetimeTypes() throws FinderException {
      Table table = new Table(this);
	  SelectQuery query = new SelectQuery(table);
	  query.addColumn(new WildCardColumn());
	  query.addCriteria(new MatchCriteria(table,IS_FREETIME_TYPE,MatchCriteria.EQUALS,true));
  	  return idoFindPKsByQuery(query);
  }
  public Collection ejbFindAllFreetimeTypes(String category) throws FinderException {
  	Table table = new Table(this);
  	SelectQuery query = new SelectQuery(table);
  	query.addColumn(new WildCardColumn());
  	query.addCriteria(new MatchCriteria(table,IS_FREETIME_TYPE,MatchCriteria.EQUALS,true));
  	query.addCriteria(new MatchCriteria(table,COLUMN_SCHOOL_CATEGORY,MatchCriteria.EQUALS,category));
  	return idoFindPKsByQuery(query);
  }

	@Override
	public void store() throws IDOStoreException {
		super.store();
		Object primaryKey = getPrimaryKey();
		if (primaryKey != null) {
			getCourseProviderTypeHome().update(primaryKey.toString(),
					getSchoolTypeName(), getLocalizationKey(), getCategory());
		}
	}

	@Override
	public void remove() throws RemoveException {
		super.remove();
		getCourseProviderTypeHome().remove(getPrimaryKey());
	}
  
	private CourseProviderTypeHome courseProviderTypeHome = null;

	protected CourseProviderTypeHome getCourseProviderTypeHome() {
		if (this.courseProviderTypeHome == null) {
			try {
				this.courseProviderTypeHome = (CourseProviderTypeHome) IDOLookup
						.getHome(CourseProviderType.class);
			} catch (IDOLookupException e) {
				java.util.logging.Logger.getLogger(getClass().getName()).log(
						Level.WARNING,
						"Failed to get "
								+ CourseProviderTypeHome.class.getSimpleName()
								+ " cause of: ", e);
			}
		}

		return this.courseProviderTypeHome;
	}
}