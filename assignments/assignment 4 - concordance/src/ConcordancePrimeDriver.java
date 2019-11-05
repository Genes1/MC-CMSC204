
public class ConcordancePrimeDriver {
	static ConcordanceDataStructure c;
	
	public static void main(String[] args) {
		c = new ConcordanceDataStructure(100);
		System.out.println(get4KPrime(333));
	}
	
	
	
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
	
	
}
