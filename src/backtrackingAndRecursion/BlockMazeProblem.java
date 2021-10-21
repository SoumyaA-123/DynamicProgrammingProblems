package backtrackingAndRecursion;

public class BlockMazeProblem {

	public static void main(String[] args) {
		int[][] maze = {{0,1,0,0},
						{0,0,0,0},
						{0,1,0,0},
						{0,0,1,0}};
		long start=System.currentTimeMillis();
		System.out.println("all possible path to cover");
		blockMaze(maze, 0, 0, maze.length-1, maze[0].length-1, "", new boolean[4][4]);
		long end=System.currentTimeMillis();
		System.out.println("time taken to run this problem is "+ (end-start)+"sec");
		

	}
	
	public static void blockMaze(int[][] maze, int cr, int cc, int er, int ec, String Ans, boolean[][] visited) {
		 // first create a postitive base case 
		if(cr == er && cc == ec)
		{
			System.out.println(Ans);
			return;
		}
		// next step to write negative base case
		if(cr < 0 || cc < 0 || cr > er || cc > ec || maze[cr][cc] == 1 || visited[cr][cc])// this maze condition added to exclude calls from blocked path and already visited blocks
		{
			return;
		}
		
		visited[cr][cc] = true;  // this step is to track the already visited block important step
		// here we need to do 4 calls because a maze can move all four direction top right down left
		blockMaze(maze, cr-1, cc, er, ec, Ans + "T", visited);
		blockMaze(maze, cr +1, cc, er, ec, Ans + "D", visited);
		blockMaze(maze, cr, cc-1, er, ec, Ans + "L", visited);
		blockMaze(maze, cr, cc +1, er, ec, Ans + "R", visited);
		
		// this step is to reset the visited path 
		visited[cr][cc] = false;
		
	}

}
