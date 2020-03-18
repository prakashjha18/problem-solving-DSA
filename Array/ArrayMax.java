// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
        

//User function Template for Java

// Solution class to implement function largestAndSecondLargest
class ArrayMax{
    
    // Function to find largest and second largest element in the array
    static void largestAndSecondLargest(int sizeofarray, int arr[]){
        int max = -1;
        int max2 = -1;
        int temp;
        for(int i=0;i<sizeofarray;i++) {
            if(arr[i]>max)
            {
                temp=max;
                max=arr[i];
                max2=temp;
            }
            if(arr[i]>max2 & arr[i]!=max)
            {
                max2=arr[i];
            }
        }
        System.out.println(max + " " + max2);
    }
}

// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    int arr[] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int index = 0;index < sizeOfArray; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    ArrayMax obj = new ArrayMax();
		    obj.largestAndSecondLargest(sizeOfArray, arr);
		}
	}
}  // } Driver Code Ends
