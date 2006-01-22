/*
 * $Id: SchoolUserHomeImpl.java 1.1 Jan 19, 2006 laddi Exp $
 * Created on Jan 19, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.school.data;

import java.util.Collection;
import javax.ejb.FinderException;
import com.idega.data.IDOFactory;
import com.idega.user.data.User;


/**
 * <p>
 * TODO laddi Describe Type SchoolUserHomeImpl
 * </p>
 *  Last modified: $Date: 2004/06/28 09:09:50 $ by $Author: laddi $
 * 
 * @author <a href="mailto:laddi@idega.com">laddi</a>
 * @version $Revision: 1.1 $
 */
public class SchoolUserHomeImpl extends IDOFactory implements SchoolUserHome {

	protected Class getEntityInterfaceClass() {
		return SchoolUser.class;
	}

	public SchoolUser create() throws javax.ejb.CreateException {
		return (SchoolUser) super.createIDO();
	}

	public SchoolUser findByPrimaryKey(Object pk) throws javax.ejb.FinderException {
		return (SchoolUser) super.findByPrimaryKeyIDO(pk);
	}

	public Collection findBySchoolAndType(School school, int userType) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndType(school, userType);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndIsEconomicalResponsible(School school) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndIsEconomicalResponsible(school);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndTypeAndDepartment(School school, int userType, int departmentID) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndTypeAndDepartment(school, userType, departmentID);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndDepartment(School school, int departmentID) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndDepartment(school, departmentID);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchoolAndMainHeadmaster(School school, int userType, boolean main_headmaster) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndMainHeadmaster(school, userType, main_headmaster);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findByUser(User user) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolUserBMPBean) entity).ejbFindByUser(user);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolUser findForUser(User user) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolUserBMPBean) entity).ejbFindForUser(user);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public Collection findBySchoolAndUser(School school, User user) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchoolAndUser(school, user);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findBySchool(School school) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolUserBMPBean) entity).ejbFindBySchool(school);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Object getSchoolUserId(School school, User user, int userType) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object theReturn = ((SchoolUserBMPBean) entity).ejbHomeGetSchoolUserId(school, user, userType);
		this.idoCheckInPooledEntity(entity);
		return theReturn;
	}
}
