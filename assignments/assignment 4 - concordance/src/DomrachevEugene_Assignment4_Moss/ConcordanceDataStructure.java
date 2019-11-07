import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


/**
 * @author Eugene Domrachev 
 * 
 * This is the Concordance Data Structure Class. It is the data structure class that is used with
 * the ConcordanceDataManager class. This is a hash table with buckets. Your hash table with be an 
 * array of linked lists of ConcordanceDataElements. Use the hashcode for an ConcordanceDataElement 
 * to place in the hashtable. Do not enter duplicate words or duplicate line numbers for a word. 
 */


public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	
	
	
	private LinkedList<ConcordanceDataElement>[] hashtable;
	private int size;
	
	
	
	/**
	 * <i> There should be two constructors.  The first one takes in an integer which represents the
	 * estimated number of words in the text.  Determine the size of the table by using a loading
	 * factor of 1.5 and a 4K+3 prime.  Example: if you estimated 500 words, 500/1.5 = 333.  
	 * The next 4K+3 prime over 333 is 347.  So the tableSize would be 347. </i>
	 * @param estimate an estimated amount of words to be stored in the concordance
	 */
	
	public ConcordanceDataStructure(int estimate) {
		size = get4KPrime((int)((double)estimate/1.5));
		hashtable = new LinkedList[size];
		for(int i = 0; i < size; i++) {
			hashtable[i] = new LinkedList<ConcordanceDataElement>();
		}
	}
	
	
	
	/** 
	 * <i>The other constructor will take in a String and an int.  The string will be "Testing"
	 * and the int will be the size of the hash table.  This is used only for testing.</i>
	 * @param test string to be passed as "Testing"
	 * @param the size the testing hashtable should have
	 */
	
	public ConcordanceDataStructure(String test, int num) {
		
		size = num;
		hashtable = new LinkedList[num];
		
		for(int i = 0; i < size; i++) {
			hashtable[i] = new LinkedList<ConcordanceDataElement>();
		}
		
		
	}

	 
	 
	 
	 
	/**
	 * Get the size of the hashtable.
	 * @return the size of the ConcordanceDataStructure (number of indexes in the array)
	 */
	
	@Override
	public int getTableSize() {
		return size;
	}

	
	
	
	
	/**
	 * Return an ArrayList of the words at a particular index in the hashtable.
	 * @param index location within the hash table
	 * @return an Arraylist of the words at this index
	 */
	
	@Override
	public ArrayList<String> getWords(int index) {
		
		ArrayList<String> ret = new ArrayList<String>();
		
		for(ConcordanceDataElement d : hashtable[index]) {
			ret.add(d.getWord());
		}
		
		return ret;
		
		
	}

	
	
	
	
	/**
	 * Return an ArrayList of the Linked list of page numbers for each word at this index. This is used for testing only.
	 * @param index location within the hash table
	 * @return an ArrayList of the Linked list of page numbers for each word at this index
	 */
	
	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
		
		ArrayList<LinkedList<Integer>> ret = new ArrayList<LinkedList<Integer>>();
		
		for(ConcordanceDataElement d : hashtable[index]) {
			ret.add(d.getList());
		}
		
		return ret;
		
		
	}

	
	
	
	
	/**
	 * Add an occurence of a word to the hashtable via bucket hashing.
	 * @param word the word to be added/updated with a line number.
	 * @param lineNum the line number where the word is found
	 */
	
	@Override
	public void add(String word, int lineNum) {
		
		word = word.toLowerCase();
		int key = word.hashCode() % size;
		if (key < 0) key += size; // If this line is removed, an ArrayIndexOutOfBounds exception may occur due to the integer overflow of some hashcodes
		
		//System.out.println(word + " -> " + key + " = " + word.hashCode() + " % " + size);
		if(getWords(key).contains(word)) {
			for(ConcordanceDataElement d : hashtable[key]) {
				if(word.equals(d.getWord())) {
					d.addPage(lineNum);
					return;
				}
			}
		} else {
			hashtable[key].add(new ConcordanceDataElement(word, lineNum));
		}

		
		
	}

	
	
	
	
	/**
	 * Utility method to find the next 4k+3 prime given an integer.
	 * @param num the number to which to find the closest prime for
	 * @return the closest 4k+3 prime above the number
	 */
	
	public static int get4KPrime(int num) {
		
		int nextPrime = num;
		boolean primeFound = false;
		
		
		if(nextPrime % 2 == 0) {
			nextPrime++;
		}
		
		while(!primeFound) {
			
			primeFound = true;
			
			for(int i = 2; i <= Math.sqrt(nextPrime); i++) {
				if(nextPrime % i == 0) {
					primeFound = false;
					break;
				}
			}
			
			if(nextPrime % 4 != 3) {
				primeFound = false;
			}
			
			if(!primeFound) {
				nextPrime += 2;
			} else {
				break;
				
			}
			

			
		}
		
		
		return nextPrime;
		
		
				
	}
	
	
	
	
	
	/**
	 * Display the words in Alphabetical Order followed by a :, followed by the line numbers in numerical order, followed by a newline. 
	 * example: 
	 * after: 129, 175 
	 * agree: 185 
	 * agreed: 37 all: 24, 93, 112, 175, 203 
	 * always: 90, 128
	 * @return the contents of the hashtable
	 */
	
	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> displayList = new ArrayList<String>();
		
		
		 for(LinkedList<ConcordanceDataElement> l : hashtable){
			 for(ConcordanceDataElement d : l) {
				 displayList.add(d.toString());
			 }
		 }
		 
		 Collections.sort(displayList);
		 
		return displayList;
	}
	
	
	
	

}
