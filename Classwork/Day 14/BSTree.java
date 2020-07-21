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
		TreeNode parent = front;		// keep track of the parent
		int childCount = 0;		// number of children the node has (0, 1 or 2)
		
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

		if (front.getLeft() != null)
			childCount++;
		if (front.getRight() != null)
			childCount++;
		// if we get here front points to the node we want to delete
		// case 1 - the node we want to delete is a leaf
		if (childCount == 0)	{
			// repoint front's parent to null
			if (parent.getLeft() == front)
				parent.setLeft(null); // parent now points to null
			else parent.setRight(null); 
		}	
		// case 2 check if front has one child
		else if (childCount == 1)  {
			// assign that child to the parent
			if (parent.getLeft() == front)		{  // if the node we want to delete is on the parents's Left
					if (front.getLeft() != null)  // the child's left points to a node
						parent.setLeft(front.getLeft());	// set the parent to that node
					else parent.setLeft(front.getRight());	// child's Right must be that node to delete
				}	
			else  {  // node we want to delete is on the parent's right
				if (front.getLeft() != null)   // the child's left points to a node
					parent.setRight(front.getLeft());  // set the parent to that node
				else parent.setRight(front.getRight()); // child's Right must be that node to delete
			}
		}	
		// case 3 front has two children
		// find the node with the largest value on front's left subtree
		// and replace front with it.
		else {
			TreeNode replaceNode = findReplacement(front.getLeft());
			if (parent.getLeft() == front)		// if the node we want to delete is on the parents's Left
				parent.setLeft(replaceNode);	// set the Left node to the new node
			else parent.setRight(replaceNode);	// set the Right node to the new node
			replaceNode.setRight(front.getRight());
			if (replaceNode != front.getLeft())	{  // dont want somethings child assiged to itself
				// else we assign the new node to front's children
				replaceNode.setLeft(front.getLeft());
			}
		}	
		
			
	} // end delete
	
		
		
		// traverse to the right and find the bottom node
	private TreeNode findReplacement(TreeNode topNode)	{
		TreeNode maxNode = topNode;		// assume our top is the maxNode
		while (maxNode.getRight() != null)
			maxNode = maxNode.getRight();
		
		return maxNode;
	}	
			
		
	
	
		
	
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
