package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Z4_ReversWordsFromFile {
	/**
	 * 4. Napisati program koji kao argument prima ime filea. U fileu – jedna
	 * linija, jedna reèenica. Ispisati sve reèenice iz filea u obrnutom
	 * redosljedu rijeèi. (Npr. ukoliko je prva reèenica u fileu “Hello World“
	 * program treba da ispiše “World Hello“)
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("reverse.txt");

		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(" Single one sentence");
		}
		
		BufferedReader reader = Files.newBufferedReader(path);
		String line;

		while ((line = reader.readLine()) != null) {

			String[] parts = line.split(" ");

			for (int i = parts.length - 1; i > 0; i--) {
				System.out.print(" "+parts[i]);
			}
		}

	}

}
