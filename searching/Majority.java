// { Driver Code Starts
//Initial Template for Java
//Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Majority().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends
//User function Template for Java

class Majority
{
    static int majorityElement(int arr[], int size)
    {
        if(size ==1 )
        return arr[0];
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>(); 
  
        for(int i = 0; i < arr.length; i++) { 
            if (map.containsKey(arr[i])) { 
                    int count = map.get(arr[i]) +1; 
                    if (count > arr.length /2) { 
                        return  arr[i];
                    } else
                        map.put(arr[i], count); 
  
            } 
            else
                map.put(arr[i],1); 
            } 
            return -1;
    }
}
