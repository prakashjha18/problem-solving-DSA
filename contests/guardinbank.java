// { Driver Code Starts
//Initial Template for Java
/*
Given an M x N character matrix that is filled with the characters ‘O’, ‘G’, and ‘W’ where:

‘O’ represents an open space.
‘G’ represents a guards
‘W’ represents a wall.
You have to replace all of the O’s in the matrix with their shortest distance from a guard without being 
able to go through any walls. Also, replace the guards with 0 and walls with -1 in the resultant matrix. 
If no path exists replace 'O' with -1.

Input:
First line of input contains number of testcases T. For each testcase, first line contains M and N respectively. 
Then M lines will follow containing N characters each.

Output:
Print the resultant integer matrix that denotes shortest distance of each cell from a guard.

Your Task:
Complete the function findDistance() that takes the character matrix, M and N as inputs and returns resultant 
integer matrix. The printing is done by the driver code.   

Constraints: 
0 <= T <= 50
1 <= M,N <= 10

Example:
Input:
1
2 3
O O O
G W G

Output:
1  2  1
0 -1  0

Explanation:
Testcase 1: The distance to any nearest guard from the open spaces of the first row is 1, 2 and 1 respectively.
*/


import java.util.*;
import java.math.*;

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
           
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Write your code here
        int[][]op =new int[m][n];
        int []dx = new int[]{0,0,-1,1};
        int []dy = new int[]{-1,1,0,0};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                op[i][j] = -1;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]=='G'){
                    q.add(new int[]{i,j,0});
                    op[i][j] = 0;
                }
                if(mat[i][j]=='W'){
                    op[i][j]=-1;
                }
            }
        }
        
        while(!q.isEmpty()){
                int []cur = q.poll();
                int distance = cur[2];
                for(int i=0;i<4;i++){
                    int x = dx[i]+cur[0];
                    int y = dy[i]+cur[1];
                    
                    if(x>=0 && y>=0 && x<m&& y<n && mat[x][y]=='O' && op[x][y]==-1){
                        op[x][y] = distance+1;
                        q.add(new int[]{x,y,distance+1});
                    }
                
            }
            //step++;
        }
        return op;
        
    }
}
