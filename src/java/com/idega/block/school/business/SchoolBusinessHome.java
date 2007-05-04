package com.idega.block.school.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHome;
import java.rmi.RemoteException;

public interface SchoolBusinessHome extends IBOHome {

	public SchoolBusiness create() throws CreateException, RemoteException;
}