package backtrackingAndRecursion;

public class WildCardPatternMatchingProblem {
	
	public static void main(String[] args) {
		String src = "aahgjkjhksjkjhgfjhgjhkjshkshhff";
		String pat = "a****?***********************************************f";
		System.out.println(wildCardPatternMatchingRecursionBU(src, pat));
		//System.out.println(wildCardPatternMatchingRecursionTD(src, pat, 0, 0, new int[src.length()][pat.length()]));
		//System.out.println(wildCardPatternMatchingRecursion(src, pat));
	}
	
	public static boolean wildCardPatternMatchingRecursion(String src, String pat) {
		// order of code is also matter
		// first write base case 
		
		// base case where to stop recursion
		// this case when length of src and pat is zero
		if(src.length() == 0 && pat.length() == 0) {
			return true;
		}
		// when length of pat is zero and src not in that case it also false
		if(src.length() != 0 && pat.length() ==0 ) {
			return false;
		}
		// when length of src is zero but there is only * in pattern in that case it is true
		if(src.length() == 0 && pat.length() != 0) {
			// this is the negative base case which handle the * pattern 
			for(int i=0 ; i < pat.length() ; i++) {
				if(pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		
		// then write all variable and constants changing
		char chs = src.charAt(0);
		char chp = pat.charAt(0);
		
		String ros = src.substring(1);
		String rop = pat.substring(1);
		
		boolean res;
		
		// then write your recursive calls
		if(chs == chp || chp == '?') {
			// this call is whem first character of src is matched with pat
			res = wildCardPatternMatchingRecursion(ros, rop);
		}else if(chp == '*') {
			// this calls for * when we encounter * char in pattern it leads to two call
			// one for blank and another one is for multiple characters
			
			boolean blank = wildCardPatternMatchingRecursion(src, rop);
			boolean multiple = wildCardPatternMatchingRecursion(ros, pat);
			res = blank || multiple;
		}else {
			res= false;
		}
		
		return res;
	}
	
	
	// we have used svidx and pvidx because substring complexity is n we r taking two virtual index to keep track of the char in src and pat
	// we will use int 2d array to store result because IN boolean array not possible to store 3 values 
	// int array we will use 0 as result is not computed and 2 as true and 1 as false
	// there are two type of boolean 
	// small boolean(primitive boolean) array store false value as by default and it has only two value true and false
	// Boolean(where capital boolean is class)  is store 3 values that is null true and false instead of int we can also use Boolean array 
	public static boolean wildCardPatternMatchingRecursionTD(String src, String pat, int svidx, int pvidx, int[][] strg) {
		// order of code is also matter
				// first write base case 
				
				// base case where to stop recursion
				// this case when length of src and pat is zero
				if(src.length() == svidx && pat.length() == pvidx) {
					return true;
				}
				// when length of pat is zero and src not in that case it also false
				if(src.length() != svidx && pat.length() == pvidx ) {
					return false;
				}
				// when length of src is zero but there is only * in pattern in that case it is true
				if(src.length() == svidx && pat.length() != pvidx) {
					// this is the negative base case which handle the * pattern 
					for(int i=pvidx ; i < pat.length() ; i++) {
						if(pat.charAt(i) != '*') {
							return false;
						}
					}
					return true;
				}
				
				// reuse before call
				// 0 means result is not computed yet
				if(strg[svidx][pvidx] != 0 ) {
					return strg[svidx][pvidx] == 2 ? true : false;
				}
				
				// then write all variable and constants changing
				char chs = src.charAt(svidx);
				char chp = pat.charAt(pvidx);
				
				boolean res;
				
				// then write your recursive calls
				if(chs == chp || chp == '?') {
					// this call is whem first character of src is matched with pat
					res = wildCardPatternMatchingRecursionTD(src, pat, svidx+1 , pvidx+1, strg);
				}else if(chp == '*') {
					// this calls for * when we encounter * char in pattern it leads to two call
					// one for blank and another one is for multiple characters
					
					boolean blank = wildCardPatternMatchingRecursionTD(src, pat, svidx, pvidx +1, strg);
					boolean multiple = wildCardPatternMatchingRecursionTD(src, pat, svidx + 1, pvidx, strg);
					res = blank || multiple;
				}else {
					res= false;
				}
				
				// store res 
				strg[svidx][pvidx] = res ? 2 : 1;
				
				return res;
	}

	public static boolean wildCardPatternMatchingRecursionBU(String src, String pat) {
		// declare your storage array
		boolean[][] strg = new boolean[src.length() +1][pat.length() +1];
		
		// first base case prefilled when src length and pattern length is 0 
		strg[src.length()][pat.length()] =true;
		
		// loop to fill boolean array
		for (int r= src.length() ; r>=0; r-- ) {
			for(int c= pat.length()-1; c>=0; c--) {
				// this condition is to fill last row 
				if(r == src.length()) {
					// if pat contain any char * then we will store next cell value
					if(pat.charAt(c) == '*') {
						strg[r][c] = strg[r][c+1];
					}else {
						// if contain ? or any character blank src with question mark and character of pat is always false
						strg[r][c] = false;
					}
				}else {
					// this will store normal cell or inbetwen cells which will use diagonal values from rop ros value 
					char chs = src.charAt(r);
					char chp = pat.charAt(c);
					
					boolean res;
					
					// then write your recursive calls
					if(chs == chp || chp == '?') {
						// this call is whem first character of src is matched with pat
						res = strg[r+1][c+1];
					}else if(chp == '*') {
						// this calls for * when we encounter * char in pattern it leads to two call
						// one for blank and another one is for multiple characters
						
						boolean blank =strg[r][c+1];
						boolean multiple = strg[r+1][c];
						res = blank || multiple;
					}else {
						res= false;
					}
					
					// store res 
					strg[r][c] = res;
				}
			}
		}
		
		return strg[0][0];
		
	}
	
}
