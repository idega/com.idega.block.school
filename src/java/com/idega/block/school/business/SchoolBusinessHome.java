/*
 * $Id: SchoolBusinessHome.java,v 1.18 2006/02/01 19:09:59 laddi Exp $
 * Created on Feb 1, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.school.business;

import com.idega.business.IBOHome;


/**
 * <p>
 * TODO laddi Describe Type SchoolBusinessHome
 * </p>
 *  Last modified: $Date: 2006/02/01 19:09:59 $ by $Author: laddi $
 * 
 * @author <a href="mailto:laddi@idega.com">laddi</a>
 * @version $Revision: 1.18 $
 */
public interface SchoolBusinessHome extends IBOHome {

	public SchoolBusiness create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
