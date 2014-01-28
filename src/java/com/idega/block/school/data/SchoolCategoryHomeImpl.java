package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProviderCategoryHomeImpl;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.idega.data.IDOEntity;

public class SchoolCategoryHomeImpl extends CourseProviderCategoryHomeImpl implements SchoolCategoryHome {

	private static final long serialVersionUID = -2921265541424788425L;

	public Class getEntityInterfaceClass() {
		return SchoolCategory.class;
	}

	public SchoolCategory create() throws CreateException {
		return (SchoolCategory) super.createIDO();
	}

	public SchoolCategory findByPrimaryKey(Object pk) throws FinderException {
		return (SchoolCategory) super.findByPrimaryKeyIDO(pk);
	}

	public Collection<SchoolCategory> findAllCategories() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection<Object> ids = ((SchoolCategoryBMPBean) entity).ejbFindAllCategories();
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolCategory findByLocalizedKey(String key) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindByLocalizedKey(key);
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findAfterSchoolCareCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindAfterSchoolCareCategory();
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findChildcareCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindChildcareCategory();
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findElementarySchoolCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindElementarySchoolCategory();
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findHighSchoolCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindHighSchoolCategory();
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findCollegeCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindCollegeCategory();
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findUniversityCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindUniversityCategory();
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findAdultEducationCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindAdultEducationCategory();
		return this.findByPrimaryKey(pk);
	}

	public SchoolCategory findMusicSchoolCategory() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolCategoryBMPBean) entity).ejbFindMusicSchoolCategory();
		return this.findByPrimaryKey(pk);
	}
}