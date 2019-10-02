/**
 * 
 * @author revised by Eugene Domrachev
 * 
 * The deliverable of the Office Depot which holds an item to be delivered.
 *
 */

public class DonationPackage {

	String description;
	Double weight;
	
	public DonationPackage(String pDesc, double pWeight) {
		description = pDesc;
		weight = pWeight;
	}


	/**
	 * Checks if the package is too heavy to be delivered.
	 * @return true if the weight is more than 20
	 */
	public boolean isHeavy() {
		return weight > 20;
	}

	
	public String toString() {
		return description;
	}

}
