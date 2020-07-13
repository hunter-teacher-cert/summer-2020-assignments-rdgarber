import java.io.*;
import java.util.*;

public class StackDriver {
  public static void main(String[] args) {

    System.out.println("Begin test");
	MyStack g = new MyStack();

    printdiags(g);
	
	
    System.out.println(g.isEmpty());


    System.out.println("\nTest addFront 3x & isEmpty():");
    
	//g.push(null); // try pushing null - this works we got an exception
	g.push("good");
    g.push("news");
    g.push("everyone!");
    printdiags(g);
	System.out.println(g.isEmpty());

   g.pop();
   printdiags(g);
    g.pop();
   printdiags(g);
    g.pop();
   printdiags(g);
    g.pop();
   printdiags(g);


   

  }//main
  
    static void printdiags(MyStack g)    {
		
		System.out.printf("Stack Diagnostics: size: %d, top is =[%s], listing: %s\n",g.size(), g.top(), g.toString());
    
	}
	
}//StackDriver
