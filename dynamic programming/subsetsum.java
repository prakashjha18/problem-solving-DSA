// { Driver Code Starts
// Initial Template for Java
//https://practice.geeksforgeeks.org/problems/subset-sum-problem2643/1/?track=amazon-dynamic-programming&batchId=192
// Given a set of numbers, check whether 
// it can be partitioned into two subsets such that the sum of elements in both subsets is same or not.
// Example:
// Input:
// 2
// 4
// 1 5 11 5
// 3
// 1 3 5 
// Output:
// YES
// NO
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            if (sln.findPartition(a, n) == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean findPartition(int[] arr, int n) {
        // code here
        int sum = 0; 
        int i, j; 
  
        // Calculate sum of all elements 
        for (i = 0; i < n; i++) 
            sum += arr[i]; 
  
        if (sum%2 != 0) 
            return false; 
  
        boolean part[][]=new boolean[sum/2+1][n+1]; 
  
        // initialize top row as true 
        for (i = 0; i <= n; i++) 
            part[0][i] = true; 
  
        // initialize leftmost column, except part[0][0], as 0 
        for (i = 1; i <= sum/2; i++) 
            part[i][0] = false; 
  
        // Fill the partition table in botton up manner 
        for (i = 1; i <= sum/2; i++) 
        { 
            for (j = 1; j <= n; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= arr[j-1]) 
                    part[i][j] = part[i][j] || 
                                 part[i - arr[j-1]][j-1]; 
            } 
        } 
  
        
        // for (i = 0; i <= sum/2; i++) 
        // { 
        //     for (j = 0; j <= n; j++) 
        //         System.out.print(part[i][j]+" "); 
        //     System.out.println();
        // } 
  
        return part[sum/2][n]; 
    }
}
