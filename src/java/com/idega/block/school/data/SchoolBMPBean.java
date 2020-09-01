package com.idega.block.school.data;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.ejb.FinderException;

import com.idega.block.text.business.TextBusiness;
import com.idega.block.text.business.TextFinder;
import com.idega.block.text.data.LocalizedText;
import com.idega.block.text.data.TxText;
import com.idega.core.file.data.ICFile;
import com.idega.core.file.data.ICFileHome;
import com.idega.core.location.data.Commune;
import com.idega.core.location.data.CommuneHome;
import com.idega.core.location.data.Country;
import com.idega.data.GenericEntity;
import com.idega.data.IDOAddRelationshipException;
import com.idega.data.IDOEntity;
import com.idega.data.IDOException;
import com.idega.data.IDOFinderException;
import com.idega.data.IDOLegacyEntity;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.data.IDOQuery;
import com.idega.data.IDORelationshipException;
import com.idega.data.IDORemoveRelationshipException;
import com.idega.data.MetaDataCapable;
import com.idega.data.query.MatchCriteria;
import com.idega.data.query.SelectQuery;
import com.idega.data.query.Table;
import com.idega.user.data.Group;
import com.idega.user.data.GroupHome;
import com.idega.user.data.User;
import com.idega.util.CoreConstants;
import com.idega.util.StringUtil;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company:
 * </p>
 *
 * @author <br>
 *         <a href="mailto:aron@idega.is">Aron Birkir</a><br>
 * @version 1.0
 */

public class SchoolBMPBean extends GenericEntity implements School, IDOLegacyEntity, MetaDataCapable {

	private static final long serialVersionUID = -2233834309495357949L;

	public final static String SCHOOL = "sch_school";
	public final static String NAME = "SCHOOL_NAME";
	public final static String ADDRESS = "school_address";
	public final static String INFO = "school_info";
	public final static String HEADMASTER = "headmaster_group_id";
	public final static String SCHOOLTYPE = "sch_school_type_id";
	public final static String SCHOOLAREA = "sch_school_area_id";
	public final static String SCHOOLSUBAREA = "sch_school_sub_area_id";
	public final static String ZIPCODE = "zip_code";
	public final static String ZIPAREA = "zip_area";
	public final static String PHONE = "phone";
	public final static String EMAIL = "email";
	public final static String KEYCODE = "key_kode";
	public final static String LONGITUDE = "longitude";
	public final static String LATITUDE = "latitude";
	/** Gimmi 4-5 Nov 2002 */
	public final static String FAX = "fax_nr";
	public final static String WEB_PAGE = "web_page";
	// public final static String MANAGEMENT_TYPE_ID = "managment_type";
	public final static String MANAGEMENT_TYPE = "management_type";
	public final static String HEADMASTER_USER_ID = "headmaster_user_id";
	public final static String ASSISTANT_HEADMASTER_GROUP_ID = "assistant_hm_grp_id";
	public final static String MAP_URL = "map_url";
	/** Kelly 13-14 May 2003 */
	public final static String ACTIVITY = "activity";
	public final static String OPEN_HOURS = "open_hours";
	/** Laddi 3 Sep 2003 */
	public final static String COMMUNE = "commune";
	/** Anders 15 Sep 2003 */
	public final static String ORGANIZATION_NUMBER = "organization_number";
	public final static String EXTRA_PROVIDER_ID = "extra_provider_id";
	public final static String TERMINATION_DATE = "termination_date";
	public final static String COUNTRY = "country"; // Not connected to commune
	public final static String CENTRALIZED_ADMINISTRATION = "centralized_administration";
	/** Malin 10 Dec 2003 * */
	public final static String VISITADDRESS = "school_visit_address";
	// MANY TO MANY RELATIONSHIP TABLES
	public final static String M2M_TX_TEXT_SCH_SCHOOL = "TX_TEXT_SCH_SCHOOL";
	public final static String M2M_TX_LOCALIZED_TEXT_SCH_SCHOOL = "TX_LOCALIZED_TEXT_SCH_SCHOOL";
	public final static String INVISIBLE_FOR_CITIZEN = "invisible_for_citizen";
	/** Anders 10 Jan 2005 */
	public final static String PROVIDER_STRING_ID = "provider_string_id";
	public final static String JUNIOR_HIGH_SCHOOL = "junior_high_school_id";
	public final static String AFTER_SCHOOL_CARE_PROVIDER = "after_school_care_id";
	public final static String PARENT_SCHOOL = "parent_school_id";
	/** Dainis 23 Sep 2005 */
	public final static String SORT_BY_BIRTHDATE = "sort_by_birthdate";
	public static final String HAS_REFRESHMENTS = "has_refreshments";
	public static final String HAS_REVIEW = "has_review";
	public static final String HAS_PRE_CARE = "has_pre_care";
	public static final String HAS_POST_CARE = "has_post_care";
	/** Alex 27 July 2007 */
	public static final String HAS_HANDICAP = "has_handicap";

	public static final String COLUMN_HAS_DGK = "has_dgk";

	private static final String COLUMN_PRIMARY_GROUP = "primary_group_id";

	private static final String COLUMN_SCHOOL_SYSTEM = "school_system";

	public final static String COLUMN_FOREIGN_ID = "foreign_id";

