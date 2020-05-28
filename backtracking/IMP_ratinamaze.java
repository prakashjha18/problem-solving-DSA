// { Driver Code Starts
// Initial Template for Java
// Explanation:
// Testcase 2: The given input is in the form
// 1 0 0 0
// 1 1 0 1
// 1 1 0 0
// 0 1 1 1
// For the above matrix the rat can reach the destination at (3, 3) from (0, 0) by
// two paths ie DRDDRR and DDRDRR when printed in sorted order we get DDRDRR DRDDRR.
import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            GfG g = new GfG();
            ArrayList<String> res = g.printPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class GfG {
   
    public static ArrayList<String> result = new ArrayList<String>();
    public static boolean issafe(int x,int y,int n,int[][] visited,int[][] m){
        if(x<0 || x>n-1 || y<0 || y>n-1 || visited[x][y]==1 || m[x][y]==0)
            return false;
        return true;
    }

    public static void path(int[][] m, int x, int y, String dir, int n,int[][] visited) {
        if (x == n - 1 && y == n - 1) {
            result.add(dir);
            return;
        }
        
        visited[x][y] = 1;
        if (issafe(x-1,y,n,visited,m)) {
            path(m, x - 1, y, dir + 'U', n,visited);
        }
        if (issafe(x,y-1,n,visited,m)) {
            path(m, x, y - 1, dir + 'L', n,visited);
        }
        if (issafe(x+1,y,n,visited,m)) {
            path(m, x + 1, y, dir + 'D', n,visited);
        }
        if (issafe(x,y+1,n,visited,m)) {
            path(m, x, y + 1, dir + 'R', n,visited);
        }
        visited[x][y] = 0;
    }
    public static ArrayList<String> printPath(int[][] m, int n) {
        int[][] visited = new int[n][n];
        try {
            Arrays.fill(visited, 0);
        } catch (ArrayStoreException ex) {
        }
        result.clear();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return result;
        }

        path(m, 0, 0, "", n,visited);
        Collections.sort(result);
        return result;
    }
}
