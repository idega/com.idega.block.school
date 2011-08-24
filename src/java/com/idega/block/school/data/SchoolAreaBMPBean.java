package com.idega.block.school.data;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.FinderException;

import com.idega.data.GenericEntity;
import com.idega.data.IDOQuery;
import com.idega.util.CoreConstants;

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

	private static final long serialVersionUID = 8241605681334027622L;

	public final static String SCHOOL = "SCH_SCHOOL_AREA";
	public final static String NAME = "AREA_NAME";
	public final static String INFO = "AREA_INFO";
	public final static String CITY = "AREA_CITY";
	public final static String ACCOUNTING_KEY = "ACCOUNTING_KEY";
	public final static String SCHOOL_CATEGORY = "SCHOOL_CATEGORY";


	public void initializeAttributes() {
		this.addAttribute(getIDColumnName());
		this.addAttribute(NAME, "Schoolname", true, true, String.class);
		this.addAttribute(INFO, "Info", true, true, String.class);
		this.addAttribute(CITY, "City", true, true, String.class);
		this.addAttribute(ACCOUNTING_KEY, "Accounting key", true, true, String.class);

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


	public String getAccountingKey() {
		return this.getStringColumnValue(ACCOUNTING_KEY);
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


	public void setAccountingKey(String accountingKey) {
		this.setColumn(ACCOUNTING_KEY, accountingKey);
	}


	public void setCategory(SchoolCategory category) {
		setColumn(SCHOOL_CATEGORY, category);
	}

	public Collection<?> ejbFindAllSchoolAreas(SchoolCategory category) throws javax.ejb.FinderException {
		return ejbFindAllSchoolAreas(category, false);
	}

	public Collection<?> ejbFindAllSchoolAreas(SchoolCategory category, boolean useNullValue) throws javax.ejb.FinderException {
		IDOQuery sql = idoQuery();
		sql.appendSelectAllFrom(this.getEntityName());
		if (category != null) {
			sql.appendWhereEquals(SCHOOL_CATEGORY, category);
		} else if (useNullValue) {
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

	public Collection<?> ejbFindAllBySchoolType(int type) throws FinderException {
		StringBuffer sql = new StringBuffer("select distinct a.* ");
		sql.append(" from sch_school_area a,sch_school s,sch_school_type t,sch_school_sch_school_type m ");
		sql.append(" where a.sch_school_area_id = s.sch_school_area_id ");
		sql.append(" and t.sch_school_type_id = m.sch_school_type_id ");
		sql.append(" and s.sch_school_id = m.sch_school_id ");
		sql.append(" and t.sch_school_type_id = ");
		sql.append(type);
		sql.append(" order by a.AREA_NAME asc");

		return super.idoFindPKsBySQL(sql.toString());
	}

	public Collection<?> ejbFindAllBySchoolTypeAndCity(int type, String city) throws javax.ejb.FinderException {
		StringBuffer sql = new StringBuffer("select distinct a.* ");
		sql.append(" from sch_school_area a,sch_school s,sch_school_type t,sch_school_sch_school_type m ");
		sql.append(" where a.sch_school_area_id = s.sch_school_area_id ");
		sql.append(" and t.sch_school_type_id = m.sch_school_type_id ");
		sql.append(" and s.sch_school_id = m.sch_school_id ");
		sql.append(" and t.sch_school_type_id = ");
		sql.append(type);
		sql.append(" and ").append(CITY).append(" = '").append(city).append("'");
		sql.append(" order by ").append(NAME);

		return super.idoFindPKsBySQL(sql.toString());
	}

	public Collection<?> ejbFindAllBySchoolTypeCityAndManagementTypes(int schoolTypeId, String city, Collection<String> managementTypes) throws FinderException {
		StringBuffer sql = new StringBuffer("select distinct a.* ");
		sql.append(" from sch_school_area a,sch_school s,sch_school_type t,sch_school_sch_school_type m ");
		sql.append(" where a.sch_school_area_id = s.sch_school_area_id ");
		sql.append(" and t.sch_school_type_id = m.sch_school_type_id ");
		sql.append(" and s.sch_school_id = m.sch_school_id ");
		sql.append(" and t.sch_school_type_id = ");
		sql.append(schoolTypeId);
		sql.append(" and ").append(CITY).append(" = '").append(city).append("'");
		if (managementTypes != null && !managementTypes.isEmpty()) {
			sql.append(" and s.management_type in (");
			for (Iterator<String> typesIter = managementTypes.iterator(); typesIter.hasNext();) {
				sql.append("'").append(typesIter.next()).append("'");
				if (typesIter.hasNext()) {
					sql.append(",");
				}
			}
			sql.append(")");
		}
		sql.append(" order by a.").append(NAME);

		return super.idoFindPKsBySQL(sql.toString());
	}

	public Collection<?> ejbFindAllBySchoolTypes(Collection<SchoolType> types) throws FinderException {
		StringBuffer sql = new StringBuffer("select distinct a.* ");
		sql.append(" from sch_school_area a, sch_school s, sch_school_type t, sch_school_sch_school_type m ");
		sql.append(" where a.sch_school_area_id = s.sch_school_area_id ");
		sql.append(" and t.sch_school_type_id = m.sch_school_type_id ");
		sql.append(" and s.sch_school_id = m.sch_school_id ");
		sql.append(" and t.sch_school_type_id in (");
		for (Iterator<SchoolType> typesIter = types.iterator(); typesIter.hasNext();) {
			sql.append(typesIter.next().getPrimaryKey().toString());
			if (typesIter.hasNext())
				sql.append(CoreConstants.COMMA).append(CoreConstants.SPACE);
		}
		sql.append(")");
		sql.append(" order by a.").append(NAME);

		return super.idoFindPKsBySQL(sql.toString());
	}
}