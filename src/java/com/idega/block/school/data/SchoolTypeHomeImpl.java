/*
 * $Id: SchoolTypeHomeImpl.java,v 1.10 2006/01/25 00:27:24 gimmi Exp $
 * Created on Jan 12, 2006
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


/**
 * <p>
 * TODO gimmi Describe Type SchoolTypeHomeImpl
 * </p>
 *  Last modified: $Date: 2006/01/25 00:27:24 $ by $Author: gimmi $
 * 
 * @author <a href="mailto:gimmi@idega.com">gimmi</a>
 * @version $Revision: 1.10 $
 */
public class SchoolTypeHomeImpl extends IDOFactory implements SchoolTypeHome {

	protected Class getEntityInterfaceClass() {
		return SchoolType.class;
	}

	public SchoolType create() throws javax.ejb.CreateException {
		return (SchoolType) super.createIDO();
	}

	public SchoolType findByPrimaryKey(Object pk) throws javax.ejb.FinderException {
		return (SchoolType) super.findByPrimaryKeyIDO(pk);
	}

	public Collection findAllSchoolTypes() throws javax.ejb.FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolTypeBMPBean) entity).ejbFindAllSchoolTypes();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findAllByCategory(String category) throws javax.ejb.FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolTypeBMPBean) entity).ejbFindAllByCategory(category);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findAllByCategory(String category, boolean showFreetimeTypes) throws javax.ejb.FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolTypeBMPBean) entity).ejbFindAllByCategory(category, showFreetimeTypes);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolType findByTypeKey(String typeKey) throws javax.ejb.FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolTypeBMPBean) entity).ejbFindByTypeKey(typeKey);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolType findByName(String name) throws javax.ejb.FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolTypeBMPBean) entity).ejbFindByName(name);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolType findByTypeString(String typeString) throws javax.ejb.FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolTypeBMPBean) entity).ejbFindByTypeString(typeString);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public Collection findAllFreetimeTypes() throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolTypeBMPBean) entity).ejbFindAllFreetimeTypes();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findAllFreetimeTypes(String category) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolTypeBMPBean) entity).ejbFindAllFreetimeTypes(category);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}
}
