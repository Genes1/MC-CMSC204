/**
 * 
 * @author Eugene Domrachev
 * 
 * The container of a theoretical Office Depot which holds and manages packages to be delivered.
 *
 */

public class Container implements ContainerInterface {

	
	private MyStack<DonationPackage> packages;
	
	/**
	 * Provide two constructors:
	 * Container() make the internal stack a default size
	 * Container(int size) make the internal stack this size
	 */
	
	Container(){
		packages = new MyStack<DonationPackage>(5);
	}
	
	Container(int n){
		packages = new MyStack<DonationPackage>(n);
	}
	
	
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throw ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		
		if(!packages.push(dPackage)) { 
			throw new ContainerException("The Container is Full");
		}
		return true;
		
	}

	
	
	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throw ContainerException("The Container is Empty") if there is no package in the container
	 */
	
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if(packages.isEmpty()) throw new ContainerException("The Container is Empty");
		return packages.pop();
	}

	
	
	/**
	 * Returns an array of the DonationPackage in the stack
	 * @return an array of the DonationPackage in the stack
	 */
	
	@Override
	public DonationPackage[] toArrayPackage() {
		
		//was return packages.toArray()
		Object[] t = packages.toArray();
		DonationPackage[] temp = new DonationPackage[t.length];
		for(int i= 0 ; i< t.length; i++)
			temp[i] = (DonationPackage) t[i];
		
		return temp;
	
	}
	
	
	
	/**
	 * Returns the stack of DonationPackages in the container.
	 * @return packages - DonationPackages in the stack
	 */
	
	public MyStack<DonationPackage> getStack() {
		return packages;
	}
	
		
}
