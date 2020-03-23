// { Driver Code Starts
import java.util.*;
import java.io.*;

class sticklertheif
 {
	public static void main (String[] args)
	 {
	   
	  Scanner sc = new Scanner(System.in);
	  int t = sc.nextInt();
	  while(t-- > 0){
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      System.out.println(new solve().FindMaxSum(arr, n));
	 }
   }
}// } Driver Code Ends
class solve{
    // Function to return maximum of sum without adjacent elements
    public int FindMaxSum(int hval[], int n){
        if (n == 0) 
        return 0; 
   
        int value1 = hval[0]; 
        if (n == 1) 
            return value1; 
        int max_val = 0; 
        int value2 = Math.max(hval[0], hval[1]); 
        if (n == 2) 
            return value2; 
        for(int i=2;i<n;i++){
            max_val=Math.max(hval[i]+value1, value2);
            value1 = value2; 
            value2 = max_val; 
        }
        return max_val;
    }
}
