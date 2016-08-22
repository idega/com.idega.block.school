package com.idega.block.school.presentation;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.block.school.SchoolConstants;
import com.idega.block.school.business.SchoolBusiness;
import com.idega.block.school.data.SchoolCategory;
import com.idega.block.school.data.SchoolSeason;
import com.idega.block.school.data.SchoolSeasonHome;
import com.idega.business.IBOLookup;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.presentation.IWContext;
import com.idega.presentation.ui.DropDownMenuInputHandler;

/**
 * @author Laddi
 */
public class SchoolSeasonDropdown extends DropDownMenuInputHandler {

	/**
	 * Creates a new <code>SchoolSeasonDropdown</code> with all school seasons.
	 * 
	 * @param name The name of the <code>SchoolSeasonDropdown</code>
	 */
	public SchoolSeasonDropdown(String name) {
		super(name);
	}

	public SchoolSeasonDropdown() {
		super();
	}

	public void main(IWContext iwc) throws Exception {
		Collection<SchoolSeason> seasons = getSeasons(iwc);
		if (seasons != null) {
			for (SchoolSeason season : seasons) {
				SchoolCategory category = season.getSchoolCategory();
				if (category != null) {
					String localizedKey = getLocalizedString(
							category.getLocalizedKey(), 
							category.getLocalizedKey(), 
							getIWUserContext());
					addMenuElement(
							season.getPrimaryKey().toString(), 
							season.getSchoolSeasonName() + " - " + localizedKey);
				} else {
					addMenuElement(
							season.getPrimaryKey().toString(), 
							season.getSchoolSeasonName());
				}
			}
		}
	}

	protected Collection<SchoolSeason> getSeasons(IWContext iwc) throws RemoteException {
		return getSchoolBusiness(iwc).findAllSchoolSeasons();
	}

	protected SchoolBusiness getSchoolBusiness(IWContext iwc) throws RemoteException {
		return (SchoolBusiness) IBOLookup.getServiceInstance(iwc, SchoolBusiness.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idega.business.InputHandler#getResultingObject(java.lang.String, com.idega.presentation.IWContext)
	 */
	public Object getResultingObject(String[] value, IWContext iwc) throws Exception {
		if (value != null) {
			Object pk = Integer.decode(value[0]);
			try {
				if (value != null) {
					SchoolSeason season = ((SchoolSeasonHome) IDOLookup.getHome(SchoolSeason.class)).findByPrimaryKey(pk);
					if (season != null) {
						return season;
					}
				}
			}
			catch (IDOLookupException e) {
				e.printStackTrace();
			}
			catch (FinderException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		return (null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idega.business.InputHandler#getDisplayNameOfValue(java.lang.String, com.idega.presentation.IWContext)
	 */
	public String getDisplayForResultingObject(Object value, IWContext iwc) {
		if (value != null) {
			SchoolCategory category = ((SchoolSeason) value).getSchoolCategory();
			if (category != null) {
				String localizedKey = getLocalizedString(
						category.getLocalizedKey(), 
						category.getLocalizedKey(), 
						getIWUserContext());
				
				return ((SchoolSeason) value).getSchoolSeasonName() + " - " + localizedKey; 
			}
			
			return ((SchoolSeason) value).getSchoolSeasonName();
		}
		return "";
	}

	@Override
	public String getBundleIdentifier() {
		return SchoolConstants.IW_BUNDLE_IDENTIFIER;
	}
}