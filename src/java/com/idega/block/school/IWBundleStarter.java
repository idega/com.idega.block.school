/*
 * $Id: IWBundleStarter.java,v 1.3 2006/02/20 23:27:50 tryggvil Exp $
 * Created on 28.4.2005
 *
 * Copyright (C) 2005 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.school;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.FinderException;
import com.idega.block.school.data.SchoolCategoryBMPBean;
import com.idega.block.school.data.SchoolSeason;
import com.idega.block.school.data.SchoolSeasonHome;
import com.idega.block.school.presentation.SchoolBlock;
import com.idega.block.school.presentation.SchoolSeasonEditor;
import com.idega.block.school.presentation.SchoolYearEditor;
import com.idega.core.accesscontrol.business.StandardRoles;
import com.idega.core.view.ApplicationViewNode;
import com.idega.core.view.DefaultViewNode;
import com.idega.core.view.KeyboardShortcut;
import com.idega.core.view.ViewManager;
import com.idega.core.view.ViewNode;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWBundleStartable;
import com.idega.idegaweb.IWMainApplication;
import com.idega.idegaweb.include.GlobalIncludeManager;
import com.idega.workspace.view.WorkspaceApplicationNode;
import com.idega.workspace.view.WorkspaceClassViewNode;


public class IWBundleStarter implements IWBundleStartable {

	public void start(IWBundle starterBundle) {
		updateData();
		addStandardViews(starterBundle.getApplication());
	}
	
	public void stop(IWBundle starterBundle) {
		// nothing to do
	}
	
	private void updateData() {
		GlobalIncludeManager includeManager = GlobalIncludeManager.getInstance();
		includeManager.addBundleStyleSheet(SchoolBlock.IW_BUNDLE_IDENTIFIER, "/style/school.css");

		try {
			SchoolSeasonHome home = (SchoolSeasonHome) IDOLookup.getHome(SchoolSeason.class);
			Collection seasons = home.findAllSchoolSeasonsWithoutCategory();
			if (!seasons.isEmpty()) {
				Iterator iter = seasons.iterator();
				while (iter.hasNext()) {
					SchoolSeason element = (SchoolSeason) iter.next();
					element.setSchoolCategory(SchoolCategoryBMPBean.CATEGORY_ELEMENTARY_SCHOOL);
					System.out.println("Updated category value for season = " + element.getSchoolSeasonName());
				}
			}
		}
		catch (IDOLookupException ile) {
			ile.printStackTrace();
		}
		catch (FinderException fe) {
			fe.printStackTrace();
		}
	}
	
	protected void addStandardViews(IWMainApplication iwma){
		
		SchoolViewManager manager = SchoolViewManager.getInstance(iwma);
		
		manager.getSchoolViewNode();
		
	}

}