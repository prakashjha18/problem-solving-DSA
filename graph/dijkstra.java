// { Driver Code Starts
//Initial Template for Java
//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1/?track=amazon-graphs&batchId=192
// Example:
// Input:
// 2
// 2
// 0 25 25 0
// 0
// 3
// 0 1 43 1 0 6 43 6 0
// 2

// Output:
// 0 25
// 7 6 0
import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        
        while(t > 0)
        {
            int V = Integer.parseInt(sc.next());;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(V);
            for(int i = 0;i < V; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>(V);
                list.add(i, temp);
            }
            
            for(int i = 0; i < V; i++)
            {
                ArrayList<Integer> temp = list.get(i);
                for(int j = 0; j < V; j++)
                {
                    temp.add(Integer.parseInt(sc.next()));
                }
                list.add(temp);
            }
            int s = Integer.parseInt(sc.next());;
            Solution T = new Solution();
            T.dijkstra(list, s, V);
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

// Function to implement Djikstra
// list: adjacency list representing the graph
// src: source vertex to start traversal
// V: number of vertices

class Solution
{
    static int minDistance(int dist[], Boolean sptSet[],int V) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    static void dijkstra(ArrayList<ArrayList<Integer>> graph, int src, int V)
    {
        // Write your code here
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
        dist[src] = 0; 
        for (int count = 0; count < V - 1; count++) { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, sptSet,V); 
            System.out.print(u+"___");
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph.get(u).get(v) != 0 && dist[u] != Integer.MAX_VALUE && 
                        dist[u] + graph.get(u).get(v) < dist[v]) 
                    dist[v] = dist[u] + graph.get(u).get(v); 
        }
        for(int o : dist)
            System.out.print(o+" ");
    }
}

