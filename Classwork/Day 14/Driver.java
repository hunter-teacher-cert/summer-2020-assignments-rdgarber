import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) {
	BSTree t = new BSTree();
	
	t.seed();
	System.out.printf("Search for 8: %s\n",t.search(8));
	System.out.printf("Search for 9: %s\n",t.search(9));
	System.out.printf("Search for 22: %s\n",t.search(22));
	System.out.printf("Search for 21: %s\n",t.search(21));
	System.out.printf("Search for 20: %s\n",t.search(20));
	
	
    }
}
