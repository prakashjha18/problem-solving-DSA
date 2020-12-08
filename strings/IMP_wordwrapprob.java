/*package whatever //do not write package name here */

/*
Given an array of size N, which denotes the number of characters in one word. 
The task is simple, count the number of words in a single line with space character between two words.

Input:
First line contains the number of test cases T. First line of every test case 
consists of N, denoting number of elements in array. Second line consists of 
elements in array. Third line consists of characters allowed per line.

Output:
Single line output,print 2*L spaced integers (where L is the number of lines 
required to adjust the words with given limit of character per line), denoting
from which word to word in every line.(for more clearance of output, look the output in example).

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
4
3 2 2 5
6
3
3 2 2
4
Output:
1 1 2 3 4 4 
1 1 2 2 3 3 

For the first test case.
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 3
Line number 3: From word no. 4 to 4 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    final int MAX = Integer.MAX_VALUE; 
      
    // A utility function to print the solution 
    void printSolution (int p[], int n) 
    { 
        //int k; 
        if (p[n] == 1) 
            System.out.print(p[n] + " "  + n+" "); 
       // k = 1; 
        else{
        printSolution (p, p[n]-1) ;
        System.out.print(p[n] + " "  + n+" "); 
        }
        //return k; 
    } 
  
// l[] represents lengths of different words in input sequence.  
// For example, l[] = {3, 2, 2, 5} is for a sentence like  
// "aaa bb cc ddddd". n is size of l[] and M is line width  
// (maximum no. of characters that can fit in a line)  
    void solveWordWrap (int l[], int n, int M) 
    { 
        // For simplicity, 1 extra space is used in all below arrays 
      
        // extras[i][j] will have number of extra spaces if words from i 
        // to j are put in a single line 
        int extras[][] = new int[n+1][n+1]; 
      
        // lc[i][j] will have cost of a line which has words from 
        // i to j 
        int lc[][]= new int[n+1][n+1]; 
      
        // c[i] will have total cost of optimal arrangement of words 
        // from 1 to i 
        int c[] = new int[n+1]; 
      
        // p[] is used to print the solution. 
        int p[] =new int[n+1]; 
      
        // calculate extra spaces in a single line. The value extra[i][j] 
        // indicates extra spaces if words from word number i to j are 
        // placed in a single line 
        for (int i = 1; i <= n; i++) 
        { 
            extras[i][i] = M - l[i-1]; 
            for (int j = i+1; j <= n; j++) 
            extras[i][j] = extras[i][j-1] - l[j-1] - 1; 
        } 
        
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n;j++){
        //         System.out.print(extras[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // Calculate line cost corresponding to the above calculated extra 
        // spaces. The value lc[i][j] indicates cost of putting words from 
        // word number i to j in a single line 
        for (int i = 1; i <= n; i++) 
        { 
            for (int j = i; j <= n; j++) 
            { 
                if (extras[i][j] < 0) 
                    lc[i][j] = MAX; 
                else if (j == n && extras[i][j] >= 0) 
                    lc[i][j] = 0; 
                else
                    lc[i][j] = extras[i][j]*extras[i][j]; 
            } 
        } 
        // System.out.println("______");
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n;j++){
        //         System.out.print(lc[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("______");
        // Calculate minimum cost and find minimum cost arrangement. 
        // The value c[j] indicates optimized cost to arrange words 
        // from word number 1 to j. 
        c[0] = 0; 
        for (int j = 1; j <= n; j++) 
        { 
            c[j] = MAX; 
            for (int i = 1; i <= j; i++) 
            { 
                if (c[i-1] != MAX && lc[i][j] != MAX &&  
                   (c[i-1] + lc[i][j] < c[j])) 
                { 
                    c[j] = c[i-1] + lc[i][j]; 
                    p[j] = i; 
                } 
            } 
        } 
        // for(int i=0;i<=n;i++)
        //     System.out.print(c[i]+" ");
        // System.out.println("______");
        //  for(int i=0;i<=n;i++)
        //     System.out.print(p[i]+" ");
        // System.out.println("______");
        printSolution(p, n); 
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    GFG w = new GFG(); 
		    int n = sc.nextInt();
		    int l[] = new int[n];
		    for(int i=0;i<n;i++){
		        l[i]=sc.nextInt();
		    }
		    int M = sc.nextInt();
		    w.solveWordWrap (l, n, M); 
		    System.out.println();
		}
	}
}
