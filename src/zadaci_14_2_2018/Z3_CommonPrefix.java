package zadaci_14_2_2018;

import java.util.Scanner;

public class Z3_CommonPrefix {
	/***
	 * 3. Napisati program koji pita korisnika da unese 2 stringa te ispisuje
	 * najveæi zajednièki prefix za ta dva stringa, ukoliko isti postoji. Na
	 * primjer, ukoliko korisnik unese sljedeæa dva stringa "Dobrodošli u Dubai"
	 * i "Dobrodošli u Vankuver" program treba da ispiše: Najveæi zajednièki
	 * prefix za dva stringa je "Dobrodošli u".
	 * 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println(" Enter first string:");
		String str1 = input.nextLine();

		System.out.println(" Enter second string:");
		String str2 = input.nextLine();

		/*
		 * The value of variable j will be number of characters of the smaller
		 * string, it's will be used as a sentinel value.
		 */
		int j = 0;
		if (str1.length() > str2.length()) {
			j = str2.length();
		} else
			j = str1.length();

		// var prefix is for building a prefix
		StringBuilder prefix = new StringBuilder();

		for (int i = 0; i < j; i++) {
			// if the characters match, they are added to prefix
			if (str2.charAt(i) == str1.charAt(i)) {
				prefix.append(str1.charAt(i));
			} else
				break; // break when reach to the first different character
		}
		input.close();
		if (prefix.length() != 0) {
			System.out
					.println("The largest common prefix for two strings is: \""
							+ prefix + "\"");
		} else
			System.out.println("Two strings doesen't have common prefix.");
	}
}
