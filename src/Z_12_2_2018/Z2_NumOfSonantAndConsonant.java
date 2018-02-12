package Z_12_2_2018;

import java.util.Scanner;

public class Z2_NumOfSonantAndConsonant {
	/**
	 * 2. Pretpostavimo da su slova A, E, I, O i U samoglasnici. (Smjela
	 * pretpostavka, znam) Napisati program koji pita korisnika da unese string
	 * te mu ispište broj samoglasnika i suglasnika u datom stringu.
	 */
	public static void main(String[] args) {
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesite nisku");

		String str = unos.nextLine().toUpperCase();
		unos.close();

		int i = 0;
		int sonant = 0;
		int consonant = 0;

		while (i <= str.length() - 1) {

			if (str.charAt(i) == 'A' || str.charAt(i) == 'E'
					|| str.charAt(i) == 'I' || str.charAt(i) == 'O'
					|| str.charAt(i) == 'U') {
				sonant++;
			}

			else if (Character.isWhitespace(str.charAt(i))) {
			} else {
				consonant++;
			}

			i++;
		}
		System.out.print(str + " ima " + sonant + " samoglasnika " + consonant
				+ " suglasnika.");
	}

}
