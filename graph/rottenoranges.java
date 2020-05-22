// { Driver Code Starts
//Initial Template for Java
// Given a matrix of dimension RxC where each cell in the matrix can have values
// 0, 1 or 2 which has the following meaning:
// 0 : Empty cell
// 1 : Cells have fresh oranges
// 2 : Cells have rotten oranges

// We have to determine what is the minimum time required to rot all oranges.
// A rotten orange at index [i,j] can rot other fresh orange at indexes
// [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
// If it is impossible to rot every orange then simply return -1.
// Testcase 1:
// 2 | 1 | 0 | 2 | 1
// 1 | 0 | 1 | 2 | 1
// 1 | 0 | 0 | 2 | 1
// o/p =  2
// Oranges at positions {0,0}, {0, 3}, {1, 3} and {2, 3} will rot oranges at 
// {0, 1}, {1, 0}, {0, 4}, {1, 2}, {1, 4}, {2, 4} during 1st unit time. And, during 2nd unit time,
// orange at {1, 0} got rotten and will rot orange at {2, 0}. 
// Hence, total 2 unit of time is required to rot all oranges.

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    int r = Integer.parseInt(sc.next());
		    int c = Integer.parseInt(sc.next());
		    
		    int a[][] = new int[r][c];
		    for(int i=0;i<r;i++)
		    {
		        for(int j=0;j<c;j++)
		        {
		            a[i][j] = Integer.parseInt(sc.next());
		        }
		    }
		    
		    Solution T = new Solution();
		    System.out.println(T.rotOranges(a,r,c));
		    
		    t--;
		}
	}
}// } Driver Code Ends


//User function Template for Java

// a : given matrix
// R and C : number of rows and columns respectively

class Solution
{
    int []dx = new int[]{0,0,-1,1};
    int []dy = new int[]{-1,1,0,0};
    public int rotOranges(int A[][],int r, int c)
    {
        // Write your code here
         Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(A[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int step = 0;
        while(!q.isEmpty()){
            int nodecount = q.size();
            while(nodecount-->0){
                int []cur = q.poll();
                for(int i=0;i<4;i++){
                    int x = dx[i]+cur[0];
                    int y = dy[i]+cur[1];
                    if(x>=0 && y>=0 && x<r&& y<c && A[x][y]==1){
                        q.add(new int[]{x,y});
                        A[x][y]=0;
                    }
                }
            }
            step++;
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(A[i][j]==1){
                    return -1;
                }
            }
        }
        return step-1;
        
    }
}
      
