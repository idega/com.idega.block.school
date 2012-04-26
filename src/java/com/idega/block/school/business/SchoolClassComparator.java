package com.idega.block.school.business;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import com.idega.block.school.data.SchoolClass;

/**
 * A class to compare a collection of <code>SchoolClass</code> objects.
 * @author Laddi
 */
public class SchoolClassComparator implements Comparator<SchoolClass> {

	private Collator collator;

	public SchoolClassComparator() {
		collator = Collator.getInstance();
	}

	public SchoolClassComparator(Locale locale) {
		collator = Collator.getInstance(locale);
	}

	/**
	 * @see java.util.Comparator#compare(Object, Object)
	 */
	@Override
	public int compare(SchoolClass schoolClass1, SchoolClass schoolClass2) {
		int returner = 0;

		returner = compareSubGroups(schoolClass1.getIsSubGroup(), schoolClass2.getIsSubGroup());

		if (returner == 0)
			returner = collator.compare(schoolClass1.getSchoolClassName(), schoolClass2.getSchoolClassName());

		return returner;
	}

	public int compareSubGroups(boolean subGroup1, boolean subGroup2) {
		if (!subGroup1 && subGroup2) {
			return -1;
		}
		else if (subGroup1 && !subGroup2) {
			return 1;
		}
		else {
			return 0;
		}
	}

}