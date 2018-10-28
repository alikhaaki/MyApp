package com.ali.digikalaapp.Model;

import java.util.Comparator;

public class Person {
	private int id;
	private String name, address;
	
	public static Comparator<Person> getComparator(SortParameter... sortParameters) {
		return new PersonComparator(sortParameters);
	}

	public enum SortParameter {
		ID_ASCENDING, ID_DESCENDING, NAME_ASCENDING,
		NAME_DESCENDING, ADDRESS_ASCENDING, ADDRESS_DESCENDING
	}

	private static class PersonComparator implements Comparator<Person> {
		private SortParameter[] parameters;

		private PersonComparator(SortParameter[] parameters) {
			this.parameters = parameters;
		}

		public int compare(Person o1, Person o2) {
			int comparison;
			for (SortParameter parameter : parameters) {
				switch (parameter) {
					case ID_ASCENDING:
						comparison = o1.id - o2.id;
						if (comparison != 0) return comparison;
						break;
					case ID_DESCENDING:
						comparison = o2.id - o1.id;
						if (comparison != 0) return comparison;
						break;
					case NAME_ASCENDING:
						comparison = o1.name.compareTo(o2.name);
						if (comparison != 0) return comparison;
						break;
					case NAME_DESCENDING:
						comparison = o2.name.compareTo(o1.name);
						if (comparison != 0) return comparison;
						break;
					case ADDRESS_ASCENDING:
						comparison = o1.address.compareTo(o2.address);
						if (comparison != 0) return comparison;
						break;
					case ADDRESS_DESCENDING:
						comparison = o2.address.compareTo(o1.address);
						if (comparison != 0) return comparison;
						break;
				}
			}
			return 0;
		}
	}
}