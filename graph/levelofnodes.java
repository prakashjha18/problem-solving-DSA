// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args)throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov; i++) list.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int x = sc.nextInt();
            Level_of_Nodes g = new Level_of_Nodes();
           System.out.println(g.levels(list, nov, x));
        }
    }
}// } Driver Code Ends


// User function Template for Java

/*ArrayList<ArrayList<Integer>> list: to represent graph containing vertices
                                    and edges between them
x: starting vertex of graph
in: represent vertex whose level we have to find
*/
class Level_of_Nodes {

    static int levels(ArrayList<ArrayList<Integer>> list, int n, int x) {
        // source.
        int in = 0;
        // if x is source vertex.
        if(x==in)
          return 0;
        if(x >= n) 
            return -1;
        int level[] = new int[n];
        boolean visited[] = new boolean[n];

        Arrays.fill(level, 0);

        Queue<Integer> q = new LinkedList<>();
        q.add(in);

        visited[in] = true;
        level[in] = 0;
        // use bfs technique
        while (!q.isEmpty()) {

            in = q.peek();
            if(!q.isEmpty())
                q.poll();
            // assign level to adjacent nodes of the current node
            for (int i = 0; i < list.get(in).size(); i++) {
                int b = list.get(in).get(i);

                if (!visited[b]) {
                    q.add(b);
                    level[b] = level[in] + 1;
                    visited[b] = true;
                }
            }
        }

        if(level[x]!=0)
            return level[x];
        else return -1; 
    }
}
