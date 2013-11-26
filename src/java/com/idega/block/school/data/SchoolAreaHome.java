package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProviderAreaHome;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface SchoolAreaHome extends CourseProviderAreaHome {

	public SchoolArea create() throws CreateException;

	public SchoolArea findByPrimaryKey(Object pk) throws FinderException;

	public Collection<SchoolArea> getAllScoolAreas() throws FinderException;

	public Collection<SchoolArea> findAllSchoolAreas(SchoolCategory category) throws FinderException;

	public Collection<SchoolArea> findAllSchoolAreas(SchoolCategory category, boolean useNullValue) throws FinderException;

	public SchoolArea findSchoolAreaByAreaName(SchoolCategory category, String name) throws FinderException;

	public Collection<SchoolArea> findAllSchoolAreasByType(int type) throws FinderException;

	public Collection<SchoolArea> findAllBySchoolTypeAndCity(int schoolType, java.lang.String city) throws FinderException;

	public Collection<SchoolArea> findAllBySchoolTypeCityAndManagementTypes(int type, String city, Collection<String> managementTypes) throws FinderException;

	public Collection<SchoolArea> findAllBySchoolTypes(Collection<SchoolType> types) throws FinderException;
}