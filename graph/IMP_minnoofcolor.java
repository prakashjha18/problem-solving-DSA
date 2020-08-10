https://www.geeksforgeeks.org/minimum-number-of-colors-required-to-color-a-graph/
import java.util.*; 
  
class minnoofcolor 
{ 
  
// Function to count the minimum 
// number of color required 
static void minimumColors(int N, int E, 
                int U[], int V[]) 
{ 
  
    // Create array of vectors 
    // to make adjacency list 
    List<Integer>[] adj = new ArrayList[N];
  
    // Intialise colors array to 1 
    // and count array to 0 
    int []count = new int[N]; 
    int []colors = new int[N]; 
    for (int i = 0; i < N; i++) { 
        adj[i] = new ArrayList<>(); 
        colors[i] = 1; 
    } 
      
    // Create adjacency list of 
    // a graph 
    for (int i = 0; i < E; i++) { 
        adj[V[i] - 1].add(U[i] - 1); 
        count[U[i] - 1]++; 
    } 
    // for(int x:colors){
    //     System.out.print(x+" ");
    // }
    // System.out.println();
    // for(int x:count){
    //     System.out.print(x+" ");
    // }
    // Declare queue Q 
    Queue<Integer> Q = new LinkedList<>(); 
  
    // Traverse count[] and insert 
    // in Q if count[i] = 0; 
    for (int i = 0; i < N; i++) { 
        if (count[i] == 0) { 
            Q.add(i); 
        } 
    } 
    //System.out.print(Q);
    // Traverse queue and update 
    // the count of colors 
    // adjacent node 
    while (!Q.isEmpty()) { 
        int u = Q.peek(); 
        Q.remove(); 
  
        // Traverse node u 
        for (int x : adj[u]) { 
            count[x]--; 
  
            // If count[x] = 0 
            // insert in Q 
            if (count[x] == 0) { 
                Q.add(x); 
            } 
  
            // If colors of child 
            // node is less than 
            // parent node, update 
            // the count by 1 
            if (colors[x] <= colors[u]) { 
                colors[x] = 1 + colors[u]; 
            } 
            
        } 
        //System.out.print(Q);
    } 
  
    // Stores the minimumColors 
    // requires to color the graph. 
    int minColor = -1; 
  
    // Find the maximum of colors[] 
    for (int i = 0; i < N; i++) { 
        minColor = Math.max(minColor, colors[i]); 
    } 
    // for(int x:colors){
    //     System.out.print(x+" ");
    // }
    // Print the minimum no. of 
    // colors required. 
    System.out.print(minColor +"\n"); 
} 
  
// Driver function 
public static void main(String[] args) 
{ 
    int N = 3, E = 3; 
    // int U[] = { 1, 2, 3, 1, 2, 3 }; 
    // int V[] = { 3, 3, 4, 4, 5, 5 }; 
    int U[] = { 1, 2, 1}; 
    int V[] = { 2, 3, 3 }; 
  
    minimumColors(N, E, U, V); 
} 
} 
  
