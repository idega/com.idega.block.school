package com.idega.block.school.data;


import com.idega.data.IDOEntity;

public interface SchoolArea extends IDOEntity {

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#getName
	 */
	public String getName();

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#getSchoolAreaName
	 */
	public String getSchoolAreaName();

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#getSchoolAreaInfo
	 */
	public String getSchoolAreaInfo();

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#getSchoolAreaCity
	 */
	public String getSchoolAreaCity();

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#getAccountingKey
	 */
	public String getAccountingKey();

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#getCategory
	 */
	public SchoolCategory getCategory();

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#setSchoolAreaName
	 */
	public void setSchoolAreaName(String name);

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#setSchoolAreaInfo
	 */
	public void setSchoolAreaInfo(String info);

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#setSchoolAreaCity
	 */
	public void setSchoolAreaCity(String city);

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#setAccountingKey
	 */
	public void setAccountingKey(String accountingKey);

	/**
	 * @see com.idega.block.school.data.SchoolAreaBMPBean#setCategory
	 */
	public void setCategory(SchoolCategory category);
}