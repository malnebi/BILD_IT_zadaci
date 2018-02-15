package zadaci_15_02_2018;

import java.util.Scanner;

public class Z5_MinimumRanwayLength {
	/**
	 * * 5. Ako imamo ubrzanje aviona a te brzinu pri kojoj avion uzlije�e v,
	 * mo�emo izra�unati minimalnu du�inu piste potrebne da avion uzleti
	 * koriste�i se sljede�om formulom: du�ina = v * v / 2a. Napisati program
	 * koji pita korisnika da unese v u m/s i a u m/s2 te ispisuje korisniku
	 * minimalnu du�inu piste. (Primjer: ukoliko unesemo 60 za brzinu i 3.5 za
	 * ubrzanje du�ina piste je 514.286)
	 */
	public static void main(String[] args) {
		// kreiranje scannera za unos sa tastature
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite brzinu aviona: ");
		double v = input.nextDouble();
		System.out.println("Unesite ubrzanje aviona: ");
		double a = input.nextDouble();

		input.close();

		// racunanje minimalne duzine piste
		double ranwayLength = (v * v) / (2 * a);
		// ispis poruke korisniku
		System.out.printf(
				"Minimalna duzina piste za uzlijetanje aviona iznosi: %.3f m.",
				ranwayLength);
	}

}
