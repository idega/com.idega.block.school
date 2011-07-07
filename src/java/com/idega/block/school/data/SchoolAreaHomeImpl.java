package com.idega.block.school.data;


import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.idega.data.IDOEntity;
import com.idega.data.IDOFactory;

public class SchoolAreaHomeImpl extends IDOFactory implements SchoolAreaHome {

	private static final long serialVersionUID = 1767031846791864669L;

	@Override
	public Class<SchoolArea> getEntityInterfaceClass() {
		return SchoolArea.class;
	}

	@Override
	public SchoolArea create() throws CreateException {
		return (SchoolArea) super.createIDO();
	}

	@Override
	public SchoolArea findByPrimaryKey(Object pk) throws FinderException {
		return (SchoolArea) super.findByPrimaryKeyIDO(pk);
	}

	@Override
	public Collection<SchoolArea> findAllSchoolAreas(SchoolCategory category) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean) entity).ejbFindAllSchoolAreas(category);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	@Override
	public Collection<SchoolArea> findAllSchoolAreas(SchoolCategory category, boolean useNullValue) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean) entity).ejbFindAllSchoolAreas(category, useNullValue);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	@Override
	public Collection<SchoolArea> getAllScoolAreas() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean) entity).ejbFindAllSchoolAreas(null, false);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	@Override
	public SchoolArea findSchoolAreaByAreaName(SchoolCategory category, String name) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolAreaBMPBean) entity).ejbFindSchoolAreaByAreaName(category, name);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	@Override
	public Collection<SchoolArea> findAllSchoolAreasByType(int type) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean) entity).ejbFindAllBySchoolType(type);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	@Override
	public Collection<SchoolArea> findAllBySchoolTypeAndCity(int type, String city) throws FinderException{
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean)entity).ejbFindAllBySchoolTypeAndCity(type, city);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	@Override
	public Collection<SchoolArea> findAllBySchoolTypeCityAndManagementTypes(int type, String city, Collection<String> managementTypes) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean)entity).ejbFindAllBySchoolTypeCityAndManagementTypes(type, city, managementTypes);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	@Override
	public Collection<SchoolArea> findAllBySchoolTypes(Collection<SchoolType> types) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<?> ids = ((SchoolAreaBMPBean)entity).ejbFindAllBySchoolTypes(types);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}
}