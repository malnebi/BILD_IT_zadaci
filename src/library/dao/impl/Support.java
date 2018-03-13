package library.dao.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Support {

	/**
	 * Method checks inputs for first and last number
	 * 
	 * @return returns selected int
	 */
	public static int checkInputInt(int from, int to, Scanner inputScan) {

		int selected = 0;
		boolean error = true;
		Scanner input = inputScan;
		do {
			try {
				System.out.println(" Select number in range between " + from
						+ " - " + to);
				selected = input.nextInt();

				if (selected >= from && selected <= to) {
					error = false;
				} else {
					System.out.println("Out  of range! Try again");
				}

			} catch (InputMismatchException e) {
				System.out.println("You must enter integer type value between "
						+ from + " - " + to);
				input.nextLine();
			}

		} while (error);
		return selected;
	}

	public static String getCurrentDate() {

		SimpleDateFormat datum = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = datum.format(new Date(System.currentTimeMillis()));

		return date;
	}
}
