package Z_12_2_2018;

import java.util.Scanner;

public class Z3_LargestCommonDivider {
	/**
	 * 3. Napisati metodu koja prima dva cijela broja kao argumente te vraæa
	 * najveæi zajednièki djelilac za ta dva broja.
	 * 
	 * PRIMJER:
	 * 
	 * Unesite prvi broj: 125 Unesite drugi broj: 2525 Najveæi zajednièki
	 * djelilac za brojeve 125 i 2525 je 25.
	 * */
	public static void main(String[] args) {
		
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesite dva cijela pozitivna broja.");
		System.out.println(" Unesite prvi broj: ");
		int n1 = unos.nextInt();
		
		System.out.println(" Unesite drugi broj: ");
		int n2 = unos.nextInt();
		
		int n;
		unos.close();

		if (n1 < n2) {
			n = n1;
		} else {
			n = n2;
		}
		int lcd= 0;
		int j = 1;
		while (j <= n) {

			if (n1 % j == 0 && n2 % j == 0)
				lcd= j;
			j++;
		}
		System.out.println("Najveæi zajednièki djelilac za brojeve " + n1
				+ " i " + n2 + " je: " + lcd);
	}
}
