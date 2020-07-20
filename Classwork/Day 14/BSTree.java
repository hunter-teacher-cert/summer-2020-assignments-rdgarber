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
			System.out.println(currentValue);
			if (currentValue == key)	// we found it!
				return currentValue;
			else if (currentValue < key)
				current = current.getRight();	// key is higher, must go right
			else // key is lower than current, go left
				current = current.getLeft();
		}
		
		return -1;	// not found
			
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
