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
 *  Last modified: $Date: 2006/02/20 23:27:50 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.1 $
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
		return ViewManager.getInstance(iwma);
	}
	
	
	public ViewNode getSchoolViewNode(){
		IWBundle iwb = iwma.getBundle("com.idega.block.school");
		if(schoolViewNode==null){
			schoolViewNode = initalizeSchoolNode(iwb);
		}
		return schoolViewNode;
	}

	/**
	 * <p>
	 * TODO tryggvil describe method initalizeSchoolNode
	 * </p>
	 * @param iwb
	 * @return
	 */
	private ViewNode initalizeSchoolNode(IWBundle iwb) {
		ViewManager viewManager = ViewManager.getInstance(iwma);
		ViewNode workspace = viewManager.getWorkspaceRoot();
		
		Collection roles = new ArrayList();
		roles.add("school_admin");
		
		DefaultViewNode schoolNode = new WorkspaceApplicationNode("school",workspace,roles);
		schoolNode.setName("#{localizedStrings['com.idega.block.school']['school']}");

		DefaultViewNode setupNode = new WorkspaceClassViewNode("setup",schoolNode);
		setupNode.setName("#{localizedStrings['com.idega.block.school']['setup']}");
		
		WorkspaceClassViewNode seasons = new WorkspaceClassViewNode("seasons",setupNode);
		seasons.setName("#{localizedStrings['com.idega.block.school']['school_seasons']}");
		seasons.setComponentClass(SchoolSeasonEditor.class);
		
		WorkspaceClassViewNode years = new WorkspaceClassViewNode("years",setupNode);
		years.setName("#{localizedStrings['com.idega.block.school']['school_years']}");
		years.setComponentClass(SchoolYearEditor.class);
		
		WorkspaceClassViewNode schools = new WorkspaceClassViewNode("schools",setupNode);
		schools.setName("#{localizedStrings['com.idega.block.school']['schools']}");
		schools.setComponentClass(SchoolEditor.class);
		
		WorkspaceClassViewNode types = new WorkspaceClassViewNode("types",setupNode);
		types.setName("#{localizedStrings['com.idega.block.school']['school_types']}");
		types.setComponentClass(SchoolTypeEditor.class);
		
		WorkspaceClassViewNode areas = new WorkspaceClassViewNode("areas",setupNode);
		areas.setName("#{localizedStrings['com.idega.block.school']['school_areas']}");
		areas.setComponentClass(SchoolAreaEditor.class);
		
		WorkspaceClassViewNode users = new WorkspaceClassViewNode("users",setupNode);
		users.setName("#{localizedStrings['com.idega.block.school']['school_users']}");
		users.setComponentClass(SchoolUserEditor.class);
		
		return schoolNode;
	}
	
}
