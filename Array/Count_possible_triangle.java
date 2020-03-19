// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
             System.out.println(new Count_possible_triangle().findNumberOfTriangles(arr, n));
        }
    }
}// } Driver Code Ends
//User function Template for Java

class Count_possible_triangle
{
    // Function to find number of triangles that can be formed
    // arr[]: input array
    // n: size of array
    static long findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);

        int c=0;
        for(int i=n-1;i>1;i--){
        
            int l=0,r=i-1;
            while (l<r){
                if(arr[l]+arr[r]>arr[i]){
                    c+=r-l;
                    r--;
                }
                else 
                    l++;
            }
        }
        return c;
    }
}
