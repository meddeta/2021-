n/**********************************************************
 * EECS2101A: Fundamentals of Data Structures,  Fall 2023
 * Assignment 1, Problem 2: ArrayLongestPlateau.java
 * Student Name:   Melika Sherafat
 * Student EECS account:  meddeta
 * Student ID number:  218970871
 **********************************************************/

package A1;

/**
 * The `ArrayLongestPlateau` class is designed to find the longest plateau within an array of integers.
 * A plateau in this context is defined as a contiguous subarray within the input array where all elements
 * have the same value.
 * 
 * The main method of this class runs a series of test cases to verify the correctness of the `longestPlateau` method.
 * 
 * @author Melika Sherafat
 * @version 1.0
 * 
 * @see ArrayLongestPlateau#longestPlateau(int[])
 */

public class ArrayLongestPlateau {

	/**
     * The `longestPlateau` method finds and returns the longest plateau within the given array of integers.
     * 
     * @param ints the input array of integers in which to find the longest plateau.
     * @return an array of integers in the form {value, start, len}, where:
     *         - `value` is the common element value within the plateau.
     *         - `start` is the starting index of the longest plateau.
     *         - `len` is the length of the longest plateau.
     *         
     *         If there is no plateau in the input array, an empty array is returned.
     */

	public static int[] longestPlateau(int[] ints) {

	    int longestvalue = ints[0];
	    int longeststart = 0;
	    int longestlength = 1;
		
		if (ints == null || ints.length == 0) {
	        return new int[]{};
	    }
		if (ints.length==1) {
		    return new int[]{longestvalue, longeststart, longestlength};
			
		}


	    int curstart = 0;
	    int curlength = 1;
	    boolean isplateauvalid = true;

	    for (int i = 1; i < ints.length; i++) {
	        if (ints[i] == ints[i - 1]) {
	            curlength++;
	        } else {
	        	if (ints[i]>ints[i-1]) {
	        		isplateauvalid = false;
	        	}
	            if (curlength > longestlength && isplateauvalid) {
	            	longestvalue = ints[i - 1];
	            	longeststart = curstart;
	            	longestlength = curlength;
	            }
	            curstart = i;
	            curlength = 1;
	            isplateauvalid = true;
	        }
	        
	        if (i > 0 && ints[i] < ints[i - 1]) {
	        	isplateauvalid = false;
	        }
	    }

	    if (curlength > longestlength && isplateauvalid) {
	    	longestvalue = ints[ints.length - 1];
	    	longeststart = curstart;
	        longestlength = curlength;
	    }

	    
	    if (longestlength > 1) {
	        return new int[]{longestvalue, longeststart, longestlength};
	    } else {
	        return new int[]{}; 
	    }
        }

		// TODO: Replace the following one line stub with your solution. Ours is in-place, takes linear time,
		// and is less than 25 lines long, not counting blank/comment lines or lines already present in this file.


	
	/**
     * The `main` method runs test cases on the `longestPlateau` method to validate its correctness.
     * It prints the results of the tests and provides information about the longest plateau found.
     * If any test fails, it will output an error message.
     * 
     * @param args command-line arguments (not used in this program).
     */
	public static void main(String[] args) {
		String result;

		System.out.println("Let's find longest plateaus of arrays!\n");

		int[] test1 = { 4, 1, 1, 6, 6, 6, 6, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test1) + ":");
		result = TestHelper.stringInts(longestPlateau(test1));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 3 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test2 = { 3, 3, 1, 2, 4, 2, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test2) + ":");
		result = TestHelper.stringInts(longestPlateau(test2));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 3 , 0 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test3 = { 3, 3, 1, 2, 4, 0, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test3) + ":");
		result = TestHelper.stringInts(longestPlateau(test3));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 1 , 6 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test4 = { 3, 3, 3, 4, 1, 2, 4, 4, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test4) + ":");
		result = TestHelper.stringInts(longestPlateau(test4));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test5 = { 7, 7, 7, 7, 9, 8, 2, 5, 5, 5, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test5) + ":");
		result = TestHelper.stringInts(longestPlateau(test5));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 5 , 7 , 3 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test6 = { 4 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test6) + ":");
		result = TestHelper.stringInts(longestPlateau(test6));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 0 , 1 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test7 = { 4, 4, 4, 5, 5, 5, 6, 6 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test7) + ":");
		result = TestHelper.stringInts(longestPlateau(test7));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		System.out.println("\nAdditional tests done by the student or TA:\n");

		
	}
}