/**
 * @author Eugene Domrachev 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ConcordanceDataManager implements ConcordanceDataManagerInterface {


	
	@Override
	public ArrayList<String> createConcordanceArray(String input) {
		
		ConcordanceDataStructure struct = new ConcordanceDataStructure(250);
		String[] text = input.split("\n");
		int lineNum = 1;
		
		for(String i : text) {
			
			String[] line = i.split("[^a-zA-Z0-9']+");
			//String[] line = i.split("\\W+");
			for(String word : line) {
				word.replaceAll("[^a-zA-Z]", "");
				if(!word.equals("the") && !word.equals("and") && word.length() > 2) {
					struct.add(word, lineNum);
				}
			}
			lineNum++;
		}
		
		return struct.showAll();
		
	}

	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		
		try {
			
			String content = "";
			Scanner scanner = new Scanner(input);
			
			while(scanner.hasNextLine()){
			    content += scanner.nextLine() + "\n";
			    //System.out.println(content);
			}

			
			PrintWriter printOut = new PrintWriter(output);
			
			
			ArrayList<String> conc = createConcordanceArray(content);
			for(String line : conc) {
				printOut.print(line);
			}
			
			scanner.close();
			printOut.close();
			return true;
			
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} 
		
	}
	


}
