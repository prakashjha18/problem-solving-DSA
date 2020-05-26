// { Driver Code Starts
//Initial Template for Java
// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example:

// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]

// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
		while(t>0)
		{
		    String[] s = br.readLine().split(" ");
		    int m = Integer.parseInt(s[0]);
		    int n = Integer.parseInt(s[1]);
		    
		    char [][] board = new char[m][n];
		    for(int i=0;i<m;i++)
		    {
		        String[] s2 = br.readLine().split(" ");
		        for(int j=0;j<n;j++)
		        {
		            board[i][j] = s2[j].charAt(0);
		        }
		    }
		    
		    
		    String word = br.readLine().trim();
		    Solution T = new Solution();
		    System.out.println(T.wordSearch(board,word));
 			t--;
		}
    }
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public int wordSearch(char[][] board, String word) 
    {
        // Your Code goes here
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0) && dfs(board,i,j,0,word)){
                    return 1;
                }
            }
        }
        return 0;
    }
    public boolean dfs(char[][] board,int i,int j,int count,String word){
        if(count == word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(count)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board,i+1,j,count+1,word)
            || dfs(board,i-1,j,count+1,word)
            || dfs(board,i,j+1,count+1,word)
            || dfs(board,i,j-1,count+1,word);
        
        board[i][j] = temp;
        return found;
    }
    
    
}
