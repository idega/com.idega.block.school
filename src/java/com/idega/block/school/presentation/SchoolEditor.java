package com.idega.block.school.presentation;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.FinderException;

import com.idega.block.school.business.SchoolYearComparator;
import com.idega.block.school.data.School;
import com.idega.block.school.data.SchoolArea;
import com.idega.block.school.data.SchoolCategory;
import com.idega.block.school.data.SchoolType;
import com.idega.block.school.data.SchoolYear;
import com.idega.business.IBOLookup;
import com.idega.core.location.business.CommuneBusiness;
import com.idega.core.location.data.Commune;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.Table2;
import com.idega.presentation.TableCell2;
import com.idega.presentation.TableColumn;
import com.idega.presentation.TableColumnGroup;
import com.idega.presentation.TableRow;
import com.idega.presentation.TableRowGroup;
import com.idega.presentation.text.Break;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.ListItem;
import com.idega.presentation.text.Lists;
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.CheckBox;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.HiddenInput;
import com.idega.presentation.ui.Label;
import com.idega.presentation.ui.SubmitButton;
import com.idega.presentation.ui.TextArea;
import com.idega.presentation.ui.TextInput;
import com.idega.presentation.ui.util.SelectorUtility;
import com.idega.util.EmailValidator;
import com.idega.util.StringUtil;

/**
 * @author <a href="mailto:aron@idega.is">Aron Birkir </a> <br>
 * @version 1.0
 */

public class SchoolEditor extends SchoolBlock {

	private static final String PARAMETER_ACTION = "sch_prm_action";
	private static final String PARAMETER_SCHOOL_PK = "prm_school_pk";
	private static final String PARAMETER_PROVIDER_STRING_ID = "prm_provider_string_id";
	private static final String PARAMETER_NAME = "prm_name";
	private static final String PARAMETER_ADDRESS = "prm_address";
	private static final String PARAMETER_INFO = "prm_info";
	private static final String PARAMETER_AREA = "prm_area";
	private static final String PARAMETER_ZIPCODE = "prm_zipcode";
	private static final String PARAMETER_ZIPAREA = "prm_ziparea";
	private static final String PARAMETER_PHONE = "prm_phone";
	// private static final String PARAMETER_KEYCODE = "prm_keycode";
	// private static final String PARAMETER_LONGITUDE = "prm_longitude";
	// private static final String PARAMETER_LATITUDE = "prm_latitude";
	private static final String PARAMETER_COMMUNE = "prm_commune";
	private static final String PARAMETER_TYPE_PKS = "prm_type_pks";
	private static final String PARAMETER_YEAR_PKS = "prm_year_pks";
	private static final String PARAMETER_WEB_PAGE = "prm_web_page";
	private static final String PARAMETER_EMAIL_ADDRESS = "prm_email_address";
	private static final String PARAMETER_JUNIOR_HIGH_SCHOOL = "prm_junior_high_school_pk";
	private static final String PARAMETER_AFTER_SCHOOL_CARE_PROVIDER_PK = "prm_care_provider_pk";
	private static final String PARAMETER_HAS_REFRESHMENTS = "prm_has_refreshments";
	private static final String PARAMETER_HAS_REVIEW = "prm_has_review";
	private static final String PARAMETER_HAS_PRE_CARE = "prm_has_pre_care";
	private static final String PARAMETER_HAS_POST_CARE = "prm_has_post_care";
	private static final String PARAMETER_ORGANIZATION_ID = "prm_org_id";
	private static final String PARAMETER_SCHOOL_TYPE = "prm_school_type";
	private static final String PARAMETER_HAS_HANDICAP = "prm_has_handicap";

	private static final int ACTION_VIEW = 1;
	private static final int ACTION_EDIT = 2;
	private static final int ACTION_NEW = 3;
	private static final int ACTION_SAVE = 4;
	private static final int ACTION_DELETE = 5;

	private String iNewKey = "school.new";

	private String iEditorID = "schoolEditor";

	boolean _useProviderStringId = true;
	String iSchoolCategory = null;
	boolean setAllSchoolTypesAsChecked = false;

	public boolean getUseProviderStringId() {
		return this._useProviderStringId;
	}

	public void setUseProviderStringId(boolean b) {
		this._useProviderStringId = b;
	}

