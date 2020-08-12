// { Driver Code Starts
//Initial Template for Java
/*
There is a Giant who is exhausted. To gain strength he will go through a N*M integer grid Arr[N][M] which contains 
food packets. Arr[i][j] is the amount of strength he gains after eating the food packet. Strength gained by eating 
a food packet can also be negative( i.e. Arr[i][j]<0). From row r and column c, he can go to any of the following 
three indices:

I.                Arr[ r+1 ][ c-1 ] (valid only if c-1>=0)
II.               Arr[ r+1 ][ c ]
III.              Arr[ r+1 ][ c+1 ] (valid only if c+1<=N-1)

So if he start at any column on row 0, what is the maximum strength he can earn till row N-1. If the strength
earned is negative print 0, because in that case he will not enter the grid.

Note: If Giant is standing at Arr[i][j] he has to eat that food packet .

Input:
First line contains an integer T, denoting the number of test cases. First line of each test case contains 
two integers N and M, denoting the number of rows and columns. Next N lines of each test case contains M space 
seperated integers denoting amount of strength he gains after eating the food packet .

Output:
Print the maximum strength the giant can gain.

Constraints:
1<=T<=10
1<=N,M<=1000
0<=| Arr[i][j] |<=105
Sum of N*M over all test cases doesn't exceed 106

Your Task:​
This is a functional problem . You don't need to take input just complete the function strength()
which accpets 2d vector grid and two integers N , M as parameters and return the maximum strength giant can gain.

Example:
Input:
2
2 2
10 4
3 5
2 2
5 -1
-2 -1
Output:
15
4

Explanation:
Testcase 1: He will eat 10 in 1st row and 5 in second row.
Testcase 2: He will eat 5 in 1st row and -1 in second row.
*/


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t , n , m , x , ans;
            t = sc.nextInt();
            while(t > 0)
                {
                    n = sc.nextInt();
                    m = sc.nextInt();
                    int[][] grid = new int[n][m];
                    for (int i = 0; i < n; i++)
                        {
                            for (int j = 0; j < m; j++)
                                {
                                    x = sc.nextInt();
                                    grid[i][j] = x;
                                }
                        }
                    str g = new str(); 
                    ans = g.strength(grid, n, m);
                    System.out.println(ans);
                    t--;
                }
        }
}
// } Driver Code Ends


//User function Template for Ja

class str
{
    public int strength(int[][] grid , int n , int m)
    {
        int i , j , maxx = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        for(i=0;i<m;i++)
            dp[n-1][i] = grid[n-1][i];
        
    // storing the max energy gained after reaching a[i][j] 
        for(i=n-2;i>=0;i--)
        {
            for(j=0;j<m;j++)
            {
                if(j>0 && j<m-1)
                    dp[i][j] = Math.max(grid[i][j] + dp[i+1][j+1] , Math.max(grid[i][j] + dp[i + 1][j],grid[i][j] + dp[i + 1][j - 1]));
                else if(j==0 && j<m-1)
                    dp[i][j] = Math.max(grid[i][j] + dp[i+1][j+1] ,grid[i][j] + dp[i + 1][j]);
                else if(j==m-1 && j>0)
                    dp[i][j] = Math.max(grid[i][j] + dp[i + 1][j],grid[i][j] + dp[i + 1][j - 1]);
                

            }
        }
        
    // calculating the maximum energy gained after reaching the last row
        for(i=0;i<m;i++)
        {
            if(dp[0][i] > maxx)
                maxx = dp[0][i];
        }
        if(maxx < 0)
            return 0;
            
        return maxx;   
    }
    
    
}

