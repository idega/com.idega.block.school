package com.idega.block.school.data;


import com.idega.data.IDOException;
import com.idega.user.data.Group;
import java.util.Collection;
import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;
import javax.ejb.EJBException;
import com.idega.data.IDOLookupException;

public interface SchoolHome extends IDOHome {

	public School create() throws CreateException;

	public School findByPrimaryKey(Object pk) throws FinderException;

	public Collection findAllBySchoolType(Collection typeIds) throws FinderException;

	public Collection findAllBySchoolType(int typeId) throws FinderException;

	public Collection findAllBySchoolType(SchoolType type) throws FinderException;

	public Collection findAllByAreaTypeManagement(int areaId, int typeId, String managementType) throws FinderException;

	public Collection findAllByAreaTypeManagementCommune(int areaId, int typeId, String managementType, int communeId) throws FinderException;

	public Collection findAllByAreaTypeManagementCommune(int areaId, int typeId, Collection managementTypes, int communeId) throws FinderException;

	public Collection findAllByAreaTypeManagementCommune(int areaId, Collection typeIds, Collection managementTypes, int communeId) throws FinderException;

	public Collection findAllByAreaTypeCommune(int areaId, int typeId, int communeId) throws FinderException;

	public Collection findAllBySchoolName(String schoolName) throws FinderException;

	public School findBySchoolName(String schoolName) throws FinderException;

	public Collection findAllCentralizedAdministrated() throws FinderException;

	public Collection findAllCentralizedAdministratedByType(Collection typeIds) throws FinderException;

	public Collection findAllBySchoolArea(int areaId) throws FinderException;

	public Collection findAllSchools() throws FinderException;

	public Collection findAllSchoolsIncludingTerminated() throws FinderException;

	public Collection findAllSchoolsByCategoryIncludingTerminated(String category) throws FinderException;

	public Collection findAllByAreaAndType(int area, int type) throws FinderException;

	public Collection findAllByInQuery(String inQuery) throws FinderException;

	public Collection findAllByAreaAndTypeAndYear(int areaID, int typeID, int yearID) throws FinderException;

	public Collection findAllByAreaAndTypes(int area, Collection types) throws FinderException;

	public Collection findAllByAreaAndTypesAndYear(int area, Collection types, int yearID) throws FinderException;

	public Collection findAllBySubAreaAndTypes(int subarea, Collection types) throws FinderException;

	public Collection findAllByCategory(SchoolCategory schoolCategory) throws FinderException;

	public Collection findAllInHomeCommuneByCategory(SchoolCategory schoolCategory) throws IDOLookupException, EJBException, FinderException;

	public Collection findAllBySchoolGroup(Group schoolGroup) throws FinderException;

	public int getNumberOfRelations(School school, SchoolYear year) throws IDOException;

	public int getNumberOfFreetimeTypes(int schoolID) throws IDOException;

	public Collection findAllPrivate() throws IDOLookupException, EJBException, FinderException;
}