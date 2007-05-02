package com.idega.block.school.data;

import java.util.Collection;

import com.idega.data.GenericEntity;
import com.idega.data.IDOQuery;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author <br>
 *         <a href="mailto:aron@idega.is">Aron Birkir</a><br>
 * @version 1.0
 */

public class SchoolAreaBMPBean extends GenericEntity implements SchoolArea {

	public final static String SCHOOL = "SCH_SCHOOL_AREA";
	public final static String NAME = "AREA_NAME";
	public final static String INFO = "AREA_INFO";
	public final static String CITY = "AREA_CITY";
	public final static String SCHOOL_CATEGORY = "SCHOOL_CATEGORY";

	public void initializeAttributes() {
		this.addAttribute(getIDColumnName());
		this.addAttribute(NAME, "Schoolname", true, true, String.class);
		this.addAttribute(INFO, "Info", true, true, String.class);
		this.addAttribute(CITY, "City", true, true, String.class);

		addManyToOneRelationship(SCHOOL_CATEGORY, SchoolCategory.class);
		getEntityDefinition().setBeanCachingActiveByDefault(true);
	}

	public String getEntityName() {
		return SCHOOL;
	}

	// Getters
	public String getName() {
		return getSchoolAreaName();
	}

	public String getSchoolAreaName() {
		return this.getStringColumnValue(NAME);
	}

	public String getSchoolAreaInfo() {
		return this.getStringColumnValue(INFO);
	}

	public String getSchoolAreaCity() {
		return this.getStringColumnValue(CITY);
	}

	public SchoolCategory getCategory() {
		return (SchoolCategory) getColumnValue(SCHOOL_CATEGORY);
	}

	// Setters
	public void setSchoolAreaName(String name) {
		this.setColumn(NAME, name);
	}

	public void setSchoolAreaInfo(String info) {
		this.setColumn(INFO, info);
	}

	public void setSchoolAreaCity(String city) {
		this.setColumn(CITY, city);
	}

	public void setCategory(SchoolCategory category) {
		setColumn(SCHOOL_CATEGORY, category);
	}

	public Collection ejbFindAllSchoolAreas(SchoolCategory category) throws javax.ejb.FinderException {
		return ejbFindAllSchoolAreas(category, false);
	}

	public Collection ejbFindAllSchoolAreas(SchoolCategory category, boolean useNullValue) throws javax.ejb.FinderException {
		IDOQuery sql = idoQuery();
		sql.appendSelectAllFrom(this.getEntityName());
		if (category != null) {
			sql.appendWhereEquals(SCHOOL_CATEGORY, category);
		}
		else if (useNullValue) {
			sql.appendWhereIsNull(SCHOOL_CATEGORY);
		}
		sql.appendOrderBy(NAME);

		return super.idoFindPKsBySQL(sql.toString());
	}

	public Integer ejbFindSchoolAreaByAreaName(SchoolCategory category, String name) throws javax.ejb.FinderException {
		IDOQuery sql = idoQuery();
		sql.appendSelectAllFrom(this.getEntityName()).appendWhereEqualsQuoted(NAME, name);
		if (category != null) {
			sql.appendAndEquals(SCHOOL_CATEGORY, category);
		}

		return (Integer) super.idoFindOnePKByQuery(sql);
	}
}