package com.idega.block.school.presentation;

import java.rmi.RemoteException;

import com.idega.presentation.PresentationObject;
import com.idega.presentation.text.Link;

/**
 * @author gimmi

 */
public class SchoolContentItemEditButton extends SchoolContentItem {

	/**
	 * @see com.idega.block.school.presentation.SchoolContentItem#getObject()
	 */
	protected PresentationObject getObject() throws RemoteException {
//		System.out.println("SchoolContentItemEditButton : hasContentEdit = "+super.getSchoolContentBusiness(_iwc).hasEditPermission(_school, super._iwc));
		
		
		Link link = SchoolContentEditor.getLink(_school);
		if (super.hasEditPermission()) {
			return link;
		}else if (super.getSchoolBusiness(_iwc).hasEditPermission(_iwc.getCurrentUser(), _school)) {
			return link;
		}
		return null;
	}

}