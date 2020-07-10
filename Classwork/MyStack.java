import java.io.*;
import java.util.*;
  
 public class MyStack{
  // add your internal data structure here
	private static final int MAX_STACKSIZE = 10;
	private int stackCount;
	private String[] stack;			// where we keep the SuperArray data

	public MyStack(){  // add constructor code
		
		this(MAX_STACKSIZE);
		
	} // end constructor
	
	public MyStack(int size){  // add constructor code where set size of stack
		
		if (size < 1)
			throw new StringIndexOutOfBoundsException("Invalid Stack size: " + Integer.toString(size));
	
		stack = new String [size];  // set the size of the stack
		stackCount = 0;

		
	} // end constructor
	
	
	public void push(String data){  // add code to push data on to the stack
		 
		// check for exceptions
		if (stackCount == MAX_STACKSIZE)  // the stack is full
			throw new ArrayIndexOutOfBoundsException("Stack Overflow");
		if (data == null)  // data is empty
			throw new  NullPointerException("Invalid null data");
		
		stack[stackCount++] = data;    // push on the stack and increment the count 
		
		 
	} // end push
	

		  // add code to remove and return the
		  // item on the top of the stack
	public String pop(){
		  
		String topOfStack;
		
		topOfStack = top();
		if (topOfStack == null)
			throw new ArrayIndexOutOfBoundsException("Can't pop empty stack");
	
		stackCount--;    // pop it off the stack and decrement the stack count the count 
		return topOfStack;
		
	} // end pop()
	

		  // add code to return but not remove the
		  // item on the top of the stack
	public String top(){
		  
		if (isEmpty())	// nothing to pop
			return null;
	
		return stack[stackCount];    // pop it off the stack and decrement the stack count the count 
	
	}	// end top

		  // return true if the stack has no data, false otherwise
	public boolean isEmpty(){
		
		return stackCount == 0;  // we are empty if the stack has 0 elements.
		  
	}

		  // add code to return the number of items currently on the stack
	public int size(){
		 
		return stackCount;
	}
    
	// build and return a String with all the elements of the 
	// stack in a printable form
	public String toString() {
				
		String printableString = "";
		
		// iterate through each item on the stack starting from the top
		for (int i = stackCount; i> 0; i--)  {
			printableString += stack[i-1] + ", ";
		}	
		printableString += "[Bottom]";	// tack this on the end
			
		return printableString;
		
	} // end toString
	
  }