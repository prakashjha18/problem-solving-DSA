// { Driver Code Starts
// Initial Template for Java
// Input : N = 3, M = 4
//         mat[][] = { 0, 0, 0, 1,
//                     0, 0, 1, 1,
//                     0, 1, 1, 0 }
// Output : 3 2 1 0
//          2 1 0 0
//          1 0 0 1
// Explanation:
// For cell at (0, 0), nearest 1 is at (0, 3),
// so distance = (0 - 0) + (3 - 0) = 3.
// Similarly, all the distance can be calculated.

// Input : N = 3, M = 3
//         mat[][] = { 1, 0, 0, 
//             0, 0, 1, 
//             0, 1, 1 }
// Output :
//       0 1 1 
//       1 1 0 
//       1 0 0 
// Explanation:
// For cell at (0, 1), nearest 1 is at (0, 0), so distance
// is 1. Similarly, all the distance can be calculated.
import java.util.*;
import java.io.*;
import java.io.*;

class Driver_class {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(row);

            for (int i = 0; i < row; i++) {
                ArrayList<Integer> temp = new ArrayList<>(col);
                list.add(i, temp);
            }
            int k = 0;
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int val = Integer.parseInt(str[k++]);
                    list.get(i).add(j, val);
                }
            }
            new Distance().nearest(list, row, col);
        }
    }

    static void print(ArrayList<ArrayList<Integer>> sol, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(sol.get(i).get(j) + " ");
        }

        System.out.println();
    }
}
// } Driver Code Ends


// User function Template for Java

/*  Function to find the distance of nearest cell having 1
*   arr: ArrayList of ArrayList to represent graph
*   row, col: rows and cols in given matrix
*/
// Input : N = 3, M = 4
//         mat[][] = { 
//                     0, 0, 0, 1,
//                     0, 0, 1, 1,
//                     0, 1, 1, 0 
//                   }
// Output : 3 2 1 0
//          2 1 0 0
//          1 0 0 1

// For cell at (0, 0), nearest 1 is at (0, 3),
// so distance = (0 - 0) + (3 - 0) = 3.
// Similarly all the distance can be calculated.
class Pair {
    
    int row;
    int col;
    boolean visited;
    
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public String toString() {
	    return  row+","+col;
    }
}

class Distance {
    
    private static int ROW;
    private static int COL;
    private static int n = 4;
    private static int[] rDir = {-1, 0, 0, 1};
    private static int[] cDir = { 0,-1, 1, 0};
    
    
    public static boolean isValid(int row, int col) {
        boolean isRow = row >= 0 && row < ROW;
        boolean isCol = col >= 0 && col < COL;
        if (isRow && isCol)
            return true;
        return false;
    }

    public static void nearest(ArrayList<ArrayList<Integer>> list, int row, int col) {
        ROW = row;
        COL = col;
        Queue<Pair> queue = new LinkedList<>();
        int[][] distance = new int[row][col];
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (list.get(r).get(c) == 1) {
                    distance[r][c] = 0;
                    queue.offer(new Pair(r, c));
                } else distance[r][c] = Integer.MAX_VALUE;
            }
        }
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int rCurr = curr.row;
            int cCurr = curr.col;
            for (int index = 0; index < n; ++index) {
                int i = rCurr + rDir[index];
                int j = cCurr + cDir[index];
                if (isValid(i, j) && distance[i][j] > distance[rCurr][cCurr] + 1) {
                    distance[i][j] = distance[rCurr][cCurr] + 1;
                    queue.offer(new Pair(i, j));
                }
            }
        }
        StringBuffer res = new StringBuffer();
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                res.append(distance[r][c] + " ");
            }
        }
        System.out.println(res);
    } 
}
