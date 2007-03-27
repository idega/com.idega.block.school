package com.idega.block.school.data;


import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.data.IDOEntity;
import com.idega.data.IDOFactory;

public class SchoolCategoryHomeImpl extends IDOFactory implements SchoolCategoryHome {

	public Class getEntityInterfaceClass() {
		return SchoolCategory.class;
	}

	public SchoolCategory create() throws CreateException {
		return (SchoolCategory) super.createIDO();
	}

	public SchoolCategory findByPrimaryKey(Object pk) throws FinderException {
		return (SchoolCategory) super.findByPrimaryKeyIDO(pk);
	}

	public Collection findAllCategories() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolCategoryBMPBean) entity).ejbFindAllCategories();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolCategory findByLocalizedKey(String key) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindByLocalizedKey(key);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findAfterSchoolCareCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindAfterSchoolCareCategory();
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findChildcareCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindChildcareCategory();
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findElementarySchoolCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindElementarySchoolCategory();
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findHighSchoolCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindHighSchoolCategory();
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findCollegeCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindCollegeCategory();
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findUniversityCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindUniversityCategory();
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findAdultEducationCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindAdultEducationCategory();
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findMusicSchoolCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindMusicSchoolCategory();
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}
}