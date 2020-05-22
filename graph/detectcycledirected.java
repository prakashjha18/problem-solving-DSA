// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

/*
ArrayList<ArrayList<Integer>> list: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static boolean isCyclicUtil(int i, boolean[] visited, 
                                      boolean[] recStack,ArrayList<ArrayList<Integer>> list)  
    { 
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        List<Integer> children = list.get(i); 
          
        for (Integer c: children) 
            if (isCyclicUtil(c, visited, recStack,list)) 
                return true; 
                  
        recStack[i] = false; 
  
        return false; 
    } 
  
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        // add your code here
        boolean[] visited = new boolean[V]; 
        boolean[] recStack = new boolean[V]; 
          
        // for(ArrayList<Integer> l : list){
        //     System.out.print(l);
        // }  
        // Call the recursive helper function to 
        // detect cycle in different DFS trees 
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil(i, visited, recStack,list)) 
                return true; 
  
        return false; 
    }
}
