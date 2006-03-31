/*
 * $Id$
 * Created on Mar 30, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.school.data;

import com.idega.data.IDOFactory;


/**
 * <p>
 * TODO laddi Describe Type StudentHomeImpl
 * </p>
 *  Last modified: $Date$ by $Author$
 * 
 * @author <a href="mailto:laddi@idega.com">laddi</a>
 * @version $Revision$
 */
public class StudentHomeImpl extends IDOFactory implements StudentHome {

	protected Class getEntityInterfaceClass() {
		return Student.class;
	}

	public Student create() throws javax.ejb.CreateException {
		return (Student) super.createIDO();
	}

	public Student findByPrimaryKey(Object pk) throws javax.ejb.FinderException {
		return (Student) super.findByPrimaryKeyIDO(pk);
	}

}
