public class GridImage {

	public static void main(String[] args) {

    int rows = 20;
    int cols = 20;

    int[][] grid = new int[rows][cols];


	
	System.out.println();
	
	
	//Show invert method
	rowPop(grid, 4, 12);
	colPop(grid, 2, 5);
	
	// before invert
	print2d(grid);
	System.out.println();

	// after invert
	invert(grid);
	print2d(grid);
    System.out.println();
	
	reset(grid);
	print2d(grid);
    diagonal(grid, 8,  3, 0, 111);
	print2d(grid);
    System.out.println();

	reset(grid);
	diagonal(grid, 11, 4, 1, 222);
	print2d(grid);
    System.out.println();
	
	reset(grid);
	diagonal(grid, 4, 9, 2, 333);
	print2d(grid);
    System.out.println();
	
	reset(grid);
	diagonal(grid, 0, 5, 3, 444);
	print2d(grid);
    System.out.println();

  }

  // prints out 2-dimensional array values
  public static void print2d(int[][] d2) {

    for (int r=0; r < d2.length; r++) {
      for (int c=0; c < d2[r].length; c++) {

        System.out.printf("%03d ", d2[r][c]);
      }//end c for

      System.out.println();
    }//end r for
  }//end print2d
	
	public static void diagonal(int[][]d2, int r, int c, int direction, int value) {
	
		switch(direction)
		{
			case 0: // up and to the left
				while (r>=0 && c >= 0) {  // keep going until outside of array boundary
					d2[r][c] = value;
					r--;				// this goes up one row
					c--;				// this goes left one column
				 
				}  // end while 
				break;
			case 1: //up and to the right
				while (r>=0 && c <d2[r].length) {  // keep going until outside of array boundary
					d2[r][c] = value;
					r--;				// this goes up one row
					c++;				// this goes right one column
				} // end while 
				break;		
			case 2: // down and to the left
				while (r<d2.length && c >=0) {  // keep going until outside of array boundary
					d2[r][c] = value;
					r++;				// this goes down one row
					c--;				// this goes left one column
				} // end while 
				break;		
			case 3:	// down and to the right
				while (r<d2.length && c <d2[r].length) {  // keep going until outside of array boundary
					d2[r][c] = value;
					r++;				// this goes down one row
					c++;				// this goes right one column
				}; // end while 
				break;
		} // end switch
		
	} // end diagonal
		
		
		
	
  // Goes through d2 and modifies each element so 
  //	All 0s become 255
  //	Any non-zero becomes 0
  public static void invert(int[][] d2) {

    for (int r=0; r < d2.length; r++) {
      for (int c=0; c < d2[r].length; c++) {
		if (d2[r][c] == 0)
			d2[r][c] = 255;
		else d2[r][c] = 0; // no need to check if non-zero because everything will become a 0
        
      }//end c for
    }//end r for
  }//end invert
	
  // Goes through d2 and sets each element to a number starting with 0 
  //	All 0s become 255
  //	Any non-zero becomes 0
  public static void reset(int[][] d2) {

    int value = 0;
	for (int r=0; r < d2.length; r++) {
      for (int c=0; c < d2[r].length; c++) {
		d2[r][c] = value;
	
        
      }//end c for
    }//end r for
  }//end reset
	
	
	// Populates row r in d2 with value
	public static void rowPop(int[][] d2, int r, int value) {
		
		for (int c=0; c<d2[r].length; c++)	{
			d2[r][c] = value;
			
		} // end of c
		
		
	} // end rowPop
	
	// Populates col c in d2 with value
	public static void colPop(int[][] d2, int c, int value) {
		
		for (int r=0; r<d2.length; r++)	{
			d2[r][c] = value;
			
		} // end of r
		
		
	} // end rowPop
	
	
	public static int rowSum(int[][] d2, int r) {
		
		int sum = 0;
		
		for (int c=0; c<d2[r].length; c++)	{
			sum+= d2[r][c];
			
		} // end of c
		
		return sum;
		
	} // end of rowSum
	
	public static int colSum(int[][] d2, int c) {
		
		int sum = 0;
		
		for (int r=0; r <d2.length; r++)	{
			sum+= d2[r][c];
			
		} // end of c
		
		return sum;
		
	} // end of rowSum
	
	public static void printArray(int[][] a) {
		
		for (int r=0; r<a.length; r++)	{   // a.length gives how many ROwS you have
			for (int c=0; c < a[r].length; c++) {
				System.out.printf("%02d ", a[r][c]);
			
			} // end for c
			System.out.println();
		} // end for r
	} // end printArray
	
	public static void popArray(int[][] a) {
		
		int value = 0;
		
		for (int r=0; r<a.length; r++)	{   // a.length gives how many ROwS you have
			for (int c=0; c < a[r].length; c++) {
				a[r][c] = value++;
			
			} // end for c
			
		} // end for r
	} // end printArray
} // end class
