package com.idega.block.school.data;


import java.util.Collection;
import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;

public interface SchoolAreaHome extends IDOHome {

	public SchoolArea create() throws CreateException;

	public SchoolArea findByPrimaryKey(Object pk) throws FinderException;

	public Collection findAllSchoolAreas(SchoolCategory category) throws FinderException;

	public SchoolArea findSchoolAreaByAreaName(SchoolCategory category, String name) throws FinderException;
}