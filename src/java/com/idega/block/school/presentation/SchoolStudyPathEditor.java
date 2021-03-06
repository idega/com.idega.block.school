package com.idega.block.school.presentation;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.ejb.FinderException;

import com.idega.block.school.business.SchoolBusiness;
import com.idega.block.school.data.School;
import com.idega.block.school.data.SchoolClassMember;
import com.idega.block.school.data.SchoolClassMemberHome;
import com.idega.block.school.data.SchoolStudyPath;
import com.idega.block.school.data.SchoolStudyPathHome;
import com.idega.business.IBOLookup;
import com.idega.data.IDOLookup;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.Block;
import com.idega.presentation.IWContext;
import com.idega.presentation.Table;
import com.idega.presentation.text.Link;
import com.idega.presentation.ui.BackButton;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.SubmitButton;
import com.idega.presentation.ui.TextArea;
import com.idega.presentation.ui.TextInput;
import com.idega.presentation.util.TextFormat;
import com.idega.util.PresentationUtil;

/**
 * @author Gimmi
 */
public class SchoolStudyPathEditor extends Block {
	private TextFormat tFormat;
	private SchoolBusiness sBus;
	private IWResourceBundle iwrb;

	private String ACTION = "sce_a";
	private String ACTION_PARAMETER_NEW_COURSE = "sce_nc";
	private String ACTION_PARAMETER_SAVE_COURSE = "sce_sc";
	private String ACTION_PARAMETER_DELETE_COURSE = "sce_ec";
	private String ACTION_PARAMETER_EDIT_COURSE = "sce_dc";

	private String PARAMETER_SCHOOL_ID = "sce_s_id";
	private String PARAMETER_SCHOOL_TYPE_ID = "sce_st_id";
	private String PARAMETER_SCHOOL_COURSE_ID = "sce_sc_id";
	private String PARAMETER_COURSE_NAME = "sce_cn";
	private String PARAMETER_COURSE_DESCRIPTION = "sce_cd";
	private String PARAMETER_CATEGORY = "sce_category";
	private School school;
	private String schoolTypeId;

	public final static String IW_BUNDLE_IDENTIFIER = "com.idega.block.school";

	public String getBundleIdentifier(){
	  return IW_BUNDLE_IDENTIFIER;
	}
	
	private void init(IWContext iwc) throws RemoteException {
		this.iwrb = getResourceBundle(iwc);
		this.tFormat = TextFormat.getInstance();
		this.sBus = (SchoolBusiness) IBOLookup.getServiceInstance(iwc, SchoolBusiness.class);
		String sSchoolId = iwc.getParameter(this.PARAMETER_SCHOOL_ID);
		if (sSchoolId != null) {
			this.school = this.sBus.getSchool(new Integer(sSchoolId));
		}
		this.schoolTypeId = iwc.getParameter(this.PARAMETER_SCHOOL_TYPE_ID);
	}
	
	public void main (IWContext iwc) throws RemoteException {
		PresentationUtil.addStyleSheetToHeader(iwc, getBundle(iwc).getVirtualPathWithFileNameString("style/school.css"));
		init(iwc);
		
		String action = iwc.getParameter(this.ACTION);
		if (action == null) {
			action = "";
		}
		if ( action.equals(this.ACTION_PARAMETER_NEW_COURSE) || action.equals(this.ACTION_PARAMETER_EDIT_COURSE) ) {
			createCourse(iwc);
		} else if ( action.equals(this.ACTION_PARAMETER_SAVE_COURSE)) {
			if (!saveCourse(iwc)) {
				add(this.tFormat.format(this.iwrb.getLocalizedString("school.could_not_save_course","Could not save course"), TextFormat.HEADER));
			} 
			drawMenu(iwc);
		} else if (action.equals(this.ACTION_PARAMETER_DELETE_COURSE)) {
			if (deleteCourse(iwc)) {
				add(this.tFormat.format(this.iwrb.getLocalizedString("school.could_not_delete_course","Could not delete course"), TextFormat.HEADER));
			} 
			drawMenu(iwc);
		} else {
			drawMenu(iwc);
		}
	}
	
