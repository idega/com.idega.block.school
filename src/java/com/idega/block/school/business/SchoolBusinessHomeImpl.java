/*
 * $Id: SchoolBusinessHomeImpl.java,v 1.19 2006/02/01 19:23:19 laddi Exp $
 * Created on Feb 1, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.school.business;

import com.idega.business.IBOHomeImpl;


/**
 * <p>
 * TODO laddi Describe Type SchoolBusinessHomeImpl
 * </p>
 *  Last modified: $Date: 2006/02/01 19:23:19 $ by $Author: laddi $
 * 
 * @author <a href="mailto:laddi@idega.com">laddi</a>
 * @version $Revision: 1.19 $
 */
public class SchoolBusinessHomeImpl extends IBOHomeImpl implements SchoolBusinessHome {

	protected Class getBeanInterfaceClass() {
		return SchoolBusiness.class;
	}

	public SchoolBusiness create() throws javax.ejb.CreateException {
		return (SchoolBusiness) super.createIBO();
	}
}
