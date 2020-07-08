import java.io.*;
import java.util.*;

public class LList {

	private Node head;
	private int lCount;
	
	public LList()	{ // constructor
	
		head = null;
		
	} // end constructor	
		
	public class Node {

		 Node next;
		 String data;
		 
				 
		 Node (String data)	{   // constructor
		 
			this.data = data;
			this.next = null;
			
		} // end of constructor
		
		public Node getNext() {
			return this.next;	
		} // end of getNext()
		
		public void setNext(Node n)		{
			
			this.next = n;
			
		} // end setNext()
		
	} // end of Node
	
	// printable string
	public String toString() {
	
		Node tmp;
		
		String printableString = "";
		
		if (!isEmpty())	{	/// if there are nodes here, loop through them
			tmp = head;
			while (tmp != null)	{
				
				printableString += tmp.data + "--->";
				tmp = tmp.next;
			}
		}	
		printableString += "null";
		return printableString;
		
		
	} // end toString

	// Add a new Node containing value to the front of the list
	public void addFront(String value)	{
		
		Node newnode = new Node(value);	// this is our new Node
		if (head == null)	// we had an empty list
			head = newnode;	// in that case, point it at the new node
		else	{	  // else stick in front of our existing list		
			newnode.setNext(head);	// point the new node to the rest of the linked list
			head = newnode;		// now point the head at the new node
		}
		this.lCount++;	// add one ot the list counter
	}	

	// Returns true if the list is empty, false otherwise.
	public boolean isEmpty()	{
		
		return head == null;
		
	} // end isEmpty()
	

	// Returns the value (not the Node) at index.
	// If index is out of bounds, return null.
	public String get(int index)	{
		String value = null;
		Node tmp = head;
		int count = 0;
		
		if (isEmpty() || index >= this.lCount)	// index is out of bounds
			return null;
		while (tmp != null && count<index)	{ // keep going until the count hits the index
			tmp =tmp.next;	// iterate to the next node	
			count++;		// increment the count 
		}
		return tmp.data;	
		
	} // end get()

	// Set the Node at index to contain value
	// If index is invalid, do nothing.
	public void set(int index, String value)	{
		
		Node tmp = head;
		int count = 0;
		
		if (isEmpty() || index >= this.lCount)	// index is out of bounds
			return;
		while (tmp != null && count<index)	{ // keep going until the count hits the index
			tmp =tmp.next;	// iterate to the next node	
			count++;		// increment the count 
		}
		tmp.data = value;
	} // end set()

	// Insert a new Node containing value at index.
	// If index is invalid, do nothing.
	public void insert(int index, String value)	{
		Node tmp = head;
		int count = 1;
		// three possibilities here
		// if Index == 0, then we replace the head
		// if index == the lcount, then we are adding to the end
		// in between, we need to insert between the head and the end
		
		if (index > this.lCount)	// index is out of bounds
			return;  // index is out of bounds
			
		// Empty lists cannot have an index > 0 - this is invalid
		if (isEmpty() && index > 0)	
			return;	// this is also  invalid 
		
		if (index == 0)	// we've already handled this 
			addFront(value);
		else {
			tmp = head;  // we start with index 1
		
			while (tmp.next != null && count < index)	{
				tmp = tmp.next;
				count++;
			}	
			Node newnode = new Node(value);	// this is our new Node	
			newnode.setNext(tmp.getNext());  // point its next value to the rest of the list
			tmp.setNext(newnode);		// reset the pointer at the insertion Node
			this.lCount++;	// up the count
		
		} // end else
		
	
	} // end insert

	
	/* Returns the index of the first time key occurs in the list.
	Returns -1 if key is not found.
	*/
	public int search(String key)	{
		
		Node tmp = head;
		int index = 0;
		
		// we don't need to test for empty, because if we are empty
		// then the head is null, so tmp will equal null and we skip the while loop
		while (tmp != null)	{
			if (tmp.data.equals(key))  // if we find a match	
				return(index);			// then we are at the correct index
			index++;		// not there, so we increment the index
			tmp = tmp.next;	// and try again
		}
		return(-1);  // if we are here, there is no match
	} // end search()
	
	/* Removes the Node at index from the list.
	If index is invalid, do nothing.
	*/
	public void remove(int index)		{
		Node tmp = head;
		int count = 1;
		
		if (isEmpty() || index >= this.lCount)	// index is out of bounds
			return;
		
		
		if (index == 0)  // remove the first node
			head = head.next;  // point header to the next node
		else {
			while (tmp.next != null && count < index)	{
				tmp = tmp.next;
				count++;
			}
			// OK, at this point tmp.next should be pointing to the node we want to delete
			tmp.next = tmp.next.next;  // reset the pointer to the next Node in the list
		}
		this.lCount--;

		
	} // end remove
	
	
		
		
} // end of LList