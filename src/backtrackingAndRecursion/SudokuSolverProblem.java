package backtrackingAndRecursion;



public class SudokuSolverProblem {
	public static void main(String[] args) {
		int[][] board = {
				{3,0,6,  5,0,8,  4,0,0}, 
				{5,2,0,  0,0,0,  0,0,0}, 
				{0,8,7,  0,0,0,  0,3,1}, 
				
				{0,0,3,  0,1,0,  0,8,0}, 
				{9,0,0,  8,6,3,  0,0,5}, 
				{0,5,0,  0,9,0,  6,0,0}, 
				
				{1,3,0,  0,0,0,  2,5,0}, 
				{0,0,0,  0,0,0,  0,7,4}, 
				{0,0,5,  2,0,6,  3,0,0}
		};
		long start1=System.currentTimeMillis();
		sudokuSolver(board, 0, 0, board.length-1, board[0].length-1);
		long end1=System.currentTimeMillis();
		System.out.println("time taken to run this problem is "+ (end1-start1)+"sec");
		
		
	}
	public static void sudokuSolver(int[][] board, int cr, int cc, int er, int ec) {
		//this case when we got our answer when all rows are called and row exceeds its boundary
		if(cr > er) {
			display(board);
			return;
		}
		// this call is when call exceed the columns in a particular row or we can say call goes to out of boundary we make a one more call to next row 
		if(cc > ec) {
			// next row 1, 0
			sudokuSolver(board, cr+1, 0, er, ec);
			return;
		}
		// first we have to make a call for next box or column in a same row  when there number is already exist in a box 
		if(board[cr][cc] != 0) {
			sudokuSolver(board, cr, cc+1, er, ec);
			return;
		}
		
		for(int i=1; i < 10; i ++) {
			if(IsSafeNumber(board, cr, cc, er, ec, i)) {
				board[cr][cc] = i;
				sudokuSolver(board, cr, cc+1, er, ec);
				board[cr][cc] = 0;
			}
		}
	}
	private static void display(int[][] board) {
		// to display sudoku in a grid
		System.out.println("--------------------------------------");
		for(int i=0; i < board.length -1 ; i++) {
			for(int j=0; j < board[0].length-1; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
		
	}
	private static boolean IsSafeNumber(int[][] board, int cr, int cc, int er, int ec, int i) {
		// to check is it safe to place number on a particular position
		
		
		//row ---> to check row wise
		for(int c=0; c <= ec; c++ ) {
			if(board[cr][c] == i) {
				return false;
			}
		}
		
		//column ---> to check column wise
		for( int r=0; r <= er; r++) {
			if(board[r][cc] == i) {
				return false;
			}
		}
		// grid --> to check grid wise
		int sr = cr - cr % 3; // to find out the grid of the current value row
		int sc =  cc - cc % 3; // to find out the grid of the current value of column
		
		for( int r = sr; r < sr + 3; r++) {
			for(int c = sc; c < sc +3; c++) {
				if(board[r][c] == i) {
					return false;
				}
			}
		}
		
		return true;
	}

}
