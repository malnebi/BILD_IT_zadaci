package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Z2_NumberOfLettersInFile {
	/**
	 * Napisati program koji pita korisnika da unese ime filea. Nakon što je
	 * korisnik unio ime filea, program vraæa koliko se puta koje slovo ponovilo
	 * u fileu. Program pravi razliku izmeðu velikih i malih slova – to jeste,
	 * vraæa koliko puta se ponovilo slovo 'a' i koliko se puta ponovilo slovo
	 * 'A'.
	 */
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter file name: text.txt");
		Path path = Paths.get(input.nextLine());
		// Path path = Paths.get("text.txt");

		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String line;

			while ((line = reader.readLine()) != null) {
				for (int i = 65; i < 123; i++) {

					char ch = (char) i;
					int counter = 0;

					for (int j = 0; j < line.length(); j++) {
						if (ch == line.charAt(j)) {
							counter++;
						}

					}
					if (counter != 0) {

						if (i % 10 != 0 || i > 9) {
							System.out.print(ch + " " + counter + "  ");
						} else
							System.out.println(ch + " " + counter + "  ");
					}
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(1);
		}
	}
}