// { Driver Code Starts
//Initial Template for Java
// Example:
// Input:
// 1
// 4
// GEEKS FOR QUIZ GO
// 3 3
// G I Z 
// U E K 
// Q S E
// Output:
// GEEKS QUIZ
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int x = sc.nextInt();
            String[] dictionary = new String[x];
            for(int i=0;i<x;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            
            char board[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution T = new Solution();
            String[] ans = T.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        //String sc[] = new String[1];
        ArrayList<String> al = new ArrayList<String>(); 
        for(String dct : dictionary){
            if(wordSearch(board,dct) == 1){
                al.add(dct);
            }
        }
        String sc[] = new String[al.size()];
        for(int i=0;i<al.size();i++){
            sc[i] = al.get(i);
        }
        return sc;
    }
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
            || dfs(board,i,j-1,count+1,word)
            || dfs(board,i-1,j-1,count+1,word)
            || dfs(board,i+1,j+1,count+1,word)
            || dfs(board,i+1,j-1,count+1,word)
            || dfs(board,i-1,j+1,count+1,word);
        
        board[i][j] = temp;
        return found;
    }
}
