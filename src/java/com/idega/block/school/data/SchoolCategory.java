package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProviderCategory;

public interface SchoolCategory extends CourseProviderCategory {

	/**
	 * @see com.idega.block.school.data.SchoolCategoryBMPBean#getPrimaryKeyClass
	 */
	public Class getPrimaryKeyClass();
}