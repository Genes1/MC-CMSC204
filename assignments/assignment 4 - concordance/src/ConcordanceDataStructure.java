/**
 * @author Eugene Domrachev 
 * 
 * This is the Concordance Data Structure Class. It is the data structure class that is used with
 * the ConcordanceDataManager class. This is a hash table with buckets. Your hash table with be an 
 * array of linked lists of ConcordanceDataElements. Use the hashcode for an ConcordanceDataElement 
 * to place in the hashtable. Do not enter duplicate words or duplicate line numbers for a word. 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	
	private LinkedList<ConcordanceDataElement>[] hashtable;
	private int size;
	
	/**
	 * There should be two constructors.  The first one takes in an integer which represents the
	 * estimated number of words in the text.  Determine the size of the table by using a loading
	 * factor of 1.5 and a 4K+3 prime.  Example: if you estimated 500 words, 500/1.5 = 333.  
	 * The next 4K+3 prime over 333 is 347.  So the tableSize would be 347.
	 */
	
	public ConcordanceDataStructure(int estimate) {
		size = get4KPrime((int)((double)estimate/1.5));
		hashtable = new LinkedList[size];
		for(int i = 0; i < size; i++) {
			hashtable[i] = new LinkedList<ConcordanceDataElement>();
		}
	}
	
	
	
	/**
	 * The other constructor will take in a String and an int.  The string will be "Testing"
	 * and the int will be the size of the hash table.  This is used only for testing.
	 */
	
	public ConcordanceDataStructure(String string, int num) {
		size = num;
		hashtable = new LinkedList[num];
		for(int i = 0; i < size; i++) {
			hashtable[i] = new LinkedList<ConcordanceDataElement>();
		}
	}

	 
	 
	 
	 
	/**
	 * @return the size of the ConcordanceDataStructure (number of indexes in the array)
	 */
	
	@Override
	public int getTableSize() {
		return size;
	}

	
	
	
	
	/**
	 * Returns an ArrayList of the words at this index 
	 * [0] of the ArrayList holds the first word in the "bucket" 
	 * [1] of the ArrayList holds the next word in the "bucket", etc. This is used for testing
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
	 * Returns an ArrayList of the Linked list of page numbers for each word at this index 
	 * [0] of the ArrayList holds the LinkedList of page numbers for the first word in the "bucket" (index) 
	 * [1] of the ArrayList holds the LinkedList of page numbers for next word in the "bucket", etc. This is used for testing.
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
	 * Use the hashcode of the ConcordanceDataElement to see if it is in the hashtable. 
	 * If the word does not exist in the hashtable - Add the ConcordanceDataElement to the hashtable. 
	 * Put the line number in the linked list If the word already exists in the hashtable 1. 
	 * add the line number to the end of the linked list in the ConcordanceDataElement (if the line number is not currently there).
	 * @param term the word to be added/updated with a line number.
	 * @param lineNum the line number where the word is found
	 */
	@Override
	public void add(String word, int lineNum) {
		
		word = word.toLowerCase();
		int key = word.hashCode() % size;
		if (key < 0) key += size;
		
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
	 * This is a utility method to find the next 4k+3 prime given an integer.
	 * @param The number to which to find the closest prime for
	 * @return The closest 4k+3 prime above the number
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
	 * Display the words in Alphabetical Order followed by a :, followed by the line numbers in numerical order, 
	 * followed by a newline 
	 * here's an example: after: 129, 175 agree: 185 agreed: 37 all: 24, 93, 112, 175, 203 always: 90, 128
	 * @return an ArrayList of Strings. Each string has one word, followed by a :, followed by the line numbers in numerical order, followed by a newline.
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
