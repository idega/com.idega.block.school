package com.idega.block.school.business;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import com.idega.block.school.data.School;

/**
 * A class to compare a collection of <code>School</code> objects.
 * @author Laddi
 */
public class SchoolComparator implements Comparator<School> {

	private Locale _locale;
	private Collator collator;

	/**
	 * Constructor for SchoolComparator.
	 */
	public SchoolComparator(Locale locale) {
		this._locale = locale;
		collator = Collator.getInstance(this._locale);
	}

	@Override
	public int compare(School school1, School school2) {
		return collator.compare(school1.getSchoolName(), school2.getSchoolName());
	}

}