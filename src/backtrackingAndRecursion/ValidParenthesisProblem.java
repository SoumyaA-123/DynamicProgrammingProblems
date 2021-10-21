package backtrackingAndRecursion;

public class ValidParenthesisProblem {
	public static void main(String args[]) {
		System.out.println("to check valid parenthesis");
		long start1=System.currentTimeMillis();
		validParenthesis(0, 0, 4, "");
		long end1=System.currentTimeMillis();
		System.out.println("time taken to run this problem is "+ (end1-start1)+"sec");
		
	}
	public static void validParenthesis(int close, int open, int n, String Ans) {
		// positive base case
		if(close == n && open == n) {
			System.out.println(Ans);
			return;
		}
		// negative base case
		if(close > open || open >n) {
			return;
		}
		validParenthesis(close, open+1, n, Ans+"(");
		validParenthesis(close + 1, open, n, Ans+")");
		
	}
}
