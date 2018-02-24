package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Z2 {
	/**
	 * Napisati program koji pita korisnika da unese ime filea. Nakon što je
	 * korisnik unio ime filea, program vraæa koliko se puta koje slovo ponovilo
	 * u fileu. Program pravi razliku izmeðu velikih i malih slova – to jeste,
	 * vraæa koliko puta se ponovilo slovo 'a' i koliko se puta ponovilo slovo
	 * 'A'.
	 */
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		try {
			System.out
					.println("Enter file name with a path (exp. c:/files/file.txt)");
			// Path file1 = Paths.get(input.nextLine());
			Path file1 = Paths.get("neki_text.txt");

			BufferedReader reader = Files.newBufferedReader(file1);
			String line;

			while ((line = reader.readLine()) != null) {
				
				ArrayList<String> letters = new ArrayList<String>();

				int counter = 0;
				char ch = 0;
				for (int i = 65; i < 123; i++) {
					 ch = (char) i;

					for (int j = 0; j < line.length(); j++) {
						if ((char) i == line.charAt(j)) {
							counter++;
						}
					
					}
					
				}
				if(counter != 0)
				System.out.println(ch + " " + counter);
			}

		} catch (FileNotFoundException e) {
			System.out
					.println("File don't exists. Please enter new name for a file.");
		}

	}

}