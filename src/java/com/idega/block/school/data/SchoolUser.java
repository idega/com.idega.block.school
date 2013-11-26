package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProviderUser;

import java.rmi.RemoteException;
import java.util.Collection;

import com.idega.data.IDORelationshipException;

public interface SchoolUser extends CourseProviderUser {

	/**
	 * @see com.idega.block.school.data.SchoolUserBMPBean#getSchools
	 */
	public Collection getSchools() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolUserBMPBean#setMainHeadmaster
	 */
	public void setMainHeadmaster(boolean mainHead);

	/**
	 * @see com.idega.block.school.data.SchoolUserBMPBean#getMainHeadmaster
	 */
	public boolean getMainHeadmaster();

	/**
	 * @see com.idega.block.school.data.SchoolUserBMPBean#setIsEconomicalResponsible
	 */
	public void setIsEconomicalResponsible(boolean b);

	/**
	 * @see com.idega.block.school.data.SchoolUserBMPBean#isEconomicalResponsible
	 */
	public boolean isEconomicalResponsible();

	/**
	 * @see com.idega.block.school.data.SchoolUserBMPBean#setShowInContact
	 */
	public void setShowInContact(boolean showinContacts);

	/**
	 * @see com.idega.block.school.data.SchoolUserBMPBean#getShowInContact
	 */
	public boolean getShowInContact();

	/**
	 * @see com.idega.block.school.data.SchoolUserBMPBean#getHome
	 */
	public SchoolUserHome getHome() throws RemoteException;
}