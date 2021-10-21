package backtrackingAndRecursion;

public class MazePathProblem {

	public static void main(String[] args) {
		
//		System.out.println("Maze path problem");
//		long start=System.currentTimeMillis();
//		mazePath(3, 3, 0, 0, "");
//		long end=System.currentTimeMillis();
//		System.out.println("time taken to run this problem is "+ (end-start)+"sec");
//		
//		System.out.println("if we take intelligent decision");
//		long start1=System.currentTimeMillis();
//		mazePath1(3, 3, 0, 0, "");
//		long end1=System.currentTimeMillis();
//		System.out.println("time taken to run this problem is "+ (end1-start1)+"sec");
		//System.out.println(mazePathWays(0,0,50,50));
		int n=1000;
		//System.out.println(mazePathWaysTD(0, 0, n, n,new int[n+1][n+1]));
		System.out.println(mazePathWaysBU(n, n));

	}
	public static void mazePath(int er,int ec,int cr,int cc,String Ans) {
		//positive base case
		if(cr == er && cc ==ec) {
			System.out.println(Ans);
			return;
		}
		//negative base case
		if(cr > er || cc > ec) {
			return;
		}
		// possible calls is always equal to possible ways or option
		// this call is for horizontal move
		mazePath(er, ec, cr+1, cc, Ans+"H");
		// this call is for vertical move
		mazePath(er, ec, cr, cc+1, Ans+"V");
	}
	public static void mazePath1(int er,int ec,int cr,int cc,String Ans) {
		
		// in this problem we take intelligent decision before making any call this lead to save extra time and reduce un necessary calls and remove negative base case
		
		//positive base case
		if(cr == er && cc ==ec) {
			System.out.println(Ans);
			return;
		}
//		//negative base case
//		if(cr > er || cc > ec) {
//			return;
//		}
		// possible calls is always equal to possible ways or option
		// this call is for horizontal move
		if(cr+1 < er) {
			mazePath(er, ec, cr+1, cc, Ans+"H");
		}
		if(cc + 1 < ec) {
			// this call is for vertical move
			mazePath(er, ec, cr, cc+1, Ans+"V");
		}
	
		
	}
	// dp solutions to find number of ways
	// first find no of ways using recursion
	public static int mazePathWays(int cr, int cc, int er, int ec) {
		// positive base case
		if( cr == er && cc == ec) {
		return 1;
		}
		if(cr > er || cc > ec) {
			return 0;
		}
		int ch = mazePathWays(cr, cc+1, er, ec);
		int cv = mazePathWays(cr+1, cc, er, ec);
		
		return ch+cv;
	}
	// this method top down approach because recursion approach is failing for input above 40
	public static int mazePathWaysTD(int cr, int cc, int er, int ec, int[][] strg) {
		// positive base case
		if( cr == er && cc == ec) {
		return 1;
		}
		if(cr > er || cc > ec) {
			return 0;
		}
		
		if(strg[cr][cc] != 0 ) { // to re-use the storing value
			return strg[cr][cc];
		}
		
		int ch = mazePathWaysTD(cr, cc+1, er, ec,strg);
		int cv = mazePathWaysTD(cr+1, cc, er, ec, strg);
		
		strg[cr][cc] = ch+cv; // store the repeated value
		
		return ch+cv;
	}
	// as this TD approach is not valid for 1000 + input so we have to create BU approach to build this
	public static int mazePathWaysBU(int er, int ec) {
		int[][] strg = new int[er+2][ec+2];
		
		
		
		for(int r =er; r >=  0; r--) {
			for(int c = ec; c >=0; c--) {
				if(r==er && c==ec) {
					strg[er][ec] = 1;
				}else {
					strg[r][c] = strg[r+1][c] + strg[r][c+1];
				}
				
			}
		}
		 
		
		return strg[0][0];
	}
	
	
}
