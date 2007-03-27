package com.idega.block.school.data;


import com.idega.data.IDOEntity;

public interface SchoolCategory extends IDOEntity {

	/**
	 * @see com.idega.block.school.data.SchoolCategoryBMPBean#getPrimaryKeyClass
	 */
	public Class getPrimaryKeyClass();

	/**
	 * @see com.idega.block.school.data.SchoolCategoryBMPBean#setCategory
	 */
	public void setCategory(String category);

	/**
	 * @see com.idega.block.school.data.SchoolCategoryBMPBean#setName
	 */
	public void setName(String name);

	/**
	 * @see com.idega.block.school.data.SchoolCategoryBMPBean#setLocalizedKey
	 */
	public void setLocalizedKey(String key);

	/**
	 * @see com.idega.block.school.data.SchoolCategoryBMPBean#getCategory
	 */
	public String getCategory();

	/**
	 * @see com.idega.block.school.data.SchoolCategoryBMPBean#getName
	 */
	public String getName();

	/**
	 * @see com.idega.block.school.data.SchoolCategoryBMPBean#getLocalizedKey
	 */
	public String getLocalizedKey();
}