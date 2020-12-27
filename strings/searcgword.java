/*package whatever //do not write package name here */
/*
Given a 2D grid (G[]) of characters and a word(x), find all occurrences of given word in grid. 
A word can be matched in all 8 directions at any point. Word is said be found in a direction 
if all characters match in this direction (not in zig-zag form).

The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically down 
and 4 Diagonal directions.

Example:

Input:  G[][] = {"GEEKSFORGEEKS",
                 "GEEKSQUIZGEEK",
                 "IDEQAPRACTICE"};
        x = "GEEKS"

Output: pattern found at 0, 0
        pattern found at 0, 8
        pattern found at 1, 0


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. 
Each test case contains two space separated integers N and M denoting the size of the grid. Then in the
next line are N * M space separated values of the grid. In the next line is the word x.

Output:
For each test case in a new line print the space separated sorted indexes of the matrix where after each 
index there is a ', ' . If there are no such occurences print -1.

Constraints:
1<=T<100
1<=N,M<=100
1<=G[]<=100

Example:
Input:
2
3 3
a b c d e f g h i
abc
4 3
a b a b a b e b e b e b
abe
Output:
0 0,
0 0, 0 2, 1 1,

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 }; 
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 }; 
    static boolean search2D(char[][] grid, int row,int col, String word) {
        if (grid[row][col] != word.charAt(0)) 
            return false;
            
        int len = word.length(); 
        for (int dir = 0; dir < 8; dir++){
            int k , rd = row + x[dir], cd = col + y[dir]; 
            for(k=1;k<len;k++){
                 if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0) 
                    break; 
                    
                if (grid[rd][cd] != word.charAt(k)) 
                    break; 
                    
                rd += x[dir]; 
                cd += y[dir]; 
            }
            if (k == len) 
                return true; 

        }
        return false;
        
    }
    static int patternSearch(char[][] grid,String word) { 
        int flag=0;
        for (int row = 0; row < grid.length; row++) { 
            for (int col = 0; col < grid[0].length; col++) { 
                if (search2D(grid, row, col, word)) {
                    flag=1;
                    System.out.print(row + " " + col+", "); 
                }
            } 
        } 
        return flag;
    } 
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int R = sc.nextInt();
		    int C = sc.nextInt();
		    char[][] grid  = new char[R][C];
		    for (int row = 0; row < grid.length; row++) { 
                for (int col = 0; col < grid[0].length; col++) { 
                    grid[row][col]=sc.next().charAt(0);
                } 
            } 
		    String str = sc.next();
		    int flag = patternSearch(grid, str);
		    
		    if(flag==0){
		        System.out.println(-1);
		    }else{
		        System.out.println();
		    }
		}
	}
}
