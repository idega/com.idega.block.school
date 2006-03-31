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

import com.idega.user.data.User;
import com.idega.user.data.UserBMPBean;


public class StudentBMPBean extends UserBMPBean implements User, Student {

	public static final String METADATA_LAST_PROVIDER = "last_care_provider";
	public static final String METADATA_CAN_CONTACT_LAST_PROVIDER = "can_contact_last_provider";
	public static final String METADATA_CAN_DISPLAY_PARENT_INFORMATION = "can_display_parent_information";
	public static final String METADATA_CAN_DISPLAY_IMAGE = "can_display_image";
	
	public static final String METADATA_AFTER_SCHOOL_CARE_INFORMATION = "after_school_care_information";
	public static final String METADATA_CAN_PARTICIPATE_IN_CHURCH_RECREATION = "can_participate_in_church_recreation";
	public static final String METADATA_CAN_CONTACT_ELEMENTARY_SCHOOL_FOR_INFORMATION = "can_contact_elementary_school_for_information";

	public boolean canDisplayImages() {
		String meta = getMetaData(METADATA_CAN_DISPLAY_IMAGE);
		if (meta != null) {
			return new Boolean(meta).booleanValue();
		}
		return false;
	}
	
	public void setCanDisplayImages(boolean canDisplayImages) {
		setMetaData(METADATA_CAN_DISPLAY_IMAGE, String.valueOf(canDisplayImages), "java.lang.Boolean");
	}
	
	public String getLastProvider() {
		return getMetaData(METADATA_LAST_PROVIDER);
	}
	
	public void setLastProvider(String lastProvider) {
		if (lastProvider != null && lastProvider.length() > 0) {
			setMetaData(METADATA_LAST_PROVIDER, lastProvider, "java.lang.String");
		}
		else {
			removeMetaData(METADATA_LAST_PROVIDER);
		}
	}

	public boolean canContactLastProvider() {
		String meta = getMetaData(METADATA_CAN_CONTACT_LAST_PROVIDER);
		if (meta != null && meta.length() > 0) {
			return new Boolean(meta).booleanValue();
		}
		return true;
	}
	
	public void setCanContactLastProvider(boolean canContactLastProvider) {
		setMetaData(METADATA_CAN_CONTACT_LAST_PROVIDER, String.valueOf(canContactLastProvider), "java.lang.Boolean");
	}
	
	public boolean canDisplayParentInformation() {
		String meta = getMetaData(METADATA_CAN_DISPLAY_PARENT_INFORMATION);
		if (meta != null && meta.length() > 0) {
			return new Boolean(meta).booleanValue();
		}
		return false;
	}
	
	public void setCanDisplayParentInformation(boolean canDisplayParentInformation) {
		setMetaData(METADATA_CAN_DISPLAY_PARENT_INFORMATION, String.valueOf(canDisplayParentInformation), "java.lang.Boolean");
	}

	public boolean canParticipateInChurchRecreation() {
		String meta = getMetaData(METADATA_CAN_PARTICIPATE_IN_CHURCH_RECREATION);
		if (meta != null && meta.length() > 0) {
			return new Boolean(meta).booleanValue();
		}
		return true;
	}
	
	public void setCanParticipateInChurchRecreation(boolean canParticipateInChurchRecreation) {
		setMetaData(METADATA_CAN_PARTICIPATE_IN_CHURCH_RECREATION, String.valueOf(canParticipateInChurchRecreation), "java.lang.Boolean");
	}
	
	public boolean canContactElementarySchoolForInformation() {
		String meta = getMetaData(METADATA_CAN_CONTACT_ELEMENTARY_SCHOOL_FOR_INFORMATION);
		if (meta != null && meta.length() > 0) {
			return new Boolean(meta).booleanValue();
		}
		return true;
	}
	
	public void setCanContactElementarySchoolForInformation(boolean canContactElementarySchoolForInformation) {
		setMetaData(METADATA_CAN_CONTACT_ELEMENTARY_SCHOOL_FOR_INFORMATION, String.valueOf(canContactElementarySchoolForInformation), "java.lang.Boolean");
	}
	
	public String getAfterSchoolCareOtherInformation() {
		return getMetaData(METADATA_AFTER_SCHOOL_CARE_INFORMATION);
	}
	
	public void setAfterSchoolCareOtherInformation(String information) {
		if (information != null && information.length() > 0) {
			setMetaData(METADATA_AFTER_SCHOOL_CARE_INFORMATION, information, "java.lang.String");
		}
		else {
			removeMetaData(METADATA_AFTER_SCHOOL_CARE_INFORMATION);
		}
	}
}