// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner in=new Scanner(System.in);
	    int t=in.nextInt();
	    while(t-- > 0)
	    {
	        int n=in.nextInt();
	        int arr[]=new int[n];
	        for(int i = 0;i<n;i++){
	            arr[i] = in.nextInt();
	        }
	        
	        LongestSubsequence obj = new LongestSubsequence();
	        
	        System.out.println(obj.longestSubsequence(n, arr));
	                
	    }
	}
}// } Driver Code Ends


class LongestSubsequence{
    
    // function to find longest increasing subsequence
    long longestSubsequence(int n, int nums[]){
        
        // your code here
         int maxLength = 0;

        // Initializing LIS array and filling them all with 1
        int[] LIS = new int[n];
        for(int i = 0; i < n; i++){
            LIS[i] = 1;
        }

        // This double loop fills the LIS array
        for(int i = 1; i < n ; i++){
            for(int j = 0; j < i ; j++){
                if (nums[i] > nums[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        // This loop just finds the maximum value among all the LIS[i] values
        for(int i = 0; i <= n - 1; i++){
            if(maxLength < LIS[i]){
                maxLength = LIS[i];
            }
        }

        return maxLength;
        
    }
    
}
