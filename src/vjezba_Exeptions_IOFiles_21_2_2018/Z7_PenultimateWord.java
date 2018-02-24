package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Z7_PenultimateWord {
	/**
	 * 7. Napisati program koji prima kao argument ime fiela. Nakon što je
	 * program uèitao file, nalazi predzadnju rijeè na svakoj liniji teksta te
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

			System.out.println(" " + parts[parts.length - 2]);

		}

	}

}
