package com.idega.block.school.data;


import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.user.data.User;
import com.idega.data.IDOEntity;
import com.idega.data.IDOFactory;

public class SchoolUserHomeImpl extends IDOFactory implements SchoolUserHome {

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

	public SchoolUser findForUser(User user) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolUserBMPBean) entity).ejbFindForUser(user);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
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