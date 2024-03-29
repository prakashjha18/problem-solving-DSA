/*

Chef Ada has a matrix with N rows (numbered 1 through N from top to bottom) and N columns (numbered 1 through N from left to right) 
containing all integers between 1 and N2 inclusive. For each valid i and j, let's denote the cell in the i-th row and j-th column by (i,j).

Ada wants to sort the matrix in row-major order ― for each valid i and j, she wants the cell (i,j) to contain the value (i−1)⋅N+j.

In one operation, Ada should choose an integer L and transpose the submatrix between rows 1 and L and columns 1 and L (inclusive).
Formally, for each i and j (1≤i,j≤L), the value in the cell (i,j) after this operation is equal to the value in (j,i) before it.

The initial state of the matrix is chosen in such a way that it is possible to sort it using a finite number of operations (possibly zero). 
Find the smallest number of operations required to sort the matrix.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N.
The next N lines describe the matrix. For each valid i, the i-th of these lines contains N space-separated integers ― the initial values 
in cells (i,1),(i,2),…,(i,N).
Output
For each test case, print a single line containing one integer ― the smallest number of operations required to sort the matrix.

Constraints
4≤N≤64
the sum of N2 over all test files does not exceed 3⋅105
Subtasks
Subtask #1 (10 points):

T≤50
N=4
Subtask #2 (90 points): original constraints

Example Input
1
4
1 2 9 13
5 6 10 14
3 7 11 15
4 8 12 16
Example Output
2
Explanation
Example case 1: After the first operation, with L=2, the resulting matrix is

1 5 9 13
2 6 10 14
3 7 11 15
4 8 12 16
After the second operation, with L=4, the matrix becomes sorted

1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

*/


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
    		FastReader sc=new FastReader(); 
    		int t = sc.nextInt();
    		while(t-->0){
    		    int n = sc.nextInt();
    		    int arr[][] = new int[n][n];
    		    for(int i=0;i<n;i++){
    		        for(int j=0;j<n;j++){
    		            arr[i][j] = sc.nextInt();
    		        }
    		    }
    		    int count =0;
    		    int y=0;
    		    for(int i=n-1;i>0;i--){
    		        if((arr[i][i-1]+1)!=arr[i][i]){
    		            count++;
    		            y=i+1;
    		            for(int k=0;k<y;k++){
    		                for(int l=k;l<y;l++){
    		                    //System.out.print(k+" "+l+"__");
    		                    int temp = arr[l][k];
    		                    arr[l][k] = arr[k][l];
    		                    arr[k][l] = temp;
    		                }
    		            }
    		        }
    		    }
    		    System.out.println(count);
    		}
		}
		catch(Exception e){}
	}
}
