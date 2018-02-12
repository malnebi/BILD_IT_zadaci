package Z_12_2_2018;

import java.util.ArrayList;

public class Z1_MaxValue {
	/**
	 * 1. Napisati sljedeæu metodu koja vraæa najveæu vrijednosti u ArrayListu
	 * Integera. Metoda vraæa null ukoliko je lista null iil ukoliko lista
	 * sadrži 0 elemenata. public static Integer max(ArrayList<Integer> list)
	 * 
	 * 4. Napišite program koji generiše 100 nasumiènih cijelih brojeva izmeðu 0
	 * i 9 te ispisuje koliko se puta koji broj ponovio.
	 * 
	 * 5. Napisati program koji uèitava niz brojeva, pronalazi najveæi broj te
	 * ispisuje koliko se puta taj broj ponavlja. Pretpostavimo da se unos
	 * brojeva završava sa nulom.
	 */
	public static void main(String[] args) {
		// kreiranje liste
		ArrayList<Integer> list = new ArrayList<Integer>();
		// dodavanje elemenata u istu
		list.add(1);
		list.add(20);
		list.add(11);
		list.add(4);
		list.add(25);
		// ispis rezultata
		System.out.print("Najveca vrijednost je: " + max(list));

	}

	/** metoda koja vraca vrijednost najveceg broja **/
	public static Integer max(ArrayList<Integer> list) {
		// pocetna vrijednost varijable maxim
		Integer maxim = list.get(0);

		if (list.isEmpty()) {
			return null;
		} else {
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i - 1) < list.get(i)) {
					maxim = list.get(i);
				}
			}
		}
		return maxim;
	}

}
