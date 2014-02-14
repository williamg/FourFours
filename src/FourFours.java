
public class FourFours {
	
	private int number = 4;
	
	/* Operations:
	 * 0 = addition
	 * 1 = subtraction
	 * 2 = multiplication
	 * 3 = division
	 * 4 = val'th root
	 * 5 = power of val
	 */
	
	public static int NUM_OPS = 6;
	
	public FourFours () {
		
			for (int i = -100; i < 100; i++) {
				
				System.out.print (i + ": ");
				search (number, 1, i, "");
				System.out.println();
			}
	}
	
	private boolean search (double val, int timesUsed, int objective, String opString) {
		
		if (val == objective && timesUsed == number) {
			System.out.print (opString);
			return true;
		}
		
		if (timesUsed >= number) return false;
		
		for (int i = 0; i < NUM_OPS; i++) {
			
			String temp = opString;
			temp = temp.concat(Integer.toString(i));
			
			double newVal = evaluate(val, i);
			if (search (newVal, timesUsed+1, objective, temp)) return true;
		}
		
		return false;
	}
	
	private double evaluate (double n, int operation) {
		
		if (operation == 0) 
			return n+number;
		
		if (operation == 1)
			return n-number;
		
		if (operation == 2)
			return n*number;
		
		if (operation == 3)
			return n/number;
		
		if (operation == 4) {
			if (n < 0) return Double.NaN;
			return Math.pow(n, 1.0/number);
		}
		
		if (operation == 5)
			return Math.pow(n, number);
		
		return Double.NaN;
	}
	
	public static void main(String[] args) {
		
		new FourFours();
		
	}

}
