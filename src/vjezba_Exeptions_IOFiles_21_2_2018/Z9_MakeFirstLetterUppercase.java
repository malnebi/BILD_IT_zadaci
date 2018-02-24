package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Z9_MakeFirstLetterUppercase {
	/**
	 * 9. Napisati program koji èita reèenice iz filea i vraæa svaku rijeè u
	 * reèenicu sa poèetnim velikim slovom. Da li æe program da prima ime filea
	 * kao argument ili ne, na vama je. (Reèenica “Hello world“ u outputu treba
	 * biti pretvorena u “Hello World“)
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("text.txt");

		BufferedReader reader = Files.newBufferedReader(path);
		String line;

		while ((line = reader.readLine()) != null) {
			// separate words with spllit() method
			String[] parts = line.split(" ");

			/**
			 * print first substring (first letter) as uppercase, then add the
			 * rest of the word
			 */
			for (int i = 0; i < parts.length; i++) {

				System.out.print(parts[i].substring(0, 1).toUpperCase()
						+ parts[i].substring(1, parts[i].length()) + " ");

			}
			System.out.println();
		}

	}

}
