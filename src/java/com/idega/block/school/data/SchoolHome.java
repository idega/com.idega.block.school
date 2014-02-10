package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProvider;
import is.idega.idegaweb.egov.course.data.CourseProviderHome;

import java.util.Collection;
import java.util.Collections;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;

import com.idega.core.location.data.PostalCode;
import com.idega.data.IDOException;
import com.idega.data.IDOLookupException;

public interface SchoolHome extends CourseProviderHome {
	public School create() throws CreateException;

	public School findByPrimaryKey(Object pk) throws FinderException;

	public <P extends CourseProvider> Collection<P> findAllBySchoolType(Collection typeIds) throws FinderException;

	public Collection findAllBySchoolType(int typeId) throws FinderException;

	public Collection findAllBySchoolType(SchoolType type)
			throws FinderException;

	public Collection findAllByAreaTypeManagement(int areaId, int typeId,
			String managementType) throws FinderException;

	public Collection findAllByAreaTypeManagementCommune(int areaId,
			int typeId, String managementType, int communeId)
			throws FinderException;

	public Collection findAllByAreaTypeManagementCommune(int areaId,
			int typeId, Collection managementTypes, int communeId)
			throws FinderException;

	public Collection findAllByAreaTypeManagementCommune(int areaId,
			Collection typeIds, Collection managementTypes, int communeId)
			throws FinderException;

	public Collection findAllByAreaTypeCommune(int areaId, int typeId,
			int communeId) throws FinderException;

	public Collection findAllBySchoolName(String schoolName)
			throws FinderException;

	public School findBySchoolName(String schoolName) throws FinderException;

	public School findByOrganizationNumber(String organizationNumber)
			throws FinderException;

	public Collection findAllCentralizedAdministrated() throws FinderException;

	public Collection findAllCentralizedAdministratedByType(Collection typeIds)
			throws FinderException;

	public Collection findAllByHandicapParameter(boolean hasHandicap)
			throws FinderException;

	public Collection findAllBySchoolArea(int areaId) throws FinderException;

	public Collection<School> findAllSchools() throws FinderException;

	public Collection findAllSchoolsIncludingTerminated()
			throws FinderException;

	public Collection findAllSchoolsByCategoryIncludingTerminated(
			String category) throws FinderException;

	public Collection findAllByAreaAndType(int area, int type)
			throws FinderException;

	public Collection findAllByInQuery(String inQuery) throws FinderException;

	public Collection findAllByAreaAndTypeAndYear(int areaID, int typeID,
			int yearID) throws FinderException;

	public Collection findAllByAreaAndTypes(int area, Collection types)
			throws FinderException;

	public Collection findAllByAreaAndTypesAndYear(int area, Collection types,
			int yearID) throws FinderException;

	public Collection findAllBySubAreaAndTypes(int subarea, Collection types)
			throws FinderException;

	public Collection<School> findAllByCategory(SchoolCategory schoolCategory)
			throws FinderException;

	public Collection findAllInHomeCommuneByCategory(
			SchoolCategory schoolCategory) throws IDOLookupException,
			EJBException, FinderException;

	public int getNumberOfRelations(School school, SchoolYear year)
			throws IDOException;

	public int getNumberOfFreetimeTypes(int schoolID) throws IDOException;

	public Collection findAllPrivate() throws IDOLookupException, EJBException,
			FinderException;

	public Collection findAllWithNoPrimaryGroup() throws FinderException;

	/**
	 * 
	 * @param name is {@link CourseProvider#getName()}, not <code>null</code>;
	 * @param postalCode is {@link PostalCode#getPostalCode()}, not <code>null</code>;
	 * @return entities by criteria or {@link Collections#emptyList()} on failure;
	 * @author <a href="mailto:martynas@idega.is">Martynas Stakė</a>
	 */
	public Collection<? extends CourseProvider> find(
			String name, 
			String postalCode);
}