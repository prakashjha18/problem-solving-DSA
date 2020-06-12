// In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

// Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

// Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

// Example 1:

// Input: A = [[0,1],[1,0]]
// Output: 1
// Example 2:

// Input: A = [[0,1,0],[0,0,0],[0,0,1]]
// Output: 2
// Example 3:

// Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
// Output: 1

class Solution {
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for(int i=0;i<m;i++){
            if(found)
                break;
            else{
                for(int j=0;j<n;j++){
                    if(A[i][j]==1){
                        dfs(A, visited, q, i, j, dirs);
                        found = true;
                        break;
                    }
                }
            }
        }
        int step =0;
        while(!q.isEmpty()){
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for(int[] dir: dirs){
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if(i>=0 && j>=0 && i < m && j < n && !visited[i][j]){
                        if(A[i][j]==1)
                                return step;
                        q.offer(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
                
            }
            step++;
        }
        return -1;
        
    }
    public void dfs(int[][] A,boolean[][] visited,Queue<int[]> q,int i,int j,int[][] dirs){
        if(i<0 || j<0||i>=A.length || j>=A[0].length || visited[i][j] || A[i][j] == 0){
            return;
        }
        visited[i][j] = true;
        q.offer(new int[]{i,j});
        for(int[] dir: dirs){
            dfs(A,visited,q,i+dir[0],j+dir[1],dirs);
        }
    }
}
