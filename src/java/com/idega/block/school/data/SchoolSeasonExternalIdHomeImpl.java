package com.idega.block.school.data;

import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.data.IDOFactory;

public class SchoolSeasonExternalIdHomeImpl extends IDOFactory implements SchoolSeasonExternalIdHome {
	private static final long serialVersionUID = 8150866953787362045L;


	@Override
	protected Class getEntityInterfaceClass() {
		return SchoolSeasonExternalId.class;
	}

	@Override
	public SchoolSeasonExternalId create() throws javax.ejb.CreateException {
		return (SchoolSeasonExternalId) super.createIDO();
	}

	@Override
	public SchoolSeasonExternalId findByPrimaryKey(Object pk) throws javax.ejb.FinderException {
		return (SchoolSeasonExternalId) super.findByPrimaryKeyIDO(pk);
	}


	@Override
	public SchoolSeasonExternalId findSchoolSeasonExternalIdBySchoolSeasonAndType(SchoolSeason schoolSeason, String type) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolSeasonExternalIdBMPBean) entity).ejbFindSchoolSeasonExternalIdBySchoolSeasonAndType(schoolSeason, type);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	@Override
	public Collection<SchoolSeasonExternalId> findAll() throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((SchoolSeasonExternalIdBMPBean) entity).ejbFindAll();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

}
