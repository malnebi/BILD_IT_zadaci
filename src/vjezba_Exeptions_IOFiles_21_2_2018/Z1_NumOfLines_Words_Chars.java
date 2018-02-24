package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Z1_NumOfLines_Words_Chars {
	/*
	 * Napisati program koji kao argument prima ime filea te: a. vraæa broj
	 * karaktera u datom fileu b. vraæa broj rijeèi u datom fileu c. vraæa broj
	 * linija teksta u datom fileu Rijeci su razdvojene jednim spaceom.
	 */

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("neki_text.txt");

		BufferedReader reader = Files.newBufferedReader(path);
		String line;

		int lines = 0;
		int words = 0;
		int chars = 0;

		System.out.println("");

		while ((line = reader.readLine()) != null) {
			lines++;

			// count words
			String[] parts = line.split(" ");
			for (String w : parts) {
				words++;
				// count characters
				for (int i = 0; i < parts[0].length(); i++) {
					chars++;
				}
			}
			System.out.println(lines + " " + line);
		}
		reader.close();

		System.out.println(" ");
		System.out.println("Lines : " + lines);
		System.out.println("Words : " + words);
		System.out.println("Characters : " + chars);

	}

}
