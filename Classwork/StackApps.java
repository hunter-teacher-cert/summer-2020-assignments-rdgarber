import java.io.*;
import java.util.*;
  
 // Stack Application
 public class StackApps {
 
	
 
	// Returns s in reverse order
	public static String reverse(String s)  	{
		
		String newString = "";
		int strLength;
		
		if (s == null)
			throw new  NullPointerException("Invalid null string");
		
			
		Stack<Character> StringStack = new Stack<Character>();
		strLength = s.length();
		
		// push each character onto the stack		
		for (int i=0; i<strLength; i++)
			StringStack.push(s.charAt(i));  
		
		// now we pull it off, one char at a time, to create the new string 
		// in reverse, since stacks work LIFO
		for (int i=0; i<strLength; i++)	
			newString += StringStack.pop();  
			
		return newString;
		
	} // end reverse
	
	// Returns true or false depending on whether s is a paendrome (can be read the same forward & backward).
	// Example palendromes:  "racecar" or "able was i ere i saw elba"
	public static boolean isPalindrome(String s)	{
		
		int strLength;
		int i;
		
		if (s == null)
			throw new  NullPointerException("Invalid null string");

		strLength = s.length();		
		// could try reversing string and see if they are the same
		String revString = reverse(s);
		for (int j = 0; j<strLength; j++)
			if (revString.charAt(j) != s.charAt(j))
				return false;
		
		return true;
		
		
		
		
/*

		// our plan is to push up until half the characters onto the stack
		// then pop them off the stack and see if they match character for
		// character the rest of the string
		// if there are an odd number of chars, we ignore the middle one
		
		Stack<Character> StringStack = new Stack<Character>();
		strLength = s.length();
		
		// push each character onto the stack		
		for (i = 0; i<strLength/2; i++)  // this will not include the middle
			StringStack.push(s.charAt(i));  // char if there are odd num of chars
		
		// if we have an odd number of chars, lets skip the middle
		if (strLength % 2 == 1)	// this means an odd num of chars
			i++;	// increment the counter
		
		// Finally, we pop each char off the stack and see
		// if each char matches the rest of the string
		for (int j=i; j<strLength; j++)  
			if (StringStack.pop() != s.charAt(j)) 
				return false;
			
		return true;	// if we got down to here then we have a pallindrome
		
	*/	
		
	} // end isPallindrome
	
	
	/*
	Assume s is a string representing a mathematical expression.
	Limit the expression to containing letters, numbers and the following characters: ()+-/*
	Returns true if the parentheses in the expression are matched accurately.
	This should just check valid parentheses matching, ignoring any other potential syntax issues.
	*/
	
	public static boolean parenCheck(String s)	{
		
		int strLength;
		int parenCount = 0;    // count parens
		int squareCount = 0;  // count of Square Brackets []
		int squigglyCount = 0;	// count of squiggly Brackets {}
		
		if (s == null)
			throw new  NullPointerException("Invalid null string");
		
		strLength = s.length();		
		// as we go through the chars add each time we encounter one of our
		// special chars, we either add 1 or subtract 1
		// if any count goes below zero we have an error
		for (int i=0; i<strLength; i++)	{
			if (s.charAt(i) == '(')
				parenCount++;
			if (s.charAt(i) == ')')
				parenCount--;	
			if (s.charAt(i) == '[')
				squareCount++;
			if (s.charAt(i) == ']')
				squareCount--;	
			if (s.charAt(i) == '{')
				squigglyCount++;
			if (s.charAt(i) == '}')
				squigglyCount--;
			if (parenCount < 0 || squareCount < 0 || squigglyCount< 0 )
				return false;
		}
			
		
		// both counts must be 0 if we are in balance
		return parenCount == 0 && squareCount == 0 && squigglyCount == 0;
		
		
		
	} // end parenCheck
	
 
	public static void main(String[] args) {
		
		String testString = "Rhinocerous";
		String testString2 = "able was i ere i saw elba";
		String testString3 = "MarkkraM";
		String ptestString1 = "(abc{def})";
		String ptestString2 = "(abc[{def})";

		
		
		
		
	
				
		System.out.println("Start with string " + testString);
		
		System.out.println("Reversed string is: "+ reverse(testString));
		//System.out.println(isPalindrome(testString));
		System.out.printf("Palindrome check: %s, : %b\n", testString, isPalindrome(testString));
		System.out.printf("Palindrome check: %s, : %b\n", testString2, isPalindrome(testString2));
		System.out.printf("Palindrome check: %s, : %b\n", testString3, isPalindrome(testString3));
		System.out.printf("Paren check: %s, : %b\n", ptestString1, parenCheck(ptestString1));
		System.out.printf("Paren check: %s, : %b\n", ptestString2, parenCheck(ptestString2));


		
		
 
	} // end main
	
 }  // end StackApps