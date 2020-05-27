// { Driver Code Starts
// Initial Template for Java
// Input:

// 2
// 4 3
// 0 1 1 2 2 3
// 1 2
// 5 5
// 1 2 2 0 1 0 3 4 3 0
// 2 0

// Output:

// 1
// 0
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Graph {
    int v;
    int e;

    ArrayList<Integer>[] edges;

    public Graph(int v, int e) {
        this.v = v;
        this.e = e;

        edges = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        edges[u].add(v);
        edges[v].add(u);
    }

}

class Gfg {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();

            Graph g = new Graph(v, e);

            for (int i = 0; i < e; i++) {
                g.addEdge(sc.nextInt(), sc.nextInt());
            }

            Solution obj = new Solution();
            obj.isBridge(g, sc.nextInt(), sc.nextInt());
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// class Graph {
//     int v;   --> no of vertices
//     int e;   --> no of edges
//
//     ArrayList<Integer>[] edges; --> Adjacency list
//
// }

class Solution {

    public void DFS(Graph g,int v,boolean vis[])
    {
        vis[v]=true;
        for(int i=0;i<g.edges[v].size();i++)
        {
            int u=g.edges[v].get(i);
            if(!vis[u])
                DFS(g,u,vis);
        }
    }
    
    public boolean isConnected(Graph g,int one,int two)
    {
        boolean vis[]=new boolean[g.v];
        DFS(g,one,vis);
        if(vis[two]==false)
            return false;
        return true;
    }

    public void isBridge(Graph g, int u, int v) {

        if(isConnected(g,u,v)==false)
        {
            System.out.println(0);
            return;
        }
            
        g.edges[u].remove(new Integer(v));
        g.edges[v].remove(new Integer(u));
        
        if(isConnected(g,u,v)==false)
            System.out.println(1);
        else
            System.out.println(0);
        
    }
}