	private void drawMenu(IWContext iwc) throws RemoteException {
		Form form = new Form();
		Table table = new Table();
		int row = 1;

		form.maintainParameter(this.PARAMETER_SCHOOL_ID);
		form.maintainParameter(this.PARAMETER_SCHOOL_TYPE_ID);

		Collection schoolColl = this.sBus.findAllSchools();
		if (schoolColl != null && !schoolColl.isEmpty()) {
			DropdownMenu schools = new DropdownMenu(schoolColl, this.PARAMETER_SCHOOL_ID);
			DropdownMenu schoolTypes = new DropdownMenu(this.PARAMETER_SCHOOL_TYPE_ID);
			schools.setToSubmit();
			schoolTypes.setToSubmit();
			if (this.school != null) {
				schools.setSelectedElement(this.school.getPrimaryKey().toString());
				Map schoolTypesMap = this.sBus.getSchoolRelatedSchoolTypes(this.school);
				if (schoolTypesMap != null) {
					schoolTypes.addMenuElements(schoolTypesMap.values());
				}
				if (this.schoolTypeId != null) {
					schoolTypes.setSelectedElement(this.schoolTypeId);
				}
			}
				
			table.add(schools, 1, row);
			table.add(schoolTypes, 1, row);
			table.add(new SubmitButton(this.iwrb.getLocalizedImageButton("school.submit","Submit")), 1, row);
			table.mergeCells(1, row, 2, row);
			
			if (this.schoolTypeId != null) {
				row = listCourses(iwc, table, row);
				SubmitButton newCourse = new SubmitButton(this.iwrb.getLocalizedImageButton("school.new","New"), this.ACTION, this.ACTION_PARAMETER_NEW_COURSE);
				table.add(newCourse, 1, ++row);
			}
			
		}
		
		
		form.add(table);
		add(form);
	}
	
	private int listCourses(IWContext iwc, Table table, int row) throws RemoteException {
		Map map = this.sBus.getSchoolAndSchoolTypeRelatedSchoolCourses(this.school, this.schoolTypeId);

		++row;
		table.add(this.tFormat.format(this.iwrb.getLocalizedString("school.name","Name"), TextFormat.HEADER), 1, row);
		table.add(this.tFormat.format(this.iwrb.getLocalizedString("school.description","Description"), TextFormat.HEADER), 2, row);
		
		if (map != null && !map.isEmpty()) {
			Collection courses = map.values();
			Iterator iter = courses.iterator();
			SchoolStudyPath course;
			Link edit;
			Link delete;
			while (iter.hasNext()) {
				course = (SchoolStudyPath) iter.next();
				++row;
				table.add(course.getCode(), 1, row);
				table.add(course.getDescription(), 2, row);
				
				edit = new Link(this.iwrb.getLocalizedImageButton("school.edit","Edit"));
				edit.maintainParameter(this.PARAMETER_SCHOOL_ID, iwc);
				edit.maintainParameter(this.PARAMETER_SCHOOL_TYPE_ID, iwc);
				edit.addParameter(this.ACTION, this.ACTION_PARAMETER_EDIT_COURSE);
				edit.addParameter(this.PARAMETER_SCHOOL_COURSE_ID, course.getPrimaryKey().toString());
				
				delete = new Link(this.iwrb.getLocalizedImageButton("school.delete","Delete"));
				delete.maintainParameter(this.PARAMETER_SCHOOL_ID, iwc);
				delete.maintainParameter(this.PARAMETER_SCHOOL_TYPE_ID, iwc);
				delete.addParameter(this.ACTION, this.ACTION_PARAMETER_DELETE_COURSE);
				delete.addParameter(this.PARAMETER_SCHOOL_COURSE_ID, course.getPrimaryKey().toString());

				table.add(edit, 3, row);
				table.add(delete, 3, row);
			}
		} else {
			++row;
			table.add(this.tFormat.format(this.iwrb.getLocalizedString("school.no_courses_found","No courses found"), TextFormat.NORMAL), 1, row);
		}
		return row;
	}
	
