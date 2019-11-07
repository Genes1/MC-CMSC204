import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Eugene Domrachev 
 * 
 * This class creates a concordance via the ConcordanceDataElement and ConcordanceDataStructure classes.
 */

public class ConcordanceDataManager implements ConcordanceDataManagerInterface {

	
	
	/**
	 * Create and return a concordance of the string input. New lines are parsed by \n.
	 * @param input text to be made into a concordance
	 * @return the concordance 
	 */
	
	@Override
	public ArrayList<String> createConcordanceArray(String input) {
		
		ConcordanceDataStructure struct = new ConcordanceDataStructure(250);
		String[] text = input.split("\n");
		int lineNum = 1;
		
		for(String i : text) {
			
			// Split each line into
			String[] line = i.split("[^a-zA-Z0-9']+");
			
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

	
	
	
	
	/**
	 * Create a concordance of the file input and write it into the output file.  
	 * @param input text file to be made into a concordance
	 * @return true if the creation was successful, false if not 
	 * @throws FileNotFoundException 
	 */
	
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
			
		} catch (IOException e) {
			throw new FileNotFoundException();
		} 
		
	}
	


}
