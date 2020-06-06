//https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1/?track=amazon-dynamic-programming&batchId=192
// { Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    int m = sc.nextInt();
		    
		    DynamicProgramming obj = new DynamicProgramming();
		    
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}// } Driver Code Ends


class DynamicProgramming{
    
    // function to count ways to reach mth stair
    Long countWays(int n){
        
        // your code here
        Long[] ways = new Long[n + 1];
        
      

		ways[0] = (long)1;
     
		ways[1] = (long)1;
    

	    
    for(int i = 2; i <= n; i++){
   
		         ways[i] = ways[i - 1]%(1000000007) + ways[i - 2]%(1000000007);
  
	        }
        

	
        return ways[n]%(1000000007);
        
    }
    
}