	@Override
	public void initializeAttributes() {
		this.addAttribute(getIDColumnName());
		// this.addAttribute(SCHOOLTYPE,"Schooltype",true,true,Integer.class,this.MANY_TO_ONE,SchoolType.class);
		this.addAttribute(SCHOOLAREA, "Schoolarea", true, true, Integer.class, MANY_TO_ONE, SchoolArea.class);
		this.addAttribute(SCHOOLSUBAREA, "Schoolsubarea", true, true, Integer.class, MANY_TO_ONE, SchoolSubArea.class);
		this.addAttribute(NAME, "Schoolname", true, true, String.class);
		this.addAttribute(INFO, "Info", true, true, String.class, 4000);
		this.addAttribute(ADDRESS, "Address", true, true, String.class, 100);
		this.addAttribute(VISITADDRESS, "Visiting address", true, true, String.class, 400);
		this.addAttribute(ZIPAREA, "Ziparea", true, true, String.class, 20);
		this.addAttribute(ZIPCODE, "Zipcode", true, true, String.class, 20);
		this.addAttribute(PHONE, "phone", true, true, String.class, 60);
		this.addAttribute(EMAIL, "email", true, true, String.class, 60);
		this.addAttribute(KEYCODE, "keycode", true, true, String.class, 20);
		this.addAttribute(LATITUDE, "latitude", true, true, String.class, 20);
		this.addAttribute(LONGITUDE, "longitude", true, true, String.class, 20);
		this.addAttribute(HEADMASTER, "Headmaster", true, true, Integer.class, MANY_TO_ONE, Group.class);
		/** Gimmi 4-5 Nov 2002 */
		this.addAttribute(FAX, "fax", true, true, String.class, 50);
		this.addAttribute(WEB_PAGE, "web_page", true, true, String.class, 500);
		/** Laddi 3 Sep 2003 */
		// this.addAttribute(MANAGEMENT_TYPE_ID, "management_type", true, true, Integer.class);
		addManyToOneRelationship(MANAGEMENT_TYPE, SchoolManagementType.class);
		this.addAttribute(HEADMASTER_USER_ID, "headmaster user id", true, true, Integer.class, MANY_TO_ONE, User.class);
		this.addAttribute(ASSISTANT_HEADMASTER_GROUP_ID, "assistant headmaster group id", true, true, Integer.class, MANY_TO_ONE, Group.class);
		this.addAttribute(MAP_URL, "url to map", true, true, String.class, 500);
		/** Kelly 13-14 May 2003 */
		this.addAttribute(ACTIVITY, "The schools activity", true, true, String.class, 256);
		this.addAttribute(OPEN_HOURS, "The school open hours", true, true, String.class, 256);
		this.addManyToManyRelationShip(SchoolType.class);
		this.addManyToManyRelationShip(SchoolYear.class, "sch_school_sch_school_year");
		// Grimur 16.10.2002
		this.addManyToManyRelationShip(LocalizedText.class, M2M_TX_LOCALIZED_TEXT_SCH_SCHOOL); // in for backwards compatability
		this.addManyToManyRelationShip(ICFile.class);
		// Gimmi 27.12.2002
		this.addManyToManyRelationShip(TxText.class, M2M_TX_TEXT_SCH_SCHOOL);
		addManyToOneRelationship(COMMUNE, Commune.class);
		// Anders 15 Sep 2003
		this.addAttribute(ORGANIZATION_NUMBER, "organisationsnummer", true, true, String.class, 20);
		this.addAttribute(EXTRA_PROVIDER_ID, "user supplied provider id", true, true, String.class, 20);
		this.addAttribute(TERMINATION_DATE, "termination date", true, true, Date.class);
		addManyToOneRelationship(COUNTRY, Country.class);
		this.addAttribute(CENTRALIZED_ADMINISTRATION, "has provider centralized administration", true, true, Boolean.class);
		addAttribute(INVISIBLE_FOR_CITIZEN, "Do not show this provider for citizens", true, true, Boolean.class);
		this.addMetaDataRelationship();
		this.addManyToManyRelationShip(SchoolStudyPath.class, "sch_school_study_path");
		this.addAttribute(PROVIDER_STRING_ID, "Extra provider id", true, true, String.class, 40);
		addManyToOneRelationship(AFTER_SCHOOL_CARE_PROVIDER, School.class);
		addManyToOneRelationship(PARENT_SCHOOL, School.class);
		addManyToOneRelationship(JUNIOR_HIGH_SCHOOL, School.class);
		// Dainis 23 Sep 2005
		this.addAttribute(SORT_BY_BIRTHDATE, "Sorted by date of birth", true, true, Boolean.class);
		addAttribute(HAS_REFRESHMENTS, "Has refreshments", Boolean.class);
		addAttribute(HAS_REVIEW, "Has review", Boolean.class);
		addAttribute(HAS_PRE_CARE, "Has pre care", Boolean.class);
		addAttribute(HAS_POST_CARE, "Has post care", Boolean.class);
		/** Alex 27 July 2007 */
		addAttribute(HAS_HANDICAP, "Has handicap facilities", Boolean.class);

		addAttribute(COLUMN_HAS_DGK, "Has DGK", Boolean.class);

		addOneToOneRelationship(COLUMN_PRIMARY_GROUP, Group.class);

		this.addAttribute(COLUMN_SCHOOL_SYSTEM, "School system", true, true, String.class, 40);

		this.addAttribute(COLUMN_FOREIGN_ID, "Foreign school id", true, true, String.class, 40);

		getEntityDefinition().setBeanCachingActiveByDefault(true);
	}

	@Override
	public String getEntityName() {
		return SCHOOL;
	}

	@Override
	public Group getPrimaryGroup() {
		return (Group) getColumnValue(COLUMN_PRIMARY_GROUP);
	}

	@Override
	public void setPrimaryGroup(Group group) {
		setColumn(COLUMN_PRIMARY_GROUP, group);
	}

	@Override
	public String getName() {
		return getSchoolName();
	}

	@Override
	public String getNameWithStarIfQueueSortedByBirthdate() {
		return (this.getSortByBirthdate() ? "*" : "") + getSchoolName();
	}

	@Override
	public School getAfterSchoolCareProvider() {
		return (School) getColumnValue(AFTER_SCHOOL_CARE_PROVIDER);
	}

	@Override
	public Object getAfterSchoolCareProviderPK() {
		return getIntegerColumnValue(AFTER_SCHOOL_CARE_PROVIDER);
	}

	@Override
	public void setAfterSchoolCareProvider(School provider) {
		setColumn(AFTER_SCHOOL_CARE_PROVIDER, provider);
	}

	@Override
	public void setAfterSchoolCareProvider(Object providerPK) {
		setColumn(AFTER_SCHOOL_CARE_PROVIDER, providerPK);
	}

	@Override
	public School getJuniorHighSchool() {
		return (School) getColumnValue(JUNIOR_HIGH_SCHOOL);
	}

	@Override
	public Object getJuniorHighSchoolPK() {
		return getIntegerColumnValue(JUNIOR_HIGH_SCHOOL);
	}

	@Override
	public boolean hasRefreshments() {
		return getBooleanColumnValue(HAS_REFRESHMENTS, false);
	}

	@Override
	public boolean hasReview() {
		return getBooleanColumnValue(HAS_REVIEW, false);
	}

	@Override
	public boolean hasPreCare() {
		return getBooleanColumnValue(HAS_PRE_CARE, false);
	}

	@Override
	public boolean hasPostCare() {
		return getBooleanColumnValue(HAS_POST_CARE, false);
	}

	@Override
	public boolean hasHandicap() {
		return getBooleanColumnValue(HAS_HANDICAP, false);
	}

