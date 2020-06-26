// { Driver Code Starts
//Initial Template for Java
// Given a non-empty array of integers, find the top K elements which have the highest frequency in the array.
// If two numbers have the same frequency then the larger number should be given preference. 

// Input:
// The first line of input contains the number of test cases T. For each test case, there will be two 
// lines. The first line contains the number N ie. the size of the array followed by N space-separated integers. 
// The second line contains the integer K.

// Output:
// For each test case, print the top K frequent elements in the given array. 

// User Task:
// The task is to complete the function TopK() that takes the array and integer K as input and returns a 
// list of top K frequent elements.

// Expected Time Complexity : O(NlogN)
// Expected Auxilliary Space : O(N)

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 103
// 1<=A[i]<=104


// Example:
// Input:
// 2
// 6 1 1 1 2 2 3
// 2
// 8 1 1 2 2 3 3 3 4
// 2
// Output:
// 1 2
// 3 2 

import java.util.*;
import java.io.*;
public class Solution{
  public static void main(String[] args) {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = 0;
		t = in.nextInt();
		while(t-->0)
		{
			int n = 0,k = 0 ;
			n = in.nextInt();
			ArrayList<Integer> array = new ArrayList<>();
			for(int i=0; i<n; i++)
				array.add(in.nextInt());
			
			k = in.nextInt();
			
			ArrayList<Integer> result = new frequency().TopK(array,k);
			
			for(int i=0; i<result.size();i++)
				System.out.print(result.get(i)+" ");

			System.out.println();
		}		
	}
}

class pair{
	int first;
	int second;
	pair(int first, int second){
		this.first = first;
		this.second = second;
	}
}// } Driver Code Ends

class comp implements Comparator<pair>
{
	public int compare(pair o1, pair o2)
	{
		// If 2 elements have same frequency then return larger element
		if(o1.second==o2.second)
			return o2.first-o1.first;
		
		// Else return element with larger frequency
		else return o2.second-o1.second;
	}
}
//User function Template for Java
class frequency{
	
	/*class pair
	{
		int first;
		int second;
		pair(int first, int second){
			this.first = first;
			this.second = second;
		}
	}*/
	
	static ArrayList<Integer> TopK(ArrayList<Integer> array, int k) 
	{
		ArrayList<Integer> result = new ArrayList<>(); // ArrayList to store elements that have top k frequencies
		
		HashMap <Integer,Integer> ump = new HashMap<>(); // frequency map

		// add all elements to frequency map
		for(int i=0; i<array.size(); i++){
			ump.put(array.get(i), ump.get(array.get(i)) == null ? 1 : ump.get(array.get(i)) + 1); 
		}
		
		// convert frequency map to ArrayList
		ArrayList<pair> frequency = new ArrayList<>();
		
		for(int val : ump.keySet())
		{
			frequency.add( new pair( val, ump.get(val)) );
		}
		
		// sort frequency vector using user defined compare function
		Collections.sort(frequency, new comp());
		
		// add first k elements from sorted vector to result 
		for(int i=0; i<k; i++)
			result.add (frequency.get(i).first);
		
		return result;
		
	}
	
	
	//comparator sort
	
}
