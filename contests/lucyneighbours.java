// { Driver Code Starts
//Initial Template for Java
// Lucy lives in house number X. She has a list of N house numbers in the society. Distance between houses can be
// determined by studying the difference between house numbers. Help her find out K closest neighbours.
// Note: If two houses are equidistant and Lucy has to pick only one, the house with the smaller house number is 
// given preference.

// Input:
// First line of input contains number of testcases T. For each testcase, there will be two lines. First line contains 
// space separated integers N, X and K. Second line contains the house numbers of N houses in an unsorted manner. 

// Output:
// Print the house numbers of Lucy's K closest neighbours in sorted order. 

// Your Task:
// Complete the function Kclosest() that takes array, n, x and k as inputs and returns a list of integers.

// Constraints: 
// 1 <= T <= 50
// 1 <= N <= 104
// -104 <= arr[i] <= 104
// -104<= X <= 104
// 1 <= K <= N

// Example:
// Sample Input:
// 2
// 6 5 3
// 10 2 14 4 7 6
// 5 0 4
// -21 21 4 -12 20

// Sample Output:
// 4 6 7 
// -21 -12 4 20

// Explanation:
// Testcase 2:
// The closest neighbour is house number 4. Followed by -12 and 20. -21 and 21 are both equal distance from X=0. 
// Therefore, Lucy can only pick 1. Based on the given condition she picks -21 as it is the smaller of the two.


import java.io.*;
import java.util.*; 
import java.lang.*;

 // } Driver Code Ends


//User function Template for Java
class Info{
	int distance;
	int houseno;

	Info(int x,int y)
	{
		distance = x;
		houseno = y;
	}
	
	public String toString(){
	    return houseno+" ";
	}
}
class Compare implements Comparator<Info>{ 
	public int compare (Info p1,Info p2 )
	{
		if (p1.distance == p2.distance)	{
			if (p1.houseno < p2.houseno)
				return +1;
			else
				return -1;
		}

		else {
		   	return(p2.distance-p1.distance);
		}
	}
}

class Solution 
{ 
	public  ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
		ArrayList<Integer> result= new ArrayList<Integer>();
		PriorityQueue<Info> pq = new PriorityQueue<Info>(k, new Compare()); 

		for (int i = 0; i < k; i++) 
		{
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i] );
			pq.add(obj); 
		}
		//System.out.print(pq);
		for (int i = k; i < n; i++) 
		{ 
			int diff = Math.abs(arr[i] - x); 
			if (diff > pq.peek().distance) 
				continue; 

			if (diff == pq.peek().distance && arr[i] > pq.peek().houseno) 
				continue; 

			pq.remove();
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i] );
			pq.add(obj);
		} 
		//System.out.print(pq);
		while (pq.size() >0) { 
			result.add(pq.peek().houseno);
			pq.remove();
		}
		Collections.sort(result);
		return result;
	}    
} 

// { Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int x = sc.nextInt();
        	int k = sc.nextInt();
        	int arr[] = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		arr[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.Kclosest(arr,n,x,k);

            for (int i=0; i<ans.size(); i++) 
        	    System.out.print(ans.get(i)+" "); 
            System.out.println();
            t--;
        }
    } 
} 



  // } Driver Code Ends
