// { Driver Code Starts
// Initial Template for Java
// Input
// 2
// 3 3
// 1 1 0 0 0 1 1 0 1
// 4 4
// 1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0

// Output
// 2
// 2

// Explanation:
// Testcase 1: The graph will look like
// 1 1 0
// 0 0 1
// 1 0 1
// Here, two islands will be formed
// First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][2]}
// Second island will be formed by {A[2][0]}.
// Testcase 2: The graph will look like
// 1 1 0 0
// 0 0 1 0
// 0 0 0 1
// 0 1 0 0
// Here, two islands will be formed
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            // creating arraylist of arraylist
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }

            // adding elements to the arraylist of arraylist
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }

            System.out.println(new Islands().findIslands(list, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Islands {
    static int ROW=0;
    static int COL=0;
    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static boolean isSafe(ArrayList<ArrayList<Integer>> list, int row, int col, 
                   boolean visited[][]){ 
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (list.get(row).get(col) == 1 && !visited[row][col]); 
    } 
    static void DFS(ArrayList<ArrayList<Integer>> list, int row, int col, boolean visited[][]){ 
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
        visited[row][col] = true; 
        for (int k = 0; k < 8; ++k) 
            if (isSafe(list, row + rowNbr[k], col + colNbr[k], visited)) 
                DFS(list, row + rowNbr[k], col + colNbr[k], visited); 
    } 
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M){
        boolean visited[][] = new boolean[N][M]; 
        ROW=N;
        COL=M;
        int count = 0; 
        for (int i = 0; i < N; ++i) 
            for (int j = 0; j < M; ++j) 
                if (list.get(i).get(j) == 1 && !visited[i][j]){
                    DFS(list, i, j, visited); 
                    ++count; 
                } 
  
        return count; 
    }
}
