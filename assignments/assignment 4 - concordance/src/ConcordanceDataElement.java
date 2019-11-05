import java.util.Collections;
import java.util.LinkedList;

/***
 * @author Eugene Domrachev 
 * This class is the data element class for the ConcordanceDataStructure.
 * It consists of a word (String) and a list of page numbers (LinkedList)
 */

public class ConcordanceDataElement {
	
	String word;
	LinkedList<Integer> occurences;
	
	
	
	/**
	 * TODO
	 */
	
	public ConcordanceDataElement(String word, int line) {
		occurences = new LinkedList<Integer>();
		occurences.add(line);
		this.word = word;
	}
	
	
	
	
	/**
	 * Add a line number to the linked list if the number doesn't exist in the list
	 */
	
	public void addPage(int lineNum) {
		if(!occurences.contains(lineNum)) occurences.add(lineNum);
	}
	
	
	
	
	
	/**
	 * Returns the linked list of integers that represent the line numbers 
	 */
	
	public LinkedList<Integer> getList(){
		return occurences;
	}
	
	
	
	
	
	/**
	 * Return the word portion of the Concordance Data Element
	 */
	
	public String getWord() {
		return word;
	}
	
	
	
	
	
	/**
	 * TODO what is this used for?
	 */
	
	public int compareTo(ConcordanceDataElement arg0) {
		return 0;
		
	}
	
	
	
	
	
	/**
	 * Returns the hashCode.
	 */
	
	public int hashCode() {
		return word.hashCode();
	}
	
	
	
	
	
	/**
	 * Returns the word followed by page numbers Returns a string in the following format: 
	 * word: page num, page num 
	 * Example: after: 2,8,15 \n
	 */
	
	public String toString() {
		
		String s = "";
		Collections.sort(occurences);
		
		for(Integer i : getList()) {
			s += i.toString() + ", ";
		}
		
		if(getList() != null) {
			s = s.substring(0, s.length()-2);
		}
		
		
		return word + ": " + s + "\n";
	}
	
	
	
}
