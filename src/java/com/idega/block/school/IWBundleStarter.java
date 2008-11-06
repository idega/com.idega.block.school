/*
 * $Id: IWBundleStarter.java,v 1.9 2008/11/06 19:27:29 laddi Exp $ Created on 28.4.2005
 * 
 * Copyright (C) 2005 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to license terms.
 */
package com.idega.block.school;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.idega.block.school.business.SchoolBusiness;
import com.idega.block.school.data.School;
import com.idega.block.school.data.SchoolArea;
import com.idega.block.school.data.SchoolCategory;
import com.idega.block.school.data.SchoolCategoryHome;
import com.idega.block.school.data.SchoolClass;
import com.idega.block.school.data.SchoolClassHome;
import com.idega.block.school.data.SchoolHome;
import com.idega.block.school.data.SchoolSeason;
import com.idega.block.school.data.SchoolSeasonHome;
import com.idega.block.school.data.SchoolType;
import com.idega.block.school.data.SchoolTypeHome;
import com.idega.block.school.presentation.SchoolBlock;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWBundleStartable;
import com.idega.idegaweb.IWMainApplication;
import com.idega.idegaweb.include.GlobalIncludeManager;
import com.idega.user.business.GroupBusiness;
import com.idega.user.data.GroupType;

public class IWBundleStarter implements IWBundleStartable {

	public void start(IWBundle starterBundle) {
		updateData(starterBundle.getApplication().getIWApplicationContext());
		addStandardViews(starterBundle.getApplication());
	}

	public void stop(IWBundle starterBundle) {
		// nothing to do
	}

