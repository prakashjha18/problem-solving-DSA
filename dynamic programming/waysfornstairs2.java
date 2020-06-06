// { Driver Code Starts
//https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter1322/1/?track=amazon-dynamic-programming&batchId=192
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
}
// } Driver Code Ends


class DynamicProgramming{
    
    // function to find number of ways 
    Long countWays(int m){
        
        Long res[] = new Long[m+1];
        res[0] = 1L; 
        res[1] = 1L;
        for (int i = 2; i <= m; i++)  
            res[i] = (res[i-2] + 1);
      
        return res[m];
    }    
    
    
}
