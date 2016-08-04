package com.idega.block.school.data;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.idega.data.IDOHome;

public interface SchoolSeasonExternalIdHome extends IDOHome {

	public SchoolSeasonExternalId create() throws CreateException;

	public SchoolSeasonExternalId findByPrimaryKey(Object pk) throws FinderException;

	public SchoolSeasonExternalId findSchoolSeasonExternalIdBySchoolSeasonAndType(SchoolSeason schoolSeason, String type) throws FinderException;

	public Collection<SchoolSeasonExternalId> findAll() throws FinderException;
}
