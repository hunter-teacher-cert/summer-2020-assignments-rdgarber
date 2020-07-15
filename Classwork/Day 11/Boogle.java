/**
   classwork -- Day 10 | 0b1010 | 0x10

   class: Boogle

   A tester class for code analysis and search exploration.

   USAGE:
   Read through at least once.
   Compile, run.
   Comment/uncomment lines, recompile, run to explore functionality.
   "Lather, rinse, repeat" until comprehension achieved.
   Rename methods to indicate purpose.
   Insert comment preceding each method to summarize functionality.

   T. Mykolyk, F. Dragon
   June 2020
**/

import java.io.*;
import java.util.*;

public class Boogle
{

  //return index of first occurence of target, or -1 if not found
  public static int linSearch( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) {
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }//end linSearch()








  //return index of target, or -1 if not found
  public static int binSearch( ArrayList al, int target )
  {
    if (al.size() < 1)
		return -1; //placeholder to get past compiler
		
		
	int bottom = 0;
	int top = al.size()-1;
		
	return (binary(al, target, bottom, top));
		
  }//end binSearch()

	// this is the recursive binary search
	static int binary(ArrayList al, int target, int bottom, int top) {
		
		int middle = (top + bottom)/2;
		int newtop = top;		// assume this will not change
		int newbot = bottom;	// assume new bottom will be the same as the old one
		
		// System.out.printf("middle = %d\n", middle);
		
		if (al.get(middle).equals(target))
			return middle;		/// we found it!
		if (top <= bottom)
			return -1;		// we did not find anything
		if ((int) al.get(middle) < target)	{  //we are too low
			newbot = middle + 1;
		}
		else if ((int) al.get(middle) > target)	{ // we are too high
			newtop = middle - 1;
		}
		// System.out.printf("newbot = %d, newtop = %d\n", newbot, newtop);
		return binary(al, target, newbot, newtop);   // recursively do it again
	}
		

		
		
	
  // subgoal: recognize target found (and take what action?)
  // subgoal: recognize search space exhausted (and take what action?)
  // subgoal: recognize target in lower portion of range (and do what?)
  // subgoal: recognize target in upper portion of range (and do what?)

  //nota bene: A helper method could be very useful.
  // Q: Why?
  // Q: What would the parameters be for such a method?



  //return ArrayList of random ints on range [lo,lo+hi)
  public static ArrayList prestoArrayListo(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    for(int i=0; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
    }
    return retArr;
  }//end prestoArrayListo()


  //return ArrayList of random ints, sorted in ascending order
  public static ArrayList prestoSortedArrayListo(int numItems,
                                                 int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    //if requested, return empty ArrayList
    if ( numItems<1 )
      return retArr;

    //populate index 0
    retArr.add( (int)(lo * Math.random()) );

    //populate rest of indices, each one greater than last
    for(int i=1; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
      //System.out.println(retArr.get(i-1));
      retArr.add( (int)retArr.get(i-1)
                  + lo + (int)(hi * Math.random()) ); // ["left neighbour",hi)
    }

    return retArr;
  }//end prestoSortedArrayListo()


	public static void newsort(ArrayList al)   {
		
		int smallest;
		int temp;
		int size = al.size();  // keep track of the # of elements in the arraylist
		for (int index = 0; index < size -1; index++)  {
			// now we find the minimum value for the current region
			// which is  from index  to size -1 .
			smallest = findSmallest(al, index, size -1);
			if (smallest != index)   {  // if we are at the smallest already, we are good so just move on
				// swap
				temp = (int) al.get(index);  // store 1st item
				al.set(index, al.get(smallest));  // put the smallest first
				al.set(smallest, temp);	// now put the former first where the smmallest was
				// end swap
			}	
		}	
			
	}
	
	  //##################################################
  //##################################################

    // find and return the index of the smallest value in the
    // ArrayList al from index lo to index hi inclusive 
    public static int findSmallest(ArrayList<Integer> al, int lo, int hi){
	// assume the first item is the smallest - call it our smallest so far
		int minValue = (int) al.get(lo);
		int minIndex = lo;
		for (int i=lo+1; i<=hi && i<al.size(); i++){
			if ((int) al.get(i) < minValue)	{
				minValue = (int) al.get(i);
				minIndex = i;
			}
			
			
		}	
		return minIndex;
	}
	
	

