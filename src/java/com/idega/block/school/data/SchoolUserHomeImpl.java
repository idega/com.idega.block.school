package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProviderUserHomeImpl;

import java.util.Collection;
import java.util.logging.Level;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.idega.data.IDOEntity;
import com.idega.user.data.User;

public class SchoolUserHomeImpl extends CourseProviderUserHomeImpl implements SchoolUserHome {

	private static final long serialVersionUID = -8383345235383866840L;

	public Class getEntityInterfaceClass() {
		return SchoolUser.class;
	}

	public SchoolUser create() throws CreateException {
		return (SchoolUser) super.createIDO();
	}

	public SchoolUser findByPrimaryKey(Object pk) throws FinderException {
		return (SchoolUser) super.findByPrimaryKeyIDO(pk);
	}

	public Collection findBySchoolAndType(School school, int userType) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndType(school, userType);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findByTypes(int[] userTypes) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindByTypes(userTypes);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndTypes(School school, int[] userTypes) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndTypes(school, userTypes);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndIsEconomicalResponsible(School school) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndIsEconomicalResponsible(school);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndTypeAndDepartment(School school, int userType, int departmentID) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndTypeAndDepartment(school, userType, departmentID);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndDepartment(School school, int departmentID) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndDepartment(school, departmentID);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndMainHeadmaster(School school, int userType, boolean main_headmaster) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndMainHeadmaster(school, userType, main_headmaster);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findByUser(User user) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindByUser(user);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolUser findForUser(User user) {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = null;
		try {
			pk = ((SchoolUserBMPBean) entity).ejbFindForUser(user);
		} catch (FinderException e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					Level.WARNING, 
					"Failed to get primary key for " + getEntityInterfaceClass().getName() + 
					" by user: '" + user + "'");
		}

		try {
			return this.findByPrimaryKey(pk);
		} catch (FinderException e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					Level.WARNING, 
					"Failed to get " + getEntityInterfaceClass().getName() + 
					" by id's: '" + pk +  "'");
		}

		return null;
	}

	public Collection findBySchoolAndUser(School school, User user) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndUser(school, user);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchool(School school) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchool(school);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findRelatedToSchool(School school) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolUserBMPBean) entity).ejbFindRelatedToSchool(school);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Object getSchoolUserId(School school, User user, int userType) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object theReturn = ((SchoolUserBMPBean) entity).ejbHomeGetSchoolUserId(school, user, userType);
		this.idoCheckInPooledEntity(entity);
		return theReturn;
	}
}