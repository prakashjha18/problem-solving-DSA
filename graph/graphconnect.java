// Java program to print connected components in  
// an undirected graph  
import java.util.*;
class graphconnect {
    int V;
    ArrayList<Integer>[] adjListArray;
      
    graphconnect(int V) {
        this.V = V; 
        adjListArray = new ArrayList[V];
  
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new ArrayList<Integer>(); 
        }
    }
      
    // Adds an edge to an undirected graph 
    void addEdge( int src, int dest) { 
        adjListArray[src].add(dest); 
  
        adjListArray[dest].add(src); 
    } 
      
    void DFSUtil(int v, boolean[] visited) { 
        visited[v] = true; 
        System.out.print(v+" "); 
        for (int x : adjListArray[v]) { 
            if(!visited[x]) DFSUtil(x,visited); 
        } 
  
    } 
    void connectedComponents() { 
        boolean[] visited = new boolean[V]; 
        for(int v = 0; v < V; ++v) { 
            if(!visited[v]) { 
                DFSUtil(v,visited); 
                System.out.println(); 
            } 
        } 
    } 
      
    public static void main(String[] args){ 
        graphconnect g = new graphconnect(5); 
        g.addEdge(1, 0);  
        g.addEdge(2, 3);  
        g.addEdge(3, 4); 
        System.out.println("Following are connected components"); 
        g.connectedComponents(); 
    } 
}    
