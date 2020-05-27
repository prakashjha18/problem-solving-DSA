// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

  public class Driver_class {

    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < V; j++) temp.add(Integer.MAX_VALUE);
                graph.add(temp);
            }
            str = read.readLine().trim().split(" ");
            int k = 0;
            while (E-- > 0) {
                int u = Integer.parseInt(str[k++]);
                int v = Integer.parseInt(str[k++]);
                int w = Integer.parseInt(str[k++]);
                u--;
                v--;
                graph.get(u).set(v, w);
                graph.get(v).set(u, w);
            }

            System.out.println(new MST().spanningTree(V, E, graph));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class MST {
    static int minKey(int key[], boolean mstSet[], int V) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = 0;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int[V];

        // To represent set of vertices not yet included in MST
        boolean mstSet[] = new boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        // Make key 0 so that this vertex is picked as first vertex.
        key[0] = 0;
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the
            // set of vertices not yet included in MST
            int u = minKey(key, mstSet, V);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of
            // the adjacent vertices of the picked vertex.
            // Consider only those vertices which are not
            // yet included in MST
            for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph.get(u).get(v) != 0 && mstSet[v] == false &&
                    graph.get(u).get(v) < key[v]) {
                    parent[v] = u;
                    key[v] = graph.get(u).get(v);
                }
        }
        // print the constructed MST
        int cost =0;
        for(int i=1;i<V;i++){
            cost+=key[i];
        }
        return cost;
        //return costofMST(parent, graph, V);
    }
}
