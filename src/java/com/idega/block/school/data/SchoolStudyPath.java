/**
 *
 */
package com.idega.block.school.data;

import java.util.Collection;

import com.idega.data.IDOAddRelationshipException;
import com.idega.data.IDOEntity;
import com.idega.data.IDORelationshipException;
import com.idega.data.IDORemoveRelationshipException;


/**
 * <p>
 * TODO Dainis Describe Type SchoolStudyPath
 * </p>
 *  Last modified: $Date: 2006/03/08 11:51:36 $ by $Author: dainis $
 *
 * @author <a href="mailto:Dainis@idega.com">Dainis</a>
 * @version $Revision: 1.16 $
 */
public interface SchoolStudyPath extends IDOEntity {

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getCode
	 */
	public String getCode();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#setCode
	 */
	public void setCode(String code);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getDescription
	 */
	public String getDescription();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#setDescription
	 */
	public void setDescription(String description);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getLocalizedKey
	 */
	public String getLocalizedKey();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#setLocalizedKey
	 */
	public void setLocalizedKey(String localizedKey);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getSchoolType
	 */
	public SchoolType getSchoolType();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getSchoolTypeId
	 */
	public int getSchoolTypeId();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#setSchoolTypeId
	 */
	public void setSchoolTypeId(Object schoolTypeId);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getSchoolCategory
	 */
	public SchoolType getSchoolCategory();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getSchoolCategoryPK
	 */
	public Object getSchoolCategoryPK();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#setSchoolCategory
	 */
	public void setSchoolCategory(Object schoolCategory);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#isValid
	 */
	public boolean isValid();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#setIsValid
	 */
	public void setIsValid(boolean isValid);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getPoints
	 */
	public int getPoints();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#setPoints
	 */
	public void setPoints(int points);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getStudyPathGroup
	 */
	public SchoolStudyPathGroup getStudyPathGroup();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getStudyPathGroupID
	 */
	public int getStudyPathGroupID();

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#setStudyPathGroupID
	 */
	public void setStudyPathGroupID(int study_path_group);

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#addSchool
	 */
	public void addSchool(School school) throws IDOAddRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#addSchoolYear
	 */
	public void addSchoolYear(SchoolYear year) throws IDOAddRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#removeSchool
	 */
	public void removeSchool(School school) throws IDORemoveRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#getSchools
	 */
	public Collection<School> getSchools() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathBMPBean#removeAllSchools
	 */
	public void removeAllSchools() throws IDORemoveRelationshipException;
}
