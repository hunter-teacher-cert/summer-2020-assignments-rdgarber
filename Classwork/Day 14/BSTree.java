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
	
		// Search the tree for a specific key
	public void insert(int key) {
		TreeNode t;
		TreeNode current = root;
		TreeNode parent;		// keep track of the parent
		
		t = new TreeNode(key);	// create our new node;
		if (current == null) { // there is no root
			// make this the root;
			root = t;
			return;		// we are done
		}
		
		while (current != null)		{  // traverse the tree until we get a null
			parent = current;	// keep track of this when we find a null
			int currentValue = current.getData();
			if (currentValue == key)	// we found it!
				throw new IllegalArgumentException("Node with key " + key + " already exists");
			else if (currentValue < key)  {
				current = current.getRight();	// key is higher, must go right
				if (current == null) // this is where the key should have been if it had existed
					parent.setRight(t);	// add the new node to the tree here
			}
			else    {// key is lower than current, go left
				current = current.getLeft();
				if (current == null) // this is where the key should have been if it had existed
					parent.setLeft(t);	// add the new node to the tree here
			}
		}
	
			
	} // end search
	 

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
