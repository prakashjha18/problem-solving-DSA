// { Driver Code Starts
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
            int x = sc.nextInt();
            //new SearchinMat().search(n1, m1, arr1, x);
            SearchinMat obj = new SearchinMat();
            System.out.println(obj.search(n1, m1, arr1, x));
        }
    }
}

// } Driver Code Ends
class SearchinMat
{
    //Complete this function
    static int search(int n1, int m1, int mat[][], int x)
    {
       //Your code here
       int i = 0, j = m1 - 1; // set indexes for top right 
        // element 
  
        while (i < mat.length && j >= 0) { 
            if (mat[i][j] == x) { 
                return 1; 
            } 
            //System.out.print("___lll");
            if (mat[i][j] > x) 
                j--; 
            else // if mat[i][j] < x 
                i++; 
        } 
  
       
        return 0; // if ( i==n || j== -1 ) 
    }
}
