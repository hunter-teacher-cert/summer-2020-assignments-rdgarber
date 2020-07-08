import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
	
	System.out.println("Begin");
	
	/* Driver for testing Time
	Time curtime = new Time(11,59, 59.9);
	Time newtime = new Time(11,49, 59.2);
	Time.printTime(curtime);
	System.out.println(newtime);
	System.out.println(curtime.add(newtime));
	System.out.println(curtime);
	System.out.println(curtime.increment(2));
	System.out.println(curtime);
	*/
	
	LList myList = new LList(); 
	// print out our empty list
	System.out.println("Is our list empty? " + myList.isEmpty());
	System.out.println(myList);
	myList.addFront("Third");
	System.out.println("Is our list empty? " + myList.isEmpty());
	System.out.println(myList);
	myList.addFront("Second");
	System.out.println("Is our list empty? " + myList.isEmpty());
	System.out.println(myList);
	myList.addFront("First");
	System.out.println("Is our list empty? " + myList.isEmpty());
	System.out.println(myList);
	for (int i=0; i < 4; i++)	{
			System.out.printf("Item #%d is: %s\n",i, myList.get(i));
		
	}	
	// tests setting value
	for (int i=0; i < 4; i++)	 {
			System.out.printf("Setting Item #%d:\n",i);
			myList.set(i, "New " +Integer.toString(i) );
	}
	for (int i=0; i < 4; i++)	
			System.out.printf("Item #%d is: %s\n",i, myList.get(i));

	
		
	} // end main
	
	
  
}
