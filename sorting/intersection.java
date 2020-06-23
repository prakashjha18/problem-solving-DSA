// { Driver Code Starts
//     Example:
// Input:
// 3
// 4 5
// 1 2 3 4
// 2 4 6 7 8
// 5 6
// 1 2 2 3 4
// 2 2 4 6 7 8
// 2 2
// 1 2
// 3 4
// Output:
// 2 4
// 2 4
// -1
//    
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
                arr1[i] = Integer.parseInt(st[i]);
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < M; i++)
                arr2[i] = Integer.parseInt(st[i]);
                
            ArrayList<Integer> v = new ArrayList<Integer>();
            v = new Intersection().printIntersection(arr1, arr2, N, M);
           
            for(int i=0;i<v.size();i++)
                System.out.print(v.get(i)+" ");
                
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Intersection
{
    /* Function prints Intersection of arr1[] and arr2[] 
    n is the number of elements in arr1[] 
    m is the number of elements in arr2[] 
    Return the array
    */
    static ArrayList<Integer> printIntersection(int arr1[], int arr2[], int n, int m) 
    {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0, j = 0; 
        int flag =0;
        while (i < n && j < m){ 
            while(  i+1<n  &&  arr1[i]==arr1[i+1]  )
                i++;
            
            while(  j+1<m  &&  arr2[j]==arr2[j+1]  )
                j++;
          
            if (arr1[i] < arr2[j]) 
                i++;
          
            else if (arr2[j] < arr1[i]) 
                j++;
          
            else
            {
                flag =1;
                ans.add(arr2[j++]);
                i++;
            }
        } 
        if (flag ==0)
        {
            ans.add(-1);
            return ans;
        }
        return ans;
    }

}

