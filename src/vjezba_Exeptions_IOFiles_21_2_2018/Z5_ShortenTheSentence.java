package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Z5_ShortenTheSentence {
	/**
	 * 5. Napisati program koji kao argument prima ime filea. Nakon što je
	 * korisnik unio ime filea, program prolazi kroz file te ispisuje reèenice
	 * iz filea po sljedeæim pravilima:
	 * 
	 * a. Ukoliko je dužina reèenice manja od 55 karaktera, ispisati reèenicu
	 * bez ikakvih promjena.
	 *
	 * b. Ukoliko je dužina reèenice veæa od 55 karaktera, promijeniti reèenicu
	 * na sljedeæi naèin: i. Smanjiti dužinu reèenice na 40 karaktera ii. Dodati
	 * string ... <Read More> na kraj reèenice
	 * 
	 * iii. Ispisati promjenjenu reèenicu na konzoli
	 * 
	 * PRIMJER: text.txt:
	 * 
	 * Amy Lawrence was proud and glad, and she tried to make Tom see it in her
	 * face - but he wouldn't look. n/ Tom was tugging at a button-hole and
	 * looking sheepish.
	 * 
	 * konzola:
	 * 
	 * Amy Lawrence was proud and glad, and... <Read More> Tom was tugging at a
	 * button-hole and looking sheepish.
	 * 
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter file name: text.txt");

		Path path = Paths.get(input.nextLine());

		input.close();

		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("Amy Lawrence was proud and glad, and she tried to make Tom see it in her face but he wouldn't look. ");
			writer.newLine();
			writer.write("Tom was tugging at a button-hole and looking sheepish.");
		}

		BufferedReader reader = Files.newBufferedReader(path);
		String line;

		while ((line = reader.readLine()) != null) {

			if (line.length() > 55) {

				for (int i = 0; i < 39; i++) {

					System.out.print(line.charAt(i));
				}
				System.out.println(" ... <Read more>");
			} else {
				System.out.println(line);
			}
		}
		reader.close();
	}

}