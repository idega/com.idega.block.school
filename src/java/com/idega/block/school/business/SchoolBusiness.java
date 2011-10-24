package com.idega.block.school.business;


import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.idega.block.school.data.School;
import com.idega.block.school.data.SchoolArea;
import com.idega.block.school.data.SchoolAreaHome;
import com.idega.block.school.data.SchoolCategory;
import com.idega.block.school.data.SchoolCategoryHome;
import com.idega.block.school.data.SchoolClass;
import com.idega.block.school.data.SchoolClassHome;
import com.idega.block.school.data.SchoolClassMember;
import com.idega.block.school.data.SchoolClassMemberHome;
import com.idega.block.school.data.SchoolClassMemberLogHome;
import com.idega.block.school.data.SchoolDepartment;
import com.idega.block.school.data.SchoolDepartmentHome;
import com.idega.block.school.data.SchoolDistrictHome;
import com.idega.block.school.data.SchoolHome;
import com.idega.block.school.data.SchoolManagementTypeHome;
import com.idega.block.school.data.SchoolSeason;
import com.idega.block.school.data.SchoolSeasonHome;
import com.idega.block.school.data.SchoolStudyPath;
import com.idega.block.school.data.SchoolStudyPathHome;
import com.idega.block.school.data.SchoolSubArea;
import com.idega.block.school.data.SchoolSubAreaHome;
import com.idega.block.school.data.SchoolType;
import com.idega.block.school.data.SchoolTypeHome;
import com.idega.block.school.data.SchoolUser;
import com.idega.block.school.data.SchoolYear;
import com.idega.block.school.data.SchoolYearHome;
import com.idega.block.school.data.SchoolYearPlaces;
import com.idega.block.school.data.SchoolYearPlacesHome;
import com.idega.block.school.data.Student;
import com.idega.business.IBOService;
import com.idega.data.IDORemoveRelationshipException;
import com.idega.user.data.Group;
import com.idega.user.data.User;

