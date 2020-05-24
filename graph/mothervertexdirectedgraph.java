// { Driver Code Starts
//Initial Template for Java
// Example:
// Input:
// 2
// 5 5
// 1 0 0 2 2 1 0 3 3 4
// 3 2
// 0 1 2 1

// Ouput:
// 0
// -1

// Explanation:
// Testcase 1: According to the given edges, all nodes can be reaced from nodes from 0, 1 and 2. 
// But, since we are traversing from node 0, so 0 is the output.

// Testcase 2: According to the given edges, 
// no vertices are there from where we can reach all vertices. So, output is -1.
import java.util.*;
import java.io.*;
import java.lang.*;


class DriverClass
{
    public static void main (String[] args)throws IOException 
    {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String str[] = read.readLine().trim().split(" ");
            
            int nov = Integer.parseInt(str[0]);
            int edg = Integer.parseInt(str[1]);
            
            for(int i = 0; i< nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            
            int k = 0;
            str = read.readLine().trim().split(" ");
            for(int i = 1; i <= edg; i++)
            {    int u = Integer.parseInt(str[k++]);
                 int v = Integer.parseInt(str[k++]);
                 list.get(u).add(v);
                 
                
            }
          System.out.println(new MotherVertex().findMother(list, nov));
		}
    }
}




// } Driver Code Ends


//User function Template for Java

/*
*ArrayList<ArrayList<Integer>> list: arraylist of arraylist which represents graph
*n: represents number of vertex in graph
*/
class MotherVertex
{
    static void dfs(int src,  boolean vis[],ArrayList<ArrayList<Integer>> list)
    {
       
         vis[src]=true;                          // Mark the current source vertex as visited
         //System.out.print(src + " ");           // Print the vertex
        for(int i=0;i<list.get(src).size();i++) // Traverse through all the connected components of vertex s
        {
            
            if(!vis[list.get(src).get(i)])          // If they are not visited, call dfs for the new connected vertex
                dfs(list.get(src).get(i),vis,list); 
        }
    }
    static int findMother(ArrayList<ArrayList<Integer>> list, int n)
    {
        // add your code here
        int mother =0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                //System.out.print("+");
                dfs(i,visited,list);
                mother=i;
            }
        }
        boolean vis[]=new boolean[n];
        dfs(mother,vis,list);
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                return -1;
            }
        }
        return mother;
    }
    
}

