/**
 * Class to represent a town, the node of the graph.
 * @author Eugene Domrachev
 */

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Town implements Comparable<Town>{
	
	
	
	String name;
	LinkedHashSet<Town> adjacentTowns;
	
	Town(Town template){
		name = template.getName();
		adjacentTowns = template.adjacentTowns;
	}

	Town(String name){
		this.name = name;
		adjacentTowns = new LinkedHashSet<Town>();
	}
	
	
	
	
	
	/**
	 * Returns the town's name
	 * @return town's name
	 */
	
	public String getName() { return name; }

	


	
	/**
	 * Returns the town's name
	 * @return town's name
	 */
	
	public LinkedHashSet getAdjacentSet() { return adjacentTowns; }
	
	
	
	
	
	/**
	 * Compare to method
	 * @return town's name
	 */
	
	@Override
	public int compareTo(Town o) { return name.compareTo(o.getName()); }
	
	
	
	
	/**
	 * Equivalency check
	 * @return true if the town names are equal, false if not
	 */
	
	public boolean equals(Object o) { 
		
		if (!(o instanceof Town)) {
			return false;
		}
		
		return (this.compareTo((Town) o) == 0) ? true : false; 
	
	}
	
	
	
	
	/**
	 * Hash code of town
	 * @return the hashcode for the name of the town
	 */
	
	public int hashCode() { return name.hashCode(); }
	
	
	
	
	/**
	 * To string method
	 * @return the town name
	 */
	
	public String toString() { return name; }

	
	
}
