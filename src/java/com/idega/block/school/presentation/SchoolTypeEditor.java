package com.idega.block.school.presentation;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

import com.idega.block.school.data.SchoolCategory;
import com.idega.block.school.data.SchoolType;
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
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.HiddenInput;
import com.idega.presentation.ui.Label;
import com.idega.presentation.ui.SubmitButton;
import com.idega.presentation.ui.TextArea;
import com.idega.presentation.ui.TextInput;
import com.idega.presentation.ui.util.SelectorUtility;

/**
 * @author <br>
 *         <a href="mailto:aron@idega.is">Aron Birkir</a><br>
 * @version 1.0
 */
public class SchoolTypeEditor extends SchoolBlock {

	private static final String PARAMETER_ACTION = "sch_type_prm_action";
	private static final String PARAMETER_SCHOOL_TYPE_PK = "prm_school_type_pk";
	private static final String PARAMETER_TYPE_STRING_ID = "prm_type_string_id";
	private static final String PARAMETER_NAME = "prm_name";
	private static final String PARAMETER_INFO = "prm_info";
	private static final String PARAMETER_CATEGORY = "prm_category";
	private static final String PARAMETER_LOCALIZED_KEY = "prm_localized_key";
	private static final String PARAMETER_MAX_AGE = "prm_max_age";
	private static final String PARAMETER_ORDER = "prm_order";

	private static final int ACTION_VIEW = 1;
	private static final int ACTION_EDIT = 2;
	private static final int ACTION_NEW = 3;
	private static final int ACTION_SAVE = 4;
	private static final int ACTION_DELETE = 5;

	private boolean _useTypeStringId = false;
	private String iSchoolCategory;

	public boolean getUseTypeStringId() {
		return this._useTypeStringId;
	}

	public void setUseTypeStringId(boolean b) {
		this._useTypeStringId = b;
	}

	protected void init(IWContext iwc) throws Exception {
		switch (parseAction(iwc)) {
			case ACTION_VIEW:
				showList(iwc);
				break;

			case ACTION_EDIT:
				Object schoolPK = iwc.getParameter(PARAMETER_SCHOOL_TYPE_PK);
				showEditor(iwc, schoolPK);
				break;

			case ACTION_NEW:
				showEditor(iwc, null);
				break;

			case ACTION_SAVE:
				saveType(iwc);
				showList(iwc);
				break;

			case ACTION_DELETE:
				getBusiness().removeSchoolType(iwc.getParameter(PARAMETER_SCHOOL_TYPE_PK));
				showList(iwc);
				break;
		}
	}

	private int parseAction(IWContext iwc) {
		if (iwc.isParameterSet(PARAMETER_ACTION)) {
			return Integer.parseInt(iwc.getParameter(PARAMETER_ACTION));
		}
		return ACTION_VIEW;
	}

