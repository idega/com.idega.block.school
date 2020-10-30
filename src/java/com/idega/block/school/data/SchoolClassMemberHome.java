/**
 *
 */
package com.idega.block.school.data;

import java.sql.Date;
import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.core.location.data.Commune;
import com.idega.data.IDOException;
import com.idega.data.IDOHome;
import com.idega.data.IDOLookupException;
import com.idega.user.data.Group;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;


/**
 * <p>
 * TODO Dainis Describe Type SchoolClassMemberHome
 * </p>
 *  Last modified: $Date: 2006/04/12 14:39:59 $ by $Author: igors $
 *
 * @author <a href="mailto:Dainis@idega.com">Dainis</a>
 * @version $Revision: 1.87 $
 */
public interface SchoolClassMemberHome extends IDOHome {

	public SchoolClassMember create() throws javax.ejb.CreateException;

	public SchoolClassMember findByPrimaryKey(Object pk) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllOrderedByRegisterDate
	 */
	public Collection findAllOrderedByRegisterDate(User user) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllOrderedByRegisterDate
	 */
	public Collection findAllOrderedByRegisterDate(int userID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolClass
	 */
	public Collection findBySchoolClass(SchoolClass schoolClass) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolClass
	 */
	public Collection findBySchoolClass(int schoolClassID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllBySchoolClass
	 */
	public Collection findAllBySchoolClass(SchoolClass schoolClass) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolClasses
	 */
	public Collection findBySchoolClasses(Collection schoolClasses) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolClassAndYear
	 */
	public Collection<SchoolClassMember> findBySchoolClassAndYear(int schoolClassID, int schoolYearID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolClassAndYearAndStudyPath
	 */
	public Collection findBySchoolClassAndYearAndStudyPath(SchoolClass group, SchoolYear schoolYear,
			SchoolStudyPath studyPath) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolAndSeasonAndYearAndStudyPath
	 */
	public Collection<SchoolClassMember> findBySchoolAndSeasonAndYearAndStudyPath(School school, SchoolSeason season, SchoolYear year,
			SchoolStudyPath studyPath) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByStudent
	 */
	public Collection findByStudent(User student) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByStudent
	 */
	public Collection findByStudent(int studentID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByStudentAndTypes
	 */
	public Collection findByStudentAndTypes(int studentID, Collection schoolTypes) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllBySchoolAndUsersWithSchoolYearAndNotRemoved
	 */
	public java.util.Collection findAllBySchoolAndUsersWithSchoolYearAndNotRemoved(int schoolId,
			java.util.Collection users) throws javax.ejb.FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByStudentAndSchoolAndTypes
	 */
	public Collection findByStudentAndSchoolAndTypes(int studentID, int schoolID, Collection schoolTypes)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByUserAndSchoolClass
	 */
	public SchoolClassMember findByUserAndSchoolClass(User user, SchoolClass schoolClass) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByUserAndSchoolClass
	 */
	public SchoolClassMember findByUserAndSchoolClass(int userID, int schoolClassID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByUserAndSeason
	 */
	public SchoolClassMember findByUserAndSeason(User user, SchoolSeason season) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByUserAndSeason
	 */
	public SchoolClassMember findByUserAndSeason(int userID, int seasonID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByUserAndSchool
	 */
	public SchoolClassMember findByUserAndSchool(int userID, int schoolID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfPlacingsAtSchool
	 */
	public int getNumberOfPlacingsAtSchool(User user, School school) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfPlacingsAtSchool
	 */
	public int getNumberOfPlacingsAtSchool(int userID, int schoolID) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfPlacings
	 */
	public int getNumberOfPlacings(int userID) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfPlacings
	 */
	public int getNumberOfPlacings(int userID, int schoolClassID) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfPlacingsBySchoolCategory
	 */
	public int getNumberOfPlacingsBySchoolCategory(User child, SchoolCategory schoolCategory) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfPlacingsBySeasonAndSchoolCategory
	 */
	public int getNumberOfPlacingsBySeasonAndSchoolCategory(User child, SchoolSeason season,
			SchoolCategory schoolCategory) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfSubGroupPlacings
	 */
	public int getNumberOfSubGroupPlacings(int userID, int schoolClassID) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfPlacingsByClass
	 */
	public int getNumberOfPlacingsByClass(SchoolClass schoolClass) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllSubGroupPlacements
	 */
	public Collection findAllSubGroupPlacements(int userID, int schoolID, int seasonID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestByUserAndSchool
	 */
	public SchoolClassMember findLatestByUserAndSchool(int userID, int schoolID) throws FinderException;


	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestByUserAndSchool
	 */
	public SchoolClassMember findLatestByUserAndSchool(int userID, int schoolID, Collection schoolTypes)
			throws FinderException;

	/** @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestByUserAndSchoolAndPlacementDate
	 */
	public SchoolClassMember findLatestByUserAndSchoolAndPlacementDate(int userID, int schoolID, Collection schoolTypes,Date placementDate) throws FinderException;


	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestByUser
	 */
	public SchoolClassMember findLatestByUser(User user) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestByUserAndSchoolType
	 */
	public SchoolClassMember findLatestByUserAndSchoolType(User user, SchoolType type) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestByUserAndSchCategory
	 */
	public SchoolClassMember findLatestByUserAndSchCategory(User user, SchoolCategory cat) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestByUserAndSchCategoryAndSeason
	 */
	public SchoolClassMember findLatestByUserAndSchCategoryAndSeason(User user, SchoolCategory cat, SchoolSeason season)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindActiveByCategorySeasonAndSchools
	 */
	public Collection findActiveByCategorySeasonAndSchools(SchoolCategory cat, SchoolSeason season, String[] schoolIds,
			boolean notInSchools) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllByCategory
	 */
	public Collection findAllByCategory(SchoolCategory category) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllByCategoryForPlacementChangesExport
	 */
	public Collection findAllByCategoryForPlacementChangesExport(SchoolCategory category, Date startDate, Date endDate)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindActiveByStudentSchoolAndCategory
	 */
	public SchoolClassMember findActiveByStudentSchoolAndCategory(int studentId, int schoolId, SchoolCategory category)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindNotTerminatedByStudentSchoolAndCategory
	 */
	public SchoolClassMember findNotTerminatedByStudentSchoolAndCategory(int studentId, int schoolId,
			SchoolCategory category) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllNotTerminatedByStudent
	 */
	public Collection findAllNotTerminatedByStudent(int studentId) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllByUserAndSchoolCategory
	 */
	public Collection findAllByUserAndSchoolCategory(User user, SchoolCategory cat) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestFromElemAndHighSchoolByUser
	 */
	public SchoolClassMember findLatestFromElemAndHighSchoolByUser(User user) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindLatestFromElemAndHighSchoolByUserAndSeason
	 */
	public SchoolClassMember findLatestFromElemAndHighSchoolByUserAndSeason(User user, SchoolSeason season)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByStudentAndSchool
	 */
	public Collection findByStudentAndSchool(int userID, int schoolID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllByUserAndSeason
	 */
	public Collection findAllByUserAndSeason(User user, SchoolSeason season) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllBySchoolStudyPath
	 */
	public Collection findAllBySchoolStudyPath(SchoolStudyPath studyPath) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllByUserAndSeason
	 */
	public Collection findAllByUserAndSeason(int userID, int seasonID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllCurrentInvoiceCompensationBySchoolTypeAndSchools
	 */
	public Collection findAllCurrentInvoiceCompensationBySchoolTypeAndSchools(String operationalField,
			Collection schools) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByUserAndSchoolAndSeason
	 */
	public SchoolClassMember findByUserAndSchoolAndSeason(int userID, int schoolID, int seasonID)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByUserAndSchoolAndSeason
	 */
	public SchoolClassMember findByUserAndSchoolAndSeason(int userID, int schoolID, int seasonID, Collection schoolTypes)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByUserAndSchoolAndSeasonAndStudyPath
	 */
	public SchoolClassMember findByUserAndSchoolAndSeasonAndStudyPath(int userID, int schoolID, int seasonID,
			int studyPathID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeCountByUserAndSchoolAndSeasonAndStudyPath
	 */
	public int countByUserAndSchoolAndSeasonAndStudyPath(int userID, int schoolID, int seasonID, int studyPathID)
			throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeCountByUserAndSchoolAndSeasonAndStudyPath
	 */
	public int countByUserAndSchoolAndSeasonAndStudyPath(User user, School school, SchoolSeason season,
			SchoolStudyPath studyPath) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolAndSeasonAndYear
	 */
	public Collection findBySchoolAndSeasonAndYear(int schoolID, int seasonID, int yearID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolAndSeason
	 */
	public Collection findBySchoolAndSeason(int schoolID, int seasonID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchool
	 */
	public Collection findBySchool(int schoolID, int schoolClassID) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchool
	 */
	public Collection findBySchool(int schoolID, int schoolClassID, Date date) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchool
	 */
	public Collection findBySchool(int schoolID, int schoolClassID, String schoolCategory, Date date)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchool
	 */
	public Collection findBySchool(int schoolID, int schoolClassID, Date date, boolean showNotYetActive)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchool
	 */
	public Collection findBySchool(int schoolID, int schoolClassID, String schoolCategory, Date date,
			boolean showNotYetActive) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolAndLog
	 */
	public Collection findBySchoolAndLog(int schoolID, int schoolClassID, String schoolCategory, Date date)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolAndLog
	 */
	public Collection findBySchoolAndLog(int schoolID, int schoolClassID, String schoolCategory, Date date,
			boolean showNotYetActive) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolChildcare
	 */
	public Collection findBySchoolChildcare(int schoolID, int schoolClassID, Date date, boolean showNotYetActive)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindBySchoolChildcare
	 */
	public Collection findBySchoolChildcare(int schoolID, int schoolClassID, String schoolCategory, Date date,
			boolean showNotYetActive) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllLastYearStudentsBySeasonAndMaximumAge
	 */
	public Collection findAllLastYearStudentsBySeasonAndMaximumAge(SchoolSeason season, int maxAge)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllLastYearStudentsBySeasonAndYear
	 */
	public Collection findAllLastYearStudentsBySeasonAndYear(SchoolSeason season, SchoolYear year)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllLastYearStudentsBySeasonAndYearAndMaximumAge
	 */
	public Collection findAllLastYearStudentsBySeasonAndYearAndMaximumAge(SchoolSeason season, SchoolYear year,
			int maxAge) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllBySeasonAndSchoolYear
	 */
	public Collection findAllBySeasonAndSchoolYear(SchoolSeason season, SchoolYear schoolYear) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfUsersNotAssignedToClassOnGivenDate
	 */
	public int getNumberOfUsersNotAssignedToClassOnGivenDate(Group citizenGroup, Date date, Collection classes,
			Date firstDateOfBirth, Date lastDateOfBirth) throws IDOException, IDOLookupException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfUsersNotAssignedToClassOnGivenDateNew
	 */
	public int getNumberOfUsersNotAssignedToClassOnGivenDateNew(Group citizenGroup, Date date,
			SchoolSeason schoolSeason, Date firstDateOfBirth, Date lastDateOfBirth) throws IDOException,
			IDOLookupException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindAllByUserAndPeriodAndSchoolCategory
	 */
	public Collection findAllByUserAndPeriodAndSchoolCategory(User child, Date period, SchoolCategory category)
			throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByCategorydManagementCommune
	 */
	public Collection findByCategorydManagementCommune(String category, String managementType, int communeId,
			int seasonId) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindByCategorydManagementCommune
	 */
	public Collection findByCategorydManagementCommune(String category, String managementType, int communeId,
			int seasonId, boolean newestFirst) throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetNumberOfPlacingsAtSchool
	 */
	public int getNumberOfPlacingsAtSchool(School school, SchoolSeason season, SchoolYear department,
			SchoolStudyPath instrument, String types, Commune commune) throws IDOException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbHomeGetInvoiceIntervalTypes
	 */
	public Collection getInvoiceIntervalTypes();

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindSubGroupPlacements
	 */
	public Collection findSubGroupPlacements() throws FinderException;

	/**
	 * @see com.idega.block.school.data.SchoolClassMemberBMPBean#ejbFindPlacementsBySchoolTypeAndRegisterDateAndGradeInPeriod
	 */
	public Collection findPlacementsBySchoolTypeAndRegisterDateAndGradeInPeriod(SchoolType type,
			IWTimestamp periodFrom, IWTimestamp periodTo) throws FinderException;
}
