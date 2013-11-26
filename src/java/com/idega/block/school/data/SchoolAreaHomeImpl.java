package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProviderAreaHomeImpl;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.idega.data.IDOEntity;

public class SchoolAreaHomeImpl extends CourseProviderAreaHomeImpl implements SchoolAreaHome {

	private static final long serialVersionUID = 1767031846791864669L;


	public Class<SchoolArea> getEntityInterfaceClass() {
		return SchoolArea.class;
	}


	public SchoolArea create() throws CreateException {
		return (SchoolArea) super.createIDO();
	}


	public SchoolArea findByPrimaryKey(Object pk) throws FinderException {
		return (SchoolArea) super.findByPrimaryKeyIDO(pk);
	}


	public Collection<SchoolArea> findAllSchoolAreas(SchoolCategory category) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean) entity).ejbFindAllSchoolAreas(category);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}


	public Collection<SchoolArea> findAllSchoolAreas(SchoolCategory category, boolean useNullValue) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean) entity).ejbFindAllSchoolAreas(category, useNullValue);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}


	public Collection<SchoolArea> getAllScoolAreas() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean) entity).ejbFindAllSchoolAreas(null, false);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}


	public SchoolArea findSchoolAreaByAreaName(SchoolCategory category, String name) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolAreaBMPBean) entity).ejbFindSchoolAreaByAreaName(category, name);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}


	public Collection<SchoolArea> findAllSchoolAreasByType(int type) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean) entity).ejbFindAllBySchoolType(type);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}


	public Collection<SchoolArea> findAllBySchoolTypeAndCity(int type, String city) throws FinderException{
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean)entity).ejbFindAllBySchoolTypeAndCity(type, city);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}


	public Collection<SchoolArea> findAllBySchoolTypeCityAndManagementTypes(int type, String city, Collection<String> managementTypes) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean)entity).ejbFindAllBySchoolTypeCityAndManagementTypes(type, city, managementTypes);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}


	public Collection<SchoolArea> findAllBySchoolTypes(Collection<SchoolType> types) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean)entity).ejbFindAllBySchoolTypes(types);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}
}