package Z_12_2_2018;

import java.util.Scanner;

public class Z5_RepetitionOfANumber {
	/**
	 * * 5. Napisati program koji uèitava niz brojeva, pronalazi najveæi broj te
	 * ispisuje koliko se puta taj broj ponavlja. Pretpostavimo da se unos
	 * brojeva završava sa nulom.
	 */

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Unesite cijele brojeve, 0 prekida unos.");
		int num = 1;
		int max = 0;
		int counter = 1;

		do {
			num = input.nextInt();
			if (num == max) {
				counter++;
			}
			if (num > max) {
				max = num;
			}
		} while (num != 0);

		input.close();

		System.out.println("Najveci broj " + max + " se ponovio " + counter
				+ " puta");

	}

}
