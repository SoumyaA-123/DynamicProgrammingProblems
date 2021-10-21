package backtrackingAndRecursion;

public class NthFibonacciNumber {

	public static void main(String[] args) {
		System.out.println("nth fibo number");
		int n=200;
		System.out.println(fiboBU(1000000));
		System.out.println(nthFiboTD(100, new double[n+1]));
		System.out.println(nthFiboTDINT(100, new int[n+1]));
		
		//System.out.println(nthFibo(n));
	}
	
	public static int nthFibo(int n) {
		// base case 
		if(n==0 || n==1) {
			return n;
		}
		
		// two calls made 
		int fn1 = nthFibo(n-1);
		int fn2 = nthFibo(n-2);
		
		// this will return final result
		return fn1+fn2;
	}
	
	// top down dp problem
	public static double nthFiboTD(int n, double[] strg) {
		// base case 
		if(n==0 || n==1) {
			return n;
		}
		
		// check weather nth value is present in table if yes return 
		if(strg[n] !=0) {
			return strg[n];
		}
		// two calls made 
		double fn1 = nthFiboTD(n-1, strg);
		double fn2 = nthFiboTD(n-2, strg);
		// store the computed result
		strg[n] = fn1+fn2;
		
		// this will return final result
		return fn1+fn2;
	}
	
	// top down dp problem
		public static int nthFiboTDINT(int n, int[] strg) {
			// base case 
			if(n==0 || n==1) {
				return n;
			}
			
			// check weather nth value is present in table if yes return 
			if(strg[n] !=0) {
				return strg[n];
			}
			// two calls made 
			int fn1 = nthFiboTDINT(n-1, strg);
			int fn2 = nthFiboTDINT(n-2, strg);
			// store the computed result
			strg[n] = fn1+fn2;
			
			// this will return final result
			return fn1+fn2;
		}
	//BU approach to implement fibbonacci where we create strg array with previously fill values
		public static int fiboBU(int n) {
			int[] strg= new int[n+1];
			strg[0]=0;
			strg[1]=1;
			for(int i=2; i<strg.length ; i++) {
				strg[i] = strg[i-1]+strg[i-2];
			}
			
			return strg[n];
		}
	

}
