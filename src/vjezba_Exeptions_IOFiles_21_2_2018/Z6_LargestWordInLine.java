package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Z6_LargestWordInLine {
	/**
	 * 6. Napisati program koji prima kao argument ime filea. Nakon �to je
	 * program u�itao file, nalazi najdu�u rije� u svakoj liniji teksta te
	 * ispisuje istu korisniku.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("text.txt");

		BufferedReader reader = Files.newBufferedReader(path);
		String line;

		while ((line = reader.readLine()) != null) {

			String[] parts = line.split(" ");

			int wordLength = 0;
			int largestIndex = 0;

			for (int i = 0; i < parts.length; i++) {

				if (wordLength <= parts[i].length()) {

					wordLength = parts[i].length();
					largestIndex = i;

				}

			}
			System.out.println(" Largest word in tex is word: "
					+ parts[largestIndex] + " with "
					+ parts[largestIndex].length() + " characters.");

		}

	}

}
