package zadaci_13_2_2018;

import java.util.Scanner;

public class Z2_MinElementInArray {
	/**
	 * 2. Napisati metodu koja nalazi najmanji element u nizu decimalnih
	 * vrijednosti koristeæi se sljedeæim headerom:
	 * 
	 * public static double min(double[ ] array)
	 * 
	 * Napišite potom test program koji pita korisnika da unese deset brojeva te
	 * poziva ovu metodu da vrati najmanji element u nizu.
	 */
	public static void main(String[] args) {
		double[] array = new double[10];

		Scanner input = new Scanner(System.in);
		System.out.println("Enter 10 numbers: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextDouble();
		}
		input.close();
		System.out.println("Najmanji broj u nizu je: "
				+ minElementInArray(array));
	}

	public static double minElementInArray(double[] array) {
		double minNumber = array[0];
		for (int i = 1; i < array.length; i++) {
			if (minNumber > array[i]) {
				minNumber = array[i];
			}
		}
		return minNumber;
	}
}
