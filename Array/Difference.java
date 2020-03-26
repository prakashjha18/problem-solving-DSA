//         Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
// Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
// Examples :

//   Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
//   Output: 6  (j = 7, i = 1)

//   Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
//   Output: 8 ( j = 8, i = 0)

//   Input:  {1, 2, 3, 4, 5, 6}
//   Output: 5  (j = 5, i = 0)

//   Input:  {6, 5, 4, 3, 2, 1}
//   Output: -1 
// { Driver Code Starts
import java.io.*;
import java.util.*;

class Difference {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    MaxDifference obj = new MaxDifference();
		    
		    System.out.println(obj.maxIndexDiff(arr, n)); // print the result
		}
	}
}// } Driver Code Ends
class MaxDifference{
    
    // Function to find maximum difference of j-1
    // arr[]: input array
    // n: size of array
    static int maxIndexDiff(int arr[], int n) { 
        
        int maxDiff; 
        int i, j; 
  
        int RMax[] = new int[n]; 
        int LMin[] = new int[n]; 
        
        LMin[0] = arr[0];
        for(i=1;i<n;i++){
            LMin[i]=Math.min(arr[i],LMin[i-i]);
        }
        RMax[n-1]=arr[n - 1];
        for(j=n-2;j>=0;j--){
            RMax[j] = Math.max(arr[j], RMax[j + 1]); 
        }
        i=0;j=0;maxDiff=0;
        while(i<n && j<n){
            if (LMin[i] < RMax[j])  
            { 
                maxDiff = Math.max(maxDiff, j - i); 
                j++; 
            }  else {
                i++;
            }
        }
        return maxDiff;
    }
}