	@Override
	protected void init(IWContext iwc) throws Exception {
		switch (parseAction(iwc)) {
			case ACTION_VIEW:
				showList(iwc);
				break;

			case ACTION_EDIT:
				Object schoolPK = iwc.getParameter(PARAMETER_SCHOOL_PK);
				showEditor(iwc, schoolPK);
				break;

			case ACTION_NEW:
				showEditor(iwc, null);
				break;

			case ACTION_SAVE:
				saveSchool(iwc);
				showList(iwc);
				break;

			case ACTION_DELETE:
				getBusiness().removeProvider(iwc.getParameter(PARAMETER_SCHOOL_PK));
				showList(iwc);
				break;
		}
	}

	private int parseAction(IWContext iwc) {
		if (iwc.isParameterSet(PARAMETER_SCHOOL_TYPE)) {
			int typePK = Integer.parseInt(iwc.getParameter(PARAMETER_SCHOOL_TYPE));
			if (typePK > 0) {
				setSchoolTypePK(iwc, new Integer(typePK));
			}
			else {
				iwc.removeSessionAttribute(PARAMETER_SCHOOL_TYPE);
			}
		}

		if (iwc.isParameterSet(PARAMETER_ACTION)) {
			return Integer.parseInt(iwc.getParameter(PARAMETER_ACTION));
		}
		return ACTION_VIEW;
	}

	private Object getSchoolTypePK(IWContext iwc) {
		return iwc.getSessionAttribute(PARAMETER_SCHOOL_TYPE);
	}

	private void setSchoolTypePK(IWContext iwc, Object pk) {
		iwc.setSessionAttribute(PARAMETER_SCHOOL_TYPE, pk);
	}

	private void saveSchool(IWContext iwc) throws java.rmi.RemoteException {
		String pk = iwc.getParameter(PARAMETER_SCHOOL_PK);

		String providerStringId = iwc.getParameter(PARAMETER_PROVIDER_STRING_ID);
		String name = iwc.getParameter(PARAMETER_NAME);
		String address = iwc.getParameter(PARAMETER_ADDRESS);
		String info = iwc.getParameter(PARAMETER_INFO);
		String area = iwc.getParameter(PARAMETER_AREA);
		String zipcode = iwc.getParameter(PARAMETER_ZIPCODE);
		String ziparea = iwc.getParameter(PARAMETER_ZIPAREA);
		String phone = iwc.getParameter(PARAMETER_PHONE);
		// String keycode = iwc.getParameter(PARAMETER_KEYCODE);
		// String lon = iwc.getParameter(PARAMETER_LONGITUDE);
		// String lat = iwc.getParameter(PARAMETER_LATITUDE);
		String commune = iwc.getParameter(PARAMETER_COMMUNE);
		String orgNr = iwc.getParameter(PARAMETER_ORGANIZATION_ID);
		String[] type_ids = iwc.getParameterValues(PARAMETER_TYPE_PKS);
		String[] year_ids = iwc.getParameterValues(PARAMETER_YEAR_PKS);
		String webPage = iwc.getParameter(PARAMETER_WEB_PAGE);
		String email = iwc.getParameter(PARAMETER_EMAIL_ADDRESS);
		int[] types = new int[0];
		int[] years = new int[0];
		if (type_ids != null && type_ids.length > 0) {
			types = new int[type_ids.length];
			for (int i = 0; i < type_ids.length; i++) {
				types[i] = Integer.parseInt(type_ids[i]);
			}

		}
		if (year_ids != null && year_ids.length > 0) {
			years = new int[year_ids.length];
			for (int i = 0; i < year_ids.length; i++) {
				years[i] = Integer.parseInt(year_ids[i]);
			}

		}
		int areaId = -1, sid = -1;
		if (pk != null) {
			sid = Integer.parseInt(pk);
		}
		if (area != null) {
			areaId = Integer.parseInt(area);
		}

		Integer communePK = null;
		if (commune != null) {
			communePK = new Integer(commune);
		}

		Object juniorHighID = iwc.isParameterSet(PARAMETER_JUNIOR_HIGH_SCHOOL) ? iwc.getParameter(PARAMETER_JUNIOR_HIGH_SCHOOL) : null;
		Object providerID = iwc.isParameterSet(PARAMETER_AFTER_SCHOOL_CARE_PROVIDER_PK) ? iwc.getParameter(PARAMETER_AFTER_SCHOOL_CARE_PROVIDER_PK) : null;
		boolean hasRefreshments = iwc.isParameterSet(PARAMETER_HAS_REFRESHMENTS) ? new Boolean(iwc.getParameter(PARAMETER_HAS_REFRESHMENTS)).booleanValue() : false;
		boolean hasReview = iwc.isParameterSet(PARAMETER_HAS_REVIEW) ? new Boolean(iwc.getParameter(PARAMETER_HAS_REVIEW)).booleanValue() : false;
		boolean hasPreCare = iwc.isParameterSet(PARAMETER_HAS_PRE_CARE) ? new Boolean(iwc.getParameter(PARAMETER_HAS_PRE_CARE)).booleanValue() : false;
		boolean hasPostCare = iwc.isParameterSet(PARAMETER_HAS_POST_CARE) ? new Boolean(iwc.getParameter(PARAMETER_HAS_POST_CARE)).booleanValue() : false;
		boolean hasHandicap = iwc.isParameterSet(PARAMETER_HAS_HANDICAP) ? new Boolean(iwc.isParameterSet(PARAMETER_HAS_POST_CARE)).booleanValue() : false;


		School school = getBusiness().storeSchool(sid, name, info, address, zipcode, ziparea, phone, null, null, null, areaId, types, years, communePK, providerStringId);
		if (juniorHighID != null) {
			school.setJuniorHighSchool(juniorHighID);
		}
		if (providerID != null) {
			school.setAfterSchoolCareProvider(providerID);
		}
		if (orgNr != null) {
			school.setOrganizationNumber(orgNr);
		}
		school.setSchoolWebPage(webPage);
		school.setHasRefreshments(hasRefreshments);
		school.setHasReview(hasReview);
		school.setHasPreCare(hasPreCare);
		school.setHasPostCare(hasPostCare);
		school.setHasHandicap(hasHandicap);
		if (StringUtil.isEmpty(email)) {
			school.setSchoolEmail(null);
		} else if (EmailValidator.getInstance().isValid(email)) {
			school.setSchoolEmail(email);
		}

		school.store();
	}

