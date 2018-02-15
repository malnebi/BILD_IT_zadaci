package zadaci_14_2_2018;

import java.util.Scanner;

/**
 * 4. Napisati program koji prima 10 cijelih brojeva te ih ispisuje u obrnutom
 * redosljedu.
 */
public class Z4_ReverseNumbers {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println(" Enter 10 numbers:");
		// user enters numbers in
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
		}
		input.close();

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 1; j < array.length; j++) {
				/*
				 * if the first element is smaller then the next one, they will
				 * switch places
				 */
				if (array[j - 1] < array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		System.out.println("Number in decreasing order: ");
		for (int e : array) {
			System.out.print(e + " ");
		}
	}

}
