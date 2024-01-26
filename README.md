# ArrayLongestPlateau
Overview
ArrayLongestPlateau is a Java class designed to identify the longest plateau within an array of integers. A plateau is defined as a sequence of adjacent elements in the array that are all equal.

Features
Find Longest Plateau: Analyzes an integer array to find the longest plateau.
Edge Case Handling: Efficiently handles edge cases like null, empty, and single-element arrays.
Test Cases: Includes a main method with multiple test cases for validation.
Usage
To use ArrayLongestPlateau, include it in your Java project and call the longestPlateau method with an integer array as an argument. The method returns an array with the value of the plateau, its starting index, and its length.

java
Copy code
int[] myArray = {1, 2, 2, 3, 3, 3, 1};
int[] plateau = ArrayLongestPlateau.longestPlateau(myArray);
System.out.println("Plateau Value: " + plateau[0] + ", Start: " + plateau[1] + ", Length: " + plateau[2]);
Contributing
Contributions, issues, and feature requests are welcome. Feel free to check issues page if you want to contribute.

License
Distributed under the MIT License. See LICENSE for more information.
#ArraySqueeze
Overview
ArraySqueeze is a Java utility that offers an efficient way to "squeeze" an array of integers. This operation involves removing consecutive duplicate elements from the array and filling the unused spaces at the end of the array with -1.

Features
In-Place Modification: The array is modified in place, reducing the need for additional memory allocation.
Linear Time Complexity: The squeezing algorithm operates in O(n) time, making it efficient for large arrays.
Versatility: Can be used on any array of integers, regardless of size or content.
Getting Started
Prerequisites
Java Development Kit (JDK) - Version 8 or higher recommended.
Installation
No installation is required. Just ensure that the Java files are in your Java project.

Usage
To use ArraySqueeze, simply create an instance of the class and call the squeeze method with an integer array as an argument. For example:

java
Copy code
int[] myArray = {1, 1, 2, 3, 3, 3, 4};
ArraySqueeze.squeeze(myArray);
After the squeeze method is called, myArray will be modified to [1, 2, 3, 4, -1, -1, -1].

Testing
The main method in ArraySqueeze.java includes test cases that demonstrate the functionality and verify the correctness of the squeezing algorithm.



#TestHelper
Overview
TestHelper.java is a utility class designed to assist in testing and debugging Java applications, particularly for the course EECS2101A: Fundamentals of Data Structures. It provides two main functionalities: converting an array of integers into a string representation, and a method to verify invariants with error reporting.

Features
String Conversion of Integer Arrays
stringInts(int[] ints): Converts an array of integers (ints) into a string format. This method ensures efficient processing in O(n) time by using StringBuilder.
Output Format: The array [1, 2, 3] is converted to a string as "[ 1 , 2 , 3 ]".
Invariant Verification
verify(boolean invariant, String message): Checks whether a provided invariant is true. If false, it prints a specified error message and a stack trace for debugging.
This method is useful for asserting conditions in your code and automatically reporting when these conditions fail.
Usage
Including in Your Project
Place TestHelper.java in your project's directory, typically within a package. For instance, in the package A1, as indicated by the package A1; line at the top of the file.

Using stringInts
java
Copy code
int[] array = {1, 2, 3};
String arrayString = TestHelper.stringInts(array);
System.out.println(arrayString); // Outputs: "[ 1 , 2 , 3 ]"
Using verify
java
Copy code
int a = 5;
int b = 3;
TestHelper.verify(a > b, "a should be greater than b");
// If a is not greater than b, an error message is printed along with a stack trace.
Notes
Designed for educational purposes in the context of EECS2101A.
The verify method is particularly useful for implementing test cases and ensuring your code adheres to specified conditions.
#Window.java
Overview
Window.java is a Java class that represents rectangular windows in a 2D space. It allows for the creation of window objects with specified coordinates and provides methods to check for overlaps and enclosures between these windows.

Features
Window Creation: Instantiate windows with specific left, right, bottom, and top coordinates.
Coordinate Validation: Ensures the creation of valid windows where the left coordinate is less than the right and the bottom is less than the top.
Coordinate Manipulation: Getters and setters for all four coordinates with validation checks.
Overlap Detection: Method to check if two windows overlap each other.
Enclosure Detection: Method to determine if one window encloses another.
Bulk Operations: Static methods to calculate the number of overlapping pairs and the number of enclosures among an array of windows.
Requirements
Java Development Kit (JDK) 8 or higher.
Installation
No installation is needed. Just include Window.java in your Java project.

Usage
To use the Window class:

Include the file in your Java project.
Create Window objects by specifying their left, right, bottom, and top coordinates.
Use the methods provided to manipulate window coordinates and check for overlaps and enclosures.
Example
java
Copy code
Window w1 = new Window(0, 5, 0, 5);
Window w2 = new Window(1, 4, 1, 4);
// Check if w1 overlaps with w2
boolean isOverlap = w1.overlaps(w2);
Error Handling
The class includes a custom exception InvalidWindowException that is thrown when an attempt to create an invalid window or set invalid coordinates is made.

Author
Melika Sherafat
