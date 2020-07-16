/**
**/

import java.io.*;
import java.util.*;

public class MSort
{


  //return ArrayList of random ints on range [lo,lo+hi)
  public static ArrayList<Integer> prestoArrayListo(int numItems, int lo, int hi)
  {
    ArrayList<Integer> retArr = new ArrayList<Integer>();

    for(int i=0; i<numItems; i++) {
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
    }
    return retArr;
  }//end prestoArrayListo()

  // find and return the index of the smallest value in the
  // ArrayList al from index lo to index hi inclusive
  public static int findSmallest(ArrayList<Integer> al, int lo, int hi){
    int maxIndexSoFar = lo;
    for (int i = lo; i <=hi; i++) {
      if (al.get(i) < al.get(maxIndexSoFar)){
        maxIndexSoFar = i;
      }
    }
    return maxIndexSoFar;
  }

  public static void selectionSort(ArrayList<Integer> al) {

    int lo = 0;
    int temp;

    for (int i=0; i < al.size() - 1; i++) {
      lo = findSmallest(al, i, al.size()-1);
      temp = al.get(i);
      al.set(i, al.get(lo));
      al.set(lo, temp);
    }

  }//selectionSort

  //returns a sublist of al containing the elements at indices in the range [lo, hi)
  public static ArrayList<Integer> slice(ArrayList<Integer> al, int lo, int hi) {

    ArrayList<Integer> sub = new ArrayList<Integer>();
    for (; lo < hi; lo++) {
      sub.add( al.get(lo) );
    }//copy
    return sub;
  }//slice


  //Input: 2 SORTED ArrayLists
   //returns 1 new SORTED ArrayList containing all the elements from lists a and b
  public static ArrayList<Integer> merge(ArrayList<Integer> a,
                                         ArrayList<Integer> b) {
    //setup variables
	int indexA = 0;
	int indexB = 0;
    //   make a new ArrayList
	ArrayList<Integer> retArr = new ArrayList<Integer>();
    //   indices for each input

    //while both indices are less than their respective lengths
	while (indexA < a.size() || indexB < b.size())	{
    //compare current index elements of each input list
		if (indexA >= a.size())	// we are done with Array a, so we only have array B to worry about
			retArr.add(b.get(indexB++));
		else if (indexB >= b.size())	// we are done with Array b, so we only have array a to worry about
			retArr.add(a.get(indexA++));
    //add the smaller value to the new list
		else if (a.get(indexA) < b.get(indexB)) 	  // The current Array a element is the smallest
			retArr.add(a.get(indexA++));
		else	// The current Array b element is the smallest or equal to the current element in Array A
			retArr.add(b.get(indexB++));
		// at this point we have automatically updated the index of the Array that we used.
	}  //loop ends: both indices are past the end of the list
    //return the new list
    return retArr;
  }// end merge


  public static void main( String[] args )
  {
    ArrayList<Integer> rando = prestoArrayListo(10, 0, 100);
    ArrayList<Integer> calrissian = prestoArrayListo(10, 0, 100);

    selectionSort(rando);
    selectionSort(calrissian);

    System.out.printf("rando: %s\n", rando);
    System.out.printf("calrissian: %s\n", calrissian);

    ArrayList<Integer> randoCalrissian = merge(rando, calrissian);
    System.out.printf("randoCalrissian: %s\n", randoCalrissian);

  }//end main

}//end class
