/*
 * $Id: SchoolSeasonHomeImpl.java,v 1.13 2006/01/25 00:27:24 gimmi Exp $
 * Created on Jan 12, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.school.data;

import java.sql.Date;
import java.util.Collection;
import javax.ejb.FinderException;
import com.idega.data.IDOFactory;


/**
 * <p>
 * TODO gimmi Describe Type SchoolSeasonHomeImpl
 * </p>
 *  Last modified: $Date: 2006/01/25 00:27:24 $ by $Author: gimmi $
 * 
 * @author <a href="mailto:gimmi@idega.com">gimmi</a>
 * @version $Revision: 1.13 $
 */
public class SchoolSeasonHomeImpl extends IDOFactory implements SchoolSeasonHome {

	protected Class getEntityInterfaceClass() {
		return SchoolSeason.class;
	}

	public SchoolSeason create() throws javax.ejb.CreateException {
		return (SchoolSeason) super.createIDO();
	}

	public SchoolSeason findByPrimaryKey(Object pk) throws javax.ejb.FinderException {
		return (SchoolSeason) super.findByPrimaryKeyIDO(pk);
	}

	public java.util.Collection findAllSchoolSeasons() throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolSeasonBMPBean) entity).ejbFindAllSchoolSeasons();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public java.util.Collection findAllSchoolSeasonsWithoutCategory() throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolSeasonBMPBean) entity).ejbFindAllSchoolSeasonsWithoutCategory();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public java.util.Collection findAllSchoolSeasons(SchoolCategory category) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolSeasonBMPBean) entity).ejbFindAllSchoolSeasons(category);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public java.util.Collection findAllPreviousSchoolSeasons(SchoolSeason schoolSeason) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolSeasonBMPBean) entity).ejbFindAllPreviousSchoolSeasons(schoolSeason);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolSeason findPreviousSchoolSeason(SchoolSeason schoolSeason) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolSeasonBMPBean) entity).ejbFindPreviousSchoolSeason(schoolSeason);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolSeason findSeasonByDate(SchoolCategory category, Date date) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolSeasonBMPBean) entity).ejbFindSeasonByDate(category, date);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public Collection findPendingSeasonsByDate(SchoolCategory category, Date date) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolSeasonBMPBean) entity).ejbFindPendingSeasonsByDate(category, date);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolSeason findByNameAndCategory(String name, SchoolCategory category) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolSeasonBMPBean) entity).ejbFindByNameAndCategory(name, category);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolSeason findCurrentSeason(SchoolCategory category) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolSeasonBMPBean) entity).ejbFindCurrentSeason(category);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public Collection findSchoolSeasonsActiveInTimePeriod(SchoolCategory category, Date firstDateInPeriod,
			Date lastDateInPeriod) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolSeasonBMPBean) entity).ejbFindSchoolSeasonsActiveInTimePeriod(category,
				firstDateInPeriod, lastDateInPeriod);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public Collection findCurrentSchoolSeasons(SchoolCategory category) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((SchoolSeasonBMPBean) entity).ejbFindCurrentSchoolSeasons(category);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public SchoolSeason findNextSeason(SchoolSeason currentSeason) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolSeasonBMPBean) entity).ejbFindNextSeason(currentSeason);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public SchoolSeason findNextSeason(SchoolCategory category, Date date) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((SchoolSeasonBMPBean) entity).ejbFindNextSeason(category, date);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}
}
