/*
 * Created on 20.8.2003
 */
package com.idega.block.school.data;

import is.idega.idegaweb.egov.course.data.CourseProviderCategoryBMPBean;

import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.data.IDOLookup;
import com.idega.data.IDOQuery;

/**
 * @author laddi
 */
public class SchoolCategoryBMPBean extends CourseProviderCategoryBMPBean implements SchoolCategory {

	private static final long serialVersionUID = 2686860045988607045L;
	public static final String ENTITY_NAME = "SCH_SCHOOL_CATEGORY";
	public static final String COLUMN_NAME = "CATEGORY_NAME";

	public static final String CATEGORY_PREFIX = "school_category.";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idega.data.IDOEntityBean#getPrimaryKeyClass()
	 */
	public Class getPrimaryKeyClass() {
		return String.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idega.data.GenericEntity#insertStartData()
	 */
	public void insertStartData() throws Exception {
		String[] categories = { CATEGORY_AFTER_SCHOOL_CARE, CATEGORY_CHILD_CARE, CATEGORY_ELEMENTARY_SCHOOL, CATEGORY_HIGH_SCHOOL, CATEGORY_COLLEGE, CATEGORY_UNIVERSITY };
		String[] names = { "After school care", "Child care", "Elementary school", "High school", "College", "University" };

		SchoolCategoryHome categoryHome = (SchoolCategoryHome) IDOLookup.getHome(SchoolCategory.class);
		SchoolCategory category;

		for (int i = 0; i < categories.length; i++) {
			category = categoryHome.create();
			category.setCategory(categories[i]);
			category.setName(names[i]);
			category.setLocalizedKey(CATEGORY_PREFIX + categories[i]);
			category.store();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idega.data.GenericEntity#getEntityName()
	 */
	public String getEntityName() {
		return ENTITY_NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idega.data.GenericEntity#initializeAttributes()
	 */
	public void initializeAttributes() {
		addAttribute(COLUMN_CATEGORY, "Category", String.class, 30);
		setAsPrimaryKey(COLUMN_CATEGORY, true);

		addAttribute(COLUMN_NAME, "Name of category", String.class, 255);
		addAttribute(COLUMN_LOCALIZED_KEY, "Localized key for category", String.class, 255);
		getEntityDefinition().setBeanCachingActiveByDefault(true);
	}

	// Find methods
	public Collection ejbFindAllCategories() throws FinderException {
		IDOQuery query = idoQuery();
		query.appendSelectAllFrom(this);

		return idoFindPKsByQuery(query);
	}
}