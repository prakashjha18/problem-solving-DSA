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

class TripletSum2
{
    public static int find3Numbers(int A[], int arr_size, int sum) { 
        for (int i = 0; i < arr_size - 2; i++) { 
  
            HashSet<Integer> s = new HashSet<Integer>(); 
            int curr_sum = sum - A[i]; 
            for (int j = i + 1; j < arr_size; j++) { 
                if (s.contains(curr_sum - A[j])) { 
                    return 1; 
                } 
                s.add(A[j]); 
            } 
        } 
        return 0; 
    
    }
}
