package zadaci_14_2_2018;

import java.util.Scanner;

public class Z5_NumberOfCharactersInString {
	/**
	 * 5. Napisati metodu koja broji slova u stringu. Metoda treba koristiti
	 * sljedeæi header: public static int countLetters(String s). Napisati
	 * program koji pita korisnika da unese neki string te mu vrati koliko taj
	 * string ima slova.
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println(" Enter a string:");
		String str = input.nextLine();
		input.close();

		System.out.println("Number of characters in the string is: "
				+ countLetters(str));
	}

	/** a method counts characters in the string */
	public static int countLetters(String s) {

		int countLetters = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isLetter(ch)) {
				countLetters++;
			}
		}
		return countLetters;
	}
}