	private void saveType(IWContext iwc) throws java.rmi.RemoteException {
		String id = iwc.getParameter(PARAMETER_SCHOOL_TYPE_PK);
		String typeStringId = iwc.getParameter(PARAMETER_TYPE_STRING_ID);
		String name = iwc.getParameter(PARAMETER_NAME);
		String info = iwc.getParameter(PARAMETER_INFO);
		String cat = null;
		if (this.iSchoolCategory != null) {
			cat = this.iSchoolCategory;
		}
		else {
			cat = iwc.getParameter(PARAMETER_CATEGORY);
		}
		String locKey = iwc.getParameter(PARAMETER_LOCALIZED_KEY);
		int maxAge = -1;
		if (iwc.isParameterSet(PARAMETER_MAX_AGE)) {
			try {
				maxAge = Integer.parseInt(iwc.getParameter(PARAMETER_MAX_AGE));
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		int aid = -1;
		if (id != null) {
			aid = Integer.parseInt(id);
		}

		int order = -1;
		if (iwc.isParameterSet(PARAMETER_ORDER)) {
			try {
				order = Integer.parseInt(iwc.getParameter(PARAMETER_ORDER));
			}
			catch (NumberFormatException e) {
				order = -1;
			}
		}

		getBusiness().storeSchoolType(aid, name, info, cat, locKey, maxAge, false, false, order, typeStringId);
	}

	public void showList(IWContext iwc) {
		Form form = new Form();
		form.setStyleClass(STYLENAME_SCHOOL_FORM);

		Table2 table = new Table2();
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setWidth("100%");
		table.setStyleClass(STYLENAME_LIST_TABLE);

		TableColumnGroup columnGroup = table.createColumnGroup();
		TableColumn column = columnGroup.createColumn();
		column.setSpan(5);
		column = columnGroup.createColumn();
		column.setSpan(2);
		column.setWidth("12");

		Collection schoolTypes = null;
		try {
			if (this.iSchoolCategory != null) {
				schoolTypes = getBusiness().findAllSchoolTypesInCategory(this.iSchoolCategory);
			}
			else {
				schoolTypes = getBusiness().findAllSchoolTypes();
			}
		}
		catch (RemoteException rex) {
			schoolTypes = new ArrayList();
		}

		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();
		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("firstColumn");
		cell.setStyleClass("name");
		cell.add(new Text(localize("name", "Name")));

		cell = row.createHeaderCell();
		cell.setStyleClass("info");
		cell.add(new Text(localize("info", "Info")));

		cell = row.createHeaderCell();
		cell.setStyleClass("schoolCategory");
		cell.add(new Text(localize("category", "Category")));

		cell = row.createHeaderCell();
		cell.setStyleClass("maxAge");
		cell.add(new Text(localize("max_school_age", "Max school age")));

		cell = row.createHeaderCell();
		cell.setStyleClass("order");
		cell.add(new Text(localize("order", "Order")));

		cell = row.createHeaderCell();
		cell.setStyleClass("edit");
		cell.add(Text.getNonBrakingSpace());

		cell = row.createHeaderCell();
		cell.setStyleClass("lastColumn");
		cell.setStyleClass("delete");
		cell.add(Text.getNonBrakingSpace());

		group = table.createBodyRowGroup();
		int iRow = 1;
		java.util.Iterator iter = schoolTypes.iterator();
		while (iter.hasNext()) {
			SchoolType sType = (SchoolType) iter.next();
			SchoolCategory category = sType.getCategory();
			row = group.createRow();

			try {
				Link edit = new Link(getEditIcon(localize("edit", "Edit")));
				edit.addParameter(PARAMETER_SCHOOL_TYPE_PK, sType.getPrimaryKey().toString());
				edit.addParameter(PARAMETER_ACTION, ACTION_EDIT);

				Link delete = new Link(getDeleteIcon(localize("delete", "Delete")));
				delete.addParameter(PARAMETER_SCHOOL_TYPE_PK, sType.getPrimaryKey().toString());
				delete.addParameter(PARAMETER_ACTION, ACTION_DELETE);

				cell = row.createCell();
				cell.setStyleClass("firstColumn");
				cell.add(new Text(sType.getSchoolTypeName()));

				cell = row.createCell();
				cell.setStyleClass("info");
				cell.add(new Text(sType.getSchoolTypeInfo()));

				cell = row.createCell();
				cell.setStyleClass("schoolCategory");
				cell.add(new Text(localize(category.getLocalizedKey(), category.getName())));

				cell = row.createCell();
				cell.setStyleClass("maxAge");
				cell.add(new Text(sType.getMaxSchoolAge() > 0 ? String.valueOf(sType.getMaxSchoolAge()) : "-"));

				cell = row.createCell();
				cell.setStyleClass("order");
				cell.add(new Text(sType.getOrder() > 0 ? String.valueOf(sType.getOrder()) : "-"));

				cell = row.createCell();
				cell.setStyleClass("edit");
				cell.add(edit);

				cell = row.createCell();
				cell.setStyleClass("delete");
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

		SubmitButton newLink = (SubmitButton) getButton(new SubmitButton(localize("type.new", "New type"), PARAMETER_ACTION, String.valueOf(ACTION_NEW)));
		form.add(newLink);

		add(form);
	}

	public void showEditor(IWContext iwc, Object typePK) throws RemoteException {
		Form form = new Form();
		form.setStyleClass(STYLENAME_SCHOOL_FORM);

		SelectorUtility util = new SelectorUtility();
		DropdownMenu drpCategory = (DropdownMenu) util.getSelectorFromIDOEntities(new DropdownMenu(PARAMETER_CATEGORY), getBusiness().getSchoolCategories(), "getLocalizedKey", getResourceBundle());

		TextInput inputTypeStringId = new TextInput(PARAMETER_TYPE_STRING_ID);
		inputTypeStringId.setAsNotEmpty(localize("type_string_id_not_empty", "Type ID must be entered."));

		TextInput inputName = new TextInput(PARAMETER_NAME);
		TextInput inputKey = new TextInput(PARAMETER_LOCALIZED_KEY);
		TextArea inputInfo = new TextArea(PARAMETER_INFO);

		TextInput inputAge = new TextInput(PARAMETER_MAX_AGE);
		inputAge.setLength(4);

		TextInput inputOrder = new TextInput(PARAMETER_ORDER);
		inputOrder.setLength(4);

		if (typePK != null) {
			try {
				SchoolType type = getBusiness().getSchoolType(typePK);
				form.add(new HiddenInput(PARAMETER_SCHOOL_TYPE_PK, String.valueOf(typePK)));

				if (this._useTypeStringId) {
					inputTypeStringId.setContent(type.getTypeStringId());
				}
				inputName.setContent(type.getSchoolTypeName());
				inputInfo.setContent(type.getSchoolTypeInfo());
				inputKey.setContent(type.getLocalizationKey());
				drpCategory.setSelectedElement(type.getSchoolCategory());

				if (type.getMaxSchoolAge() != -1) {
					inputAge.setContent(String.valueOf(type.getMaxSchoolAge()));
				}
				if (type.getOrder() != -1) {
					inputOrder.setContent(String.valueOf(type.getOrder()));
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		Layer layer = new Layer(Layer.DIV);
		layer.setId("name");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		Label label = new Label(localize("name", "Name"), inputName);
		layer.add(label);
		layer.add(inputName);
		form.add(layer);

		if (this.iSchoolCategory == null) {
			layer = new Layer(Layer.DIV);
			layer.setId("schoolCategory");
			layer.setStyleClass(STYLENAME_FORM_ELEMENT);
			label = new Label(localize("category", "Category"), drpCategory);
			layer.add(label);
			layer.add(drpCategory);
			form.add(layer);
		}

		if (this._useTypeStringId) {
			layer = new Layer(Layer.DIV);
			layer.setId("typeID");
			layer.setStyleClass(STYLENAME_FORM_ELEMENT);
			label = new Label(localize("school_type_string_id", "Type ID"), inputTypeStringId);
			layer.add(label);
			layer.add(inputTypeStringId);
			form.add(layer);
		}

		layer = new Layer(Layer.DIV);
		layer.setId("info");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("info", "Info"), inputInfo);
		layer.add(label);
		layer.add(inputInfo);
		form.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setId("key");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("localization_key", "Key"), inputKey);
		layer.add(label);
		layer.add(inputKey);
		form.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setId("maxAge");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("maxage", "Max school age"), inputAge);
		layer.add(label);
		layer.add(inputAge);
		form.add(layer);

		layer = new Layer(Layer.DIV);
		layer.setId("order");
		layer.setStyleClass(STYLENAME_FORM_ELEMENT);
		label = new Label(localize("order", "Order"), inputOrder);
		layer.add(label);
		layer.add(inputOrder);
		form.add(layer);

		form.add(new Break());

		SubmitButton save = (SubmitButton) getButton(new SubmitButton(localize("save", "Save"), PARAMETER_ACTION, String.valueOf(ACTION_SAVE)));
		SubmitButton cancel = (SubmitButton) getButton(new SubmitButton(localize("cancel", "Cancel"), PARAMETER_ACTION, String.valueOf(ACTION_VIEW)));

		form.add(cancel);
		form.add(save);

		add(form);
	}

	public void setSchoolCategory(String category) {
		this.iSchoolCategory = category;
	}
}