package com.idega.block.school.data;


import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;

public interface StudentHome extends IDOHome {

	public Student create() throws CreateException;

	public Student findByPrimaryKey(Object pk) throws FinderException;
}