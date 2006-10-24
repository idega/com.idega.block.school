package com.idega.block.school.data;


import com.idega.user.data.User;
import com.idega.data.IDOEntity;

public interface Student extends IDOEntity, User {

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#canDisplayImages
	 */
	public boolean canDisplayImages();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setCanDisplayImages
	 */
	public void setCanDisplayImages(boolean canDisplayImages);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#hasCaretaker
	 */
	public boolean hasCaretaker();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setHasCaretaker
	 */
	public void setHasCaretaker(boolean hasCaretaker);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#getLastProvider
	 */
	public String getLastProvider();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setLastProvider
	 */
	public void setLastProvider(String lastProvider);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#canContactLastProvider
	 */
	public boolean canContactLastProvider();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setCanContactLastProvider
	 */
	public void setCanContactLastProvider(boolean canContactLastProvider);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#canDisplayParentInformation
	 */
	public boolean canDisplayParentInformation();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setCanDisplayParentInformation
	 */
	public void setCanDisplayParentInformation(boolean canDisplayParentInformation);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#canParticipateInChurchRecreation
	 */
	public boolean canParticipateInChurchRecreation();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setCanParticipateInChurchRecreation
	 */
	public void setCanParticipateInChurchRecreation(boolean canParticipateInChurchRecreation);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#canContactElementarySchoolForInformation
	 */
	public boolean canContactElementarySchoolForInformation();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setCanContactElementarySchoolForInformation
	 */
	public void setCanContactElementarySchoolForInformation(boolean canContactElementarySchoolForInformation);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#getAfterSchoolCareOtherInformation
	 */
	public String getAfterSchoolCareOtherInformation();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setAfterSchoolCareOtherInformation
	 */
	public void setAfterSchoolCareOtherInformation(String information);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#getChildCareOtherInformation
	 */
	public String getChildCareOtherInformation();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setChildCareOtherInformation
	 */
	public void setChildCareOtherInformation(String information);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#hasSiblingInSchool
	 */
	public boolean hasSiblingInSchool();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setHasSiblingInSchool
	 */
	public void setHasSiblingInSchool(boolean hasSiblingInSchool);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#getSibling
	 */
	public String getSibling();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setSibling
	 */
	public void setSibling(String sibling);

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#getSiblingSchool
	 */
	public String getSiblingSchool();

	/**
	 * @see com.idega.block.school.data.StudentBMPBean#setSiblingSchool
	 */
	public void setSiblingSchool(String siblingSchool);
}