import java.io.*;
import java.util.*;
/*
  2D array 
  set up 
  change values in it
  a way of applying the GOL rules 
 */



class Life{

    public static void main(String[] args) {
	char[][] board;
	board = createNewBoard(10,12);
	initializePattern(board);
	printBoard(board);
	countNeighbours(board, 1, 4);
	countNeighbours(board, 2, 4);
	countNeighbours(board, 2, 3);
	countNeighbours(board, 0, 3);
	countNeighbours(board, 1, 11);

	
	
    }	
	// Starting pattern for the Game of Life
	public static void initializePattern(char[][] board) {
		board[1][3] = 'X';
		board[2][3] = 'X';
		board[3][3] = 'X';
				
		
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
		System.out.printf("For point %d, %d: ",r,c); 
		for (int i=(Math.max(r-1, 0)); i<Math.min(r+2, board.length); i++)
				for (int j=(Math.max(c-1, 0)); j<Math.min(c+2, board[r].length); j++)	{
					System.out.printf("Checked %d, %d. ",i,j); 
					// check for two things:
					//  1 if square is not blank
					//  2 make sure we do not count the square itself
					if (board[i][j] != ' ' && (i != r || j != c))	{  
						System.out.printf("*Hit* "); 
						count++;
					}
				}	
		System.out.printf("Count=%d\n",count);
		return count;
    }
    
    /*
      given a board and a cell, determine, based on the rules for 
      Conway's GOL if the cell is alive ('X') or dead (' ') in the 
      next generation.
      
     */
    public static char getNextGenCell(char[][] board,int r, int c){
	// calculate the number of living neighbors around board[r][c]

	// determine if board[r][c] is living or dead
	//    if living and 2 3 neighbors then remain alive
	//    if dead and 3 neighbors then become alive
	
	return ' ';
    }
    /*
      scan the board to generate a NEW board with the
      next generation
    */
    public char[][] generateNextBoard(char[][] board){
	char newBoard[][] = new char[25][25];
	// fill the new board
	return newBoard;
    }
    
   
}
