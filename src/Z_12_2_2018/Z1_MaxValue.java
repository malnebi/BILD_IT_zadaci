package Z_12_2_2018;

import java.util.ArrayList;

public class Z1_MaxValue {
	/**
	 * 1. Napisati sljedeæu metodu koja vraæa najveæu vrijednosti u ArrayListu
	 * Integera. Metoda vraæa null ukoliko je lista null iil ukoliko lista
	 * sadrži 0 elemenata. public static Integer max(ArrayList<Integer> list)
	 */
	public static void main(String[] args) {

		// create a list, add elements and invoke a method
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(20);
		list.add(11);
		list.add(4);
		list.add(25);
		System.out.println("Max value of list is " + max(list));

		// create an empty list and invoke a method
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		System.out.println("The list2 is empty, and it's " + max(list2));
	}

	/** the method returns largest number **/
	public static Integer max(ArrayList<Integer> list) {
		// check if list is empty
		if (list.size() == 0) {
			return null;
		}

		// get first element from the list
		Integer largest = list.get(0);
		// search for largest element from the list using loop
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) < list.get(i)) {
				largest = list.get(i);
			}
		}
		return largest;
	}

}
