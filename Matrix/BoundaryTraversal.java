// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n1 = sc.nextInt();
            int m1 = sc.nextInt();
            
            int arr1[][] = new int[n1][m1];
            
            for(int i = 0; i < n1; i++)
            {
                for(int j = 0; j < m1; j++)
                 arr1[i][j] = sc.nextInt();
            }
            new BoundaryTraversal().boundaryTraversal(n1, m1,arr1);
            System.out.println();
            
        }
    }
}// } Driver Code Ends
//User function Template for Java

class BoundaryTraversal
{
 /*  n1, m1: rows and cols of matrix
     a[][]: input matrix
*/
    static void boundaryTraversal(int n1, int m1, int a[][])
    {
        int i=0;
        int j=0;
        for(int p=0;p<m1;p++){
            System.out.print(a[i][p]+" ");
        }
        for(int p=i+1;p<n1;p++){
            System.out.print(a[p][m1-1]+" ");
        }
        if(i<n1-1){
            for(int p=m1-2;p>=0;p--){
                System.out.print(a[n1-1][p]+" ");
            }
        }
        if(j<m1-1){
            for(int p=n1-2;p>0;p--){
                System.out.print(a[p][j]+" ");
            }
        }
    }
    
}
