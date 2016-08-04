package com.idega.block.school.data;

import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.data.GenericEntity;
import com.idega.data.query.MatchCriteria;
import com.idega.data.query.SelectQuery;
import com.idega.data.query.Table;
import com.idega.data.query.WildCardColumn;

public class SchoolSeasonExternalIdBMPBean extends GenericEntity implements SchoolSeasonExternalId {
	private static final long serialVersionUID = 3587448825180516338L;

	public final static String TABLE_NAME = "sch_school_season_ext_id";

	public final static String TYPE = "type";
	public static final String EXTERNAL_ID = "external_id";
	public final static String SCHOOL_SEASON = "school_season";

	@Override
	public String getEntityName() {
		return TABLE_NAME;
	}

	@Override
	public void initializeAttributes() {
		addAttribute(getIDColumnName());
		addAttribute(TYPE, "Type", true, true, String.class);
		addAttribute(EXTERNAL_ID, "External ID", Integer.class);

		addOneToOneRelationship(SCHOOL_SEASON, SchoolSeason.class);
		getEntityDefinition().setBeanCachingActiveByDefault(true);
	}

	@Override
	public String getType() {
		return getStringColumnValue(TYPE);
	}

	@Override
	public void setType(String type) {
		setColumn(TYPE, type);
	}

	@Override
	public int getExternalID() {
		return getIntColumnValue(EXTERNAL_ID, 0);
	}

	@Override
	public void setExternalID(int externalID) {
		setColumn(EXTERNAL_ID, externalID);
	}


	@Override
	public SchoolSeason getSchoolSeason() {
		return (SchoolSeason) getColumnValue(SCHOOL_SEASON);
	}

	@Override
	public String getSchoolSeasonPK() {
		return getStringColumnValue(SCHOOL_SEASON);
	}

	@Override
	public void setSchoolSeason(SchoolSeason schoolSeason) {
		setColumn(SCHOOL_SEASON, schoolSeason);
	}

	@Override
	public void setSchoolSeason(Object schoolSeasonPK) {
		setColumn(SCHOOL_SEASON, schoolSeasonPK);
	}

	public Object ejbFindSchoolSeasonExternalIdBySchoolSeasonAndType(SchoolSeason schoolSeason, String type) throws FinderException {
		Table table = new Table(this);

		SelectQuery query = new SelectQuery(table);
		query.addColumn(new WildCardColumn());
		query.addCriteria(new MatchCriteria(table, SCHOOL_SEASON, MatchCriteria.EQUALS, schoolSeason));
		query.addCriteria(new MatchCriteria(table, TYPE, MatchCriteria.EQUALS, type));

		return idoFindOnePKByQuery(query);
	}

	public Collection ejbFindAll() throws FinderException {
		Table table = new Table(this);

		SelectQuery query = new SelectQuery(table);
		query.addColumn(new WildCardColumn());
		query.addOrder(table, SCHOOL_SEASON, true);

		return idoFindPKsByQuery(query);
	}


}
