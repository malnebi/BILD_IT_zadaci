package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Z3_ReversStringFromFile {
	/**
	 * Napisati program koji pita korisnika da unese neki string. Kada korisnik
	 * unese string, program sprema isti string u file te ispisuje korisniku sve
	 * stringove iz filea naopako.
	 * 
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("obrnuto.txt");

		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		Scanner input = new Scanner(System.in);
		System.out.println("Enter some string: ");

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(input.nextLine());

			input.close();
		}

		BufferedReader reader = Files.newBufferedReader(path);
		String line;

		while ((line = reader.readLine()) != null) {

			for (int i = line.length() - 1; i >= 0; i--) {
				System.out.print(line.charAt(i));
			}

		}
		reader.close();
	}

}
