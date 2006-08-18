package com.idega.block.school.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHomeImpl;

public class SchoolBusinessHomeImpl extends IBOHomeImpl implements SchoolBusinessHome {

	public Class getBeanInterfaceClass() {
		return SchoolBusiness.class;
	}

	public SchoolBusiness create() throws CreateException {
		return (SchoolBusiness) super.createIBO();
	}
}