/**
 *
 */
package com.idega.block.school;

import java.util.ArrayList;
import java.util.Collection;

import com.idega.block.school.presentation.SchoolAreaEditor;
import com.idega.block.school.presentation.SchoolEditor;
import com.idega.block.school.presentation.SchoolSeasonEditor;
import com.idega.block.school.presentation.SchoolTypeEditor;
import com.idega.block.school.presentation.SchoolUserEditor;
import com.idega.block.school.presentation.SchoolYearEditor;
import com.idega.core.view.DefaultViewNode;
import com.idega.core.view.ViewManager;
import com.idega.core.view.ViewNode;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWMainApplication;
import com.idega.workspace.view.WorkspaceApplicationNode;
import com.idega.workspace.view.WorkspaceClassViewNode;


/**
 * <p>
 * TODO tryggvil Describe Type SchoolViewManager
 * </p>
 *  Last modified: $Date: 2008/01/17 08:11:11 $ by $Author: alexis $
 *
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.4 $
 */
public class SchoolViewManager {

	private ViewNode schoolViewNode;
	private IWMainApplication iwma;
	/**
	 * <p>
	 * TODO tryggvil describe method getInstance
	 * </p>
	 * @param iwma
	 * @return
	 */
	public static SchoolViewManager getInstance(IWMainApplication iwma) {
		SchoolViewManager instance = (SchoolViewManager) iwma.getAttribute("schoolviewmanager");
		if(instance==null){
			instance = new SchoolViewManager();
			instance.iwma=iwma;
			iwma.setAttribute("schoolviewmanager",instance);
		}
		return instance;
	}

	public ViewManager getViewManager(){
		return ViewManager.getInstance(this.iwma);
	}


	public ViewNode getSchoolViewNode(){
		IWBundle iwb = this.iwma.getBundle("com.idega.block.school");
		if(this.schoolViewNode==null){
			this.schoolViewNode = initalizeSchoolNode(iwb);
		}
		return this.schoolViewNode;
	}

	/**
	 * <p>
	 * TODO tryggvil describe method initalizeSchoolNode
	 * </p>
	 * @param iwb
	 * @return
	 */
	private ViewNode initalizeSchoolNode(IWBundle iwb) {
		ViewManager viewManager = ViewManager.getInstance(this.iwma);
		ViewNode workspace = viewManager.getWorkspaceRoot();

		Collection<String> roles = new ArrayList<String>();
		roles.add("schools_admin");

		DefaultViewNode schoolNode = new WorkspaceApplicationNode("school",workspace,roles);

		WorkspaceClassViewNode setupNode = new WorkspaceClassViewNode("setup",schoolNode);
		setupNode.setName("#{localizedStrings['com.idega.block.school']['setup']}");

		WorkspaceClassViewNode seasons = new WorkspaceClassViewNode("seasons",schoolNode);
		seasons.setName("#{localizedStrings['com.idega.block.school']['school_seasons']}");
		seasons.setComponentClass(SchoolSeasonEditor.class);

		WorkspaceClassViewNode years = new WorkspaceClassViewNode("years",schoolNode);
		years.setName("#{localizedStrings['com.idega.block.school']['school_years']}");
		years.setComponentClass(SchoolYearEditor.class);

		WorkspaceClassViewNode schools = new WorkspaceClassViewNode("schools",schoolNode);
		schools.setName("#{localizedStrings['com.idega.block.school']['schools']}");
		schools.setComponentClass(SchoolEditor.class);

		WorkspaceClassViewNode types = new WorkspaceClassViewNode("types",schoolNode);
		types.setName("#{localizedStrings['com.idega.block.school']['school_types']}");
		types.setComponentClass(SchoolTypeEditor.class);

		WorkspaceClassViewNode areas = new WorkspaceClassViewNode("areas",schoolNode);
		areas.setName("#{localizedStrings['com.idega.block.school']['school_areas']}");
		areas.setComponentClass(SchoolAreaEditor.class);

		WorkspaceClassViewNode users = new WorkspaceClassViewNode("users",schoolNode);
		users.setName("#{localizedStrings['com.idega.block.school']['school_users']}");
		users.setComponentClass(SchoolUserEditor.class);

		return schoolNode;
	}

}
