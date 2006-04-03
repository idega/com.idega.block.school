/*
 * $Id$
 * Created on Apr 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.school.data;

import com.idega.data.IDOEntity;
import com.idega.user.data.User;


/**
 * <p>
 * TODO laddi Describe Type Student
 * </p>
 *  Last modified: $Date$ by $Author$
 * 
 * @author <a href="mailto:laddi@idega.com">laddi</a>
 * @version $Revision$
 */
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

}
