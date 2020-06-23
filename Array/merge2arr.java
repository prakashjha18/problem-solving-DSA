// { Driver Code Starts
//Initial Template for Java
// Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. 
// The task is to merge the two sorted arrays in place, i. e., we need to consider all n + m elements 
// in sorted order, then we need to put first n elements of these sorted in first array and remaining m
// elements in second array.

// Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify
// existing arrays as following.

// Input: arr1[] = {10};
//       arr2[] = {2, 3};
// Output: arr1[] = {2}
//         arr2[] = {3, 10}  

// Input: arr1[] = {1, 5, 9, 10, 15, 20};
//       arr2[] = {2, 3, 8, 13};
// Output: arr1[] = {1, 2, 3, 5, 8, 9}
//         arr2[] = {10, 13, 15, 20} 
import java.util.*;
import java.io.*;
import java.io.*;

class Sorting
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    new MergeSort().merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class MergeSort
{
    // Function to merge the two sorted arrays
    // arr1[], arr2[]: two input arrays
    // n, m: size of arr1[] and arr2[] respectively
    public static void merge(int arr1[], int arr2[], int n, int m) 
    {
       // add your code here 
       int x=n-1, y = 0;
        while(x>=0 && y<m){ 
            if(arr1[x]> arr2[y]){
            int temp =arr1[x];
            arr1[x] = arr2[y];
            arr2[y] = temp;
            x--;
            y++;
            }
            else{
                x--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
