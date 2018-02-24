package vjezba_Exeptions_IOFiles_21_2_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Z8_WithoutSpace {
	/**
	 * 8. Napisati program koji prima kao argument ime filea. Nakon što je
	 * program uèitao file, vraæa korisniku sve reèenice iz filea sa razmacima
	 * izmeðu rijeèi uklonjenim.
	 * 
	 * PRIMJER: text.txt:
	 * 
	 * Malo viski, malo koka-kola.
	 * 
	 * konzola:
	 * 
	 * Maloviski,malokoka-kola.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("text.txt");
		
		BufferedReader reader = Files.newBufferedReader(path);
		
		String line;
		
		while((line = reader.readLine()) != null){
			
			String[] parts = line.split(" ");
			
			for(int i = 0; i < parts.length; i++){
				
				System.out.print(parts[i]);
				
			}
			System.out.println();
		}
		
		
	}

}
