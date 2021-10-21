/**
 * 
 */
package backtrackingAndRecursion;

/**
 * @author sumansingh01
 *
 */
public class NQueenProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("N queen problem solution:");
		long start1=System.currentTimeMillis();
		nQueen(new boolean[4][4], 0, "");
		long end1=System.currentTimeMillis();
		System.out.println("time taken to run this problem is "+ (end1-start1)+"sec");
	

	}
	static int c = 0;
	public static void nQueen(boolean[][] board, int row, String Ans) {
		
		if(row == board.length) {
			System.out.println(++c + " " + Ans);
			return;
		}
		
		for(int col=0; col< board[0].length; col++) {
			
			if(IsItSafePlace(board,row,col)) // this line of code gives true or false weather the current position is safe place no queen can kill 
			{
				// this below 3 lines of codes give all possible answers to place a queen
				board[row][col] = true;
				nQueen(board, row+1, Ans + "{" + row + "-" + col + "}" );
				board[row][col] = false;
			}
			
		}
		
	}
	private static boolean IsItSafePlace(boolean[][] board, int row, int col) {
		// 3 possible ways can other queen kill another one
		
		
		// first vertically
		int r = row;
		int c = col;
			while(r >= 0) {
				if(board[r][c]) {
					return false;
				}
				r--;
			}
			
		// second left diagonally
			r = row;
			c = col;
			while(r >= 0 && c >= 0) {
				if(board[r][c]) {
					return false;
				}
				r--;
				c--;
			}
		
		// third right diagonally
			r = row;
			c = col;
			while(r >= 0 && c < board[0].length) {
				if(board[r][c]) {
					return false;
				}
				r--;
				c++;
			}
		return true;
	}

}