public interface SchoolBusiness extends IBOService {

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolDepartmentHome
	 */
	public SchoolDepartmentHome getSchoolDepartmentHome() throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolHome
	 */
	public SchoolHome getSchoolHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolClassMemberHome
	 */
	public SchoolClassMemberHome getSchoolClassMemberHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolClassHome
	 */
	public SchoolClassHome getSchoolClassHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolAreaHome
	 */
	public SchoolAreaHome getSchoolAreaHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolTypeHome
	 */
	public SchoolTypeHome getSchoolTypeHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolCategoryHome
	 */
	public SchoolCategoryHome getSchoolCategoryHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolSeasonHome
	 */
	public SchoolSeasonHome getSchoolSeasonHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolStudyPathHome
	 */
	public SchoolStudyPathHome getSchoolStudyPathHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolDistrictHome
	 */
	public SchoolDistrictHome getSchoolDistrictHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolManagementTypeHome
	 */
	public SchoolManagementTypeHome getSchoolManagementTypeHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getStudent
	 */
	public Student getStudent(User student) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getDepartments
	 */
	public Collection getDepartments(School school) throws RemoteException, FinderException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getDepartmentID
	 */
	public int getDepartmentID(SchoolDepartment schDepm) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeDepartment
	 */
	public void removeDepartment(SchoolDepartment schDep) throws RemoveException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#addSchoolUsr
	 */
	public void addSchoolUsr(int schDep_id, SchoolUser schUser) throws FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolUsr
	 */
	public void removeSchoolUsr(int schDep_id, SchoolUser schUser) throws FinderException, RemoteException, IDORemoveRelationshipException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolCategories
	 */
	public Collection getSchoolCategories() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolCategories
	 */
	public Collection getSchoolCategories(School school) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCategoryMusicSchool
	 */
	public SchoolCategory getCategoryMusicSchool() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCategoryAfterSchoolCare
	 */
	public SchoolCategory getCategoryAfterSchoolCare() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCategoryChildcare
	 */
	public SchoolCategory getCategoryChildcare() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCategoryElementarySchool
	 */
	public SchoolCategory getCategoryElementarySchool() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCategoryHighSchool
	 */
	public SchoolCategory getCategoryHighSchool() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCategoryCollege
	 */
	public SchoolCategory getCategoryCollege() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCategoryUniversity
	 */
	public SchoolCategory getCategoryUniversity() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCategoryAdultEducation
	 */
	public SchoolCategory getCategoryAdultEducation() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolManagementTypes
	 */
	public Collection getSchoolManagementTypes() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchool
	 */
	public School getSchool(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolStudyPath
	 */
	public SchoolStudyPath getSchoolStudyPath(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeProvider
	 */
	public void removeProvider(int id) throws RemoveException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeProvider
	 */
	public void removeProvider(Object primaryKey) throws RemoveException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchool
	 */
	public void removeSchool(int id) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchools
	 */
	public Collection findAllSchools() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByAreaAndType
	 */
	public Collection findAllSchoolsByAreaAndType(int area, int type) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByAreaAndTypeAndYear
	 */
	public Collection findAllSchoolsByAreaAndTypeAndYear(int areaID, int typeID, int yearID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByAreaAndTypes
	 */
	public Collection findAllSchoolsByAreaAndTypes(int area, Collection types) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsBySubAreaAndTypes
	 */
	public Collection findAllSchoolsBySubAreaAndTypes(int subarea, Collection types) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllCentralizedAdministrated
	 */
	public Collection findAllCentralizedAdministrated() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllCentralizedAdministratedByType
	 */
	public Collection findAllCentralizedAdministratedByType(Collection typeIds) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#createSchool
	 */
	public School createSchool(String name, String address, String zipcode, String ziparea, String phone, int school_type, Object communePK) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#createSchool
	 */
	public School createSchool(String name, String address, String zipcode, String ziparea, String phone, int area_id, int[] sch_types, Object communePK) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#createSchool
	 */
	public School createSchool(String name, String info, String address, String zipcode, String ziparea, String phone, String keycode, String latitude, String longitude, int area_id, int[] type_ids, Object communePK) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#createSchool
	 */
	public School createSchool(String name, String info, String address, String zipcode, String ziparea, String phone, String keycode, String latitude, String longitude, int area_id, int[] type_ids, int[] year_ids, Object communePK) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchool
	 */
	public School storeSchool(int id, String name, String info, String address, String zipcode, String ziparea, String phone, String keycode, String latitude, String longitude, int area_id, int[] type_ids, int[] year_ids, Object communePK) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchool
	 */
	public School storeSchool(int id, String name, String info, String address, String zipcode, String ziparea, String phone, String keycode, String latitude, String longitude, int area_id, int[] type_ids, int[] year_ids, Object communePK, String providerStringId) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchool
	 */
	public School storeSchool(int id, String name, String info, String address, String zipcode, String ziparea, String phone, String keycode, String latitude, String longitude, int area_id, int sub_area_id, int[] type_ids, int[] year_ids, String organizationNumber, String extraProviderId, String managementTypeId, Date terminationDate, Object communePK, int countryId, Boolean centralizedAdministration, Boolean invisibleForCitizen) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchool
	 */
	public School storeSchool(int id, String name, String info, String address, String zipcode, String ziparea, String phone, String keycode, String latitude, String longitude, int area_id, int sub_area_id, int[] type_ids, int[] year_ids, String organizationNumber, String extraProviderId, String managementTypeId, Date terminationDate, Object communePK, int countryId, Boolean centralizedAdministration, Boolean invisibleForCitizen, String providerStringId) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchool
	 */
	public School storeSchool(int id, String name, String info, String address, String zipcode, String ziparea, String phone, String keycode, String latitude, String longitude, int area_id, int sub_area_id, int[] type_ids, int[] year_ids, String organizationNumber, String extraProviderId, String managementTypeId, Date terminationDate, Object communePK, int countryId, Boolean centralizedAdministration, Boolean invisibleForCitizen, String providerStringId, Boolean sortByBirthdate) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolRelatedSchoolTypes
	 */
	public Map getSchoolRelatedSchoolTypes(School school) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolRelatedSchoolYears
	 */
	public Map getSchoolRelatedSchoolYears(School school) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolAndSchoolTypeRelatedSchoolCourses
	 */
	public Map getSchoolAndSchoolTypeRelatedSchoolCourses(School school, Object schoolTypeId) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getMapOfSchools
	 */
	public Map getMapOfSchools() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getNewSchoolGroup
	 */
	public Group getNewSchoolGroup(String name, String info) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootSchoolCategoryGroup
	 */
	public Group getRootSchoolCategoryGroup(SchoolCategory category) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#hasEditPermission
	 */
	public boolean hasEditPermission(User user, School school) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolGroups
	 */
	public Collection getSchoolGroups(User user) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClass
	 */
	public SchoolClass storeSchoolClass(String schoolClassName, School school, SchoolYear year, SchoolSeason season) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMember
	 */
	public SchoolClassMember storeSchoolClassMember(SchoolClass sClass, User user) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchClMemberInvoiceIntervalTypes
	 */
	public Collection findAllSchClMemberInvoiceIntervalTypes() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getAssistantHeadmasters
	 */
	public Collection getAssistantHeadmasters(School school) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolUsers
	 */
	public Collection getSchoolUsers(School school) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getAllSchoolUsers
	 */
	public Collection getAllSchoolUsers(School school) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getHeadmasters
	 */
	public Collection getHeadmasters(School school) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getHeadmaster
	 */
	public User getHeadmaster(int schoolID) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#addHeadmaster
	 */
	public void addHeadmaster(School school, User user) throws RemoteException, FinderException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByType
	 */
	public Collection findAllSchoolsByType(Collection typeIds) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByType
	 */
	public Collection findAllSchoolsByType(int type) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByTypeDWR
	 */
	public Collection findAllSchoolsByTypeDWR(String type) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByTypeDWR
	 */
	public Collection findAllGroupsBySchoolDWR(String type) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByType
	 */
	public Collection findAllSchoolsByType(SchoolType type) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolYearsInSchool
	 */
	public Collection findAllSchoolYearsInSchool(int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootSchoolAdministratorGroup
	 */
	public Group getRootSchoolAdministratorGroup() throws CreateException, FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootHighSchoolAdministratorGroup
	 */
	public Group getRootHighSchoolAdministratorGroup() throws CreateException, FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootMusicSchoolAdministratorGroup
	 */
	public Group getRootMusicSchoolAdministratorGroup() throws CreateException, FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootProviderAdministratorGroup
	 */
	public Group getRootProviderAdministratorGroup() throws CreateException, FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootSchoolOtherCommuneAdministratorGroup
	 */
	public Group getRootSchoolOtherCommuneAdministratorGroup() throws CreateException, FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootHighSchoolOtherCommuneAdministratorGroup
	 */
	public Group getRootHighSchoolOtherCommuneAdministratorGroup() throws CreateException, FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootProviderOtherCommuneAdministratorGroup
	 */
	public Group getRootProviderOtherCommuneAdministratorGroup() throws CreateException, FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getPropertyValue
	 */
	public String getPropertyValue(String propertyName) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#setProperty
	 */
	public void setProperty(String propertyName, String propertyValue) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getRootAdultEducationAdministratorGroup
	 */
	public Group getRootAdultEducationAdministratorGroup() throws CreateException, FinderException, RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#addSchoolAdministrator
	 */
	public void addSchoolAdministrator(User user) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolYearPlaces
	 */
	public SchoolYearPlaces getSchoolYearPlaces(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolYearPlace
	 */
	public void removeSchoolYearPlace(int id) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolYearPlaces
	 */
	public Collection findAllSchoolYearPlaces(int iSchoolId) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getMapOfSchoolYearPlaces
	 */
	public Map getMapOfSchoolYearPlaces(int iSchoolId) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolYearPlacesHome
	 */
	public SchoolYearPlacesHome getSchoolYearPlacesHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolYearPlaces
	 */
	public void storeSchoolYearPlaces(int id, int school_id, int school_year_id, int places) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolYear
	 */
	public SchoolYear getSchoolYear(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolYear
	 */
	public void removeSchoolYear(int id) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolYear
	 */
	public void removeSchoolYear(Object schoolYearPK) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolYears
	 */
	public Collection findAllSchoolYears() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolYearsBySchoolType
	 */
	public Collection findAllSchoolYearsBySchoolType(int schoolTypeId) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolYearsBySchoolCategory
	 */
	public Collection findSchoolYearsBySchoolCategory(String schoolCategory) throws FinderException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolYearsByAge
	 */
	public Collection findAllSchoolYearsByAge(int age) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolYear
	 */
	public void storeSchoolYear(int pk, String name, int schoolTypeId, String category, String info, String localizedKey, int age) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolYearHome
	 */
	public SchoolYearHome getSchoolYearHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolType
	 */
	public SchoolType getSchoolType(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolTypesForCategory
	 */
	public Collection getSchoolTypesForCategory(SchoolCategory category, boolean showFreetimeTypes) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolType
	 */
	public void removeSchoolType(int id) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolType
	 */
	public void removeSchoolType(Object schoolTypePK) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolTypes
	 */
	public Collection<SchoolType> findAllSchoolTypes() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolTypesInCategory
	 */
	public Collection<SchoolType> findAllSchoolTypesInCategory(String category) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolTypesInCategory
	 */
	public Collection<SchoolType> findAllSchoolTypesInCategory(String Category, boolean showFreetimeTypes) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolTypesInCategoryFreeTime
	 */
	public Collection<SchoolType> findAllSchoolTypesInCategoryFreeTime(String Category) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getAfterSchoolCareSchoolCategory
	 */
	public String getAfterSchoolCareSchoolCategory() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getChildCareSchoolCategory
	 */
	public String getChildCareSchoolCategory() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getElementarySchoolSchoolCategory
	 */
	public String getElementarySchoolSchoolCategory() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getAdultEducationSchoolCategory
	 */
	public String getAdultEducationSchoolCategory() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getHighSchoolSchoolCategory
	 */
	public String getHighSchoolSchoolCategory() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolTypesForChildCare
	 */
	public Collection findAllSchoolTypesForChildCare() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolTypesForSchool
	 */
	public Collection findAllSchoolTypesForSchool() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolTypesForAdultEducation
	 */
	public Collection findAllSchoolTypesForAdultEducation() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolType
	 */
	public void storeSchoolType(int id, String name, String info, String category, String locKey, int maxAge, boolean isFreetimeType, boolean isFamilyFreetimeType, int order) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolType
	 */
	public void storeSchoolType(int id, String name, String info, String category, String locKey, int maxAge, boolean isFreetimeType, boolean isFamilyFreetimeType, int order, String typeStringId) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolSeason
	 */
	public SchoolSeason getSchoolSeason(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getCurrentSchoolSeason
	 */
	public SchoolSeason getCurrentSchoolSeason(SchoolCategory category) throws FinderException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getNextSchoolSeason
	 */
	public SchoolSeason getNextSchoolSeason(SchoolCategory category) throws FinderException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolSeason
	 */
	public void removeSchoolSeason(int id) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolSeason
	 */
	public void removeSchoolSeason(Object schoolSeasonPK) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolSeasons
	 */
	public Collection findAllSchoolSeasons() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolSeasons
	 */
	public Collection findAllSchoolSeasons(String schoolCategory) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolSeasons
	 */
	public Collection findAllSchoolSeasons(SchoolCategory category) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllCurrentSeasons
	 */
	public Collection findAllCurrentSeasons(SchoolCategory category) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllPreviousSchoolSeasons
	 */
	public Collection findAllPreviousSchoolSeasons(SchoolSeason schoolSeason) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllPreviousSchoolSeasons
	 */
	public Collection findAllPreviousSchoolSeasons(int schoolSeasonID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findPreviousSchoolSeason
	 */
	public SchoolSeason findPreviousSchoolSeason(int schoolSeasonID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolSeason
	 */
	public SchoolSeason storeSchoolSeason(int id, String name, Date start, Date end, Date choiceStartDate, Date choiceEndDate, String category, int externalID) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findClassMemberInClass
	 */
	public SchoolClassMember findClassMemberInClass(int studentID, int schoolClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findByStudentAndSeason
	 */
	public SchoolClassMember findByStudentAndSeason(int userID, int seasonID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findByStudentAndSchoolAndSeason
	 */
	public SchoolClassMember findByStudentAndSchoolAndSeason(int userID, int schoolID, int seasonID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findByStudentAndSeason
	 */
	public SchoolClassMember findByStudentAndSeason(User user, SchoolSeason season) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findByStudentAndSeason
	 */
	public SchoolClassMember findByStudentAndSeason(SchoolClassMember student, SchoolSeason season) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findClassMember
	 */
	public Collection findClassMember(int studentID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSubGroupPlacements
	 */
	public Collection findSubGroupPlacements(int studentID, int schoolID, int seasonID) throws FinderException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findClassMemberInSchool
	 */
	public Collection findClassMemberInSchool(int studentID, int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findClassMemberInAdultEducation
	 */
	public Collection findClassMemberInAdultEducation(int studentID, int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findClassMemberInChildCare
	 */
	public Collection findClassMemberInChildCare(int studentID, int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsInClass
	 */
	public Collection findStudentsInClass(int studentClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsInClassAndYear
	 */
	public Collection findStudentsInClassAndYear(int studentClassID, int schoolYearID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsInSchool
	 */
	public Collection findStudentsInSchool(int schoolID, int schoolClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolByDate
	 */
	public Collection findSchoolByDate(int schoolID, int schoolClassID, Date date) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsInSchoolByDate
	 */
	public Collection findStudentsInSchoolByDate(int schoolID, int schoolClassID, Date date, boolean showNotYetActive) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsInSchoolByDate
	 */
	public Collection findStudentsInSchoolByDate(int schoolID, int schoolClassID, String schoolCategory, Date date, boolean showNotYetActive) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsInSchoolByDateChildcare
	 */
	public Collection findStudentsInSchoolByDateChildcare(int schoolID, int schoolClassID, String schoolCategory, Date date, boolean showNotYetActive) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsInSchoolByDate
	 */
	public Collection findStudentsInSchoolByDate(int schoolID, int schoolClassID, Date date) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsInSchoolByDate
	 */
	public Collection findStudentsInSchoolByDate(int schoolID, int schoolClassID, String schoolCategory, Date date) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassMember
	 */
	public SchoolClassMember findSchoolClassMember(int userID, int schoolClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsBySchoolAndSeasonAndYear
	 */
	public Collection findStudentsBySchoolAndSeasonAndYear(int schoolID, int seasonID, int yearID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsBySchoolAndSeasonAndYear
	 */
	public Collection findStudentsBySchoolAndSeasonAndYear(School school, SchoolSeason season, SchoolYear year) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findStudentsBySchoolAndSeason
	 */
	public Collection findStudentsBySchoolAndSeason(int schoolID, int seasonID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolClassMemberFromClass
	 */
	public void removeSchoolClassMemberFromClass(int studentID, int schoolClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolClassMember
	 */
	public void removeSchoolClassMember(int studentID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolTypeIdFromSchoolClass
	 */
	public int getSchoolTypeIdFromSchoolClass(int schoolClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMemberCC
	 */
	public SchoolClassMember storeSchoolClassMemberCC(int studentID, int schoolClassID, int schoolTypeID, Timestamp registerDate, int registrator) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMemberCC
	 */
	public SchoolClassMember storeSchoolClassMemberCC(int studentID, int schoolClassID, int schoolTypeID, Timestamp registerDate, int registrator, String notes) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMemberCC
	 */
	public SchoolClassMember storeSchoolClassMemberCC(int studentID, int schoolClassID, int schoolTypeID, Timestamp registerDate, Timestamp removedDate, int registrator, String notes) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMember
	 */
	public SchoolClassMember storeSchoolClassMember(int studentID, int schoolClassID, int schoolYearID, int schoolTypeID, Timestamp registerDate, int registrator) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMember
	 */
	public SchoolClassMember storeSchoolClassMember(int studentID, int schoolClassID, int schoolYearID, int schoolTypeID, Timestamp registerDate, int registrator, int studyPathID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMember
	 */
	public SchoolClassMember storeSchoolClassMember(int studentID, int schoolClassID, int schoolYearID, int schoolTypeID, Timestamp registerDate, int registrator, String notes) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMember
	 */
	public SchoolClassMember storeSchoolClassMember(int studentID, int schoolClassID, int schoolYearID, int schoolTypeID, Timestamp registerDate, Timestamp removedDate, int registrator, String notes) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMember
	 */
	public SchoolClassMember storeSchoolClassMember(int studentID, int schoolClassID, int schoolYearID, int schoolTypeID, Timestamp registerDate, Timestamp removedDate, int registrator, String notes, String language) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClassMember
	 */
	public SchoolClassMember storeSchoolClassMember(int studentID, int schoolClassID, int schoolYearID, int schoolTypeID, Timestamp registerDate, Timestamp removedDate, int registrator, String notes, String language, int studyPathID, int handicraftId) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeNewSchoolClassMember
	 */
	public SchoolClassMember storeNewSchoolClassMember(int studentID, int schoolClassID, int schoolYearID, int schoolTypeID, Timestamp registerDate, int registrator, String notes, String languageID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeNewSchoolClassMember
	 */
	public SchoolClassMember storeNewSchoolClassMember(int studentID, int schoolClassID, int schoolYearID, int schoolTypeID, Timestamp registerDate, Timestamp removedDate, int registrator, String notes, String sLanguage) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClass
	 */
	public SchoolClass findSchoolClass(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchool
	 */
	public Collection findSchoolClassesBySchool(int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndCategory
	 */
	public Collection findSchoolClassesBySchoolAndCategory(int schoolID, String category) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findElementarySchoolClassesBySchool
	 */
	public Collection findElementarySchoolClassesBySchool(int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findChildcareClassesBySchool
	 */
	public Collection findChildcareClassesBySchool(int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAfterschoolClassesBySchool
	 */
	public Collection findAfterschoolClassesBySchool(int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndSeason
	 */
	public Collection findSchoolClassesBySchoolAndSeason(int schoolID, int schoolSeasonID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndYear
	 */
	public Collection findSchoolClassesBySchoolAndYear(int schoolID, int schoolYearID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndSeasonAndYear
	 */
	public Collection findSchoolClassesBySchoolAndSeasonAndYear(int schoolID, int schoolSeasonID, int schoolYearID, boolean showSubGroups) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndSchoolTypeAndSeason
	 */
	public Collection findSchoolClassesBySchoolAndSchoolTypeAndSeason(int schoolID, int schoolTypeID, int schoolSeasonID, Boolean showSubGroups, Boolean showNonSeasonGroups) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndSeasonAndYear
	 */
	public Collection findSchoolClassesBySchoolAndSeasonAndYear(int schoolID, int schoolSeasonID, int schoolYearID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndSeasonAndYearAndStudyPath
	 */
	public Collection findSchoolClassesBySchoolAndSeasonAndYearAndStudyPath(int schoolID, int schoolSeasonID, int schoolYearID, int studyPathID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndSeasonAndYears
	 */
	public Collection findSchoolClassesBySchoolAndSeasonAndYears(int schoolID, int schoolSeasonID, String[] schoolYearIDs) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndSeasonAndYears
	 */
	public Collection findSchoolClassesBySchoolAndSeasonAndYears(int schoolID, int schoolSeasonID, String[] schoolYearIDs, boolean showSubGroups) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesByTeacher
	 */
	public Collection findSchoolClassesByTeacher(int teacherID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSubGroupPlacements
	 */
	public Collection findSubGroupPlacements(SchoolClass group) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndTeacher
	 */
	public Collection findSchoolClassesBySchoolAndTeacher(int schoolID, int teacherID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findSchoolClassesBySchoolAndSeasonAndTeacher
	 */
	public Collection findSchoolClassesBySchoolAndSeasonAndTeacher(int schoolID, int schoolSeasonID, int teacherID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getNumberOfStudentsInClass
	 */
	public int getNumberOfStudentsInClass(int schoolClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolClass
	 */
	public void removeSchoolClass(int schoolClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#invalidateSchoolClass
	 */
	public void invalidateSchoolClass(int schoolClassID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClass
	 */
	public SchoolClass storeSchoolClass(int schoolClassID, String className, int schoolID, int schoolTypeID, int seasonID, String[] schoolYearIDs, String[] teacherIDs) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClass
	 */
	public SchoolClass storeSchoolClass(int schoolClassID, String className, int schoolID, int schoolTypeID, int seasonID, String[] schoolYearIDs, String[] teacherIDs, String[] studyPathIDs) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClass
	 */
	public SchoolClass storeSchoolClass(int schoolClassID, String className, int schoolID, int schoolTypeID, int seasonID, String[] schoolYearIDs, String[] teacherIDs, String[] studyPathIDs, String groupStringId) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolClass
	 */
	public SchoolClass storeSchoolClass(int schoolClassID, String className, int schoolID, int schoolSeasonID, int schoolYearID, int teacherID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolArea
	 */
	public SchoolArea getSchoolArea(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolSubArea
	 */
	public SchoolSubArea getSchoolSubArea(Object primaryKey) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolArea
	 */
	public void removeSchoolArea(int id) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolArea
	 */
	public void removeSchoolArea(Object schoolAreaPK) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#removeSchoolSubArea
	 */
	public void removeSchoolSubArea(int id) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolAreas
	 */
	public Collection findAllSchoolAreas(SchoolCategory category) throws RemoteException;

	public Collection<SchoolArea> findAllSchoolAreasByType(int type) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolSubAreas
	 */
	public Collection findAllSchoolSubAreas() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolArea
	 */
	public void storeSchoolArea(int id, String name, String info, String city, String accountingKey, SchoolCategory category) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolSubArea
	 */
	public void storeSchoolSubArea(int id, String name, int areaid) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#storeSchoolDepartment
	 */
	public void storeSchoolDepartment(String description, String phone, int schoolID, int schDepID) throws RemoteException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolUserBusiness
	 */
	public SchoolUserBusiness getSchoolUserBusiness() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#hasSchoolRelationToYear
	 */
	public boolean hasSchoolRelationToYear(School school, SchoolYear schoolYear) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#hasAfterSchoolActivities
	 */
	public boolean hasAfterSchoolActivities(int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#hasSchoolPlacements
	 */
	public boolean hasSchoolPlacements(int userID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#hasGroupPlacement
	 */
	public boolean hasGroupPlacement(int userID, int groupID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#hasGroupPlacement
	 */
	public boolean hasGroupPlacement(int userID, int groupID, boolean isSubGroup) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolPhone
	 */
	public String getSchoolPhone(int schoolID) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getHomeCommuneSchools
	 */
	public Collection getHomeCommuneSchools(Collection schools) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolsByCategory
	 */
	public Collection findAllSchoolsByCategory(String categoryString) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getProperty
	 */
	public String getProperty(School school, String propertyName) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#setProperty
	 */
	public void setProperty(School school, String propertyName, String propertyValue) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolSubAreasByArea
	 */
	public Collection findAllSchoolSubAreasByArea(String area) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolClassMemberLogHome
	 */
	public SchoolClassMemberLogHome getSchoolClassMemberLogHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#getSchoolSubAreaHome
	 */
	public SchoolSubAreaHome getSchoolSubAreaHome() throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#addToSchoolClassMemberLog
	 */
	public void addToSchoolClassMemberLog(SchoolClassMember member, Date endDate, User performer) throws IllegalArgumentException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#addToSchoolClassMemberLog
	 */
	public void addToSchoolClassMemberLog(SchoolClassMember member, SchoolClass schoolClass, Date endDate, User performer) throws IllegalArgumentException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#addToSchoolClassMemberLog
	 */
	public void addToSchoolClassMemberLog(int schoolClassMemberID, int schoolClassID, Date startDate, Date endDate, User performer) throws IllegalArgumentException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#addToSchoolClassMemberLog
	 */
	public void addToSchoolClassMemberLog(SchoolClassMember member, SchoolClass schoolClass, Date startDate, Date endDate, User performer) throws IllegalArgumentException, RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#hasActivePlacement
	 */
	public boolean hasActivePlacement(int studentId, int schoolId, SchoolCategory category) throws RemoteException;

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#alignLogs
	 */
	public void alignLogs(SchoolClassMember member) throws RemoteException;

	public Collection<SchoolArea> getAllSchoolAreas();

	/**
	 * @see com.idega.block.school.business.SchoolBusinessBean#findAllSchoolAreasByTypes
	 */
	public Collection<SchoolArea> findAllSchoolAreasByTypes(Collection<SchoolType> types) throws RemoteException;

}