// { Driver Code Starts
//https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps4102/1/?track=amazon-dynamic-programming&batchId=192
// Given an array of integers where each element represents the max number of steps that can be made forward
// from that element. The task is to find the minimum number of jumps to reach the end of the array (starting
// from the first element). If an element is 0, then cannot move through that element.
// Example:
// Input:
// 2
// 11
// 1 3 5 8 9 2 6 7 6 8 9
// 6
// 1 4 3 2 6 7
// Output:
// 3
// 2
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        int numOfTestCases = t;

        for(int p = 0;p<numOfTestCases;p++){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            
            DynamicProgramming obj = new DynamicProgramming();
            System.out.println(obj.minimumJumps(arr, size));
        }
	 }
	
}
// } Driver Code Ends


class DynamicProgramming{
    
    // function to find minimum number of jumps to reach end of the array
    public static int minimumJumps(int arr[], int n){
        // your code here
        int []jump = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = 99099;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[j] + j >= i){
                    if(jump[i] > jump[j] + 1){
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
        
        return jump[jump.length-1] == 99099 ? -1 : jump[jump.length-1];
    }
}
