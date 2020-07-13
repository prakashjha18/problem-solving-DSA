// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int V = scan.nextInt();
            int C = scan.nextInt();
            int E = scan.nextInt();

            List<Integer>[] G = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                G[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                G[u].add(v);
                G[v].add(u);
            }
            int[] color = new int[V];

            System.out.println(new solve().graphColoring(G, color, 0, C) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    public static boolean issafe(List<Integer>[] G,int V,int v, int rang,int[] color) {
        for(int i=0;i<G[v].size();i++){
            if( color[G[v].get(i)]== rang){
                return false;
            }
        }
        return true;
    }
    public static boolean check(List<Integer>[] G, int C,int V,int v, int[] color) {
        //System.out.print(v);
        
        if(v==V)
            return true;
        for(int i=1;i<=C;i++){
            if(issafe(G,V,v,i,color)){
                color[v]=i;
                if(check(G,C,V,v+1,color))
                    return true;
                color[v]=0;
            }
        }
        return false;
    }
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
        // Your code here
        int V =G.length;
        // for(int k=0;k<G.length;k++){
        //     for(int j=0;j<G[k].size();j++){
        //         System.out.print(G[k].get(j));
        //     }    
        //     System.out.println();
        // }
        // System.out.print(V+"PP");
        return check(G,C,V,0,color);
    }
}
