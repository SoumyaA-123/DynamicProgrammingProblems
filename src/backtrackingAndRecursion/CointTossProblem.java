package backtrackingAndRecursion;

public class CointTossProblem {
	public static void main(String args[]) {
		System.out.println("coin toss problem");
		long start=System.currentTimeMillis();
		cointToss(5, "");
		long end=System.currentTimeMillis();
		System.out.println("time taken to run this problem is "+ (end-start)+"sec");
	}
	
	public static void cointToss(int n, String Ans) {
		///check how many options
		if(n==0) {
			System.out.println(Ans);
			return;
		}
		cointToss(n-1, Ans + "H");
		cointToss(n-1, Ans + "T");
		
	}
}
