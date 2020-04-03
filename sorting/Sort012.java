// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    new Sort012().segragate012(arr, n);
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}// } Driver Code Ends
//User function Template for Java

class Sort012
{
    // Function to segregate 0s, 1s and 2s
    // A[]: input array
    // n: size of array
    
    public static void segragate012(int a[], int arr_size){
        // your code here
        int lo = 0; 
        int hi = arr_size - 1; 
        int mid = 0, temp = 0; 
        while (mid <= hi) { 
            switch (a[mid]) { 
                case 0: { 
                    temp = a[lo]; 
                    a[lo] = a[mid]; 
                    a[mid] = temp; 
                    lo++; 
                    mid++; 
                    break; 
                } 
                case 1: 
                    mid++; 
                    break; 
                case 2: { 
                    temp = a[mid]; 
                    a[mid] = a[hi]; 
                    a[hi] = temp; 
                    hi--; 
                    break; 
                } 
            } 
        } 
    }
}
