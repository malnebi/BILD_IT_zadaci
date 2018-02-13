package zadaci_13_2_2018;

import java.util.Scanner;

public class Z3_IdenticalArrays {
	/***
	 * 3. Nizovi niz1 i niz2 su striktno identièni ukoliko su svi njihovi
	 * elementi na istim pozicijama jednaki. Napisati metodu koja vraæa true
	 * ukoliko su nizovi niz1 i niz2 striktno identièni. Koristiti sljedeæi
	 * header:
	 * 
	 * public static boolean equals(int[ ] niz1, int[ ] niz2)
	 * 
	 * Napisati testni program koji pita korisnika da unese dva niza cijelih
	 * brojeva te provjerava da li su striktno identièni.
	 * 
	 */
	public static void main(String[] args) {
		// inicijalizacija niza
		int[] array1 = new int[10];
		int[] array2 = new int[10];
		// kreiranje Scannera
		Scanner input = new Scanner(System.in);
		// poruka korisniku
		System.out.println("Unesite elemente prvog niza:");
		// popunjavanje prvog niza vrijednostima koje korisnik unosi sa
		// tastature
		for (int i = 0; i < array1.length; i++) {
			array1[i] = input.nextInt();
		}

		System.out.println("Unesite elemente drugog niza:");
		// popunjavanje drugog niza
		for (int i = 0; i < array2.length; i++) {
			array2[i] = input.nextInt();
		}
		// zatvaranje Scannera
		input.close();
		// ispis rezultata testiranja jednakosti elemenata niza
		System.out.println("Dva niza "
				+ (equals(array1, array2) == true ? "su " : "nisu ")
				+ "striktno identicna.");
	}

	/** metoda vraca true ako je niz identican, false ako nije */
	public static boolean equals(int[] niz1, int[] niz2) {
		// brojac
		int counter = 0;
		for (int i = 0; i < niz2.length; i++) {
			if (niz1[i] == niz2[i])
				counter++;
		}
		// metoda vraca true ukoliko brojac izbroji svih 10 jednakih elemenata
		if (counter == 10)
			return true;
		else
			return false;
	}
}