	private void createCourse(IWContext iwc) {
		Form form = new Form();
		Table table = new Table();

		form.maintainParameter(this.PARAMETER_SCHOOL_ID);
		form.maintainParameter(this.PARAMETER_SCHOOL_TYPE_ID);
		
		TextInput name = new TextInput(this.PARAMETER_COURSE_NAME);
		TextArea description = new TextArea(this.PARAMETER_COURSE_DESCRIPTION);
		
		String schoolCourseId = iwc.getParameter(this.PARAMETER_SCHOOL_COURSE_ID);
		if (schoolCourseId != null) {
			try {
				SchoolStudyPathHome scHome = (SchoolStudyPathHome) IDOLookup.getHome(SchoolStudyPath.class);
				SchoolStudyPath course = scHome.findByPrimaryKey(new Integer(schoolCourseId));
				form.maintainParameter(this.PARAMETER_SCHOOL_COURSE_ID);
				name.setContent(course.getCode());
				description.setContent(course.getDescription());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		table.mergeCells(1, 1, 2, 1);
		table.add(this.tFormat.format(this.iwrb.getLocalizedString("school.course","Course"), TextFormat.HEADER), 1, 1);
		
		table.add(this.tFormat.format(this.iwrb.getLocalizedString("school.name","Name"), TextFormat.NORMAL), 1, 2);
		table.add(name, 2, 2);
		
		table.add(this.tFormat.format(this.iwrb.getLocalizedString("school.description","Description"), TextFormat.NORMAL), 1, 3);
		table.add(description, 2, 3);
		
		SubmitButton save = new SubmitButton(this.iwrb.getLocalizedImageButton("school.save","Save"), this.ACTION, this.ACTION_PARAMETER_SAVE_COURSE);
		BackButton back = new BackButton(this.iwrb.getLocalizedImageButton("school.Cancel", "Cancel"));
		
		table.add(save, 2, 4);
		table.add(back, 2, 4);
		
		form.add(table);
		add(form);
	}
	
	private boolean saveCourse(IWContext iwc) {
		String name = iwc.getParameter(this.PARAMETER_COURSE_NAME);
		String description = iwc.getParameter(this.PARAMETER_COURSE_DESCRIPTION);
		String category = iwc.getParameter(this.PARAMETER_CATEGORY);
		
		String schoolCourseId = iwc.getParameter(this.PARAMETER_SCHOOL_COURSE_ID);
		if (name != null && !name.equals("") ) {
			try {
				SchoolStudyPathHome scHome = (SchoolStudyPathHome) IDOLookup.getHome(SchoolStudyPath.class);
				SchoolStudyPath course;
				if (schoolCourseId == null) {
					course = scHome.create();
				} else {
					course = scHome.findByPrimaryKey(new Integer(schoolCourseId));
				}
				course.setCode(name);
				course.setDescription(description);
//				course.setSchoolPk(school.getPrimaryKey());
				course.setSchoolTypeId(new Integer(this.schoolTypeId));
				course.setSchoolCategory(category);
				course.store();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean deleteCourse (IWContext iwc) {
		final String studyPathId
                = iwc.getParameter(this.PARAMETER_SCHOOL_COURSE_ID);
		if (null != studyPathId) {
            try {
                final SchoolStudyPathHome studyPathHome = (SchoolStudyPathHome)
                        IDOLookup.getHome(SchoolStudyPath.class);
                final SchoolStudyPath studyPath
                        = studyPathHome.findByPrimaryKey
                        (new Integer(studyPathId));
                final SchoolClassMemberHome studentHome
                        = (SchoolClassMemberHome) IDOLookup.getHome
                        (SchoolClassMember.class);
                try {
                    final Collection students
                            = studentHome.findAllBySchoolStudyPath (studyPath);
                    if (null != students) {
                        for (Iterator i = students.iterator (); i.hasNext ();) {
                            final SchoolClassMember student
                                    = (SchoolClassMember) i.next ();
                            student.setStudyPathToNull ();
                        }
                    }
                } catch (final FinderException fe) {
                    // no problem, no kids with this study path - do nothing
                }
                studyPath.remove ();
                return true;			
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
		return false;
	}
}
