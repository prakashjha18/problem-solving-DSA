// { Driver Code Starts
//Initial Template for Java
// Testcase 1:
//https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1/?track=amazon-graphs&batchId=192
// Grid is:
//  31,   100,   65,   12,   18,
//  10,    13,    47,  157,   6,
// 100,  113,  174,   11,   33,
//  88,   124,   41,    20,  140,
//  99,    32,   111,   41,   20
// A cost grid is given in above diagram, minimum
// cost to reach bottom right from top left
// is 327 (31 + 10 + 13 + 47 + 65 + 12 + 18 + 6 + 33 + 11 + 20 + 41 + 20)
// Testcase 2:
// Grid is:
// 42 93
// 07 14
// A cost grid is given in above diagram, minimum
// cost to reach bottom right from top left
// is 63(42+7+14)

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int grid[][]=new int[n][n];
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            grid[i][j]=sc.nextInt();
		        }
		    }
		    
		    
		    
		    
		    System.out.println(shortest(grid,n));
		    
		    
		}
	}
	


 // } Driver Code Ends





//User function Template for Java



/*
You may use this to push a node having three members
class Node {
    int x, y, dist;
    Node (int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.dist = d;
    }
}
*/
static int dx[] = {-1, 0, 0, 1};
static int dy[] = {0, -1, 1, 0};
static int dist[][];
static boolean[][] visited;
    
private static int shortest(int grid[][],int n) {
    
    visited = new boolean[n][n];
    dist = new int[n][n];
    for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
	
	       dist[i][j] = Integer.MAX_VALUE;
	    }
	}
    
    Queue<Node> q = new PriorityQueue<Node>((n1, n2) -> n1.dist - n2.dist);
    dist[0][0] = grid[0][0];
    q.add(new Node(0, 0, grid[0][0]));
    while (!q.isEmpty()) {
        Node node = (Node)q.remove();
        if (node.x == (n - 1) && node.y == (n - 1)) return dist[node.x][node.y];
        if (visited[node.x][node.y])  continue;
        visited[node.x][node.y] = true;
        for (int k = 0; k < 4; k++) {
            int u = node.x + dx[k];
            int v = node.y + dy[k];
            if (valid(u, v,n) &&!visited[u][v]) {
                if (dist[u][v] > dist[node.x][node.y] + grid[u][v]) {
                    dist[u][v] = dist[node.x][node.y] + grid[u][v];
                }
                q.add(new Node(u, v, dist[u][v]));
            }
        }
    }
    return dist[n-1][n-1];
}
private static boolean valid (int u, int v,int n) {
    return u < n && u >= 0 && v < n && v >= 0;
}


// { Driver Code Starts.





}

class Node {
    int x, y, dist;
    Node (int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.dist = d;
    }
}  // } Driver Code Ends
