package com.idega.block.school.data;


import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.block.text.data.LocalizedText;
import com.idega.core.file.data.ICFile;
import com.idega.core.location.data.Commune;
import com.idega.core.location.data.Country;
import com.idega.data.IDOAddRelationshipException;
import com.idega.data.IDOEntity;
import com.idega.data.IDOException;
import com.idega.data.IDOLegacyEntity;
import com.idega.data.IDORelationshipException;
import com.idega.data.IDORemoveRelationshipException;
import com.idega.data.MetaDataCapable;
import com.idega.user.data.Group;

public interface School extends IDOEntity, IDOLegacyEntity, MetaDataCapable {
	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getPrimaryGroup
	 */
	public Group getPrimaryGroup();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setPrimaryGroup
	 */
	public void setPrimaryGroup(Group group);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getName
	 */
	@Override
	public String getName();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getNameWithStarIfQueueSortedByBirthdate
	 */
	public String getNameWithStarIfQueueSortedByBirthdate();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getAfterSchoolCareProvider
	 */
	public School getAfterSchoolCareProvider();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getAfterSchoolCareProviderPK
	 */
	public Object getAfterSchoolCareProviderPK();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setAfterSchoolCareProvider
	 */
	public void setAfterSchoolCareProvider(School provider);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setAfterSchoolCareProvider
	 */
	public void setAfterSchoolCareProvider(Object providerPK);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getJuniorHighSchool
	 */
	public School getJuniorHighSchool();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getJuniorHighSchoolPK
	 */
	public Object getJuniorHighSchoolPK();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#hasRefreshments
	 */
	public boolean hasRefreshments();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#hasReview
	 */
	public boolean hasReview();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#hasPreCare
	 */
	public boolean hasPreCare();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#hasPostCare
	 */
	public boolean hasPostCare();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#hasHandicap
	 */
	public boolean hasHandicap();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getHasDGK
	 */
	public boolean getHasDGK();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setJuniorHighSchool
	 */
	public void setJuniorHighSchool(School school);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setJuniorHighSchool
	 */
	public void setJuniorHighSchool(Object schoolPK);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolAreaId
	 */
	public int getSchoolAreaId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolSubAreaId
	 */
	public int getSchoolSubAreaId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolArea
	 */
	public SchoolArea getSchoolArea();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolSubArea
	 */
	public SchoolSubArea getSchoolSubArea();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolAreaId
	 */
	public void setSchoolAreaId(int id);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolArea
	 */
	public void setSchoolArea(SchoolArea area);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolSubAreaId
	 */
	public void setSchoolSubAreaId(int id);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getCommunePK
	 */
	public Object getCommunePK();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getCommune
	 */
	public Commune getCommune();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getCommuneId
	 */
	public int getCommuneId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setCommunePK
	 */
	public void setCommunePK(Object pk);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getCountryId
	 */
	public int getCountryId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getCountry
	 */
	public Country getCountry();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setCountryId
	 */
	public void setCountryId(int id);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getManagementTypeId
	 */
	public String getManagementTypeId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getManagementType
	 */
	public SchoolManagementType getManagementType();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setManagementTypeId
	 */
	public void setManagementTypeId(String id);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolName
	 */
	public String getSchoolName();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolName
	 */
	public void setSchoolName(String name);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolInfo
	 */
	public String getSchoolInfo();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolInfo
	 */
	public void setSchoolInfo(String info);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolAddress
	 */
	public String getSchoolAddress();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolAddress
	 */
	public void setSchoolAddress(String address);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolVisitAddress
	 */
	public String getSchoolVisitAddress();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolVisitAddress
	 */
	public void setSchoolVisitAddress(String visitaddress);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setHasRefreshments
	 */
	public void setHasRefreshments(boolean hasRefreshments);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setHasReview
	 */
	public void setHasReview(boolean hasReview);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setHasPreCare
	 */
	public void setHasPreCare(boolean hasPreCare);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setHasPostCare
	 */
	public void setHasPostCare(boolean hasPostCare);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setHasHandicap
	 */
	public void setHasHandicap(boolean hasHandicap);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setHasDGK
	 */
	public void setHasDGK(boolean hasDGK);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolZipArea
	 */
	public String getSchoolZipArea();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolZipArea
	 */
	public void setSchoolZipArea(String ziparea);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolZipCode
	 */
	public String getSchoolZipCode();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolZipCode
	 */
	public void setSchoolZipCode(String zipcode);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolPhone
	 */
	public String getSchoolPhone();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolPhone
	 */
	public void setSchoolPhone(String phone);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolEmail
	 */
	public String getSchoolEmail();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolEmail
	 */
	public void setSchoolEmail(String email);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getHeadmasterGroupId
	 */
	public int getHeadmasterGroupId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getHeadmasterGroup
	 */
	public Group getHeadmasterGroup() throws RemoteException, FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setHeadmasterGroupId
	 */
	public void setHeadmasterGroupId(int masterGroupId);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolKeyCode
	 */
	public String getSchoolKeyCode();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolKeyCode
	 */
	public void setSchoolKeyCode(String code);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolLatitude
	 */
	public String getSchoolLatitude();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolLatitude
	 */
	public void setSchoolLatitude(String lat);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolLongitude
	 */
	public String getSchoolLongitude();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolLongitude
	 */
	public void setSchoolLongitude(String lon);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getOrganizationNumber
	 */
	public String getOrganizationNumber();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setOrganizationNumber
	 */
	public void setOrganizationNumber(String orgNo);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getExtraProviderId
	 */
	public String getExtraProviderId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setExtraProviderId
	 */
	public void setExtraProviderId(String id);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getTerminationDate
	 */
	public Date getTerminationDate();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setTerminationDate
	 */
	public void setTerminationDate(Date date);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getCentralizedAdministration
	 */
	public boolean getCentralizedAdministration();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setCentralizedAdministration
	 */
	public void setCentralizedAdministration(boolean b);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getInvisibleForCitizen
	 */
	public boolean getInvisibleForCitizen();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setInvisibleForCitizen
	 */
	public void setInvisibleForCitizen(boolean b);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getProviderStringId
	 */
	public String getProviderStringId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setProviderStringId
	 */
	public void setProviderStringId(String id);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#addSchoolTypes
	 */
	public void addSchoolTypes(int[] ids);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#addSchoolYears
	 */
	public void addSchoolYears(int[] ids);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#addSchoolYear
	 */
	public void addSchoolYear(SchoolYear year)
			throws IDOAddRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#addSchoolType
	 */
	public void addSchoolType(SchoolType type)
			throws IDOAddRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#addSchoolYearsRemoveOther
	 */
	public void addSchoolYearsRemoveOther(int[] ids);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#addSchoolTypesRemoveOther
	 */
	public void addSchoolTypesRemoveOther(int[] ids);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#findRelatedSchoolTypes
	 */
	public Collection findRelatedSchoolTypes() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#findRelatedSchoolTypes
	 */
	public Collection findRelatedSchoolTypes(SchoolCategory category)
			throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#findRelatedSchoolTypesWithFreetime
	 */
	public Collection findRelatedSchoolTypesWithFreetime(SchoolCategory category)
			throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#findRelatedSchoolYears
	 */
	public Collection findRelatedSchoolYears() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#findRelatedSchoolYearsSortedByName
	 */
	public Collection findRelatedSchoolYearsSortedByName() throws IDOException;

