package backtrackingAndRecursion;

//import java.util.Scanner;

public class PalindromicPartitioning {

	public static void main(String[] args) {
		
		System.out.println("here is problem for palindromic partitioning");
		long start1=System.currentTimeMillis();
		panlindromicPartition("abchdgdhbca", "");
		long end1=System.currentTimeMillis();
		System.out.println("time taken to run this problem is "+ (end1-start1)+"sec");
		
		
	}

	public static void panlindromicPartition(String ques, String Ans) {
		if (ques.length() == 0) {
			System.out.println(Ans);
			return;
		}
		for (int i = 1; i <= ques.length(); i++) {
			String part = ques.substring(0, i);
			//String roq = ques.substring(i);
			//panlindromicPartition(roq, Ans + part + " ");
			if(Ispalindrome(part)) { // this extra condition is added to filter that partition string is palindromic or not
				panlindromicPartition(ques.substring(i), Ans + part + " "); // this call will give all possible partitions
			}
			
		}

	}
	
	public static boolean Ispalindrome(String value) {
		int i =0;
		int j=value.length()-1;
		
		while(i < j) {
			if(value.charAt(i) != value.charAt(j)) {
				  return false;
			}
			//return false;
			i++;
			j--;	
		}
		
		return true;
	}

}
