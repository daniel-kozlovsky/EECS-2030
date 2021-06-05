package eecs2030.lab6;

import java.util.Arrays;
import java.util.List;

/**
 * A utility class containing several recursive methods (Lab 6, F2017)
 * 
 * <pre>
 * 
 * For all methods in this API, you are forbidden to use any loops, nor 
 * String or List based methods such as "contains", or methods that use regular expressions
 * </pre>
 * 
 * @author
 *
 */
public final class RecursiveTasks {

	private RecursiveTasks() {
	}

	/**
	 * getParenthesis returns the component within a given string that is enclosed
	 * in parenthesis
	 * 
	 * <br>
	 * The method assumes there is only a single pair of parenthesis in the string,
	 * and computes the new string recursively, such that the new string is only
	 * made of the parenthesis and their contents.
	 * 
	 * E.g.
	 * 
	 * <pre>
	 * <code>getParenthesis("abcd(xyz)qrst")</code> will return "(xyz)"
	 * </pre>
	 * 
	 * @param str
	 *            the input string (with one pair of parenthesis embedded within)
	 * @return a string made only of the parenthesis and their contents (from str)
	 */
	public static String getParenthesis(String str) {

		String trimmedStr = str;

		if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
			return str;
		} else {
			if (str.charAt(0) != '(') {
				trimmedStr = str.substring(1);
			}

			if (str.charAt(str.length() - 1) != ')') {
				trimmedStr = trimmedStr.substring(0, trimmedStr.length() - 1);
			}
			return getParenthesis(trimmedStr);

		}

	}

	/**
	 * Count the number of co-occurrances of a non-empty sub-string <code>sub</code>
	 * within the string <code>str</code>
	 * 
	 * E.g.
	 * 
	 * <pre>
	 * <code>numOccurances("dogmonkeydog","dog")</code> will return 2
	 * <code>numOccurances("dogmonkeydog","mon")</code> will return 1
	 * <code>numOccurances("dogmonkeydog","cow")</code> will return 0
	 * </pre>
	 * 
	 * @param str
	 *            the given string
	 * @param sub
	 *            a non-empty sub-string
	 * @return the number of times sub occurs in str, without overlap
	 * 
	 */
	public static int numOccurrences(String str, String sub) {

		if (str.length() < sub.length()) {
			return 0;
		}

		if (str.substring(0, sub.length()).equals(sub)) {
			return 1 + numOccurrences(str.substring(sub.length()), sub);
		} else {
			return numOccurrences(str.substring(1), sub);
		}

	}

	/**
	 * Given a string, return true if it is a nesting of zero or more pairs of
	 * balanced parenthesis, like "(())" or "((()))".
	 * 
	 * If the parenthesis are unbalanced, or the string includes characters other
	 * than parenthesis, return false
	 * 
	 * E.g.
	 * 
	 * <pre>
	 * <code>parenthIsNested("(())")</code> will return true
	 * <code>parenthIsNested("((()))")</code> will return true
	 * <code>parenthIsNested("(((x))")</code> will return false
	 * </pre>
	 * 
	 * Hint: check the first and last chars, and then recur on what's inside them.
	 * 
	 * @param str
	 *            - the string (includes zero or more pairs of parenthesis)
	 * @return a boolean value indicating true if the string contains nested and
	 *         balanced parenthesis, false otherwise
	 */
	public static boolean parenthIsNested(String str) {

		if (str.equals("")) {
			return true;
		} else if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
			return parenthIsNested(str.substring(1, str.length() - 1));
		} else {
			return false;
		}

	}

	/**
	 * Generates a list of Circles to be used in drawing a fractal pattern
	 * 
	 * <pre>
	 * This method accepts a List of Circles (see Helper classes Circle.java and
	 * FractalPatterns.java To see how the list of Circles is generated, and how
	 * this method is envoked). You do not to perform any drawing operations in
	 * this task (they are done for you).
	 * 
	 * The method computes the position of, and creates 4 new circles at each
	 * recursion step. Each circle is positioned at the vertical (top and
	 * bottom) and horizontal (left and right) intercepts with a imaginary
	 * circle (centred on x,y and with radius = <code>radius</code>). The radius
	 * of each circle created, is radius/2.
	 * 
	 * The centre position of each newly generated circle will form the centre
	 * of a new set of 4 circles in the next recursive step, each with a reduced
	 * radius of (radius/4), and drawn on the vertical and horizontal intercepts
	 * of its parent circle, and so on (see diagram in lab description).
	 *
	 * </pre>
	 * 
	 * 
	 * @param circles
	 *            a list in which to store circles as they are generated
	 * @param x
	 *            the x coord of the centre of the current set of circles
	 * @param y
	 *            the y coord of the centre of the current set of circles
	 * @param radius
	 *            the radius of the parent circle
	 * @param n
	 *            number of recursive steps to generate circles for
	 * @param mode
	 *            a boolean array [left right up down] indicating which of the 4
	 *            circles will be recursed on
	 */
	public static void genFractal(List<Circle> circles, int x, int y, int radius, int n, boolean[] mode) {

		if (n == 0) {
			return;
		}

		int newRadius = radius / 2;
		int newNLeft = n;
		int newNRight = n;
		int newNTop = n;
		int newNBottom = n;

		// set of 4 per parent circle
		Circle left = new Circle(x - radius, y, newRadius);
		Circle right = new Circle(x + radius, y, newRadius);
		Circle top = new Circle(x, y - radius, newRadius);
		Circle bottom = new Circle(x, y + radius, newRadius);

		circles.add(left);
		circles.add(right);
		circles.add(top);
		circles.add(bottom);

		if (mode[0]) {
			newNLeft--;
			genFractal(circles, x - radius, y, newRadius, newNLeft, mode);
		}
		if (mode[1]) {
			newNRight--;
			genFractal(circles, x + radius, y, newRadius, newNRight, mode);
		}
		if (mode[2]) {
			newNTop--;
			genFractal(circles, x, y - radius, newRadius, newNTop, mode);
		}
		if (mode[3]) {
			newNBottom--;
			genFractal(circles, x, y + radius, newRadius, newNBottom, mode);
		}

	}

	/**
	 * Calculate and determine if there exists a sum of (some) of the elements in an
	 * integer array that is equal to a target value. If there exists a sum, then
	 * return true, otherwise false.
	 * 
	 * Given an array of ints, is it possible to choose a group of some of the ints,
	 * such that the group sums to the given target?
	 * 
	 * Assume this method is always called with a starting index of 0 and a sum of 0
	 * Recursion traverses the array and explores alternative sums
	 * 
	 * <pre>
	 * e.g.
	 * sumSome(0, [2, 4, 8], 10) will return true
	 * sumSome(0, [2, 4, 8], 14) will return true
	 * sumSome(0, [2, 4, 8], 9) will return false
	 * </pre>
	 * 
	 * @param index
	 *            the current position in nums
	 * @param nums
	 *            an array of integers to be considered in the sum
	 * @param sum
	 *            the current sum
	 * @param target
	 *            the value some of the integers in nums should add up to
	 * @return a boolean value indicating that a sum of some of the integers in nums
	 *         equals the target
	 */
	public static boolean sumSome(int index, int[] nums, int sum, int target) {

		/*
		 * boolean sumExists; int[] subArray;
		 * 
		 * 
		 * 
		 * if (sum == target) { sumExists = true; } else if(false)//end of all
		 * permutations { sumExists = false; } else {
		 * 
		 * sum += nums[index]; if(index != nums.length-1) { index++; } else {
		 * if(nums.length == 1) {
		 * 
		 * } else { index = 0; sum = 0; subArray = Arrays.copyOfRange(nums, 1,
		 * nums.length + 1); subArray[subArray.length-1] = nums[0]; //circle shift }
		 * 
		 * 
		 * }
		 * 
		 * 
		 * sumExists = sumSome(index, nums, sum, target);
		 * 
		 * } return sumExists;
		 */
			return true;
	}

}
