package KnapSackProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class KnapSack01BruteForceApproach {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 ArrayList<Integer> val=new ArrayList<Integer>();
		 ArrayList<Integer> w=new ArrayList<Integer>();
		 int n;
		 int W;
		 try {
			 while(true) {
				 System.out.print("enter the number of element you want to enter:");
				 n= sc.nextInt();
				 System.out.print("enter the maximum wight:");
				 W=sc.nextInt();
				 
				 for(int i=0 ; i<n ; i++ ) {
					 System.out.print("Please Enter "+i+"th value must be , seprated a,b:");
					 String[] res = sc.next().split(",");
					 val.add(Integer.parseInt(res[0]));
					 w.add(Integer.parseInt(res[1]));
				 }
				 break;
			 }
			 System.out.print("maximum profit we get is:");
			 System.out.println(kanpSack(W, w, val, n));
			 
		 }catch(Exception e) {
			 System.out.println(e);
		 }
				
		
		

	}
	
	public static int max(int a,int b) {
		return a>b ? a : b;
	}
	
	public static Integer kanpSack(int W, ArrayList<Integer> w ,  ArrayList<Integer> val, int n) {
		// we are using recursion here
		// base case when n and W is zero
		if( n==0 || W== 0) {
			return 0;
		}
		
		// if weight of nth item is greater than max capacity then item is not included in optimal solution
		if(w.get(n-1) > W)
			return kanpSack(W, w, val, n-1);
		// this will return max val first argument is included and second item not
		else
			return max(val.get(n-1) + kanpSack(W - w.get(n-1), w, val, n-1), kanpSack(W, w, val, n-1));
	}

}


