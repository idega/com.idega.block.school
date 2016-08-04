package com.idega.block.school.data;

import com.idega.data.IDOEntity;

public interface SchoolSeasonExternalId extends IDOEntity {
	public String getType();

	public void setType(String type);

	public int getExternalID();

	public void setExternalID(int externalID);

	public SchoolSeason getSchoolSeason();

	public String getSchoolSeasonPK();

	public void setSchoolSeason(SchoolSeason schoolSeason);

	public void setSchoolSeason(Object schoolSeasonPK);


}
