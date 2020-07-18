
//Partition a set into two subsets such that the difference of subset sums is minimum

import java.io.*; 
  
class mindiff  
{ 
    // Returns the minimum value of  
    //the difference of the two sets. 
    static int findMin(int arr[], int n) 
    { 
        // Calculate sum of all elements 
        int sum = 0;  
        for (int i = 0; i < n; i++) 
            sum += arr[i]; 
      
        // Create an array to store  
        // results of subproblems 
        
      
        // Fill the partition table  
        // in bottom up manner 
        boolean part[][]=new boolean[sum/2+1][n+1]; 
  
        // initialize top row as true 
        for (int i = 0; i <= n; i++) 
            part[0][i] = true; 
  
        // initialize leftmost column, except part[0][0], as 0 
        for (int i = 1; i <= sum/2; i++) 
            part[i][0] = false; 
  
        // Fill the partition table in bottom up manner 
        for (int i = 1; i <= sum/2; i++) 
        { 
            
            for (int j = 1; j <= n; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= arr[j-1]) 
                    part[i][j] = part[i][j] || 
                                 part[i - arr[j-1]][j-1]; 
            } 
        } 
        // for(int i=0;i<=sum/2;i++){
        //     System.out.print(i+" ");
        //     for(int j=0;j<=n;j++){
        //         System.out.print(part[i][j]+"   ");
        //     }
        //     System.out.println();
        // }
        // Initialize difference of two sums.  
        int diff = Integer.MAX_VALUE; 
          
        // Find the largest j such that dp[n][j] 
        // is true where j loops from sum/2 t0 0 
        for (int j = sum / 2; j >= 0; j--) 
        { 
            // Find the  
            //System.out.println(dp[j][n]+" "+j+" "+n);
            if (part[j][n] == true) 
            { 
                diff = sum - 2 * j; 
                System.out.println( sum-j);
                break; 
            } 
        } 
        return diff; 
    } 
      
    // Driver program  
    public static void main (String[] args)  
    { 
        int arr[] = {25 ,30 ,35, 20 ,90 ,110 ,45, 70 ,80 ,12 ,30,35 ,85}; 
        int n = arr.length; 
        System.out.println ("The minimum difference between 2 sets is "
                            + findMin(arr, n)); 
      
    } 
} 