	public void showList(IWContext iwc) throws RemoteException {
		Form form = new Form();
		form.setID(this.iEditorID);
		form.setStyleClass(STYLENAME_SCHOOL_FORM);

		if (this.iSchoolCategory != null) {
			Layer section = new Layer();
			section.setStyleClass("FormSection");
			form.add(section);

			DropdownMenu types = new DropdownMenu(PARAMETER_SCHOOL_TYPE);
			types.addMenuElementFirst("-1", "");
			if (getSchoolTypePK(iwc) != null) {
				types.setSelectedElement(getSchoolTypePK(iwc).toString());
			}
			types.setToSubmit();

			SelectorUtility su = new SelectorUtility();
			su.getSelectorFromIDOEntities(types, getSchoolTypes());

			Layer layer = new Layer(Layer.DIV);
			layer.setStyleClass(STYLENAME_FORM_ELEMENT);
			Label label = new Label(localize("school_type", "School type"), types);
			layer.add(label);
			layer.add(types);
			section.add(layer);
		}

		Table2 table = new Table2();
		table.setWidth("100%");
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setStyleClass(STYLENAME_LIST_TABLE);

		TableColumnGroup columnGroup = table.createColumnGroup();
		TableColumn column = columnGroup.createColumn();
		column.setSpan(7);
		column = columnGroup.createColumn();
		column.setSpan(2);
		column.setWidth("12");

		Collection schools = new java.util.Vector(0);
		if (this.iSchoolCategory == null) {
			schools = getBusiness().findAllSchools();
		}
		else {
			if (getSchoolTypePK(iwc) != null) {
				schools = getBusiness().findAllSchoolsByType(Integer.parseInt(getSchoolTypePK(iwc).toString()));
			}
			else {
				schools = getBusiness().findAllSchoolsByCategory(this.iSchoolCategory);
			}
		}

		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();
		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("firstColumn");
		cell.add(new Text(localize("name", "Name")));
		row.createHeaderCell().add(new Text(localize("area", "Area")));
		row.createHeaderCell().add(new Text(localize("address", "Address")));
		row.createHeaderCell().add(new Text(localize("zipcode", "Zipcode")));
		row.createHeaderCell().add(new Text(localize("ziparea", "Ziparea")));
		row.createHeaderCell().add(new Text(localize("commune", "Commune")));
		row.createHeaderCell().add(new Text(localize("phone", "Phone")));
		row.createHeaderCell().add(Text.getNonBrakingSpace());
		cell = row.createHeaderCell();
		cell.setStyleClass("lastColumn");
		cell.add(Text.getNonBrakingSpace());

		group = table.createBodyRowGroup();
		int iRow = 1;

		Iterator iter = schools.iterator();
		School school;
		SchoolArea area;
		Commune commune;
		while (iter.hasNext()) {
			row = group.createRow();
			school = (School) iter.next();
			try {
				Link edit = new Link(getEditIcon(localize("edit", "Edit")));
				edit.addParameter(PARAMETER_SCHOOL_PK, school.getPrimaryKey().toString());
				edit.addParameter(PARAMETER_ACTION, ACTION_EDIT);

				Link delete = new Link(getDeleteIcon(localize("delete", "Delete")));
				delete.addParameter(PARAMETER_SCHOOL_PK, school.getPrimaryKey().toString());
				delete.addParameter(PARAMETER_ACTION, ACTION_DELETE);
				delete.setOnClick("return confirm('" + localize("travel.are_you_sure_you_want_to_delete", "Are you sure you want to delete") + " " + school.getName() + " ?');");

				area = school.getSchoolArea();
				commune = school.getCommune();

				cell = row.createCell();
				cell.setStyleClass("firstColumn");
				cell.add(new Text(school.getSchoolName()));
				if (area != null) {
					row.createCell().add(new Text(area.getName()));
				}
				else {
					row.createCell().add(new Text("-"));
				}
				row.createCell().add(new Text(school.getSchoolAddress()));
				row.createCell().add(new Text(school.getSchoolZipCode()));
				row.createCell().add(new Text(school.getSchoolZipArea()));
				if (commune != null) {
					row.createCell().add(new Text(commune.getCommuneName()));
				}
				else {
					row.createCell().add(new Text("-"));
				}
				row.createCell().add(new Text(school.getSchoolPhone()));
				row.createCell().add(edit);
				cell = row.createCell();
				cell.setStyleClass("lastColumn");
				cell.add(delete);

				if (iRow % 2 == 0) {
					row.setStyleClass(STYLENAME_LIST_TABLE_EVEN_ROW);
				}
				else {
					row.setStyleClass(STYLENAME_LIST_TABLE_ODD_ROW);
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			iRow++;
		}

		form.add(table);
		form.add(new Break());

		SubmitButton newLink = (SubmitButton) getButton(new SubmitButton(localize(this.iNewKey, "New school"), PARAMETER_ACTION, String.valueOf(ACTION_NEW)));
		form.add(newLink);

		add(form);
	}

	public void showEditor(IWContext iwc, Object schoolPK) throws java.rmi.RemoteException {
		Form form = new Form();
		form.setID(this.iEditorID);
		form.setStyleClass(STYLENAME_SCHOOL_FORM);

		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("FormSection");
		form.add(section);

		TextInput inputProviderStringId = new TextInput(PARAMETER_PROVIDER_STRING_ID);
		inputProviderStringId.setAsNotEmpty(localize("sch_provider_id_not_empty", "Provider id must be entered."));

		TextInput inputName = new TextInput(PARAMETER_NAME);
		TextInput inputAddress = new TextInput(PARAMETER_ADDRESS);
		TextArea inputInfo = new TextArea(PARAMETER_INFO);

		TextInput inputZipCode = new TextInput(PARAMETER_ZIPCODE);
		TextInput inputZipArea = new TextInput(PARAMETER_ZIPAREA);
		TextInput inputPhone = new TextInput(PARAMETER_PHONE);
		// TextInput inputKeyCode = new TextInput(PARAMETER_KEYCODE);
		// TextInput inputLON = new TextInput(PARAMETER_LONGITUDE);
		// TextInput inputLAT = new TextInput(PARAMETER_LATITUDE);
		TextInput inputOrgID = new TextInput(PARAMETER_ORGANIZATION_ID);
		TextInput inputWebPage = new TextInput(PARAMETER_WEB_PAGE);
		TextInput inputEmailAddress = new TextInput(PARAMETER_EMAIL_ADDRESS);

		SchoolCategory category = null;
		if (iSchoolCategory != null) {
			try {
				category = getBusiness().getSchoolCategoryHome().findByPrimaryKey(iSchoolCategory);
			}
			catch (FinderException e) {
				e.printStackTrace();
			}
		}

		DropdownMenu drpArea = new DropdownMenu(getSchoolAreas(category), PARAMETER_AREA);
		drpArea.setMenuElementFirst("-1", "");

		DropdownMenu communes = new DropdownMenu(PARAMETER_COMMUNE);
		SelectorUtility su = new SelectorUtility();
		su.getSelectorFromIDOEntities(communes, getCommuneBusiness(iwc).getCommunes(), "getCommuneName");

		DropdownMenu juniorHighs = new DropdownMenu(PARAMETER_JUNIOR_HIGH_SCHOOL);
		Collection schools = getBusiness().findAllSchoolsByCategory(getBusiness().getCategoryElementarySchool().getCategory());
		su.getSelectorFromIDOEntities(juniorHighs, schools, "getSchoolName");
		juniorHighs.setMenuElementFirst("", "");

		DropdownMenu providers = new DropdownMenu(PARAMETER_AFTER_SCHOOL_CARE_PROVIDER_PK);
		schools = getBusiness().findAllSchoolsByCategory(getBusiness().getCategoryChildcare().getCategory());
		su.getSelectorFromIDOEntities(providers, schools, "getSchoolName");
		providers.setMenuElementFirst("", "");

		DropdownMenu hasRefreshments = new DropdownMenu(PARAMETER_HAS_REFRESHMENTS);
		hasRefreshments.addMenuElement(Boolean.TRUE.toString(), localize("yes", "Yes"));
		hasRefreshments.addMenuElement(Boolean.FALSE.toString(), localize("no", "No"));

		DropdownMenu hasReview = new DropdownMenu(PARAMETER_HAS_REVIEW);
		hasReview.addMenuElement(Boolean.TRUE.toString(), localize("yes", "Yes"));
		hasReview.addMenuElement(Boolean.FALSE.toString(), localize("no", "No"));

		DropdownMenu hasPreCare = new DropdownMenu(PARAMETER_HAS_PRE_CARE);
		hasPreCare.addMenuElement(Boolean.TRUE.toString(), localize("yes", "Yes"));
		hasPreCare.addMenuElement(Boolean.FALSE.toString(), localize("no", "No"));

		DropdownMenu hasPostCare = new DropdownMenu(PARAMETER_HAS_POST_CARE);
		hasPostCare.addMenuElement(Boolean.TRUE.toString(), localize("yes", "Yes"));
		hasPostCare.addMenuElement(Boolean.FALSE.toString(), localize("no", "No"));

		CheckBox hasHandicap = new CheckBox(PARAMETER_HAS_HANDICAP);

		Map schooltypes = null, schoolyears = null;
		Commune commune = null;
		if (schoolPK != null) {
			School school = getBusiness().getSchool(schoolPK);
			try {
				schooltypes = getSchoolRelatedSchoolTypes(school);
				schoolyears = getSchoolRelatedSchoolYears(school);
				commune = school.getCommune();

				if (this._useProviderStringId) {
					inputProviderStringId.setContent(school.getProviderStringId());
				}
				inputName.setContent(school.getSchoolName());
				inputAddress.setContent(school.getSchoolAddress());
				inputInfo.setContent(school.getSchoolInfo());
				inputZipCode.setContent(school.getSchoolZipCode());
				inputZipArea.setContent(school.getSchoolZipArea());
				inputPhone.setContent(school.getSchoolPhone());
				// inputKeyCode.setContent(school.getSchoolKeyCode());
				// inputLON.setContent(school.getSchoolLongitude());
				// inputLAT.setContent(school.getSchoolLatitude());
				inputWebPage.setContent(school.getSchoolWebPage());
				inputEmailAddress.setContent(school.getSchoolEmail());
				drpArea.setSelectedElement(String.valueOf(school.getSchoolAreaId()));
				if (commune != null) {
					communes.setSelectedElement(commune.getPrimaryKey().toString());
				}
				if (school.getJuniorHighSchoolPK() != null) {
					juniorHighs.setSelectedElement(school.getJuniorHighSchoolPK().toString());
				}
				if (school.getAfterSchoolCareProviderPK() != null) {
					providers.setSelectedElement(school.getAfterSchoolCareProviderPK().toString());
				}
				if (school.getOrganizationNumber() != null) {
					inputOrgID.setContent(school.getOrganizationNumber());
				}
				hasRefreshments.setSelectedElement(String.valueOf(school.hasRefreshments()));
				hasReview.setSelectedElement(String.valueOf(school.hasReview()));
				hasPreCare.setSelectedElement(String.valueOf(school.hasPreCare()));
				hasPostCare.setSelectedElement(String.valueOf(school.hasPostCare()));
				hasHandicap.setChecked(school.hasHandicap());
			}
			catch (Exception ex) {
			}
		}
		else {
			commune = getCommuneBusiness(iwc).getDefaultCommune();
			if (commune != null) {
				communes.setSelectedElement(commune.getPrimaryKey().toString());
			}
		}

		if (schoolPK != null) {
			form.add(new HiddenInput(PARAMETER_SCHOOL_PK, schoolPK.toString()));
		}

		Layer layer;
		Label label;
		if (this._useProviderStringId) {
			layer = new Layer(Layer.DIV);
			layer.setID("providerStringID");
			layer.setStyleClass(STYLENAME_FORM_ELEMENT);
			label = new Label(localize("provider_id", "Provider ID"), inputProviderStringId);
			layer.add(label);
			layer.add(inputProviderStringId);
			section.add(layer);
		}

		layer = new Layer(Layer.DIV);
		layer.setID("orgNr");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("organization_number", "Organization Number"), inputName);
		layer.add(label);
		layer.add(inputOrgID);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("name");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("name", "Name"), inputName);
		layer.add(label);
		layer.add(inputName);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("address");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("address", "Address"), inputAddress);
		layer.add(label);
		layer.add(inputAddress);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("postalCode");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("zipcode", "zipcode"), inputZipCode);
		layer.add(label);
		layer.add(inputZipCode);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("area");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("ziparea", "Ziparea"), inputZipArea);
		layer.add(label);
		layer.add(inputZipArea);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("phone");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("phone", "Phone"), inputPhone);
		layer.add(label);
		layer.add(inputPhone);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("webpage");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("school.web_page", "Web page"), inputWebPage);
		layer.add(label);
		layer.add(inputWebPage);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("emailAddress");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("school.email_address", "E-mail"), inputEmailAddress);
		layer.add(label);
		layer.add(inputEmailAddress);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("info");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("info", "Info"), inputInfo);
		layer.add(label);
		layer.add(inputInfo);
		section.add(layer);

		/*
		 * layer = new Layer(Layer.DIV); layer.setID("keycode"); layer.setStyleClass(STYLENAME_FORM_ELEMENT); label = new Label(localize("keycode",
		 * "keycode"), inputKeyCode); layer.add(label); layer.add(inputKeyCode); section.add(layer);
		 *
		 * layer = new Layer(Layer.DIV); layer.setID("latitude"); layer.setStyleClass(STYLENAME_FORM_ELEMENT); label = new Label(localize("inputKeyCode",
		 * "Latitude"), inputLAT); layer.add(label); layer.add(inputLAT); section.add(layer);
		 *
		 * layer = new Layer(Layer.DIV); layer.setID("longitude"); layer.setStyleClass(STYLENAME_FORM_ELEMENT); label = new Label(localize("longitude",
		 * "Longitude"), inputLON); layer.add(label); layer.add(inputLON); section.add(layer);
		 */

		layer = new Layer(Layer.DIV);
		layer.setID("commune");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("commune", "Commune"), communes);
		layer.add(label);
		layer.add(communes);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("schoolArea");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("school_area", "SchoolArea"), drpArea);
		layer.add(label);
		layer.add(drpArea);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("juniorHigh");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("junior_high_school", "Junior high school"), juniorHighs);
		layer.add(label);
		layer.add(juniorHighs);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("afterSchoolCareProvider");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("after_school_care_provider", "After school care provider"), providers);
		layer.add(label);
		layer.add(providers);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("hasRefreshments");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("has_refreshments", "Has refreshments"), hasRefreshments);
		layer.add(label);
		layer.add(hasRefreshments);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("hasReview");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("has_review", "Has review"), hasReview);
		layer.add(label);
		layer.add(hasReview);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("hasPreCare");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("has_pre_care", "Has pre care"), hasPreCare);
		layer.add(label);
		layer.add(hasPreCare);
		section.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setID("hasPostCare");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("has_post_care", "Has post care"), hasPostCare);
		layer.add(label);
		layer.add(hasPostCare);
		section.add(layer);

		Layer clearLayer = new Layer();
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);

		Lists list = new Lists();
		list.setId("schoolTypes");
		Collection types = getSchoolTypes();
		if (types != null && !types.isEmpty()) {
			Iterator iter = types.iterator();
			boolean hasMap = schooltypes != null;

			while (iter.hasNext()) {
				SchoolType type = (SchoolType) iter.next();
				ListItem item = new ListItem();

				CheckBox typeCheck = new CheckBox(PARAMETER_TYPE_PKS, type.getPrimaryKey().toString());
				if (hasMap && schooltypes.containsKey(type.getPrimaryKey())) {
					typeCheck.setChecked(true);
				}
				if (!hasMap && setAllSchoolTypesAsChecked) {
					typeCheck.setChecked(true);
				}

				label = new Label(type.getSchoolTypeName(), typeCheck);
				item.add(typeCheck);
				item.add(label);
				list.add(item);

				List years = new ArrayList(getSchoolYears(((Integer) type.getPrimaryKey()).intValue()));
				if (years != null && !years.isEmpty()) {
					Collections.sort(years, new SchoolYearComparator());
					Lists yearList = new Lists();

					Iterator yearIter = years.iterator();
					boolean yearMap = schoolyears != null;
					while (yearIter.hasNext()) {
						SchoolYear year = (SchoolYear) yearIter.next();
						ListItem yearItem = new ListItem();

						CheckBox yearCheck = new CheckBox(PARAMETER_YEAR_PKS, year.getPrimaryKey().toString());
						if (yearMap && schoolyears.containsKey(year.getPrimaryKey())) {
							yearCheck.setChecked(true);
						}

						label = new Label(year.getSchoolYearName(), yearCheck);
						yearItem.add(yearCheck);
						yearItem.add(label);
						yearList.add(yearItem);
					}
					item.add(yearList);
				}
			}
			section.add(list);
		}

