package backtrackingAndRecursion;

public class WineProblems {
	public static void main(String args[]) {
		//int[] a= {2,3,5,1,4};
		int n=100;
		int[] a = new int[n];
		for(int i=0; i< n; i++) {
			a[i] = i+1;
		}
		//System.out.println(wineProblemUsingRecursion(a, 0, a.length-1, 1));
		//System.out.println(wineProblemTD(a, 0, a.length-1, new int[a.length][a.length]));
		System.out.println(wineProblemBU(a));
	}
	
	// wine problem using recursion method
	public static int wineProblemUsingRecursion(int[] arr, int si, int ei, int yr) {
		// base case
		if(si==ei) {
			return arr[si] * yr;
		}
		//calls
		int left = wineProblemUsingRecursion(arr, si+1, ei, yr+1) + arr[si] * yr;
		int right = wineProblemUsingRecursion(arr, si, ei-1, yr+1) + arr[ei] *yr;
		
		return Math.max(left, right);
	}
	// this is top down approach because recursion is failed for input greater than 100
	public static int wineProblemTD(int[] arr, int si, int ei,int[][] strg) {
		// we have to calculate year 
		int yr = arr.length-(ei-si +1) +1;
		
		// base case
		
		if(si==ei) {
			return arr[si]*yr;
		}
		
		if(strg[si][ei] != 0) {
			return strg[si][ei];
		}
		
		// number of calls
		int left = wineProblemTD(arr, si+1, ei, strg) + arr[si]*yr;
		int right = wineProblemTD(arr, si, ei-1, strg) + arr[ei]*yr;
		
		int res = Math.max(left, right);
		strg[si][ei] = res; // store the value
		
		return res;
		
	}
	// next approach is Bottom up approach 
	public static int wineProblemBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];
		
		for(int slide = 0 ; slide <= n-1 ; slide++ ) {
			
			for(int si =0; si <= n-slide-1; si++) {
				
				int ei = si+ slide;
				int yr = n-(ei-si +1) +1;
				
				if(si == ei) {
					strg[si][ei] = arr[si] * yr;
				}else {
					int left = strg[si+1][ei] + arr[si]*yr;
					int right = strg[si][ei-1] + arr[ei]*yr;
					
					int res = Math.max(left, right);
					strg[si][ei] = res;
				}
			}
		}
		
		return strg[0][n-1];
		
	}

}
