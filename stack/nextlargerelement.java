Given an array A[] of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. If no such element exists, output -1.
// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class nextlargerelement {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    new solve().printNGE(arr, n);
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class solve{
    public static void printNGE(long[] arr, int n) { 
        // Your code here
        HashMap<Long,Long> hm = new HashMap<>();
        Stack<Long>s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(s.isEmpty() || arr[i]<= s.peek()){
                s.push(arr[i]);
            }
            else{
                while(s.peek()<=arr[i] ){
                    hm.put(s.pop(),arr[i]);
                    if(s.isEmpty()){
                        
                        break;
                    }
                }
                s.push(arr[i]);
            }
        }
        while(!s.isEmpty())
        {
            hm.put(s.pop(),(long)-1);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(hm.get(arr[i])+" ");
        }
    } 
}
