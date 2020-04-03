// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    int arr[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    System.out.println(new TripletSum().find3Numbers(arr, n, x));
		}
	}
}// } Driver Code Ends
//User function Template for Java

class TripletSum
{
    // function to find the triplet which sum to x
    public static int find3Numbers(int A[], int arr_size, int sum) { 
        int l, r; 
        Arrays.sort(A);
        for (int i = 0; i < arr_size - 2; i++) { 
            l = i + 1;
            r = arr_size - 1;
            while (l < r) { 
                if (A[i] + A[l] + A[r] == sum) { 
                    return 1; 
                } 
                else if (A[i] + A[l] + A[r] < sum) 
                    l++; 
  
                else 
                    r--; 
            } 
        } 
  
        // If we reach here, then no triplet was found 
        return 0; 
    
    }
}
