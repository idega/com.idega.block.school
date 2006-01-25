/*
 * $Id: SchoolTypeHome.java,v 1.10 2006/01/25 00:27:24 gimmi Exp $
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
import com.idega.data.IDOHome;


/**
 * <p>
 * TODO gimmi Describe Type SchoolTypeHome
 * </p>
 *  Last modified: $Date: 2006/01/25 00:27:24 $ by $Author: gimmi $
 * 
 * @author <a href="mailto:gimmi@idega.com">gimmi</a>
 * @version $Revision: 1.10 $
 */
public interface SchoolTypeHome extends IDOHome {

	public SchoolType create() throws javax.ejb.CreateException;

	public SchoolType findByPrimaryKey(Object pk) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#ejbFindAllSchoolTypes
	 */
	public Collection findAllSchoolTypes() throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#ejbFindAllByCategory
	 */
	public Collection findAllByCategory(String category) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#ejbFindAllByCategory
	 */
	public Collection findAllByCategory(String category, boolean showFreetimeTypes) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#ejbFindByTypeKey
	 */
	public SchoolType findByTypeKey(String typeKey) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#ejbFindByName
	 */
	public SchoolType findByName(String name) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#ejbFindByTypeString
	 */
	public SchoolType findByTypeString(String typeString) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#ejbFindAllFreetimeTypes
	 */
	public Collection findAllFreetimeTypes() throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#ejbFindAllFreetimeTypes
	 */
	public Collection findAllFreetimeTypes(String category) throws FinderException;
}