//		ListItem handicapItem = new ListItem();
//		label = new Label(localize("has_handicap", "Has handicap facilities"), hasHandicap);
//		handicapItem.add(hasHandicap);
//		handicapItem.add(label);
//		list.add(handicapItem);


		Layer buttonLayer = new Layer(Layer.DIV);
		buttonLayer.setStyleClass("buttonLayer");
		form.add(buttonLayer);

		SubmitButton save = (SubmitButton) getButton(new SubmitButton(localize("save", "Save"), PARAMETER_ACTION, String.valueOf(ACTION_SAVE)));
		SubmitButton cancel = (SubmitButton) getButton(new SubmitButton(localize("cancel", "Cancel"), PARAMETER_ACTION, String.valueOf(ACTION_VIEW)));

		buttonLayer.add(cancel);
		buttonLayer.add(save);

		add(form);
	}

	private Map getSchoolRelatedSchoolTypes(School school) throws java.rmi.RemoteException {
		return getBusiness().getSchoolRelatedSchoolTypes(school);
	}

	private Map getSchoolRelatedSchoolYears(School school) throws java.rmi.RemoteException {
		return getBusiness().getSchoolRelatedSchoolYears(school);
	}

	private Collection getSchoolTypes() throws java.rmi.RemoteException {
		if (this.iSchoolCategory != null) {
			return getBusiness().findAllSchoolTypesInCategory(this.iSchoolCategory);
		}
		else {
			return getBusiness().findAllSchoolTypes();
		}
	}

	private Collection getSchoolYears(int schoolTypeId) throws java.rmi.RemoteException {
		return getBusiness().findAllSchoolYearsBySchoolType(schoolTypeId);
	}

	private Collection getSchoolAreas(SchoolCategory category) throws java.rmi.RemoteException {
		return getBusiness().findAllSchoolAreas(category);
	}

	public void setSchoolTypeCategory(String typeCategory) {
		this.iSchoolCategory = typeCategory;
	}

	public CommuneBusiness getCommuneBusiness(IWApplicationContext iwac) throws RemoteException {
		return IBOLookup.getServiceInstance(iwac, CommuneBusiness.class);
	}

	public void setNewSchoolLocalizedKey(String newSchoolLocalizedKey) {
		this.iNewKey = newSchoolLocalizedKey;
	}

	public void setEditorID(String ID) {
		this.iEditorID = ID;
	}

	public void setAllSchoolTypesAsChecked(boolean setAllSchoolTypesAsChecked) {
		this.setAllSchoolTypesAsChecked = setAllSchoolTypesAsChecked;
	}
}