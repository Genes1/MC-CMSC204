import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Eugene Domrachev 
 * 
 * This class is the data element class for the ConcordanceDataStructure.
 * It consists of a word (String) and a list of page numbers (LinkedList)
 */

public class ConcordanceDataElement implements Comparable{
	
	String word;
	LinkedList<Integer> occurences;
	
	
	
	/**
	 * Create a new DataElement object with the given word and its first occurrence.
	 * @param word word to be kept track of
	 * @param line first occurrence of the word
	 */
	
	public ConcordanceDataElement(String word, int line) {
		occurences = new LinkedList<Integer>();
		occurences.add(line);
		this.word = word;
	}
	
	
	
	
	/**
	 * Add a line number to the linked list if the number doesn't exist in the list.
	 * @param lineNum line to be added 
	 */
	
	public void addPage(int lineNum) {
		if(!occurences.contains(lineNum)) occurences.add(lineNum);
	}
	
	
	
	
	
	/**
	 * Returns the linked list of integers that represent the line numbers.
	 * @return all line numbers in which the word is contained
	 */
	
	public LinkedList<Integer> getList(){
		return occurences;
	}
	
	
	
	
	
	/**
	 * Return the word portion of the Concordance Data Element.
	 * @return the word which has its occurrences counted
	 */
	
	public String getWord() {
		return word;
	}

	
	
	
	
	
	/**
	 * Returns the hashCode of the word portion. NOTE: may be negative.
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




	@Override
	public int compareTo(Object o) {
		ConcordanceDataElement obj = (ConcordanceDataElement) o;
		return word.compareTo(obj.getWord());
	}





	
	
	
}
