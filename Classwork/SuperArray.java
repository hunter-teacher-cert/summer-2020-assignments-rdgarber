import java.io.*;
import java.util.*;

public class SuperArray {
    private static final int MAX_ELEMENTS = 10;
	private int[] data;			// where we keep the SuperArray data
    private int numberElements;  // number of elements in the array
	
	public SuperArray()	{	// constructor
	
		data = new int [MAX_ELEMENTS];
		numberElements = 0;
		
		
		
	} // end SuperArray constructor
	
	public SuperArray(int size)	{	// constructor
	
		data = new int [size];
		numberElements = 0;
				
	} // end SuperArray constructor
	
	// add one value to the array
	 public void add(int value)	{ 
	
		if (numberElements < data.length)
			data[numberElements++] = value;  // only add if there is room
		
	
	} // end add

	// get specific element from the array
	public int get(int index)	{ 
	
		if (index >= numberElements)
			return -1;
		
		return(data[numberElements]);
		
	
	} // end get
	
	// return TRUE if array is empty, FALSE otherwise
	public boolean isEmpty()  {
		
		if (numberElements == 0)
			return true;
		
		return false;
		
	} // end isEmpty
	
	// build and return a String with all the elements of the 
	// array in a printable form
	public String toString() {
		
		String printableString = "";
		
		for (int i=0; i< numberElements; i++){
			
			printableString = printableString + data[i] + " ";
			
		}
		
		return printableString;
		
	} // end toString
		
} // end class SuperArray