  public static void main( String[] args )
  {
	  
	  // test cases for sort

	// my test cases.....
	ArrayList test = new ArrayList();

// test 1 - Already in order
	test.add(0);
	test.add(3);
	test.add(14);
	test.add(29);
	test.add(63);
	System.out.println("Before Sort: " + test);
	newsort(test);
	System.out.println("After Sort: " + test);
// test 2 - In Reverse Order
	test.clear();
	test.add(63);
	test.add(29);
	test.add(14);
	test.add(3);
	test.add(0);
	System.out.println("Before Sort: " + test);
	newsort(test);
	System.out.println("After Sort: " + test);
	test.add(2);   // add a sixth element at the end
	System.out.println("Before Sort: " + test);
	newsort(test);
	System.out.println("After Sort: " + test);
	  
	  
    // Now lets generate random lists and sort them.
	System.out.println("\n"+"al000"+":");
    ArrayList al000 = prestoArrayListo(0,0,0);
    System.out.println("Before Sort: " + al000);
	newsort(al000);
	System.out.println("After Sort: " + al000);

    System.out.println("\n"+"al01"+":");
    ArrayList al01 = prestoArrayListo(5,0,100);
    System.out.println("Before Sort: " + al01);
 	newsort(al01);
	System.out.println("After Sort: " + al01);

    System.out.println("\n"+"al02"+":");
    ArrayList al02 = prestoArrayListo(5,3,10);
	System.out.println("Before Sort: " + al02);
	newsort(al02);
	System.out.println("After Sort: " + al02);

    System.out.println("\n"+"al05"+":");
    ArrayList al05 = prestoArrayListo(20,1,5);
    System.out.println("Before Sort: " + al05);
	newsort(al05);
	System.out.println("After Sort: " + al05);
	
	System.out.println("\n"+"al06"+":");
    ArrayList al06 = prestoArrayListo(24,1,1000);
    System.out.println("Before Sort: " + al06);
	newsort(al06);
	System.out.println("After Sort: " + al06);
	
	/*
    System.out.println("\n"+"al000"+":");
    ArrayList al000 = prestoArrayListo(0,0,0);
    System.out.println(al000);
    System.out.println(linSearch(al000,3));

    System.out.println("\n"+"al01"+":");
    ArrayList al01 = prestoArrayListo(5,0,100);
    System.out.println(al01);
    System.out.println(linSearch(al01,3));

    System.out.println("\n"+"al02"+":");
    ArrayList al02 = prestoArrayListo(5,3,10);
    System.out.println(al02);
    System.out.println(linSearch(al02,3));

    System.out.println("\n"+"al05"+":");
    ArrayList al05 = prestoArrayListo(20,1,5);
    System.out.println(al05);
    System.out.println(linSearch(al05,3));
      ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

 /* Test cases for binary search ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 
    ArrayList salamander = new ArrayList();

    //explicitly fill arraylist with intent to search for
    // present and nonpresent values...
    // generate an arraylist with an odd num of elems...
    salamander.add(4);
    salamander.add(8);
    salamander.add(15);
    salamander.add(16);
    salamander.add(23);
    System.out.println(salamander);

    //search for target in the list
    System.out.println(binSearch(salamander, 8));  // 1
    System.out.println(binSearch(salamander, 15)); // 2
    System.out.println(binSearch(salamander, 16)); // 3

    //search for target not in the list
    System.out.println(binSearch(salamander, 3)); // -1
    System.out.println(binSearch(salamander, 9)); // -1

    //add another element, for an even num of elems
    salamander.add(42);
    System.out.println(salamander);
    //search for target in the list
    System.out.println(binSearch(salamander, 8));  // 1
    System.out.println(binSearch(salamander, 15)); // 2
    System.out.println(binSearch(salamander, 16)); // 3

    //search for target not in the list
    System.out.println(binSearch(salamander, 3)); // -1
    System.out.println(binSearch(salamander, 9)); // -1

  
	// my test cases.....
	ArrayList test = new ArrayList();
	test.add(0);
	test.add(3);
	test.add(14);
	test.add(29);
	test.add(63);
	System.out.println(test);
	System.out.println(linSearch(test,3));
    System.out.println(binSearch(test,3));
	test.clear();
	test.add(3);
	test.add(9);
	test.add(14);
	test.add(29);
	test.add(63);
	System.out.println(test);
	System.out.println(linSearch(test,3));
    System.out.println(binSearch(test,3));
	test.clear();
	test.add(0);
	test.add(3);
	test.add(9);
	test.add(29);
	test.add(63);
	System.out.println(test);
	System.out.println(linSearch(test,9));
    System.out.println(binSearch(test,9));
	test.clear();
	test.add(0);
	test.add(3);
	test.add(9);
	test.add(29);
	test.add(63);
	System.out.println(test);
	System.out.println(linSearch(test,63));
    System.out.println(binSearch(test,63));

	 end test cases for binary search ~~~~~~~~~~~~~~~~~~~~~~*/

 // test battery using sorted ArrayLists as search space
   /*
    System.out.println("\n"+"sal000"+":");
    ArrayList sal000 = prestoSortedArrayListo(0,0,0);
    System.out.println(sal000);
    System.out.println(linSearch(sal000,3));
    System.out.println(binSearch(sal000,3));

    System.out.println("\n"+"sal00"+":");
    ArrayList sal00 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal00);
    System.out.println(linSearch(sal00,3));
    System.out.println(binSearch(sal00,3));

    System.out.println("\n"+"sal01"+":");
    ArrayList sal01 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal01);
    System.out.println(linSearch(sal01,3));
    System.out.println(binSearch(sal01,3));

    System.out.println("\n"+"sal02"+":");
    ArrayList sal02 = prestoSortedArrayListo(5,3,100);
    System.out.println(sal02);
    System.out.println(linSearch(sal02,3));
    System.out.println(binSearch(sal02,3));

    System.out.println("\n"+"sal03"+":");
    ArrayList sal03 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal03);
    System.out.println(linSearch(sal03,3));
    System.out.println(binSearch(sal03,3));

    System.out.println("\n"+"sal04"+":");
    ArrayList sal04 = prestoSortedArrayListo(20,0,3);
    System.out.println(sal04);
    System.out.println(linSearch(sal04,3));
    System.out.println(binSearch(sal04,3));

    System.out.println("\n"+"sal05"+":");
    ArrayList sal05 = prestoSortedArrayListo(20,1,5);
    System.out.println(sal05);
    System.out.println(linSearch(sal05,3));
    System.out.println(binSearch(sal05,3));
     */

    //batch of commands for easier test case generation:
    /*
    System.out.println("\n"+"al"+":");
    ArrayList al = prestoArrayListo(,,);
    System.out.println(al);
    System.out.println(linSearch(al, ));
    System.out.println(binSearch(al, ));
    */
  }//end main

}//end class
