/**
 * @(#)SchoolReportBean.java    1.0.0 14:23:52
 *
 * Idega Software hf. Source Code Licence Agreement x
 *
 * This agreement, made this 10th of February 2006 by and between 
 * Idega Software hf., a business formed and operating under laws 
 * of Iceland, having its principal place of business in Reykjavik, 
 * Iceland, hereinafter after referred to as "Manufacturer" and Agura 
 * IT hereinafter referred to as "Licensee".
 * 1.  License Grant: Upon completion of this agreement, the source 
 *     code that may be made available according to the documentation for 
 *     a particular software product (Software) from Manufacturer 
 *     (Source Code) shall be provided to Licensee, provided that 
 *     (1) funds have been received for payment of the License for Software and 
 *     (2) the appropriate License has been purchased as stated in the 
 *     documentation for Software. As used in this License Agreement, 
 *     Licensee shall also mean the individual using or installing 
 *     the source code together with any individual or entity, including 
 *     but not limited to your employer, on whose behalf you are acting 
 *     in using or installing the Source Code. By completing this agreement, 
 *     Licensee agrees to be bound by the terms and conditions of this Source 
 *     Code License Agreement. This Source Code License Agreement shall 
 *     be an extension of the Software License Agreement for the associated 
 *     product. No additional amendment or modification shall be made 
 *     to this Agreement except in writing signed by Licensee and 
 *     Manufacturer. This Agreement is effective indefinitely and once
 *     completed, cannot be terminated. Manufacturer hereby grants to 
 *     Licensee a non-transferable, worldwide license during the term of 
 *     this Agreement to use the Source Code for the associated product 
 *     purchased. In the event the Software License Agreement to the 
 *     associated product is terminated; (1) Licensee's rights to use 
 *     the Source Code are revoked and (2) Licensee shall destroy all 
 *     copies of the Source Code including any Source Code used in 
 *     Licensee's applications.
 * 2.  License Limitations
 *     2.1 Licensee may not resell, rent, lease or distribute the 
 *         Source Code alone, it shall only be distributed as a 
 *         compiled component of an application.
 *     2.2 Licensee shall protect and keep secure all Source Code 
 *         provided by this this Source Code License Agreement. 
 *         All Source Code provided by this Agreement that is used 
 *         with an application that is distributed or accessible outside
 *         Licensee's organization (including use from the Internet), 
 *         must be protected to the extent that it cannot be easily 
 *         extracted or decompiled.
 *     2.3 The Licensee shall not resell, rent, lease or distribute 
 *         the products created from the Source Code in any way that 
 *         would compete with Idega Software.
 *     2.4 Manufacturer's copyright notices may not be removed from 
 *         the Source Code.
 *     2.5 All modifications on the source code by Licencee must 
 *         be submitted to or provided to Manufacturer.
 * 3.  Copyright: Manufacturer's source code is copyrighted and contains 
 *     proprietary information. Licensee shall not distribute or 
 *     reveal the Source Code to anyone other than the software 
 *     developers of Licensee's organization. Licensee may be held 
 *     legally responsible for any infringement of intellectual property 
 *     rights that is caused or encouraged by Licensee's failure to abide 
 *     by the terms of this Agreement. Licensee may make copies of the 
 *     Source Code provided the copyright and trademark notices are 
 *     reproduced in their entirety on the copy. Manufacturer reserves 
 *     all rights not specifically granted to Licensee.
 *
 * 4.  Warranty & Risks: Although efforts have been made to assure that the 
 *     Source Code is correct, reliable, date compliant, and technically 
 *     accurate, the Source Code is licensed to Licensee as is and without 
 *     warranties as to performance of merchantability, fitness for a 
 *     particular purpose or use, or any other warranties whether 
 *     expressed or implied. Licensee's organization and all users 
 *     of the source code assume all risks when using it. The manufacturers, 
 *     distributors and resellers of the Source Code shall not be liable 
 *     for any consequential, incidental, punitive or special damages 
 *     arising out of the use of or inability to use the source code or 
 *     the provision of or failure to provide support services, even if we 
 *     have been advised of the possibility of such damages. In any case, 
 *     the entire liability under any provision of this agreement shall be 
 *     limited to the greater of the amount actually paid by Licensee for the 
 *     Software or 5.00 USD. No returns will be provided for the associated 
 *     License that was purchased to become eligible to receive the Source 
 *     Code after Licensee receives the source code. 
 */
package com.idega.block.school.business;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;

import javax.ejb.FinderException;

import com.idega.block.datareport.util.ReportableCollection;
import com.idega.block.datareport.util.ReportableData;
import com.idega.block.datareport.util.ReportableField;
import com.idega.block.school.data.School;
import com.idega.block.school.data.SchoolSeason;
import com.idega.block.school.data.SchoolStudyPath;
import com.idega.block.school.data.SchoolYear;
import com.idega.block.school.data.SchoolYearHome;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.business.IBOSessionBean;
import com.idega.core.location.data.Commune;
import com.idega.data.IDOException;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.util.StringUtil;

/**
 * <p>Eh, just overriding the way schools should be found</p>
 * <p>You can report about problems to: 
 * <a href="mailto:martynas@idega.is">Martynas Stakė</a></p>
 *
 * @version 1.0.0 2016 rugp. 17
 * @author <a href="mailto:martynas@idega.is">Martynas Stakė</a>
 */
