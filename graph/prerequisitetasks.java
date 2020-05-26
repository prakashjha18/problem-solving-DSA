// { Driver Code Starts
//Initial Template for Java
// There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites,
// for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]

// Given the total number of tasks and a list of prerequisite pairs, find if it is possible to finish all tasks.

// Example:
// Input:
// 2
// 4
// 3
// 1 0
// 2 1
// 3 2
// 2
// 2
// 1 0
// 0 1
// Output:
// Yes
// No
import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int numTasks = sc.nextInt();
		    int n = sc.nextInt();
		    int prerequisites[][] = new int[n][2];
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution T = new Solution();
			if(T.canFinish(numTasks,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean canFinish(int numTasks, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         for(int i = 0; i < numTasks; i++)
                list.add(i, new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++){
                list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        
        }
        if(isCyclic(list,numTasks) == true)
            return false;
        return true;
    }
    public boolean isCyclicUtil(int i, boolean[] visited, 
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
  
    
    public boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
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
