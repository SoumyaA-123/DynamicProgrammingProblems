package backtrackingAndRecursion;
//basic recursion problem with 3 cases
public class BacktrackingProblems {

	public static void main(String[] args) {
		System.out.println("backtracking example with 3 cases");
		System.out.println("1st case n-1");
		PDI(5); 
		System.out.println("2nd case --n");
		PDI2(5);
		System.out.println("3rd case n-- which throw stackoverflow error when u execute this");
		//PDI1(5);
	}
	// first problem with n-1 
	public static void PDI(int n) {
		if(n==0) {
			return;
		}
		System.out.println("hii"+n);
		PDI(n-1);
		System.out.println("bye"+n);
	}
	//second case with n--
	public static void PDI1(int n) {
		if(n==0) {
			return;
		}
		System.out.println("hii"+n);
		PDI1(n--);
		System.out.println("bye"+n);
	}
	// third case with --n
	public static void PDI2(int n) {
		if(n==0) {
			return;
		}
		System.out.println("hii"+n);
		PDI2(--n);
		System.out.println("bye"+n);
	}
	
}
