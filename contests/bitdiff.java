// { Driver Code Starts
//Initial Template for Java
// Given an integer array of size  N . You have to find sum of bit differences in all pairs that can be formed from 
// array elements. Bit difference of a pair (x, y) is count of different bits at same positions in binary representations 
// of x and y.
// For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 ( first and last bits
// differ in two numbers).

// Input:
// First line of input contains a single integer T denoting number of test cases . For each test case, there will be two
// lines, first of which containing the size of the array N. Next line contains N space separated integers denoting the
// elements of the array.
// Output:
// For each test case , print the sum of bit differences in all pairs that can be formed from array .
// Your Task:
// You have to complete the function sumBitDiff() which accepts the given array and its size as parameter and returns 
// sum of bit differences in all pairs that can be formed from array .
// Constraints:
// 1<=T<=100
// 1<=N<=104
// 1<=arr[i]<=108
// Example:
// Input:
// 2
// 2
// 1 2 
// 5
// 3 5 2 5 2
// Output:
// 4
// 36
// Explanation:
// Test Case 1: All possible pairs are [ (1,1) (1,2) (2,1) (2,2) ] their respective Bit differences are 0 ,  2 , 2 , 0


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0 ;i<n;i++)
                        arr[i] = sc.nextInt();
                    
                    Sol obj = new Sol();
                    System.out.println(obj.sumBitDiff(arr,n));
                }
        }
}

// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Sol
{
    public static long sumBitDiff(int arr[], int n) 
    { 
        // code here
        long ans = 0;  // Initialize result 
  
        // traverse over all bits 
        for (int i = 0; i < 32; i++) 
        { 
            // count number of elements with i'th bit set 
            long count = 0; 
            for (int j = 0; j < n; j++) 
                if ( (arr[j] & (1 << i))>0 ) 
                    count++; 
            //System.out.print(count+"  ");
            // Add "count * (n - count) * 2" to the answer 
            ans += (count * (n - count) * 2); 
        } 
      
        return ans; 
    } 
  
}
