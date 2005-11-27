/**
 * 
 */
package com.idega.block.school.data;

import com.idega.data.IDOEntity;


/**
 * <p>
 * TODO Dainis Describe Type SchoolStudyPathGroup
 * </p>
 *  Last modified: $Date: 2005/11/27 17:08:12 $ by $Author: dainis $
 * 
 * @author <a href="mailto:Dainis@idega.com">Dainis</a>
 * @version $Revision: 1.3 $
 */
public interface SchoolStudyPathGroup extends IDOEntity {

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathGroupBMPBean#getGroupName
	 */
	public String getGroupName();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathGroupBMPBean#setGroupName
	 */
	public void setGroupName(String groupname);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathGroupBMPBean#getLocalizationKey
	 */
	public String getLocalizationKey();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathGroupBMPBean#setLocalizationKey
	 */
	public void setLocalizationKey(String localizedkey);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathGroupBMPBean#getSchoolType
	 */
	public SchoolType getSchoolType();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathGroupBMPBean#setSchoolType
	 */
	public void setSchoolType(SchoolType type);
}
