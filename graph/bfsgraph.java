// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass {
    public static void main(String args[]) {
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
            }
            boolean vis[] = new boolean[nov];
            for (int i = 0; i < nov; i++) vis[i] = false;
            new Traversal().bfs(0, list, vis, nov);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*ArrayList<ArrayList<Integer>> list: represent graph containing vertices
                                    and edges between them
*vis[]: boolean array to represent visited vertex
*s: starting vertex
*/
class Traversal {
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[],
                    int nov) {
        // add your code here
        LinkedList<Integer>queue = new LinkedList<>();
        //System.out.println(node);
		queue.add(s); //add source node to queue
		while(!queue.isEmpty()) {
			Integer presentNode = queue.remove(0);
			vis[presentNode]=true;
			System.out.print(presentNode+" ");
			for(Integer neighbor: list.get(presentNode)) { //for each neighbor of present node
				if(!vis[neighbor]) { //if neighbor is not visited then add it to queue
					queue.add(neighbor);
					vis[neighbor]=true;
				}
			}//end of for loop
		}//end of while loop
    }
}