	@Override
	public boolean getHasDGK() {
		return getBooleanColumnValue(COLUMN_HAS_DGK, false);
	}

	@Override
	public void setJuniorHighSchool(School school) {
		setColumn(JUNIOR_HIGH_SCHOOL, school);
	}

	@Override
	public void setJuniorHighSchool(Object schoolPK) {
		setColumn(JUNIOR_HIGH_SCHOOL, schoolPK);
	}

	@Override
	public int getSchoolAreaId() {
		return this.getIntColumnValue(SCHOOLAREA);
	}

	@Override
	public int getSchoolSubAreaId() {
		return this.getIntColumnValue(SCHOOLSUBAREA);
	}

	@Override
	public SchoolArea getSchoolArea() {
		return (SchoolArea) getColumnValue(SCHOOLAREA);
	}

	@Override
	public SchoolSubArea getSchoolSubArea() {
		return (SchoolSubArea) getColumnValue(SCHOOLSUBAREA);
	}

	@Override
	public void setSchoolAreaId(int id) {
		this.setColumn(SCHOOLAREA, id);
	}

	@Override
	public void setSchoolArea(SchoolArea area) {
		this.setColumn(SCHOOLAREA, area);
	}

	@Override
	public void setSchoolSubAreaId(int id) {
		this.setColumn(SCHOOLSUBAREA, id);
	}