	private void updateData(IWApplicationContext iwac) {
		try {
			SchoolBusiness business = (SchoolBusiness) IBOLookup.getServiceInstance(iwac, SchoolBusiness.class);

			try {
				Collection areas = business.getSchoolAreaHome().findAllSchoolAreas(null, true);
				Iterator iterator = areas.iterator();
				while (iterator.hasNext()) {
					SchoolArea area = (SchoolArea) iterator.next();
					area.setCategory(business.getCategoryElementarySchool());
					area.store();
				}
			}
			catch (FinderException e1) {
				e1.printStackTrace();
			}

			SchoolCategory afterSchoolCareCategory = business.getCategoryAfterSchoolCare();
			if (afterSchoolCareCategory == null) {
				SchoolCategoryHome categoryHome = (SchoolCategoryHome) IDOLookup.getHome(SchoolCategory.class);
				try {
					afterSchoolCareCategory = categoryHome.create();
					afterSchoolCareCategory.setCategory("AFTER_SCHOOL_CARE");
					afterSchoolCareCategory.setName("After school care");
					afterSchoolCareCategory.setLocalizedKey("school_category.AFTER_SCHOOL_CARE");
					afterSchoolCareCategory.store();
				}
				catch (CreateException e) {
					e.printStackTrace();
				}
			}

			try {
				SchoolTypeHome home = (SchoolTypeHome) IDOLookup.getHome(SchoolType.class);
				Collection types = home.findAllFreetimeTypes(business.getChildCareSchoolCategory());
				Iterator iterator = types.iterator();
				while (iterator.hasNext()) {
					SchoolType type = (SchoolType) iterator.next();
					type.setCategory(afterSchoolCareCategory);
					type.store();
					System.out.println("Updated type category for type = " + type.getSchoolTypeName());
				}

				SchoolSeasonHome sHome = (SchoolSeasonHome) IDOLookup.getHome(SchoolSeason.class);
				Collection seasons = sHome.findAllSchoolSeasons(business.getCategoryElementarySchool());
				Collection afterSchoolCareSeasons = sHome.findAllSchoolSeasons(afterSchoolCareCategory);
				if (afterSchoolCareSeasons == null || afterSchoolCareSeasons.isEmpty()) {
					if (!seasons.isEmpty()) {
						Iterator iter = seasons.iterator();
						while (iter.hasNext()) {
							SchoolSeason season = (SchoolSeason) iter.next();
							business.storeSchoolSeason(-1, season.getSchoolSeasonName(), season.getSchoolSeasonStart(), season.getSchoolSeasonEnd(), season.getChoiceStartDate(), season.getChoiceEndDate(), afterSchoolCareCategory.getCategory());
							System.out.println("Created season for " + afterSchoolCareCategory.getCategory() + " = " + season.getSchoolSeasonName());
						}
					}
				}

				SchoolClassHome cHome = (SchoolClassHome) IDOLookup.getHome(SchoolClass.class);
				if (!seasons.isEmpty()) {
					iterator = seasons.iterator();
					while (iterator.hasNext()) {
						SchoolSeason element = (SchoolSeason) iterator.next();
						SchoolSeason ascSeason = sHome.findByNameAndCategory(element.getName(), afterSchoolCareCategory);

						if (ascSeason != null) {
							Collection classes = cHome.findBySeasonAndCategory(element, afterSchoolCareCategory);
							if (!classes.isEmpty()) {
								Iterator iter2 = classes.iterator();
								while (iter2.hasNext()) {
									SchoolClass group = (SchoolClass) iter2.next();
									group.setSchoolSeason(ascSeason);
									group.store();
									System.out.println("Updated season for after school care group = " + group.getSchoolClassName());
								}
							}
						}
					}
				}
			}
			catch (IDOLookupException ile) {
				ile.printStackTrace();
			}
			catch (FinderException fe) {
				fe.printStackTrace();
			}

			try {
				insertGroupType(iwac, SchoolConstants.GROUP_TYPE_SCHOOL_CATEGORY);
				insertGroupType(iwac, SchoolConstants.GROUP_TYPE_SCHOOL);
				insertGroupType(iwac, SchoolConstants.GROUP_TYPE_HEADMASTERS);
				insertGroupType(iwac, SchoolConstants.GROUP_TYPE_ASSISTANT_HEADMASTERS);
				insertGroupType(iwac, SchoolConstants.GROUP_TYPE_TEACHERS);
				insertGroupType(iwac, SchoolConstants.GROUP_TYPE_WEB_ADMINS);

				// UserBusiness userBusiness = (UserBusiness) IBOLookup.getServiceInstance(iwac, UserBusiness.class);
				SchoolHome home = (SchoolHome) IDOLookup.getHome(School.class);
				Collection schools = home.findAllWithNoPrimaryGroup();

				if (!schools.isEmpty()) {
					Iterator iterator = schools.iterator();
					while (iterator.hasNext()) {
						School school = (School) iterator.next();

						Collection categories = business.getSchoolCategories(school);
						Iterator iterator2 = categories.iterator();
						// boolean hasPrimarySet = false;
						while (iterator2.hasNext()) {
							SchoolCategory category = (SchoolCategory) iterator2.next();
							/* Group parentGroup = */business.getRootSchoolCategoryGroup(category);

							/*
							 * if (!hasPrimarySet) { try { Group schoolGroup = userBusiness.getGroupBusiness().createGroupUnder(school.getSchoolName(),
							 * school.getSchoolName(), SchoolConstants.GROUP_TYPE_SCHOOL, parentGroup.getHomePageID(), -1, parentGroup);
							 * school.setPrimaryGroup(schoolGroup); school.store(); hasPrimarySet = true; } catch (CreateException e) { e.printStackTrace(); } }
							 * else { }
							 */
						}
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
		catch (IBOLookupException e) {
			e.printStackTrace();
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		catch (IBORuntimeException e) {
			e.printStackTrace();
		}
	}

	private void insertGroupType(IWApplicationContext iwac, String groupType) {
		try {
			GroupBusiness business = (GroupBusiness) IBOLookup.getServiceInstance(iwac, GroupBusiness.class);
			GroupType type;
			try {
				type = business.getGroupTypeFromString(groupType);
			}
			catch (FinderException e) {
				type = business.getGroupTypeHome().create();
				type.setType(groupType);
				type.setVisibility(true);
				type.store();
			}
		}
		catch (IBOLookupException e) {
			e.printStackTrace();
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		catch (CreateException e) {
			e.printStackTrace();
		}
	}

	protected void addStandardViews(IWMainApplication iwma) {
		SchoolViewManager manager = SchoolViewManager.getInstance(iwma);
		manager.getSchoolViewNode();
	}
}