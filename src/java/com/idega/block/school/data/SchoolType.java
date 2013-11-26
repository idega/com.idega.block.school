/**
 * 
 */
package com.idega.block.school.data;

import is.idega.idegaweb.egov.course.data.CourseProviderType;


/**
 * <p>
 * TODO is Describe Type SchoolType
 * </p>
 *  Last modified: $Date: 2006/05/15 09:39:02 $ by $Author: igors $
 * 
 * @author <a href="mailto:is@idega.com">is</a>
 * @version $Revision: 1.17 $
 */
public interface SchoolType extends CourseProviderType {

	public void setSchoolTypeInfo(String info);

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#getSchoolTypeInfo
	 */
	public String getSchoolTypeInfo();

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#getCategory
	 */
	public SchoolCategory getCategory();

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#getMaxSchoolAge
	 */
	public int getMaxSchoolAge();

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#setMaxSchoolAge
	 */
	public void setMaxSchoolAge(int maxAge);

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#getIsFreetimeType
	 */
	public boolean getIsFreetimeType();

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#setIsFreetimeType
	 */
	public void setIsFreetimeType(boolean isFreetimeType);

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#isSelectable
	 */
	public boolean isSelectable();

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#setSelectable
	 */
	public void setSelectable(boolean isSelectable);

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#getIsFamilyFreetimeType
	 */
	public boolean getIsFamilyFreetimeType();

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#setIsFamilyFreetimeType
	 */
	public void setIsFamilyFreetimeType(boolean isFamilyFreetimeType);

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#getOrder
	 */
	public int getOrder();

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#setOrder
	 */
	public void setOrder(int order);

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#getTypeStringId
	 */
	public String getTypeStringId();

	/**
	 * @see com.idega.block.school.data.SchoolTypeBMPBean#setTypeStringId
	 */
	public void setTypeStringId(String typeStringId);
}
