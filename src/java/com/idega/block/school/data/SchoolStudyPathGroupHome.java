/**
 * 
 */
package com.idega.block.school.data;

import java.util.Collection;
import javax.ejb.FinderException;
import com.idega.data.IDOHome;


/**
 * <p>
 * TODO Dainis Describe Type SchoolStudyPathGroupHome
 * </p>
 *  Last modified: $Date: 2005/11/27 17:08:12 $ by $Author: dainis $
 * 
 * @author <a href="mailto:Dainis@idega.com">Dainis</a>
 * @version $Revision: 1.3 $
 */
public interface SchoolStudyPathGroupHome extends IDOHome {

	public SchoolStudyPathGroup create() throws javax.ejb.CreateException;

	public SchoolStudyPathGroup findByPrimaryKey(Object pk) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathGroupBMPBean#ejbFindAllStudyPathGroups
	 */
	public Collection findAllStudyPathGroups() throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolStudyPathGroupBMPBean#ejbFindByGroupName
	 */
	public SchoolStudyPathGroup findByGroupName(String name) throws FinderException;
}
