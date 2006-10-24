package com.idega.block.school.data;


import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.data.IDOFactory;

public class StudentHomeImpl extends IDOFactory implements StudentHome {

	public Class getEntityInterfaceClass() {
		return Student.class;
	}

	public Student create() throws CreateException {
		return (Student) super.createIDO();
	}

	public Student findByPrimaryKey(Object pk) throws FinderException {
		return (Student) super.findByPrimaryKeyIDO(pk);
	}
}