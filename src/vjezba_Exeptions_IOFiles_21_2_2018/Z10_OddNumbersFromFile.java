package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Z10_OddNumbersFromFile {
	/**
	 * 10. Napisati program koji uèitava neodreðen broj brojeva iz filea te
	 * ispisuje samo neparne brojeve. File možete nasumièpno generisati. Program
	 * može da prima ime filea kao argument a i ne mora. Na vama je.
	 * 
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("numbers.txt");

		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {

			for (int i = 0; i < 10; i++) {
				int number = (int) (Math.random() * 100);
				writer.write(number + " ");
			}
		}

		BufferedReader reader = Files.newBufferedReader(path);
		String line;

		while ((line = reader.readLine()) != null) {

			System.out.println("From numbers: ");
			System.out.println(line);

			System.out.println("Odd numbers are: ");

			String[] parts = line.split(" ");

			for (int i = 0; i < 10; i++) {

				int num = Integer.parseInt(parts[i]);

				if (num % 2 != 0) {
					System.out.print(num + " ");
				}

			}

			System.out.println();
		}

	}

}