	@Override
	public Object getCommunePK() {
		Object communeId = getColumnValue(COMMUNE);
		if (communeId == null) {
			try {
				CommuneHome cHome = (CommuneHome) IDOLookup.getHome(Commune.class);
				Commune comm = cHome.findDefaultCommune();
				if (comm != null) {
					this.setCommunePK(comm.getPrimaryKey());
					this.store();
					return comm.getPrimaryKey();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return communeId;
	}

	@Override
	public Commune getCommune() {
		return (Commune) getColumnValue(COMMUNE);
	}

	@Override
	public int getCommuneId() {
		return this.getIntColumnValue(COMMUNE);
	}

	@Override
	public void setCommunePK(Object pk) {
		this.setColumn(COMMUNE, pk);
	}

	@Override
	public int getCountryId() {
		return this.getIntColumnValue(COUNTRY);
	}

	@Override
	public Country getCountry() {
		return (Country) getColumnValue(COUNTRY);
	}

	@Override
	public void setCountryId(int id) {
		this.setColumn(COUNTRY, id);
	}

	@Override
	public String getManagementTypeId() {
		return this.getStringColumnValue(MANAGEMENT_TYPE);
	}

	@Override
	public SchoolManagementType getManagementType() {
		return (SchoolManagementType) getColumnValue(MANAGEMENT_TYPE);
	}

	@Override
	public void setManagementTypeId(String id) {
		this.setColumn(MANAGEMENT_TYPE, id);
	}

	@Override
	public String getSchoolName() {
		return this.getStringColumnValue(NAME);
	}

	@Override
	public void setSchoolName(String name) {
		this.setColumn(NAME, name);
	}

	@Override
	public String getSchoolInfo() {
		return this.getStringColumnValue(INFO);
	}

	@Override
	public String getSchoolSystem() {
		return this.getStringColumnValue(COLUMN_SCHOOL_SYSTEM);
	}


	@Override
	public void setSchoolInfo(String info) {
		this.setColumn(INFO, info);
	}

	@Override
	public String getSchoolAddress() {
		return this.getStringColumnValue(ADDRESS);
	}

	@Override
	public void setSchoolAddress(String address) {
		this.setColumn(ADDRESS, address);
	}

	@Override
	public String getSchoolVisitAddress() {
		return this.getStringColumnValue(VISITADDRESS);
	}

	@Override
	public void setSchoolVisitAddress(String visitaddress) {
		this.setColumn(VISITADDRESS, visitaddress);
	}

	@Override
	public void setHasRefreshments(boolean hasRefreshments) {
		setColumn(HAS_REFRESHMENTS, hasRefreshments);
	}

	@Override
	public void setHasReview(boolean hasReview) {
		setColumn(HAS_REVIEW, hasReview);
	}

	@Override
	public void setHasPreCare(boolean hasPreCare) {
		setColumn(HAS_PRE_CARE, hasPreCare);
	}

	@Override
	public void setHasPostCare(boolean hasPostCare) {
		setColumn(HAS_POST_CARE, hasPostCare);
	}

	@Override
	public void setHasHandicap(boolean hasHandicap) {
		setColumn(HAS_HANDICAP, hasHandicap);
	}

	@Override
	public void setHasDGK(boolean hasDGK) {
		setColumn(COLUMN_HAS_DGK, hasDGK);
	}

	@Override
	public String getSchoolZipArea() {
		return this.getStringColumnValue(ZIPAREA);
	}

	@Override
	public void setSchoolZipArea(String ziparea) {
		this.setColumn(ZIPAREA, ziparea);
	}

	@Override
	public String getSchoolZipCode() {
		return this.getStringColumnValue(ZIPCODE);
	}

	@Override
	public void setSchoolZipCode(String zipcode) {
		this.setColumn(ZIPCODE, zipcode);
	}

	@Override
	public String getSchoolPhone() {
		return this.getStringColumnValue(PHONE);
	}

	@Override
	public void setSchoolPhone(String phone) {
		this.setColumn(PHONE, phone);
	}

	@Override
	public String getSchoolEmail() {
		return this.getStringColumnValue(EMAIL);
	}

	@Override
	public void setSchoolEmail(String email) {
		this.setColumn(EMAIL, email);
	}

	@Override
	public int getHeadmasterGroupId() {
		return this.getIntColumnValue(HEADMASTER);
	}

	@Override
	public Group getHeadmasterGroup() throws RemoteException, FinderException {
		return ((GroupHome) IDOLookup.getHome(Group.class)).findByPrimaryKey(new Integer(getHeadmasterGroupId()));
	}

	@Override
	public void setHeadmasterGroupId(int masterGroupId) {
		this.setColumn(HEADMASTER, masterGroupId);
	}

	@Override
	public String getSchoolKeyCode() {
		return this.getStringColumnValue(KEYCODE);
	}

	@Override
	public void setSchoolKeyCode(String code) {
		this.setColumn(KEYCODE, code);
	}

	@Override
	public String getSchoolLatitude() {
		return this.getStringColumnValue(LATITUDE);
	}

	@Override
	public void setSchoolLatitude(String lat) {
		this.setColumn(LATITUDE, lat);
	}

	@Override
	public String getSchoolLongitude() {
		return this.getStringColumnValue(LONGITUDE);
	}

	@Override
	public void setSchoolLongitude(String lon) {
		this.setColumn(LONGITUDE, lon);
	}

	@Override
	public String getOrganizationNumber() {
		return this.getStringColumnValue(ORGANIZATION_NUMBER);
	}

	@Override
	public void setOrganizationNumber(String orgNo) {
		this.setColumn(ORGANIZATION_NUMBER, orgNo);
	}

	@Override
	public String getExtraProviderId() {
		return this.getStringColumnValue(EXTRA_PROVIDER_ID);
	}

	@Override
	public void setExtraProviderId(String id) {
		this.setColumn(EXTRA_PROVIDER_ID, id);
	}

	@Override
	public Date getTerminationDate() {
		return (Date) this.getColumnValue(TERMINATION_DATE);
	}

	@Override
	public void setTerminationDate(Date date) {
		this.setColumn(TERMINATION_DATE, date);
	}

	@Override
	public boolean getCentralizedAdministration() {
		boolean isCA = false;
		Boolean b = (Boolean) this.getColumnValue(CENTRALIZED_ADMINISTRATION);
		if (b != null) {
			isCA = b.booleanValue();
		}
		return isCA;
	}


	@Override
	public void setSchoolSystem(String schoolSystem) {
		this.setColumn(COLUMN_SCHOOL_SYSTEM, schoolSystem);
	}


	@Override
	public void setCentralizedAdministration(boolean b) {
		this.setColumn(CENTRALIZED_ADMINISTRATION, b);
	}

	@Override
	public boolean getInvisibleForCitizen() {
		return getBooleanColumnValue(INVISIBLE_FOR_CITIZEN, false);
	}

	@Override
	public void setInvisibleForCitizen(boolean b) {
		setColumn(INVISIBLE_FOR_CITIZEN, b);
	}

	@Override
	public String getProviderStringId() {
		return this.getStringColumnValue(PROVIDER_STRING_ID);
	}

	@Override
	public void setProviderStringId(String id) {
		this.setColumn(PROVIDER_STRING_ID, id);
	}


	@Override
	public String getForeignId() {
		return this.getStringColumnValue(COLUMN_FOREIGN_ID);
	}

	@Override
	public void setForeignId(String id) {
		this.setColumn(COLUMN_FOREIGN_ID, id);
	}

	@Override
	public String getIdForSync() {
		String schoolIdTmp = CoreConstants.EMPTY;
		if (!StringUtil.isEmpty(getForeignId())) {
			Logger.getLogger(SchoolBMPBean.class.getName()).info("Using the foreign school id for school with ID: " + getProviderStringId() + ", foreign ID: " + getForeignId());
			schoolIdTmp = getForeignId().trim();
		} else {
			schoolIdTmp = getProviderStringId().trim();
		}
		return schoolIdTmp;
	}


	private Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	public Collection ejbFindAllBySchoolType(Collection typeIds) throws javax.ejb.FinderException {
		if (typeIds == null || typeIds.size() < 1) {
			return null;
		}
		else {
			StringBuffer select = new StringBuffer("select distinct s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_type_id in (");
			select.append(getIDOUtil().convertListToCommaseparatedString(typeIds));
			select.append(") and m.sch_school_id = s.sch_school_id");
			select.append(" and (termination_date is null or termination_date > '" + getCurrentDate() + "')");
			select.append(" order by s.").append(NAME);
			return super.idoFindPKsBySQL(select.toString());
		}
	}

	public Collection ejbFindAllBySchoolType(int typeId) throws javax.ejb.FinderException {
		String select = "select s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_type_id = " + typeId + " and m.sch_school_id = s.sch_school_id " + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')" + " order by s." + NAME;
		return super.idoFindPKsBySQL(select);
	}

	public Collection ejbFindAllBySchoolType(SchoolType type) throws javax.ejb.FinderException {
		String select = "select s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_type_id = " + type.getPrimaryKey().toString() + " and m.sch_school_id = s.sch_school_id " + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')" + " order by s." + NAME;
		return super.idoFindPKsBySQL(select);
	}

	public Collection ejbFindAllByAreaTypeManagement(int areaId, int typeId, String managementType) throws javax.ejb.FinderException {
		String select = "select s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_type_id = " + typeId + " and m.sch_school_id = s.sch_school_id " + " and " + SCHOOLAREA + " = " + areaId + " and " + MANAGEMENT_TYPE + " = '" + managementType + "'" + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')" + " order by s." + NAME;
		return super.idoFindPKsBySQL(select);
	}

	public Collection ejbFindAllByAreaTypeManagementCommune(int areaId, int typeId, String managementType, int communeId) throws javax.ejb.FinderException {
		String select = "select s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_type_id = " + typeId + " and m.sch_school_id = s.sch_school_id " + " and " + SCHOOLAREA + " = " + areaId + " and " + MANAGEMENT_TYPE + " = '" + managementType + "'" + " and " + COMMUNE + " = " + communeId + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')" + " order by s." + NAME;
		return super.idoFindPKsBySQL(select);
	}

	public Collection ejbFindAllByAreaTypeManagementCommune(int areaId, int typeId, Collection managementTypes, int communeId) throws javax.ejb.FinderException {
		String select = "select s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_type_id = " + typeId + " and m.sch_school_id = s.sch_school_id " + " and " + SCHOOLAREA + " = " + areaId + " and " + COMMUNE + " = " + communeId + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')";
		if (managementTypes != null && !managementTypes.isEmpty()) {
			select += (" and s." + MANAGEMENT_TYPE + " in (");
			Iterator it = managementTypes.iterator();
			String type = null;
			while (it.hasNext()) {
				type = (String) it.next();
				select += "'" + type + "'";
				if (it.hasNext()) {
					select += ",";
				}
			}
			select += ")";
		}
		select += " order by s." + NAME;
		return super.idoFindPKsBySQL(select);
	}

	public Collection ejbFindAllByAreaTypeManagementCommune(int areaId, Collection typeIds, Collection managementTypes, int communeId) throws javax.ejb.FinderException {
		String select = "select distinct s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_id = s.sch_school_id " + " and " + SCHOOLAREA + " = " + areaId + " and " + COMMUNE + " = " + communeId + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')";
		if (typeIds != null && !typeIds.isEmpty()) {
			select += (" and m.sch_school_type_id in (");
			Iterator it = typeIds.iterator();
			Integer type = null;
			while (it.hasNext()) {
				type = (Integer) it.next();
				select += "'" + type + "'";
				if (it.hasNext()) {
					select += ",";
				}
			}
			select += ")";
		}
		if (managementTypes != null && !managementTypes.isEmpty()) {
			select += (" and s." + MANAGEMENT_TYPE + " in (");
			Iterator it = managementTypes.iterator();
			String type = null;
			while (it.hasNext()) {
				type = (String) it.next();
				select += "'" + type + "'";
				if (it.hasNext()) {
					select += ",";
				}
			}
			select += ")";
		}
		select += " order by s." + NAME;
		return super.idoFindPKsBySQL(select);
	}

	public Collection ejbFindAllByAreaTypeCommune(int areaId, int typeId, int communeId) throws javax.ejb.FinderException {
		String select = "select s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_type_id = " + typeId + " and m.sch_school_id = s.sch_school_id " + " and " + SCHOOLAREA + " = " + areaId + " and " + COMMUNE + " = " + communeId + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')" + " order by s." + NAME;
		return super.idoFindPKsBySQL(select);
	}

	public Collection ejbFindAllBySchoolName(String schoolName) throws javax.ejb.FinderException {
		String select = "select * from " + SCHOOL + " where " + NAME + " = '" + schoolName + "'" + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')";
		return super.idoFindPKsBySQL(select);
	}

	public Integer ejbFindBySchoolName(String schoolName) throws javax.ejb.FinderException {
		String select = "select * from " + SCHOOL + " where " + NAME + " = '" + schoolName + "'" + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')";

		return (Integer) super.idoFindOnePKBySQL(select);
	}

	public Integer ejbFindByOrganizationNumber(String organizationNumber) throws javax.ejb.FinderException {
		String select = "select * from " + SCHOOL + " where " + ORGANIZATION_NUMBER + " = '" + organizationNumber + "'" + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')";

		return (Integer) super.idoFindOnePKBySQL(select);
	}


	public Collection ejbFindAllCentralizedAdministrated() throws javax.ejb.FinderException {
		IDOQuery sql = idoQuery();
		sql.appendSelectAllFrom(this.getEntityName()).appendWhereEqualsQuoted(CENTRALIZED_ADMINISTRATION, "Y");
		sql.append(" and (termination_date is null or termination_date > '" + getCurrentDate() + "')");
		return super.idoFindPKsByQuery(sql);
	}

	public Collection ejbFindAllCentralizedAdministratedByType(Collection typeIds) throws javax.ejb.FinderException {
		if (typeIds == null || typeIds.size() < 1) {
			return null;
		}
		else {
			StringBuffer select = new StringBuffer("select distinct s.* from " + SCHOOL + " s,sch_school_sch_school_type m where m.sch_school_type_id in (");
			select.append(getIDOUtil().convertListToCommaseparatedString(typeIds));
			select.append(") and m.sch_school_id = s.sch_school_id");
			select.append(" and s." + CENTRALIZED_ADMINISTRATION + " like 'Y'");
			select.append(" and (termination_date is null or termination_date > '" + getCurrentDate() + "')");
			select.append(" order by s.").append(NAME);
			return super.idoFindPKsBySQL(select.toString());
		}
	}

	public Collection ejbFindAllByHandicapParameter(boolean hasHandicap) throws FinderException {
		IDOQuery query = idoQueryGetSelect();
		String flag = (hasHandicap) ? "Y" : "N";
		query.appendWhereEqualsQuoted(HAS_HANDICAP, flag);

		return idoFindPKsByQuery(query);
	}

	public Collection ejbFindAllBySchoolArea(int areaId) throws javax.ejb.FinderException {
		String sql = "select * from " + SCHOOL + " where " + SCHOOLAREA + " = " + areaId + " and (termination_date is null or termination_date > '" + getCurrentDate() + "')" + " order by " + NAME;
		return super.idoFindPKsBySQL(sql);
	}

	public Collection ejbFindAllSchools() throws javax.ejb.FinderException {
		// String sql = "select * from " + SCHOOL + " where " +
		// " (termination_date is null or termination_date > '" + getCurrentDate() + "')" +
		// " order by upper(" + NAME + ")";
		try {
			return super.idoFindPKsBySQL("select * from " + SCHOOL + " order by upper(" + NAME + ")");
		}
		catch (IDOFinderException ex) {
			// some databases doesn't understand UPPER
			return super.idoFindPKsBySQL("select * from " + SCHOOL + " order by " + NAME);
		}
	}

	public Collection ejbFindAllByParentSchool(School parent) throws javax.ejb.FinderException {
		Table table = new Table(this);

		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		query.addCriteria(new MatchCriteria(table.getColumn(PARENT_SCHOOL), MatchCriteria.EQUALS, parent));

		return idoFindPKsByQuery(query);
	}

	public Collection ejbFindAllSchoolsIncludingTerminated() throws javax.ejb.FinderException {
		// String sql = "select * from " + SCHOOL + " where " +
		// " order by upper(" + NAME + ")";
		return super.idoFindPKsBySQL("select * from " + SCHOOL + " order by upper(" + NAME + ")");
	}

	public Collection ejbFindAllSchoolsByCategoryIncludingTerminated(String category) throws javax.ejb.FinderException {
		String sql = "select unique s.* from " + SCHOOL + " s, " + "sch_school_type t, sch_school_sch_school_type st " + "where st.sch_school_type_id = t.sch_school_type_id " + "and st.sch_school_id = s.sch_school_id " + "and t.school_category = '" + category + "' " + "order by upper(s." + NAME + ")";

		return super.idoFindPKsBySQL(sql);
	}

	@Override
	public void addSchoolTypes(int[] ids) {
		try {
			super.addTo(SchoolType.class, ids);
		}
		catch (java.sql.SQLException sql) {
			sql.printStackTrace();
		}
	}

	@Override
	public void addSchoolYears(int[] ids) {
		try {
			super.addTo(SchoolYear.class, ids);
		}
		catch (java.sql.SQLException sql) {

		}
	}

	@Override
	public void addSchoolYear(SchoolYear year) throws IDOAddRelationshipException {
		super.idoAddTo(year);
	}

	@Override
	public void addSchoolType(SchoolType type) throws IDOAddRelationshipException {
		super.idoAddTo(type);
	}

	@Override
	public void addSchoolYearsRemoveOther(int[] ids) {
		try {
			super.removeFrom(SchoolYear.class);
		}
		catch (java.sql.SQLException ex) {
		}
		this.addSchoolYears(ids);
	}

	@Override
	public void addSchoolTypesRemoveOther(int[] ids) {
		try {
			super.removeFrom(SchoolType.class);
		}
		catch (java.sql.SQLException ex) {
		}
		this.addSchoolTypes(ids);
	}

	@Override
	public Collection findRelatedSchoolTypes() throws com.idega.data.IDORelationshipException {
		return super.idoGetRelatedEntities(SchoolType.class);
	}

	@Override
	public Collection findRelatedSchoolTypes(SchoolCategory category) throws IDORelationshipException {
		Collection coll = findRelatedSchoolTypes();
		Collection types = new ArrayList();
		if (coll != null) {
			Iterator iter = coll.iterator();
			while (iter.hasNext()) {
				SchoolType type = (SchoolType) iter.next();
				if (type.getSchoolCategory().equals(category.getCategory())) {
					types.add(type);
				}
			}
		}
		return types;
	}

	@Override
	public Collection findRelatedSchoolTypesWithFreetime(SchoolCategory category) throws IDORelationshipException {
		Collection coll = findRelatedSchoolTypes();
		Collection types = new ArrayList();
		if (coll != null) {
			Iterator iter = coll.iterator();
			while (iter.hasNext()) {
				SchoolType type = (SchoolType) iter.next();
				if (type.getSchoolCategory().equals(category.getCategory()) && type.getIsFamilyFreetimeType()) {
					types.add(type);
				}
			}
		}
		return types;
	}

	@Override
	public Collection findRelatedSchoolYears() throws com.idega.data.IDORelationshipException {
		return super.idoGetRelatedEntities(SchoolYear.class);
	}

	@Override
	public Collection findRelatedSchoolYearsSortedByName() throws IDOException {
		return this.idoGetRelatedEntitiesOrderedByColumn(SchoolYear.class, SchoolYearBMPBean.NAME);
	}

	@Override
	public Collection findRelatedSchoolYearsSortedByAge() throws IDOException {
		return this.idoGetRelatedEntitiesOrderedByColumn(SchoolYear.class, SchoolYearBMPBean.AGE);
	}

	@Override
	public java.util.Collection findRelatedStudyPaths() throws com.idega.data.IDORelationshipException {
		return this.idoGetRelatedEntities(SchoolStudyPath.class);
	}

	public Collection ejbFindAllByAreaAndType(int area, int type) throws javax.ejb.FinderException {
		StringBuffer sql = new StringBuffer("select s.* ");
		sql.append(" from sch_school_area a, sch_school s, sch_school_type t, sch_school_sch_school_type m ");
		sql.append(" where a.sch_school_area_id = s.sch_school_area_id ");
		sql.append(" and t.sch_school_type_id = m.sch_school_type_id ");
		sql.append(" and s.sch_school_id = m.sch_school_id ");
		sql.append(" and t.sch_school_type_id = ");
		sql.append(type);
		sql.append(" and a.sch_school_area_id = ");
		sql.append(area);
		sql.append(" and (termination_date is null or termination_date > '" + getCurrentDate() + "')");
		sql.append(" order by s.").append(NAME);

		return super.idoFindPKsBySQL(sql.toString());

	}

	public Collection ejbFindAllByInQuery(String inQuery) throws FinderException {
		StringBuffer sql = new StringBuffer("select * from sch_school where sch_school_id in (");
		sql.append(inQuery).append(") order by ").append(NAME);

		return idoFindPKsBySQL(sql.toString());
	}

	public Collection ejbFindAllByAreaAndTypeAndYear(int areaID, int typeID, int yearID) throws javax.ejb.FinderException {
		StringBuffer sql = new StringBuffer("select s.* ");
		sql.append(" from sch_school_sch_school_year ssy,sch_school_area a, sch_school s, sch_school_type t, sch_school_sch_school_type m ");
		sql.append(" where a.sch_school_area_id = s.sch_school_area_id ");
		sql.append(" and t.sch_school_type_id = m.sch_school_type_id ");
		sql.append(" and s.sch_school_id = m.sch_school_id ");
		sql.append(" and m.sch_school_id = ssy.sch_school_id ");
		sql.append(" and t.sch_school_type_id = ");
		sql.append(typeID);
		sql.append(" and a.sch_school_area_id = ");
		sql.append(areaID);
		sql.append(" and ssy.sch_school_year_id = ");
		sql.append(yearID);
		sql.append(" order by s.").append(NAME);

		return super.idoFindPKsBySQL(sql.toString());

	}

	public Collection ejbFindAllByAreaAndTypes(int area, Collection types) throws javax.ejb.FinderException {
		return ejbFindAllByAreaAndTypesAndYear(area, types, -1);
	}

	public Collection ejbFindAllByAreaAndTypesAndYear(int area, Collection types, int yearID) throws javax.ejb.FinderException {
		StringBuffer sql = new StringBuffer("select distinct s.* ");
		sql.append(" from sch_school_area a, sch_school s, sch_school_type t, sch_school_sch_school_type m");
		if (yearID != -1) {
			sql.append(", sch_school_sch_school_year ssy");
		}
		sql.append(" where a.sch_school_area_id = s.sch_school_area_id ");
		sql.append(" and t.sch_school_type_id = m.sch_school_type_id ");
		sql.append(" and s.sch_school_id = m.sch_school_id ");
		if (types != null && !types.isEmpty()) {
			sql.append(" and t.sch_school_type_id in (");
			sql.append(getIDOUtil().convertListToCommaseparatedString(types));
			sql.append(") ");
		}
		sql.append(" and a.sch_school_area_id = ");
		sql.append(area);
		sql.append(" and (termination_date is null or termination_date > '" + getCurrentDate() + "')");
		if (yearID != -1) {
			sql.append(" and s.sch_school_id = ssy.sch_school_id ");
			sql.append(" and ssy.sch_school_year_id = ");
			sql.append(yearID);
		}
		sql.append(" order by s.").append(NAME);

		return super.idoFindPKsBySQL(sql.toString());
	}

	public Collection ejbFindAllBySubAreaAndTypes(int subarea, Collection types) throws javax.ejb.FinderException {
		StringBuffer sql = new StringBuffer("select distinct s.* ");
		sql.append(" from sch_school_sub_area a, sch_school s, sch_school_type t, sch_school_sch_school_type m ");
		sql.append(" where a.sch_school_sub_area_id = s.sch_school_sub_area_id ");
		sql.append(" and t.sch_school_type_id = m.sch_school_type_id ");
		sql.append(" and s.sch_school_id = m.sch_school_id ");
		if (types != null && !types.isEmpty()) {
			sql.append(" and t.sch_school_type_id in (");
			sql.append(getIDOUtil().convertListToCommaseparatedString(types));
			sql.append(") ");
		}
		sql.append(" and a.sch_school_sub_area_id = ");
		sql.append(subarea);
		sql.append(" and (termination_date is null or termination_date > '" + getCurrentDate() + "')");
		sql.append(" order by s.").append(NAME);

		return super.idoFindPKsBySQL(sql.toString());

	}

	/**
	 * Finds all providers that is "part of" a category
	 *
	 * @param schoolCategory
	 * @return Collection of School
	 * @throws javax.ejb.FinderException
	 */
	public Collection ejbFindAllByCategory(SchoolCategory schoolCategory) throws javax.ejb.FinderException {
		// String constants is concatenated at compile time...
		return super.idoFindPKsBySQL("SELECT distinct s.* FROM sch_school s, sch_school_type t, sch_school_sch_school_type m, sch_school_category c WHERE s.sch_school_id = m.sch_school_id AND m.sch_school_type_id = t.sch_school_type_id AND t.school_category LIKE c.category AND c.category LIKE '" + schoolCategory.getPrimaryKey() + "' order by s.school_name");
	}

	public Collection ejbFindAllInHomeCommuneByCategory(SchoolCategory schoolCategory) throws IDOLookupException, EJBException, FinderException {
		int homeCommunePK = ((Integer) ((CommuneHome) IDOLookup.getHome(Commune.class)).findDefaultCommune().getPrimaryKey()).intValue();
		StringBuffer sql = new StringBuffer("select distinct s.* ");
		sql.append(" from sch_school s, sch_school_type t, sch_school_sch_school_type m, sch_school_category c ");
		sql.append(" where s.sch_school_id = m.sch_school_id ");
		sql.append(" and m.sch_school_type_id = t.sch_school_type_id");
		sql.append(" and t.school_category = c.category");
		sql.append(" and c.category = '" + schoolCategory.getPrimaryKey().toString() + "'");
		sql.append(" and s.commune = " + homeCommunePK);

		return super.idoFindPKsBySQL(sql.toString());
	}

	public Collection ejbFindAllBySchoolGroup(Group schoolGroup) throws javax.ejb.FinderException {
		StringBuffer sql = new StringBuffer("Select s.* ");
		sql.append("  from sch_school s ");
		sql.append(" where s.headmaster_group_id in ( ");
		sql.append(" select r.ic_group_id from ic_group_relation r ");
		sql.append(" where r.ic_group_id in(select headmaster_group_id from sch_school ) ");
		sql.append(" and r.related_ic_group_id = ");
		sql.append(schoolGroup.getPrimaryKey().toString());
		sql.append(" ) ");
		sql.append(" and (termination_date is null or termination_date > '" + getCurrentDate() + "')");
		sql.append(" order by s.").append(NAME);
		return super.idoFindPKsBySQL(sql.toString());
	}

	public int ejbHomeGetNumberOfRelations(School school, SchoolYear year) throws IDOException {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from sch_school s, sch_school_sch_school_year middle");
		sql.append(" where middle.sch_school_ID = ").append(school.getPrimaryKey().toString());
		sql.append(" and middle.sch_school_year_ID = ").append(year.getPrimaryKey().toString());
		sql.append(" and middle.sch_school_id = s.sch_school_id");
		sql.append(" and (termination_date is null or termination_date > '" + getCurrentDate() + "')");
		return super.idoGetNumberOfRecords(sql.toString());
	}

	public int ejbHomeGetNumberOfFreetimeTypes(int schoolID) throws IDOException {
		IDOQuery query = idoQuery();
		query.appendSelectCountFrom("sch_school_sch_school_type m, sch_school_type t");
		query.appendWhereEquals("m.sch_school_type_id", "t.sch_school_type_id");
		query.appendAndEquals("m.sch_school_id", schoolID);
		query.appendAndEquals("t.is_freetime_type", true);

		return idoGetNumberOfRecords(query);
	}

	public Collection ejbFindAllPrivate() throws IDOLookupException, EJBException, FinderException {
		Integer managementType = (Integer) ((SchoolManagementTypeHome) IDOLookup.getHome(SchoolManagementType.class)).findPrivateManagementType().getPrimaryKey();
		IDOQuery sql = idoQuery();
		sql.appendSelectAllFrom(this);
		sql.appendWhereEquals(MANAGEMENT_TYPE, managementType.intValue());
		return idoFindPKsBySQL(sql.toString());

	}

	@Override
	public LocalizedText getLocalizedText(int localeId) throws IDORelationshipException {
		Collection coll = getText();
		// TxTextHome textHome = (TxTextHome) IDOLookup.getHome(TxText.class);
		if (coll != null && !coll.isEmpty()) {
			Iterator iter = coll.iterator();
			TxText text;
			// try {
			text = (TxText) iter.next();
			// text = textHome.findByPrimaryKey(iter.next());
			/*
			 * May want to use this... if (iter.hasNext()) { System.out.println("[SchoolBMPBean] Found too many localizedTexts, removing this one
			 * ("+text.getID()+") and trying again.."); TextBusiness.deleteText(text.getID()); return getLocalizedText(localeId); }
			 */
			// } catch (ClassCastException e) {
			// e.printStackTrace(System.err);
			// return null;
			// }
			LocalizedText lText = TextFinder.getContentHelper(text.getID(), localeId).getLocalizedText();
			return lText;
		}
		else {
			/** trying backwards compatability */
			try {
				LocalizedText text = TextFinder.getLocalizedText(this, localeId);
				if (text != null) {
					int lTextId = text.getID();
					TxText txText = TextBusiness.saveText(-1, lTextId, localeId, -1, -1, null, null, text.getHeadline(), text.getTitle(), text.getBody(), null, null);
					setText(txText);
					return TextFinder.getContentHelper(txText.getID(), localeId).getLocalizedText();
				}
				else {
					return TextFinder.getLocalizedText(this, localeId);
				}
				// return TextFinder.getLocalizedText(text, localeId);
			}
			catch (Exception e) {
				System.out.println("[SchoolBMPBean] : Backwards compatability for localized text (School = '" + getSchoolName() + "') - FAILED !!");
				e.printStackTrace(System.err);
				return TextFinder.getLocalizedText(this, localeId);
			}
		}

	}

	private Collection getText() throws IDORelationshipException {
		return this.idoGetRelatedEntities(TxText.class);
	}

	private void setText(TxText text) throws IDOAddRelationshipException {
		this.idoAddTo(text);
	}

	@Override
	public void setLocalizedText(String text, int localeId) throws IDORelationshipException {
		Collection coll = getText();
		if (coll != null && !coll.isEmpty()) {
			try {
				Iterator iter = coll.iterator();
				TxText txText = (TxText) iter.next();
				LocalizedText lText = TextFinder.getContentHelper(txText.getID(), localeId).getLocalizedText();
				int lTextId = -1;
				if (lText != null) {
					lTextId = lText.getID();
				}
				// boolean added = com.idega.block.text.business.TextBusiness.addLocalizedTextToTxText(text, txText);
				TextBusiness.saveText(txText.getID(), lTextId, localeId, -1, -1, null, null, null, null, text, null, null);
			}
			catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
		else {
			System.out.println("[SchoolBMPBean] : setLocalizedText : backwards compatability");
			TxText txText = TextBusiness.saveText(-1, -1, localeId, -1, -1, null, null, null, null, text, null, null);
			idoAddTo(txText);
			this.idoRemoveFrom(LocalizedText.class);
		}
		// this.idoAddTo(text);
	}

	@Override
	public String getSchoolFax() {
		return getStringColumnValue(FAX);
	}

	@Override
	public void setSchoolFax(String fax) {
		setColumn(FAX, fax);
	}

	@Override
	public String getSchoolWebPage() {
		return getStringColumnValue(WEB_PAGE);
	}

	@Override
	public void setSchoolWebPage(String webPage) {
		setColumn(WEB_PAGE, webPage);
	}

	@Override
	public String getMapUrl() {
		return getStringColumnValue(MAP_URL);
	}

	@Override
	public void setMapUrl(String url) {
		setColumn(MAP_URL, url);
	}

	@Override
	public String getActivity() {
		return getStringColumnValue(ACTIVITY);
	}

	@Override
	public void setActivity(String activity) {
		setColumn(ACTIVITY, activity);
	}

	@Override
	public String getOpenHours() {
		return getStringColumnValue(OPEN_HOURS);
	}

	@Override
	public void setOpenHours(String openHours) {
		setColumn(OPEN_HOURS, openHours);
	}

	@Override
	public String getSchoolManagementTypeString() {
		return getStringColumnValue(MANAGEMENT_TYPE);
	}

	@Override
	public SchoolManagementType getSchoolManagementType() {
		return (SchoolManagementType) getColumnValue(MANAGEMENT_TYPE);
	}

	@Override
	public void setSchoolManagementType(String managementType) {
		setColumn(MANAGEMENT_TYPE, managementType);
	}

	@Override
	public Collection getImages() throws IDORelationshipException {
		return this.idoGetRelatedEntities(ICFile.class);
	}

	@Override
	public Collection getSchoolTypes() throws IDORelationshipException {
		return this.idoGetRelatedEntities(SchoolType.class);
	}

	@Override
	public void removeImages() throws IDORelationshipException {
		this.idoRemoveFrom(ICFile.class);
	}

	@Override
	public void setImage(ICFile image) throws IDORelationshipException {
		removeImages();
		this.idoAddTo(image);
	}

	@Override
	public void addImage(ICFile image) throws IDORelationshipException {
		this.idoAddTo(image);
	}

	@Override
	public void setImages(Collection images) throws IDORelationshipException, RemoteException {
		this.idoRemoveFrom(ICFile.class);
		if (images != null) {
			Iterator iter = images.iterator();
			ICFile file;
			while (iter.hasNext()) {
				try {
					file = ((ICFileHome) IDOLookup.getHome(ICFile.class)).findByPrimaryKey(iter.next());
					addImage(file);
				}
				catch (FinderException e) {
					e.printStackTrace(System.err);
				}
				catch (IDORelationshipException e) {
				}
			}
		}
	}

	@Override
	public int getHeadmasterUserId() {
		return getIntColumnValue(HEADMASTER_USER_ID);
	}

	@Override
	public void setHeadmasterUserId(int userId) {
		setColumn(HEADMASTER_USER_ID, userId);
	}

	@Override
	public int getAssistantHeadmasterGroupId() {
		return getIntColumnValue(ASSISTANT_HEADMASTER_GROUP_ID);
	}

	@Override
	public void setAssistantHeadmasterGroupId(int groupId) {
		setColumn(ASSISTANT_HEADMASTER_GROUP_ID, groupId);
	}

	public static void main(String[] args) {
		System.out.println("hellu there");
	}

	@Override
	public void removeFromClass(Class entityInterfaceClass) throws IDORemoveRelationshipException {
		this.idoRemoveFrom(entityInterfaceClass);
	}

	@Override
	public void addStudyPath(SchoolStudyPath studyPath) throws IDOAddRelationshipException {
		this.idoAddTo(studyPath);
	}

	@Override
	public void removeStudyPath(SchoolStudyPath studyPath) throws IDORemoveRelationshipException {
		this.idoRemoveFrom(studyPath);
	}

	@Override
	public Collection getStudyPaths() throws IDORelationshipException {
		return this.idoGetRelatedEntities(SchoolStudyPath.class);
	}

	@Override
	public void removeAllStudyPaths() throws IDORemoveRelationshipException {
		this.idoRemoveFrom(SchoolStudyPath.class);
	}

	@Override
	public boolean getSortByBirthdate() {
		return getBooleanColumnValue(SORT_BY_BIRTHDATE);
	}

	@Override
	public void setSortByBirthdate(boolean arg) {
		setColumn(SORT_BY_BIRTHDATE, arg);
	}

	@Override
	public int compareTo(IDOEntity o) {
		if (!(o instanceof School))
			return 0;

		School school = (School) o;
		String name1 = getName();
		String name2 = school.getName();
		int result = name1.compareTo(name2);
		// do not confuse others by returning zero if the names are equal but the objects are not!
		if (result == 0) {
			// only return zero if the objects are equal!
			if (!this.equals(school)) {
				// change the result!
				return 1;
			}
		}
		return result;
	}

	public Collection ejbFindAllWithNoPrimaryGroup() throws FinderException {
		Table table = new Table(this);

		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_PRIMARY_GROUP), false));

		return idoFindPKsByQuery(query);
	}


	public Integer ejbFindByProviderId(String providerId) throws javax.ejb.FinderException {
		String select = "select * from " + SCHOOL + " where " + PROVIDER_STRING_ID + " = '" + providerId + "'";

		return (Integer) super.idoFindOnePKBySQL(select);
	}

}