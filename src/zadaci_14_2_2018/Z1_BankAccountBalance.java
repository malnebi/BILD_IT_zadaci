package zadaci_14_2_2018;

import java.util.Scanner;

public class Z1_BankAccountBalance {
	/**
	 * 1. Pretpostavimo da uplatimo $100 svaki mjesec na �tedni ra�un koji ima
	 * godi�nju interesnu stopu od 5%. Mjese�na interesna stopa je stoga 0.05 /
	 * 12 = 0.00417. Nakon prvog mjeseca vrijednost na ra�unu postaje 100 * (1 +
	 * 0.00417) = 100.417. Nakon drugog mjeseca, vrijednost na ra�unu postaje
	 * (100 + 100.417) * (1 + 0.00417) = 201.252. Nakon tre�eg mjeseca,
	 * vrijednost na ra�unu postaje (100 + 201.252) * (1 + 0.00417) = 302.507 i
	 * tako dalje. Napisati program koji pita korisnika da unese mjese�ni iznos
	 * �tednje te broj mjeseci nakon kojeg bi �elio znati stanje ra�una.
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println(" Unesite mjesecni iznos stednje:");
		double monthAmount = input.nextInt();
		System.out
				.println("Unesite broj mjeseci nakon kojih zelite da znate stanje na Vasem racunu:");
		int numOfMonths = input.nextInt();
		input.close();

		// godisnja kamatna stopa
		double yearInterestRate = 5;
		// mjesecna kamatna stopa, dobijena na osnovu godisnje
		double monthInterestRate = (yearInterestRate / 100) / 12;
		// suma na racunu, pocetna je 0
		double accountAmount = 0;
		// petlja za izracunavanje sume, izvrsava se onoliko puta koliko je
		// navedeno mjeseci
		for (int i = 0; i < numOfMonths; i++) {
			accountAmount = (monthAmount + accountAmount)
					* (1 + monthInterestRate);
		}
		System.out.printf(
				"Stanje na racunu nakon %d. mjeseca iznosice %5.3fKM.",
				numOfMonths, accountAmount);
	}
}
