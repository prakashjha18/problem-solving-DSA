// 323. Number of Connected Components in an Undirected Graph
// Solved
// Medium
// Topics
// conpanies icon
// Companies
// You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

// Return the number of connected components in the graph.

 

// Example 1:


// Input: n = 5, edges = [[0,1],[1,2],[3,4]]
// Output: 2
// Example 2:


// Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
// Output: 1

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge: edges ){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        int components = 0;
        boolean[] visited =  new boolean[n];
        for(int v=0; v<n; v++){
            components += bfs(v, adjacencyList, visited);
        }
        return components;
    }

    private int bfs(int src, List<List<Integer>> adjacencyList,  boolean[] visited ){
        if(visited[src]) return 0;
        visited[src] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : adjacencyList.get(node)){
                if(!visited[neighbour]){
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return 1;
    }
}