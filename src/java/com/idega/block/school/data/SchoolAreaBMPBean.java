package com.idega.block.school.data;

import static is.idega.idegaweb.egov.course.data.CourseProviderAreaBMPBean.COLUMN_CITY;
import static is.idega.idegaweb.egov.course.data.CourseProviderAreaBMPBean.COLUMN_INFO;
import is.idega.idegaweb.egov.course.data.CourseProviderAreaBMPBean;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.FinderException;

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

public class SchoolAreaBMPBean extends CourseProviderAreaBMPBean implements SchoolArea {

	private static final long serialVersionUID = 8241605681334027622L;

	public final static String SCHOOL = "SCH_SCHOOL_AREA";

	public void initializeAttributes() {
		this.addAttribute(getIDColumnName());
		this.addAttribute(COLUMN_NAME, "Schoolname", true, true, String.class);
		this.addAttribute(COLUMN_INFO, "Info", true, true, String.class);
		this.addAttribute(COLUMN_CITY, "City", true, true, String.class);
		this.addAttribute(COLUMN_ACCOUNTING_KEY, "Accounting key", true, true, String.class);

		addManyToOneRelationship(COLUMN_SCHOOL_CATEGORY, SchoolCategory.class);
		getEntityDefinition().setBeanCachingActiveByDefault(true);
	}


	public String getEntityName() {
		return SCHOOL;
	}

	// Getters
	public SchoolCategory getCategory() {
		return (SchoolCategory) getColumnValue(COLUMN_SCHOOL_CATEGORY);
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
		sql.append(" and ").append(COLUMN_CITY).append(" = '").append(city).append("'");
		sql.append(" order by ").append(COLUMN_NAME);

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
		sql.append(" and ").append(COLUMN_CITY).append(" = '").append(city).append("'");
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
		sql.append(" order by a.").append(COLUMN_NAME);

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
		sql.append(" order by a.").append(COLUMN_NAME);

		return super.idoFindPKsBySQL(sql.toString());
	}
}