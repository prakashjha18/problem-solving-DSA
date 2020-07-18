// Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

// Note:

// Each of the array element will not exceed 100.
// The array size will not exceed 200.
 

// Example 1:

// Input: [1, 5, 11, 5]

// Output: true

// Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

// Example 2:

// Input: [1, 2, 3, 5]

// Output: false

// Explanation: The array cannot be partitioned into equal sum subsets.


class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;
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
  
        
        for(i=0;i<=sum/2;i++){
            System.out.print(i+" ");
            for( j=0;j<=n;j++){
                System.out.print(part[i][j]+"   ");
            }
            System.out.println();
        }
  
        return part[sum/2][n]; 
    }
}