	public Collection findRelatedSchoolYearsSortedByAge() throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#findRelatedStudyPaths
	 */
	public Collection findRelatedStudyPaths() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getLocalizedText
	 */
	public LocalizedText getLocalizedText(int localeId)
			throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setLocalizedText
	 */
	public void setLocalizedText(String text, int localeId)
			throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolFax
	 */
	public String getSchoolFax();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolFax
	 */
	public void setSchoolFax(String fax);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolWebPage
	 */
	public String getSchoolWebPage();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolWebPage
	 */
	public void setSchoolWebPage(String webPage);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getMapUrl
	 */
	public String getMapUrl();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setMapUrl
	 */
	public void setMapUrl(String url);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getActivity
	 */
	public String getActivity();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setActivity
	 */
	public void setActivity(String activity);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getOpenHours
	 */
	public String getOpenHours();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setOpenHours
	 */
	public void setOpenHours(String openHours);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolManagementTypeString
	 */
	public String getSchoolManagementTypeString();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolManagementType
	 */
	public SchoolManagementType getSchoolManagementType();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSchoolManagementType
	 */
	public void setSchoolManagementType(String managementType);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getImages
	 */
	public Collection getImages() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSchoolTypes
	 */
	public Collection<SchoolType> getSchoolTypes() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#removeImages
	 */
	public void removeImages() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setImage
	 */
	public void setImage(ICFile image) throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#addImage
	 */
	public void addImage(ICFile image) throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setImages
	 */
	public void setImages(Collection images) throws IDORelationshipException,
			RemoteException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getHeadmasterUserId
	 */
	public int getHeadmasterUserId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setHeadmasterUserId
	 */
	public void setHeadmasterUserId(int userId);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getAssistantHeadmasterGroupId
	 */
	public int getAssistantHeadmasterGroupId();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setAssistantHeadmasterGroupId
	 */
	public void setAssistantHeadmasterGroupId(int groupId);

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#removeFromClass
	 */
	public void removeFromClass(Class entityInterfaceClass)
			throws IDORemoveRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#addStudyPath
	 */
	public void addStudyPath(SchoolStudyPath studyPath)
			throws IDOAddRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#removeStudyPath
	 */
	public void removeStudyPath(SchoolStudyPath studyPath)
			throws IDORemoveRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getStudyPaths
	 */
	public Collection getStudyPaths() throws IDORelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#removeAllStudyPaths
	 */
	public void removeAllStudyPaths() throws IDORemoveRelationshipException;

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#getSortByBirthdate
	 */
	public boolean getSortByBirthdate();

	/**
	 * @see com.idega.block.school.data.SchoolBMPBean#setSortByBirthdate
	 */
	public void setSortByBirthdate(boolean arg);

	public void setSchoolSystem(String schoolSystem);

	public String getSchoolSystem();

	public String getForeignId();

	public void setForeignId(String id);

	public String getIdForSync();

}