// { Driver Code Starts
// Initial Template for Java
// Testcase 1: Matrix can be shown as follows:
// 1 1 0
// 0 0 1
// 1 0 1

// Largest region of 1s in the above matrix is with total 4 1s (colored in Red).
import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass {
    static int SIZE = 100;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int g[][] = new int[SIZE][SIZE];
            boolean vis[][] = new boolean[SIZE][SIZE];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) g[i][j] = sc.nextInt();
            }

            System.out.println(new Area().findAreaUtil(n, m, g, vis));
        }
    }
}// } Driver Code Ends


// User function Template for Java

/*
*   SIZE: declared globally for matrix definition
*   n, m: row and column of matrix
*   g[][]: 2D matrix from input
*   vis[][]: visited array
*/
class Area {
    static int count;
    static boolean isSafe(int[][] M, int row,  
                        int col, boolean[][] visited,int ROW,int COL){ 
            return ((row >= 0) && (row < ROW) && (col >= 0) 
                    && (col < COL) && (M[row][col] == 1 &&  
                    !visited[row][col]));  
    }
    static void DFS(int[][] M, int row,  
                    int col, boolean[][] visited,int ROW,int COL){ 
        int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1}; 
        int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1}; 
        visited[row][col] = true; 
        for (int k = 0; k < 8; k++)  { 
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited,ROW,COL)){ 
                count++; 
                DFS(M, row + rowNbr[k], col + colNbr[k], visited,ROW,COL); 
            } 
        } 
    }
    static int findAreaUtil(int ROW, int COL, int M[][], boolean visited[][]) {
        int result = 0; 
        for (int i = 0; i < ROW; i++){ 
            for (int j = 0; j < COL; j++){  
                    if (M[i][j] == 1 && !visited[i][j]){ 
                        count = 1; 
                        DFS(M, i, j, visited,ROW,COL); 
                        result = Math.max(result, count); 
                } 
            } 
        } 
        return result; 
    }
}