public class ElementarySchoolReportBean extends IBOSessionBean implements
		ElementarySchoolReport {

	private static final long serialVersionUID = -5499021588688899733L;

	private final static String PREFIX = "music_school_report.";
	private final static String FIELD_SCHOOL = "school";

	private SchoolBusiness schoolBusiness;

	private SchoolYearHome schoolYearHome;

	private IWBundle _iwb;

	private IWResourceBundle _iwrb;

	protected IWBundle getIWBundle() {
		if (this._iwb == null) {
			this._iwb = getIWApplicationContext().getIWMainApplication()
					.getBundle("is.idega.idegaweb.egov.musicschool");
		}

		return this._iwb;
	}

	private IWResourceBundle getIWResourceBundle() {
		if (this._iwrb == null) {
			this._iwrb = getIWBundle().getResourceBundle(
					this.getUserContext().getCurrentLocale());
		}

		return this._iwrb;
	}

	private String getLocalizedString(String key, String defaultValue) {
		return getIWResourceBundle().getLocalizedString(PREFIX + key, defaultValue);
	}

	private SchoolYearHome getSchoolYearHome() {
		if (this.schoolYearHome == null) {
			try {
				this.schoolYearHome = (SchoolYearHome) IDOLookup.getHome(SchoolYear.class);
			} catch (IDOLookupException e) {
				getLogger().log(Level.WARNING, 
						"Failed to get " + SchoolYearHome.class + 
						" cause of: ", e);
			}
		}

		return this.schoolYearHome;
	}

	private SchoolBusiness getSchoolBusiness() {
		if (this.schoolBusiness == null) {
			try {
				this.schoolBusiness = IBOLookup.getServiceInstance(
						getIWApplicationContext(), SchoolBusiness.class);
			} catch (IBOLookupException e) {
				getLogger().log(Level.WARNING, 
						"Failed to get " + SchoolBusiness.class + 
						" cause of: ", e);
			}
		}

		return this.schoolBusiness;
	}

	protected Collection<SchoolYear> getDepartments() {
		try {
			return getSchoolYearHome().findAllSchoolYearsBySchoolCategory(getSchoolBusiness().getCategoryElementarySchool(), true);
		} catch (FinderException | RemoteException e) {
			getLogger().log(Level.WARNING, "Failed to get school departments");
		}

		return Collections.emptyList();
	}

	protected Collection<School> findAllSchools() {
		try {
			return getSchoolBusiness().findAllSchoolsByCategory(getSchoolBusiness().getElementarySchoolSchoolCategory());
		} catch (RemoteException e) {
			getLogger().log(Level.WARNING, "Failed to get schools");
		}

		return Collections.emptyList();
	}

	protected int getApplicationCount(School school, SchoolSeason season, 
			SchoolYear department, SchoolStudyPath instrument, 
			String types, String[] statuses, int choiceNumber, 
			Commune commune, boolean showAllStudents) {
		try {
			return getSchoolBusiness().getSchoolClassMemberHome().getNumberOfPlacingsAtSchool(
					school, season, department, instrument, types, commune);
		} catch (RemoteException | IDOException e) {
			getLogger().log(Level.WARNING, "Failed to count applications");
		}

		return -1;
	}

	public Integer getYearNumber(SchoolYear department) {
		if (department != null) {
			String yearName = department.getSchoolYearName();
			if (!StringUtil.isEmpty(yearName)) {
				if (yearName.contains("10")) {
					return 10;
				} else if (yearName.contains("2")) {
					return 2;
				} else if (yearName.contains("3")) {
					return 3;
				} else if (yearName.contains("4")) {
					return 4;
				} else if (yearName.contains("5")) {
					return 5;
				} else if (yearName.contains("6")) {
					return 6;
				} else if (yearName.contains("7")) {
					return 7;
				} else if (yearName.contains("8")) {
					return 8;
				} else if (yearName.contains("9")) {
					return 9;
				} else if (yearName.contains("1")) {
					return 1;
				}
			}
		}

		return null;
	}

	public String getVariable(SchoolYear department) {
		Integer number = getYearNumber(department);
		if (number != null) {
			return "sch_year_" + number.toString();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.idega.block.school.business.SchoolReport#getPlacingsReport(com.idega.block.school.data.SchoolSeason)
	 */
	@Override
	public ReportableCollection getPlacingsReport(SchoolSeason season) {
		return getReport(season, null, null, true, true);
	}

	protected ReportableCollection getReport(SchoolSeason season, 
			Commune commune, String[] statuses, boolean getPlacements, 
			boolean showAllStudents) {
		try {
			Locale currentLocale = this.getUserContext().getCurrentLocale();
			Map<String, ReportableField> map = new HashMap<String, ReportableField>();

			ReportableCollection reportCollection = new ReportableCollection();

			ReportableField name = new ReportableField(FIELD_SCHOOL, String.class);
			name.setLocalizedName(getLocalizedString(FIELD_SCHOOL, "School"), currentLocale);
			reportCollection.addField(name);

			Collection<SchoolYear> departments = getDepartments();
			for (SchoolYear department: departments) {
				ReportableField classDepartment = new ReportableField(getVariable(department), Integer.class);
				classDepartment.setLocalizedName(department.getSchoolYearName(), currentLocale);
				reportCollection.addField(classDepartment);
				map.put(getVariable(department), classDepartment);
			}

			Collection<School> schools = findAllSchools();
			for (School school: schools) {
				ReportableData data = new ReportableData();
				data.addData(name, school.getSchoolName());

				int totalNR = 0;
				for (SchoolYear department : departments) {
					totalNR = getApplicationCount(school, season, 
							department, null, null, statuses, 1, 
							commune, showAllStudents);
					String variableName = getVariable(department);
					data.addData(map.get(variableName), new Integer(totalNR));
					getLogger().fine("Variable name: " + variableName + " has " + totalNR);
				}

				reportCollection.add(data);
			}

			getLogger().fine("Report data: " + reportCollection);
			return reportCollection;
		}
		catch (Exception fe) {
			throw new IBORuntimeException(fe);
		}
	}
}
