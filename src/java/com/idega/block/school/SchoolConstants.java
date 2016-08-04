/*
 * $Id$ Created on Mar 13, 2007
 *
 * Copyright (C) 2007 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf. Use is subject to license terms.
 */
package com.idega.block.school;

import java.util.Arrays;
import java.util.List;

import com.idega.builder.bean.AdvancedProperty;
import com.idega.idegaweb.IWMainApplication;
import com.idega.util.CoreUtil;

public class SchoolConstants {

	public static final String GROUP_TYPE_SCHOOL_CATEGORY = "school_category";
	public static final String GROUP_TYPE_SCHOOL = "school";
	public static final String GROUP_TYPE_HEADMASTERS = "school_headmasters";
	public static final String GROUP_TYPE_ASSISTANT_HEADMASTERS = "school_assistant_headmasters";
	public static final String GROUP_TYPE_TEACHERS = "school_teachers";
	public static final String GROUP_TYPE_WEB_ADMINS = "school_web_admins";

	public static final String ROLE_HEADMASTER = "school_headmaster";
	public static final String ROLE_ASSISTANT_HEADMASTER = "school_assistant_headmaster";
	public static final String ROLE_TEACHER = "school_teacher";
	public static final String ROLE_WEB_ADMIN = "school_web_admin";

	public static final String IW_BUNDLE_IDENTIFIER = "com.idega.block.school";

	public static final String MENTOR_WEB_CLIENT_TYPE = "Mentor";
	public static final String NAMSFUS_WEB_CLIENT_TYPE = "Namsfus";

	public static final List<AdvancedProperty> SCHOOL_SYSTEMS = Arrays.asList(
			new AdvancedProperty(MENTOR_WEB_CLIENT_TYPE, IWMainApplication.getDefaultIWMainApplication().getBundle(IW_BUNDLE_IDENTIFIER).getResourceBundle(CoreUtil.getCurrentLocale()).getLocalizedString("school_system.Mentor", "Mentor")),
			new AdvancedProperty(NAMSFUS_WEB_CLIENT_TYPE, IWMainApplication.getDefaultIWMainApplication().getBundle(IW_BUNDLE_IDENTIFIER).getResourceBundle(CoreUtil.getCurrentLocale()).getLocalizedString("school_system.Namsfus", "Námsfús"))
	);

}