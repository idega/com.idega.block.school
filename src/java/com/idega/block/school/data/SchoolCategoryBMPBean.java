/*
 * Created on 20.8.2003
 */
package com.idega.block.school.data;

import is.idega.idegaweb.egov.course.data.CourseProviderCategoryBMPBean;

import java.util.logging.Level;

import javax.ejb.FinderException;

import com.idega.data.IDOLookup;
import com.idega.data.IDOQuery;
import com.idega.util.StringUtil;

/**
 * @author laddi
 */
public class SchoolCategoryBMPBean extends CourseProviderCategoryBMPBean implements SchoolCategory {

	private static final long serialVersionUID = 2686860045988607045L;
	public static final String ENTITY_NAME = "SCH_SCHOOL_CATEGORY";
	public static final String COLUMN_NAME = "CATEGORY_NAME";

	public static final String CATEGORY_PREFIX = "school_category.";
	public static final String COLUMN_LOCALIZED_KEY = "localized_key";
	
	/*
	 * (non-Javadoc)
	 * @see com.idega.data.GenericEntity#getPrimaryKeyClass()
	 */
	public Class getPrimaryKeyClass() {
		return String.class;
	}

	/*
	 * (non-Javadoc)
	 * @see com.idega.data.GenericEntity#insertStartData()
	 */
	public void insertStartData() throws Exception {
		String[] categories = {
				CATEGORY_AFTER_SCHOOL_CARE,
				CATEGORY_CHILD_CARE,
				CATEGORY_ELEMENTARY_SCHOOL,
				CATEGORY_HIGH_SCHOOL,
				CATEGORY_COLLEGE,
				CATEGORY_UNIVERSITY
		};

		String[] names = {
				"After school care", 
				"Child care", 
				"Elementary school", 
				"High school", 
				"College", 
				"University"
		};

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
	 * @see is.idega.idegaweb.egov.course.data.CourseProviderCategoryBMPBean#getEntityName()
	 */
	public String getEntityName() {
		return ENTITY_NAME;
	}

	/*
	 * (non-Javadoc)
	 * @see is.idega.idegaweb.egov.course.data.CourseProviderCategoryBMPBean#initializeAttributes()
	 */
	public void initializeAttributes() {
		addAttribute(COLUMN_CATEGORY, "Category", String.class, 30);
		setAsPrimaryKey(COLUMN_CATEGORY, true);
		addAttribute(COLUMN_NAME, "Name of category", String.class, 255);
		addAttribute(COLUMN_LOCALIZED_KEY, "Localized key for category", String.class, 255);
		getEntityDefinition().setBeanCachingActiveByDefault(true);
	}

	/*
	 * (non-Javadoc)
	 * @see is.idega.idegaweb.egov.course.data.CourseProviderCategory#setLocalizedKey(java.lang.String)
	 */
	@Override
	public void setLocalizedKey(String key) {
		setColumn(COLUMN_LOCALIZED_KEY, key);
	}

	/*
	 * (non-Javadoc)
	 * @see is.idega.idegaweb.egov.course.data.CourseProviderCategory#getLocalizedKey()
	 */
	@Override
	public String getLocalizedKey() {
		return getStringColumnValue(COLUMN_LOCALIZED_KEY);
	}

	/*
	 * (non-Javadoc)
	 * @see com.idega.data.GenericEntity#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		setColumn(COLUMN_NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * @see com.idega.data.GenericEntity#getName()
	 */
	@Override
	public String getName() {
		return getStringColumnValue(COLUMN_NAME);
	}

	/**
	 * 
	 * @param key is {@link SchoolCategory#getLocalizedKey()}, 
	 * not <code>null</code>;
	 * @return {@link SchoolCategory#getPrimaryKey()} or <code>null</code>
	 * on failure;
	 * @author <a href="mailto:martynas@idega.is">Martynas Stakė</a>
	 */
	public String ejbFindByLocalizedKey(String key) {
		if (StringUtil.isEmpty(key)) {
			return null;
		}

		IDOQuery query = idoQuery();
		query.appendSelectAllFrom(this)
		.appendWhereEqualsQuoted(COLUMN_LOCALIZED_KEY, key);

		try {
			return (String) idoFindOnePKByQuery(query);
		} catch (FinderException e) {
			getLogger().log(Level.WARNING, 
					"Failed to get primary key by localization key: '" + key + 
					"' and query:'" + query.toString() + "'", e);
		}

		return null;
	}
}