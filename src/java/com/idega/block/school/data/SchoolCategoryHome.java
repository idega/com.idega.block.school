package com.idega.block.school.data;


import is.idega.idegaweb.egov.course.data.CourseProviderCategoryHome;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface SchoolCategoryHome extends CourseProviderCategoryHome {

	public SchoolCategory create() throws CreateException;

	public SchoolCategory findByPrimaryKey(Object pk) throws FinderException;

	public Collection<SchoolCategory> findAllCategories() throws FinderException;

	public SchoolCategory findByLocalizedKey(String key) throws FinderException;

	public SchoolCategory findAfterSchoolCareCategory() throws FinderException;

	public SchoolCategory findChildcareCategory() throws FinderException;

	public SchoolCategory findElementarySchoolCategory() throws FinderException;

	public SchoolCategory findHighSchoolCategory() throws FinderException;

	public SchoolCategory findCollegeCategory() throws FinderException;

	public SchoolCategory findUniversityCategory() throws FinderException;

	public SchoolCategory findAdultEducationCategory() throws FinderException;

	public SchoolCategory findMusicSchoolCategory() throws FinderException;
}