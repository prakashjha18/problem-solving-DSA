// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       new smallestRangeFromKLists().findSmallestRange(arr, n, k);
	       System.out.println();
	   }
	}
}
// } Driver Code Ends
class smallestRangeFromKLists
{
	static void findSmallestRange(int[][] arr,int n,int k)
	{
        int ptr[] = new int[501]; 
        int i, minval, maxval, minrange, minel = 0, maxel = 0, flag, minind; 
        for (i = 0; i <= k; i++) { 
            ptr[i] = 0; 
        } 
        minrange = Integer.MAX_VALUE; 
        while (true) { 
            minind = -1; 
            minval = Integer.MAX_VALUE; 
            maxval = Integer.MIN_VALUE; 
            flag = 0; 
            for (i = 0; i < k; i++) { 
                if (ptr[i] == n) { 
                    flag = 1; 
                    break; 
                } 
                if (ptr[i] < n && arr[i][ptr[i]] < minval) { 
                    minind = i; // update the index of the list 
                    minval = arr[i][ptr[i]]; 
                } 
                if (ptr[i] < n && arr[i][ptr[i]] > maxval) { 
                    maxval = arr[i][ptr[i]]; 
                } 
                System.out.println(minval+"_____"+maxval);
            } 
            if (flag == 1) { 
                break; 
            } 
            ptr[minind]++; 
            if ((maxval - minval) < minrange) { 
                minel = minval; 
                maxel = maxval; 
                minrange = maxel - minel; 
            } 
        } 

        System.out.print(minel+" " + maxel); 
	}
}
