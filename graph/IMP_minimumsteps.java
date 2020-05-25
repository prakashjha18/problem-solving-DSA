// { Driver Code Starts
// Initial Template for Java
//https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
import java.io.*;
import java.util.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble() { return Double.parseDouble(next()); }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

class GFG {
    public static void main(String[] args) {

        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ;
            int knightpos[] = new int[2];
            knightpos[0] = sc.nextInt();
            ;
            knightpos[1] = sc.nextInt();
            ;
            int targetpos[] = new int[2];
            targetpos[0] = sc.nextInt();
            ;
            targetpos[1] = sc.nextInt();

            Solution T = new Solution();
            System.out.println(T.minStepToReachTarget(knightpos, targetpos, n));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class cell  {  
    int x, y;  
    int dis;  
    public cell(int x, int y, int dis){ 
        this.x = x; 
        this.y = y; 
        this.dis = dis; 
    } 
}
class Solution {
    static boolean isInside(int x, int y, int N){  
        if (x >= 1 && x <= N && y >= 1 && y <= N)  
            return true;  
        return false;  
    }  
  
    public int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        // Write your code here
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};  
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1}; 
        
        Queue<cell> q= new LinkedList<cell>();
        q.add(new cell(knightPos[0], knightPos[1], 0));  
        cell t ;  
        int x, y;  
        boolean visit[][] = new boolean[N + 1][N + 1]; 
        visit[knightPos[0]][knightPos[1]] = true;  
   
        while (!q.isEmpty())  
        {  
            t = q.remove();
            // if current cell is equal to target cell,  
            // return its distance  
            if (t.x == targetPos[0] && t.y == targetPos[1])  
                return t.dis;  
      
            // loop for all reachable states  
            for (int i = 0; i < 8; i++)  
            {  
                x = t.x + dx[i];  
                y = t.y + dy[i];  
      
                // If reachable state is not yet visited and  
                // inside board, push that state into queue  
                if (isInside(x, y, N) && !visit[x][y]) 
                {  
                    visit[x][y] = true;  
                    q.add(new cell(x, y, t.dis + 1));  
                }  
            }  
        }  
            return Integer.MAX_VALUE; 
  
    }
}
