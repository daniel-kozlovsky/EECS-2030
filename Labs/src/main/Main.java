package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		int[] s = new int[]{1,2,3,4}, subs = new int[s.length]; 
		printAllSubsets(s, subs, 0);
	}
	
	
	public static void printAllSubsets(int[] set, int[] subset, int i)
	{
		
		if(i == set.length)
		{
			for(int x : subset)
			{
				if(x != -1)
				System.out.print(x + " ");
			}
			System.out.println();
		}
		else
		{
			subset[i] = -1;
			printAllSubsets(set, subset, i+1);
			subset[i] = set[i];
			printAllSubsets(set, subset, i+1);
		}
	}
	public static double median(int[] nums1, int[] nums2)
	{
		double median = 0;
		
		int totalSize = nums1.length + nums2.length;
		int n1 = 0, n2 = 0;
		int halfIndex = (int) (Math.floor(totalSize/2));
		int[] count = new int[halfIndex+1];
		for(int i = 0; i< halfIndex+1;i++)
		{
			if(n1 < nums1.length && n2 < nums2.length)
			{
				if(nums1[n1] < nums2[n2])
				{
					count[i] = nums1[n1];
					n1++;
				}
				else
				{
					count[i] = nums2[n2];
					n2++;
					
				}
			}
			else if(n1 < nums1.length)
			{
				count[i] = nums1[n1];
				n1++;
			}
			else if(n2 < nums2.length)
			{
				count[i] = nums2[n2];
				n2++;
			}
			
		}
		
		
		if(totalSize %2 == 1)
		{
			median = count[count.length-1];
		}
		else
		{
			median = (count[count.length-2] + count[count.length-1]) / 2.0;
		}
		
		
		return median;
	}
	
	public static int fib(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		else if(n == 1)
		{
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	public static int[] fibDP(int n)
	{
		int[] fib = new int[n];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2; i < n; i++)
		{
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib;
	}
	
	public static int nonRepeatingSubString(String input)
	{
		char[] cinput = input.toCharArray();
		Hashtable<Character,Integer> hTable = new Hashtable<Character,Integer>();
		String largestSubString = "";
		String tempSubString = "";
		for(int i = 0; i < cinput.length; i++)
		{
			
			if(hTable.containsKey(cinput[i]))
			{
				
				if(tempSubString.length() > largestSubString.length())
				{
					largestSubString = tempSubString;
				}
				
				tempSubString = "" + cinput[i];
				
				int tmp = hTable.get(cinput[i]);
				if(i != tmp + 1)
				{
					hTable.clear();
					i = tmp;
					tempSubString = "";
				}
					
			}
			else
			{
				hTable.put(cinput[i],i);
				tempSubString += cinput[i];
			}
		}
		if(tempSubString.length() > largestSubString.length())
		{
			largestSubString = tempSubString;
		}
		return largestSubString.length();
	}
	
	
	
	public static LinkedList<Integer> addLinkedNumsE(LinkedList<Integer> num1, LinkedList<Integer> num2)
	{
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		int sum = 0;
		for(int i = num1.size()-1,exp = 0; i >= 0; i--, exp++)
		{
			sum += (num1.get(i) + num2.get(i)) * Math.pow(10, exp);
			
		}
		
		for(char c : String.valueOf(sum).toCharArray())
		{
			result.addFirst(Integer.valueOf(Character.toString(c)));
		}
		
		
		
		return result;
	}
	public static LinkedList<Integer> addLinkedNums(LinkedList<Integer> num1, LinkedList<Integer> num2)
	{
		LinkedList<Integer> result = new LinkedList<Integer>();
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		Iterator<Integer> it = num1.iterator();
		Iterator<Integer> it2 = num2.iterator();
		
		while(it.hasNext() && it2.hasNext())
		{
			int n1 = it.next();
			int n2 = it2.next();
			
			stack1.push(n1);
			stack2.push(n2);
			
		}
		char[] cnum1 = new char[stack1.size()];
		char[] cnum2 = new char[stack2.size()];
		
		int size = stack1.size();
		for(int i = 0; i < size; i++)
		{
			cnum1[i] = stack1.pop().toString().charAt(0);
			cnum2[i] = stack2.pop().toString().charAt(0);
		}
		
		int n1 = Integer.parseInt(String.valueOf(cnum1));
		int n2 = Integer.parseInt(String.valueOf(cnum2));
		
		Integer iResult = n1 + n2;
		
		for ( char c : iResult.toString().toCharArray())
		{
			result.add(Integer.parseInt(Character.toString(c)));
		}
		
		return result;
	}
	//reverses a string in o(1) memory
	public static char[] ReverseString(char[] cArray)
	{
		
		for(int i = cArray.length -1, x = 0; i>cArray.length/2; i--, x++)
		{
			char temp = cArray[x];
			cArray[x] = cArray[i];
			cArray[i] = temp;
		}
		return cArray;
	}
	/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

			You may assume that each input would have exactly one solution, and you may not use the same element twice.

			Example:

			Given nums = [2, 7, 11, 15], target = 9,

			Because nums[0] + nums[1] = 2 + 7 = 9,
			return [0, 1].*/
	public static int[] twoSum(int[] ints, int target)
	{
		int[] twoIndices = new int[2];
		
		for(int i = 0; i < ints.length; i++)
		{
			for( int j = 0; j <ints.length; j++)
			{
				if(ints[i]+ints[j] == target)
				{
					twoIndices[0] = i;
					twoIndices[1] = j;
					return twoIndices;
					
				}
			}
		}
		
		return twoIndices;
		
	}
	//Efficient twosum
	public static int[] twoSumE(int[] ints, int target)
	{
		int[] twoIndices = new int[2];
		//store numbers that failed sum check
		Hashtable<Integer,Integer> values = new Hashtable<Integer,Integer>();
		
		for(int i = 0; i < ints.length; i++)
		{
			int remainder = target - ints[i];
			if(values.containsKey(remainder))
			{
				twoIndices[0] = (i);
				twoIndices[1] = values.get(remainder);
			}
			else
			{
				values.put(ints[i], i);
			}
		}
		
		return twoIndices;
		
	}
	
	public static void linkedList()
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for(int i = 0; i< 5; i++)
		{
			ll.add(i);
			
		}
		
		
		
		for(int x : ll)
		{
			System.out.println(x);
		}
	}
	public static void stack()
	{
		Stack<Integer> s = new Stack<Integer>();
		
		
		
		for(int i = 0; i< 5; i++)
		{
			s.add(i);
			
		}
		Iterator<Integer> iter = s.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		
	}
	
	public static void list()
	{
		List<Integer> list = new Stack<Integer>();
		
		list.add(1);
		list.add(3);
		list.add(2);
		
		for( int x : list)
		{
			System.out.println(x);
		}
		
	}
	public static void set()
	{
		Set<Integer> set = new HashSet<Integer>();
		SortedSet<Integer> sortSet = new TreeSet<Integer>();
		
		sortSet.add(5);
		sortSet.add(3);
		sortSet.add(8);
		
		
		set.add(1);
		if(set.add(1))
		{
			System.out.print("this is not a set!");
		}
		else
		{
			System.out.println("this is a set :)");
		}
		
		for(int x : sortSet)
		{
			System.out.println(x);
		}
		
	}
	

}
