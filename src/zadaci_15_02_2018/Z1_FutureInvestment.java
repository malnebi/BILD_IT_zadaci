package zadaci_15_02_2018;

import java.util.Scanner;

/**
 * 1. Napisati program koji uèitava iznos investicije, godišnju interesnu stopu
 * i broj godina te vraæa buduæu vrijednost investicije koristeæi se sljedeæom
 * formulom: buducaVrijednostInvesticije = iznosInvesticije * (1 +
 * mjesecnaInteresnaStopa)^brojGodina*12. Na primjer, ukoliko uneste kao iznos
 * investicije 1000, 3.25 kao godišnju interesnu stopu i 1 kao broj godina
 * program vam vraæa 1032.98 kao buducu vrijednost investicije.
 * 
 */
public class Z1_FutureInvestment {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter value of investment: ");
		double investmentValue = input.nextDouble();
		System.out.println("Enter year interest rate: ");
		double yearInterestRate = input.nextDouble();
		System.out
				.println("Enter number of years for future investment: ");
		int numberOfYears = input.nextInt();

		input.close();

		System.out.printf(
				"Value of your future investment is: %.2f",
				futureInvestmentValue(investmentValue, yearInterestRate,
						numberOfYears));

	}

	public static double futureInvestmentValue(double investmentValue,
			double yearIterestRate, int numberOfYears) {
		double monthInterestRate = yearIterestRate / (12 * 100);

		return Math.pow((1 + monthInterestRate), numberOfYears * 12)
				* investmentValue;
	}
}
