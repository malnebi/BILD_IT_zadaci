package zadaci_13_2_2018;

import java.util.Scanner;

public class Z4_LocateLArgestArrayElements {
	/**
	 * * 4. Napisati metodu koja vraæa lokaciju najveæeg elementa u 2D nizu.
	 * Metoda treba da koristi sljedeæi header:
	 * 
	 * public static int[ ] locateLargest(double[ ][ ] a)
	 * 
	 * Napisati test program koji pita korisnika da unese 2D niz te mu ispisuje
	 * lokaciju najveæeg elementa u nizu.
	 * 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite broj kolona i redova matrice");
		int numOfRows = input.nextInt();
		int numOfCol = input.nextInt();
		// kreiranje matrice
		double[][] mat = new double[numOfRows][numOfCol];
		System.out.println("Unesite elemente matrice: ");
		// popunjavanje matrice vrijednostima koje korisnik unosi sa tastature
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = input.nextDouble();
			}
		}

		// kreiranje novog niza, pozivanje metode koja vraca vrijednost indeksa
		// najvecg el
		int[] larg = locateLargest(mat);
		// zatvaranje Scannera
		input.close();

		System.out.println("NAjveci element je na (" + larg[0] + ", " + larg[1]
				+ ")");
	}

	/**
	 * metoda vraca vrijednost u obliku niza sa dva elementa, koji predstavljaju
	 * indekse najveceg elementa matrice
	 * */
	public static int[] locateLargest(double[][] a) {
		int[] arrayLargest = new int[2];
		double largest = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (largest < a[i][j]) {
					largest = a[i][j];
					arrayLargest[0] = i;
					arrayLargest[1] = j;
				}
			}
		}
		return arrayLargest;
	}
}