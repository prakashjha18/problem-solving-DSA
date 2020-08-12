// { Driver Code Starts
//Initial Template for Java
/*
You will be given a 2-D array a[ ][ ] of size n * n which represents positions in a golf course. A golfer wants
to start from the top left corner and reach the bottom right corner of the golf course with any number of shots.
Your task is to analyse the 2-D array and determine whether it is possible or not.

The 2-D array has a whole number in each cell. The number represents the maximum distance, a shot taken from 
that cell can reach. Shots can be taken in any of the 4 directions - UP, RIGHT, DOWN and LEFT. For example 
if a[i][j] hold a value 'x', then the golfer can go to any cell between a[i-x][j] and a[i+x][j] or between 
a[i][j-x] and a[i][j+x] from that cell. If a cell holds the value 0, that cell is a dead end. The golfer cannot 
go anywhere if he reaches there.

Input: First line of input contains number of test cases T. Then T test cases follow. In each test case, first 
line contains the value n. Second line of each test case contains n*n space separated integers that form the
2-D array A[ ][ ]. Input will be read by driver code.

Output: If it is possible to reach the bottom right celll starting from the top left, 1 is printed, else, 
0 is printed.

Your task: Your task is to complete the function is_possible(). This function gets the 2-D array a[ ][ ] 
and its number of rows n as argument. Return 1 if it is possible to start from top left and reach bottom right, 
else return 0. Returned value will be printed  y driver code.

Constraints: T <= 200 ; 2 <= n <= 150 ; 0 <= a[i][j] <= 10

Example:
Input:
2
4
3 0 0 2 0 2 1 1 1 0 0 0 0 4 0 0
3
1 2 0 0 0 2 3 0 1

Output:
1
0

Explanation:
Testcase 1:
3 0 0 2
0 2 1 1
1 0 0 0
0 4 0 0
We can see the path a[0][0] -> a[0][3] -> a[1][3] -> a[1][2] -> a[1][1] -> a[3][1] -> a[3][3], hence output is 1

Testcase 2:
1 2 0
0 0 2
3 0 1
​There is no possible path to reach the bottom right cell, hence output is 0.
*/
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        while(t-->0)
        {
            int n=ob.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=ob.nextInt();
                }
            }
            find ab=new find();
            int b=ab.is_possible(a,n);
            System.out.println(b);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class find
{
    int is_possible(int a[][],int n)
    {
        //code here
        return go_there(a,0,0,n);
    }
    int go_there(int a[][],int r,int c,int n){
        if(r==n-1 && c==n-1)
            return 1;
        if(a[r][c]==0)
            return 0;
        int m =a[r][c];
        a[r][c]=0;
        for(int i=m;i>=0;i--){
            if(r+i<n){
                if(go_there(a,r+i,c,n) == 1)
                    return 1;
            }
            if(c+i<n){
                if(go_there(a,r,c+i,n) == 1)
                    return 1;
            }
            if(r-i>=0){
                if(go_there(a,r-i,c,n) == 1)
                    return 1;
            }    
            if(c-i>=0){
                if(go_there(a,r,c-i,n) == 1)
                    return 1;
            }
        }
        return 0;
    }
}
