/*
 * $Id: SchoolSeason.java,v 1.12 2006/01/25 00:27:23 gimmi Exp $
 * Created on Jan 12, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.school.data;

import java.sql.Date;

import javax.ejb.FinderException;

import com.idega.data.IDOEntity;


/**
 * <p>
 * TODO gimmi Describe Type SchoolSeason
 * </p>
 *  Last modified: $Date: 2006/01/25 00:27:23 $ by $Author: gimmi $
 *
 * @author <a href="mailto:gimmi@idega.com">gimmi</a>
 * @version $Revision: 1.12 $
 */
public interface SchoolSeason extends IDOEntity {

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getName
	 */
	public String getName();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getSchoolSeasonName
	 */
	public String getSchoolSeasonName();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#setSchoolSeasonName
	 */
	public void setSchoolSeasonName(String name);

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getSchoolSeasonEnd
	 */
	public Date getSchoolSeasonEnd();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#setSchoolSeasonEnd
	 */
	public void setSchoolSeasonEnd(java.util.Date end);

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getSchoolSeasonStart
	 */
	public Date getSchoolSeasonStart();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#setSchoolSeasonStart
	 */
	public void setSchoolSeasonStart(java.util.Date start);

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getChoiceEndDate
	 */
	public Date getChoiceEndDate();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#setChoiceEndDate
	 */
	public void setChoiceEndDate(java.util.Date due);

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getChoiceStartDate
	 */
	public Date getChoiceStartDate();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#setChoiceStartDate
	 */
	public void setChoiceStartDate(java.util.Date due);

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getSchoolCategory
	 */
	public SchoolCategory getSchoolCategory();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getSchoolCategoryPK
	 */
	public String getSchoolCategoryPK();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#setSchoolCategory
	 */
	public void setSchoolCategory(SchoolCategory category);

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#setSchoolCategory
	 */
	public void setSchoolCategory(Object categoryPK);

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getPreviousSeason
	 */
	public SchoolSeason getPreviousSeason() throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#getExternalID
	 */
	public int getExternalID();

	/**
	 * @see com.idega.block.school.data.SchoolSeasonBMPBean#setExternalID
	 */
	public void setExternalID(int externalID);

	public int getMinAge();

	public void setMinAge(int minAge);

	public int getMaxAge();

	public void setMaxAge(int maxAge);

}