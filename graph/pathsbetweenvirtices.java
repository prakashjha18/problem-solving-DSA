// { Driver Code Starts
// Initial Template for Java
// Example:
// Input:
// 1
// 5 7
// 1 2 1 3 1 5 2 4 2 5 3 5 4 3
// 1 5

// Output:
// 4

// Explanation:
// Testcase 1 :  
//                       There are 4 paths from 1 to 5.
//                       1 -> 5
//                       1 -> 2 -> 5
//                       1 -> 3 -> 5
//                       1 -> 2 -> 4 -> 3 -> 5
import java.util.*;
import java.io.*;
import java.lang.*;
class Graph {
    int size;
    Graph(int V) { this.size = V; }
    Graph() {}
    static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        // list.get(v).add(u);
    }
} class DriverClass {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String str[] = read.readLine().trim().split(" ");
            int nov = Integer.parseInt(str[0]);
            int edg = Integer.parseInt(str[1]);

            // int nov = sc.nextInt();
            // int edg = sc.nextInt();

            new Graph(nov);
            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            str = read.readLine().trim().split(" ");
            int k = 0;
            for (int i = 1; i <= edg; i++) {
                int u = Integer.parseInt(str[k++]);
                int v = Integer.parseInt(str[k++]);
                new Graph().addEdge(list, u, v);
            }
            str = read.readLine().trim().split(" ");
            int s = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            System.out.println(new Path().countPaths(list, s, d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// class Graph
// {
//     int size;
//     Graph(int V)
//     {
//         this.size = V;

//     }
//     Graph()
//     {}
//     static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v)
//     {
//         list.get(u).add(v);
//         // list.get(v).add(u);
//     }
// }
class Path {
    static int count=0;
    static void path_count(ArrayList<ArrayList<Integer>> list,int s,int d,boolean vis[]){
        //vis[s]=true;  
        //System.out.print(s + " ");     
        if(s==d){
            count++;
        }
        else {      
            for(int i=0;i<list.get(s).size();i++) 
            {
                if(!vis[list.get(s).get(i)])          
                    path_count(list,list.get(s).get(i),d,vis); 
            }
        }
        //vis[s]=false;
    }
    static int countPaths(ArrayList<ArrayList<Integer>> list, int s, int d) {
        // add your code here
        count=0;
        boolean visited[] = new boolean[list.size()];
        path_count(list,s,d,visited);
        // for(ArrayList<Integer> o : list)
        //     System.out.print(o);
        return count;
        
    }
}
