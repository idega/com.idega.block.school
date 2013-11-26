package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProviderUserHome;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.idega.user.data.User;

public interface SchoolUserHome extends CourseProviderUserHome {

	public SchoolUser create() throws CreateException;

	public SchoolUser findByPrimaryKey(Object pk) throws FinderException;

	public Collection findBySchoolAndType(School school, int userType) throws FinderException;

	public Collection findByTypes(int[] userTypes) throws FinderException;

	public Collection findBySchoolAndTypes(School school, int[] userTypes) throws FinderException;

	public Collection findBySchoolAndIsEconomicalResponsible(School school) throws FinderException;

	public Collection findBySchoolAndTypeAndDepartment(School school, int userType, int departmentID) throws FinderException;

	public Collection findBySchoolAndDepartment(School school, int departmentID) throws FinderException;

	public Collection findBySchoolAndMainHeadmaster(School school, int userType, boolean main_headmaster) throws FinderException;

	public Collection findByUser(User user) throws FinderException;

	public SchoolUser findForUser(User user);

	public Collection findBySchoolAndUser(School school, User user) throws FinderException;

	public Collection findBySchool(School school) throws FinderException;

	public Collection findRelatedToSchool(School school) throws FinderException;

	public Object getSchoolUserId(School school, User user, int userType) throws FinderException;
}