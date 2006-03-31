/*
 * $Id: SchoolBusinessHomeImpl.java,v 1.20 2006/03/31 12:25:54 laddi Exp $
 * Created on Mar 30, 2006
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
 *  Last modified: $Date: 2006/03/31 12:25:54 $ by $Author: laddi $
 * 
 * @author <a href="mailto:laddi@idega.com">laddi</a>
 * @version $Revision: 1.20 $
 */
public class SchoolBusinessHomeImpl extends IBOHomeImpl implements SchoolBusinessHome {

	protected Class getBeanInterfaceClass() {
		return SchoolBusiness.class;
	}

	public SchoolBusiness create() throws javax.ejb.CreateException {
		return (SchoolBusiness) super.createIBO();
	}

}
