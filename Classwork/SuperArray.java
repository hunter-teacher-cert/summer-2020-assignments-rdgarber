import java.io.*;
import java.util.*;

public class SuperArray {
    private static final int MAX_ELEMENTS = 10;
	private int[] data;			// where we keep the SuperArray data
    private int numberElements;  // number of elements in the array
	
	public SuperArray()	{	// constructor
	
		this(MAX_ELEMENTS);
		
	} // end SuperArray constructor
	
	public SuperArray(int size)	{	// constructor
	
		data = new int [size];
		numberElements = 0;
				
	} // end SuperArray constructor with one argument
	
	// add one value to the array
	//  index - location in array to add (e.g. insert)
	//  value - element to add
	 public void add(int index, int value)	{ 
	/*  Old code before we added the grow() method:
		if (numberElements  data.length)
			data[numberElements++] = value;  // only add if there is room
	*/
			if (index > numberElements)
				return; // do nothing here - this is not an insert - index is too big
			
			if (numberElements >= data.length) // We are at capacity (should never be greater than, but just in case....
					grow();
					
			if (index == -1)	{   // add only
				data[numberElements] = value; 
			}
			else {  // we are inserting
				// lets move everything up past the insert point
				for (int i=numberElements; i>index; i--)
					data[i] = data[i-1];
				// now insert the value
				data[index] = value;
			}
			// now up the count
			numberElements++;
	
		
	} // end add

	
	// add one value to the array
	 public void add(int value)	{ 
	 
		add(-1, value);
	 
	 } // end add
	
	// remove one from the array at position 'index'
	public void remove(int index)	{
		if (isEmpty() || get(index) == -1)
			return; 	// Nothing there or index is too big
		// nothing to move if we are removing the last element
		for (int i = index; i< numberElements -1; i++)  
			data[i] = data[i+1];
		
		numberElements--;
		
	} // end remove

	
	// get specific element from the array
	public int get(int index)	{ 
	
		if (index >= numberElements)
			return -1;
		
		return(data[index]);
		
	
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
	
	
	/*  This should increase the capacity of your SuperArray:
		Make a new array with extra room.
		Copy the data from the original internal array over to the new one.
		Set the internal instance variable data to the new array.
	*/
	public void grow()		{
		
		int newdata[];
		
				
		newdata = new int [data.length + MAX_ELEMENTS];
		// now copy everything over
		for (int i=0; i< numberElements; i++){
			
			newdata[i] = data[i];
			
		}
		
		data = newdata;		// reset the pointer to the new data
		
	} // end grow
	
	
} // end class SuperArray