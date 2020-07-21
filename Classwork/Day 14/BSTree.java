import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
	root = null;
    }

	
	// Search the tree for a specific key
	public int search(int key) {
		TreeNode current = root;
		
		while (current != null)		{
			int currentValue = current.getData();
			if (currentValue == key)	// we found it!
				return currentValue;
			else if (currentValue < key)
				current = current.getRight();	// key is higher, must go right
			else // key is lower than current, go left
				current = current.getLeft();
		}
		
		return -1;	// not found
			
	} // end search
	
		// Insert a new node into the tree
	public void insert(int key) {
		TreeNode newNode;
		TreeNode front = root;
		TreeNode parent;		// keep track of the parent
		
		newNode = new TreeNode(key);	// create our new node;
		if (front == null) { // there is no root
			// make this the root;
			root = newNode;
			return;		// we are done
		}
		
		while (front != null)		{  // traverse the tree until we get a null
			parent = front;	// keep track of this when we find a null
			int frontValue = front.getData();
			if (frontValue == key)	// we found it!
				throw new IllegalArgumentException("Node with key " + key + " already exists");
			else if (frontValue < key)  {
				front = front.getRight();	// key is higher, must go right
				if (front == null) // this is where the key should have been if it had existed
					parent.setRight(newNode);	// add the new node to the tree here
			}
			else    {// key is lower than front, go left
				front = front.getLeft();
				if (front == null) // this is where the key should have been if it had existed
					parent.setLeft(newNode);	// add the new node to the tree here
			}
		}
	
			
	} // end insert
	
	// Delete a node from the tree
	public void delete(int key) {
		TreeNode front = root;
		TreeNode parent;		// keep track of the parent
		
		
		if (front == null) { // there is no root
			return;		// we are done
		}
		
		// find the node that we want to delete
		// keep track of the node above it
		
		while (front != null && front.getData() != key)		{  // traverse the tree until we get a null
			parent = front;	// keep track of this when we find a null
			int frontValue = front.getData();
			if (frontValue < key)  {
				front = front.getRight();	// key is higher, must go right
			}
			else    {// key is lower than front, go left
				front = front.getLeft();
			}
		}
		// if the key is not in the tree
		if (front == null)
			return;		// the key isn't there
		
		// if we get here front points to the node we want to delete
		// case 1 - the node we want to delete is a leaf
		if (front.getLeft() == null && front.getRight() == null)	{
			// repoint front's parent to null
			
		}	
		// case 2 check if front has one child
		else if (true)  {
			
			
			
		}
		// case 3 front has two children
		// find the node with the largest value on front's left subtree
		// and replace front with it.
		else {
			
			
		}	
		
			
	} // end delete
	
	// recursively traverse 
	private void preorderTraverse(TreeNode current) {
		 if (current ==null)
			 return;
		 
		// process the current nodeS
		System.out.print(current.getData() + ", ");
		
		// recursively print out the left subnode
		preorderTraverse(current.getLeft());
		
		// recursively print out the right subnode
		preorderTraverse(current.getRight());
	} // end private preorderTraverse
	 
	 public void preorderTraverse()	{
		 preorderTraverse(root); 
		 System.out.println();
	 
	 } // end public preorderTraverse
	 
	 	// recursively postorderTraverse 
	private void postorderTraverse(TreeNode current) {
		 if (current ==null)
			 return;
		 
		
		// recursively print out the left subnode
		postorderTraverse(current.getLeft());
		
		// recursively print out the right subnode
		postorderTraverse(current.getRight());
		
		// process the current nodeS
		System.out.print(current.getData() + ", ");
		
	} // end private postorderTraverse2
	 
	 public void postorderTraverse()	{
		 postorderTraverse(root);
		 System.out.println();
	 } // end public postorderTraverse
	 
	 
	// recursively postorderTraverse
	
	private void inorderTraverse(TreeNode current) {
		 if (current ==null)
			 return;
		
		// recursively print out the left subnode
		inorderTraverse(current.getLeft());
		 
		// process the current nodeS
		System.out.print(current.getData() + ", ");
		
		// recursively print out the right subnode
		inorderTraverse(current.getRight());
	} // end private inorderTraverse
	 
	 public void inorderTraverse()	{
		 inorderTraverse(root);
		  System.out.println();

	 
	 } // end public inorderTraverse


    public void seed(){
	TreeNode t;

	t = new TreeNode(10);
	root = t;
	t = new TreeNode(5);
	root.setLeft(t);
	t = new TreeNode(20);
	root.setRight(t);

	root.getLeft().setRight( new TreeNode(8));

	t = new TreeNode(15);
	root.getRight().setLeft(t);

	t = new TreeNode(22);
	root.getRight().setRight(t);
	
	}
    
    
}
