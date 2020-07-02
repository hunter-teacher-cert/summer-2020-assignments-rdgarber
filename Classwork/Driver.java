import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
	
	System.out.println("Begin");
	Time curtime = new Time(11,59, 59.9);
	Time newtime = new Time(11,49, 59.2);
	Time.printTime(curtime);
	System.out.println(newtime);
	System.out.println(curtime.add(newtime));
	System.out.println(curtime);
	System.out.println(curtime.increment(2));
	System.out.println(curtime);
	
		
	} // end main
	
  
}
