// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] a = new int[n];
	       for(int i=0;i<n;i++) {
	           a[i] = in.nextInt();
	       }
	       System.out.println(new countsubArray().countSubarrWithEqualZeroAndOne(a, n));
	   }
	 }
}

// } Driver Code Ends
//User function Template for Java

class countsubArray
{
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        Map<Integer, Integer> myMap = new HashMap<>(); 
        int sum = 0; 
        int count = 0; 
        for (int i = 0; i < n; i++) { 
            //Replacing 0's in array with -1 
            if (arr[i] == 0) 
                arr[i] = -1; 
          
            sum += arr[i]; 
              
            //If sum = 0, it implies number of 0's and 1's are  
            //equal from arr[0]..arr[i] 
            if (sum == 0) 
                count++; 
              
            if (myMap.containsKey(sum)) 
                count += myMap.get(sum); 
  
            if (!myMap.containsKey(sum)) 
                myMap.put(sum, 1); 
            else
                myMap.put(sum, myMap.get(sum) + 1); 
            
            
        } 
        return count; 
    }
}


