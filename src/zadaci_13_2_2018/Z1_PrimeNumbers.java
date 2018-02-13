package zadaci_13_2_2018;

import java.util.Scanner;

public class Z1_PrimeNumbers {
	/**
	 * 1. Napisati metodu koja prima 2 argumenta: poèetni broj i krajnji broj te
	 * printa sve proste brojeve u zadanom rangu. BONUS: metoda može primati i
	 * treæi argument, broj brojeva za isprintati po liniji.
	 * */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter start number: ");
		int startNum = input.nextInt();
		System.out.println("Enter end number: ");
		int endNum = input.nextInt();
		System.out
				.println("Enter number of numbers you want to be printed in one line:");
		int numPerLine = input.nextInt();

		printPrimeNumbers(startNum, endNum, numPerLine);
		input.close();
	}

	public static void printPrimeNumbers(int startNum, int endNum,
			int numPerLine) {

		int num = startNum;
		int counter = 0;
		while (num < endNum) {
			boolean prime = true; 

			for (int div = 2; div <= num / 2; div++) {
				if (num % div == 0) {
					prime = false;
					break;
				}
			}

			if (prime) { 
				counter++;
				if (counter % numPerLine == 0) {
					System.out.println(num);
				} else
					System.out.printf(" %4d ", num);
			}
			num++; 
		}
	}
}