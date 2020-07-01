import java.io.*;
import java.util.*;
/*
  2D array 
  set up 
  change values in it
  a way of applying the GOL rules 
 */




class Life{

    static final int ROWS = 10;
	static final int COLS = 12;
	
	public static void main(String[] args) {
		char[][] board;
		char[][] nextBoard;
		board = createNewBoard(ROWS, COLS);
		// First we do it initializing with a simple pattern
		initializeSimplePattern(board);
		printBoard(board);
		nextBoard = generateNextBoard(board);
		printBoard(nextBoard);
		nextBoard = generateNextBoard(nextBoard);
		printBoard(nextBoard);
		
		// now we'll do a random pattern
		initializeRandomPattern(board);
		printBoard(board);
		nextBoard = generateNextBoard(board);
		printBoard(nextBoard);
		// lets do it 10 iterations
		for (int i=0; i<10; i++)	{
			nextBoard = generateNextBoard(nextBoard);
			printBoard(nextBoard);
		}	
	
	
    }	
	// Starting pattern for the Game of Life
	public static void initializeSimplePattern(char[][] board) {
		board[1][3] = 'X';
		board[2][3] = 'X';
		board[3][3] = 'X';
				
		
	} // end initializeSimplePattern
	
	// Starting pattern for the Game of Life
	public static void initializeRandomPattern(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (Math.random() < 0.25)
					board[r][c] = 'X';   
			}
		}		
		
	} // end initializePattern
	
	/*
      create a new 2D array, fill it with ' ' 
      representing that the entire board is empty.
     */
    public static char[][] createNewBoard(int rows, int cols){
	char[][] board = new char[rows][cols];
	for (int r = 0; r < rows; r++) {
	    for (int c = 0; c < cols; c++) {
		board[r][c] = ' ';
	    }
	}
	return board;
    }

    
    public static void printBoard(char[][] board){
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c++) {
		System.out.printf("%c",board[r][c]);
	    }
	    System.out.println();
	}
	System.out.println("\n\n------------------\n\n");
    }

    /*
      set the cell (r,c) to value
    */
    public static void setCell(char[][] board, int r, int c, char val){
	if (r>=0 && r<board.length && c>=0 && c<board[r].length){
	    board[r][c] = val;
	}
    }


    /* 
       Count and return the number of living neigbords around board[r][c]
       approach 1 - lots of if statements
       approach 2 - you can loop over the grid from board[r-1][c-1]
                    to board[r+1][c+1]
    */
    public static int countNeighbours(char[][] board, int r, int c){
		int count = 0;  // initialize our counter
		//System.out.printf("For point %d, %d: ",r,c); 
		for (int i=(Math.max(r-1, 0)); i<Math.min(r+2, board.length); i++)
				for (int j=(Math.max(c-1, 0)); j<Math.min(c+2, board[r].length); j++)	{
					//System.out.printf("Checked %d, %d. ",i,j); 
					// check for two things:
					//  1 if square is not blank
					//  2 make sure we do not count the square itself
					if (board[i][j] != ' ' && (i != r || j != c))	{  
						//System.out.printf("*Hit* "); 
						count++;
					}
				}	
		//System.out.printf("Count=%d\n",count);
		return count;
    }
    
    /*
      given a board and a cell, determine, based on the rules for 
      Conway's GOL if the cell is alive ('X') or dead (' ') in the 
      next generation.
      
     */
    public static char getNextGenCell(char[][] board,int r, int c){
	// calculate the number of living neighbors around board[r][c]
		int count = countNeighbours(board, r, c);
	// determine if board[r][c] is living or dead
	//    if living and 2 3 neighbors then remain alive
		if  (board[r][c] != ' ')   {	// cell is alive
			if (count < 2 || count > 3)
				return ' ';	// dead!
		}
		else {	// cell is dead
	//    if dead and 3 neighbors then become alive
			if (count == 3)
				return 'X';
		}	
		// otherwise, returns the status quo
		return board[r][c];
    }
    /*
      scan the board to generate a NEW board with the
      next generation
    */
    public static char[][] generateNextBoard(char[][] board){
		char newBoard[][] = new char[ROWS][COLS];
	// fill the new board
		for (int r = 0; r< board.length; r++)
			for (int c = 0; c < board[r].length; c++)
				newBoard[r][c] = getNextGenCell(board, r, c);
		return newBoard;
    }
    
   
}
