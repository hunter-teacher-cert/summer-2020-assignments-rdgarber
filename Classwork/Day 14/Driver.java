import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) {
	BSTree t = new BSTree();
	
	/*
	t.seed();
	System.out.printf("Search for 8: %s\n",t.search(8));
	System.out.printf("Search for 9: %s\n",t.search(9));
	System.out.printf("Search for 22: %s\n",t.search(22));
	System.out.printf("Search for 21: %s\n",t.search(21));
	System.out.printf("Search for 20: %s\n",t.search(20));
	
	int value;

		value = t.search(10);
		System.out.println(value);

		value = t.search(15);
		System.out.println(value);

		try {
			value = t.search(17);
			System.out.println(value);
		} catch (NullPointerException e) {
			System.out.println("17 not in tree");
		}
    }
	*/

		t.insert(10);
		t.insert(20);
		t.insert(5);
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.insert(25);

		printallTraverse(t);
		
		t.delete(25);
		printallTraverse(t);
		t.insert(25);
		t.delete(3);
		printallTraverse(t);
		t.insert(3);
		t.delete(5);
		printallTraverse(t);
		t.insert(5);
		
		
		printallTraverse(t);
		
	/*	
		t.delete(10);
		printallTraverse(t);
	*/	
	}
	
	static void printallTraverse(BSTree t)	{
		t.preorderTraverse();
		t.postorderTraverse();
		t.inorderTraverse();
		
		
	}	
}	
