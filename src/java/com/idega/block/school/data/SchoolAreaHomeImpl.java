package com.idega.block.school.data;


import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.data.IDOEntity;
import com.idega.data.IDOFactory;

public class SchoolAreaHomeImpl extends IDOFactory implements SchoolAreaHome {

	public Class getEntityInterfaceClass() {
		return SchoolArea.class;
	}

	public SchoolArea create() throws CreateException {
		return (SchoolArea) super.createIDO();
	}

	public SchoolArea findByPrimaryKey(Object pk) throws FinderException {
		return (SchoolArea) super.findByPrimaryKeyIDO(pk);
	}

	public Collection findAllSchoolAreas(SchoolCategory category) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolAreaBMPBean) entity).ejbFindAllSchoolAreas(category);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findAllSchoolAreas(SchoolCategory category, boolean useNullValue) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolAreaBMPBean) entity).ejbFindAllSchoolAreas(category, useNullValue);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolArea findSchoolAreaByAreaName(SchoolCategory category, String name) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolAreaBMPBean) entity).ejbFindSchoolAreaByAreaName(category, name);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}
}