// { Driver Code Starts
// Given an array with repeated elements, the task is to find the maximum distance between two occurrences of an element.


// Input:

// The first line of input will contain no of test cases T . Then T test cases follow . 
// Each test case contains 2 lines. The first line of each test case contains an integer N denoting the number 
// of elements in the array, the next line contains N space separated integer's.


// Output:

// For each test case in new line print the Maximum distance between two occurrences of an element


// Constraints:

// 1<=T<=100

// 1<=N<=1000


// Example:

// Input

// 2
// 6
// 1 1 2 2 2 1
// 12
// 3 2 1 2 1 4 5 8 6 7 4 2

// Output

// 5
// 10
import java.util.Scanner;
import java.util.*;

class Max_Dis_Between_Same_Element
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.maxDistance(arr,n));
		
		t--;
		}
	}
}// } Driver Code Ends


// your task is to complete this function
class GfG
{
    int maxDistance(int arr[], int n)
    {
	// Your code here
	    HashMap<Integer, Integer> map = new HashMap<>(); 
          
        // Traverse elements and find maximum distance between  
        // same occurrences with the help of map.  
        int max_dist = 0; 
  
        for (int i = 0; i < n; i++) 
        { 
            // If this is first occurrence of element, insert its  
            // index in map  
            if (!map.containsKey(arr[i])) 
                map.put(arr[i], i); 
  
            // Else update max distance  
            else
                max_dist = Math.max(max_dist, i - map.get(arr[i])); 
        } 
  
        return max_dist; 
    }
}
