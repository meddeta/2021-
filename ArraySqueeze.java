/**********************************************************
 * EECS2101A: Fundamentals of Data Structures,  Fall 2023 
 * Assignment 1, Problem 1: ArraySqueeze.java
 * Student Name:   Melika Sherafat
 * Student EECS account:  meddeta
 * Student ID number:  218970871
 **********************************************************/

package A1;

/**
 * The `ArraySqueeze` class provides a method to squeeze an array of integers
 * by removing consecutive duplicate numbers and filling any unused elements at
 * the end of the array with -1.
 * <p>
 * The main method of this class runs some tests to verify the functionality of
 * the `squeeze` method.
 * <p>
 * The squeeze() method takes an array of ints and modifies it in-place to
 * ensure that no two consecutive numbers in the array are the same. It also
 * fills any unused elements at the end of the array with -1.
 * <p>
 * For example, if the input array is [4, 1, 1, 3, 3, 3, 1, 1], after calling
 * squeeze(), the array becomes [4, 1, 3, 1, -1, -1, -1, -1].
 * <p>
 * The squeeze algorithm has a time complexity of O(n), where n is the length
 * of the input array.
 *
 * @author Melika Sherafat
 * @version 1.0
 * @see A1.TestHelper
 */

public class ArraySqueeze {

	/**
     * squeeze() takes an array of ints and modifies it to remove consecutive
     * duplicate numbers, replacing them with a single copy of the number. It also
     * fills any unused elements at the end of the array with -1.
     *
     * @param ints the input array to be squeezed.
     */

	public static void squeeze(int[] ints) {

		// TODO: Fill in your solution here. Ours is in-place, takes linear time, and is less than
		// 10 lines long, not counting blank/comment lines or lines already present in this file.
		if (ints.length == 0) {
	        return;
	    }

	    int cur = ints[0];
	    int wid = 1;

	    for (int rid = 1; rid < ints.length; rid++) {
	        if (ints[rid] != cur) {
	        	ints[wid] = ints[rid];
	            cur = ints[rid];
	            wid++;
	        }
	    }

	    
	    for (int i = wid; i < ints.length; i++) {
	    	ints[i] = -1;
	    }

	}

	/**
     * main() runs test cases on the squeeze() method and prints summary
     * information on basic operations.
     *
     * @param args command line arguments (not used).
     */
	public static void main(String[] args) {
		String result;

		System.out.println("Let's squeeze arrays!\n");

		int[] test1 = { 3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5 };
		System.out.println("squeezing " + TestHelper.stringInts(test1) + ":");
		squeeze(test1);
		result = TestHelper.stringInts(test1);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 3 , 7 , 4 , 5 , 2 , 0 , 8 , 5 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test2 = { 6, 6, 6, 6, 6, 3, 6, 3, 6, 3, 3, 3, 3, 3, 3 };
		System.out.println("squeezing " + TestHelper.stringInts(test2) + ":");
		squeeze(test2);
		result = TestHelper.stringInts(test2);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 6 , 3 , 6 , 3 , 6 , 3 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test3 = { 4, 4, 4, 4, 4 };
		System.out.println("squeezing " + TestHelper.stringInts(test3) + ":");
		squeeze(test3);
		result = TestHelper.stringInts(test3);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 4 , -1 , -1 , -1 , -1 ]"), "BAD SQEEZE!!!  No cookie.");

		int[] test4 = { 0, 1, 2, 3, 4, 5, 6 };
		System.out.println("squeezing " + TestHelper.stringInts(test4) + ":");
		squeeze(test4);
		result = TestHelper.stringInts(test4);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 0 , 1 , 2 , 3 , 4 , 5 , 6 ]"), "BAD SQEEZE!!!  No cookie.");

		System.out.println("\nAdditional tests done by the student or TA:\n");

		
	}
}