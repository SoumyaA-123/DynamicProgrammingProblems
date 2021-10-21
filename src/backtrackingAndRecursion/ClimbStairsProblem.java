package backtrackingAndRecursion;

public class ClimbStairsProblem {
	public static void main(String args[]) {
//		System.out.println("Number of ways to climb stairscase we consider 3 types 1 step at a time 2 step at a time and 3 step at a time");
//		long start=System.currentTimeMillis();
//		climbStairs(8, 0, "");
//		long end=System.currentTimeMillis();
//		System.out.println("time taken to run this problem is "+ (end-start)+"sec");
//		
//		System.out.println("when number of jumps is variable");
//		long start1=System.currentTimeMillis();
//		climbStairsWithManyJumps(8, 0, "");
//		long end1=System.currentTimeMillis();
//		System.out.println("time taken to run this problem is "+ (end1-start1)+"sec");
//		System.out.println();
//		long start2=System.currentTimeMillis();
//		System.out.println(climbStairsWaysDP(50, 0));
//		long end2=System.currentTimeMillis();
//		System.out.println("time taken to run this problem is "+ (end2-start2)+"sec");
//		
		int n=500;
		System.out.println(climbStairsWaysTD(n, 0, new int[n]));
		System.out.println(climbStairsWaysBU(n));
		
	}
	public static void climbStairs(int n, int curr, String Ans) {
		// in this problem there is two base cases positive and negative
		//this one positive base case when we reach to our aim or we reach to end of stair case n== curr
		if(n==curr) {
			System.out.println(Ans);
			return;
		}
		// second base case is negative base case when curr value exceed the nth value or number of stairs 
		// in this case we don't need to print anything just return back to previous state
		if(curr > n) {
			return;
		}
		climbStairs(n, curr+1, Ans+"1");
		climbStairs(n, curr+2, Ans+"2");
		climbStairs(n, curr+3, Ans+"3");
	}
	public static void climbStairsWithManyJumps(int n, int curr, String Ans) {
		// int this case j is jumps possible 

		//positive base case
		if(n==curr) {
			System.out.println(Ans);
			return;
		}
		//negative base case
		if(curr > n) {
			return;
		}
		for(int i=1; i<= n;i++) {
			climbStairsWithManyJumps(n, curr+i, Ans+i);
		}
	}
	public static int climbStairsWaysDP(int n, int curr) {
	 if(n == curr) {
		 return 1;
	 }
	 if(curr > n) {
		 return 0;
	 }
	 int o1 = climbStairsWaysDP(n, curr+1);
	 int o2 = climbStairsWaysDP(n, curr+2);
	 int o3 = climbStairsWaysDP(n, curr+3);
	 
	 return o1+o2+o3;
	}
	public static int climbStairsWaysTD(int n, int curr, int[] strg) {

		 if(n == curr) {
			 return 1;
		 }
		 if(curr > n) {
			 return 0;
		 }
		 if(strg[curr] != 0) { // re-use
			 return strg[curr];
		 }
		 // calls
		 int o1 = climbStairsWaysTD(n, curr+1,strg);
		 int o2 = climbStairsWaysTD(n, curr+2,strg);
		 int o3 = climbStairsWaysTD(n, curr+3,strg);
		 
		 strg[curr]=o1+o2+o3; // store
		 
		 return o1+o2+o3;
		}
	public static int climbStairsWaysBU(int n) {
		int[] strg = new int[n+3]; // this is strg array which will store all possible ways overlapping subproblems
		strg[n]=1; // we will storing the intial value which help to compute the other results
		// in BU approach we will use iterative way to find the no of ways 
		for(int i = n-1; i >= 0; i--) {
			strg[i] = strg[i+1] + strg[i+2] + strg[i+3];
		}
		return strg[0]; // we will return start index because we are storing count of no of ways for each step in strg array
	}

}
