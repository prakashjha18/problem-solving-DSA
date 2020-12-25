/*

Given a 2-Dimensional character array and a string, we need to find the given string in 
2-dimensional character array such that individual characters can be present left to right, 
right to left, top to down or down to top.

Examples:

Input : a ={
            {D,D,D,G,D,D},
            {B,B,D,E,B,S},
            {B,S,K,E,B,K},
            {D,D,D,D,D,E},
            {D,D,D,D,D,E},
            {D,D,D,D,D,G}
           }
        str= "GEEKS"
Output :2

Input : a = {
            {B,B,M,B,B,B},
            {C,B,A,B,B,B},
            {I,B,G,B,B,B},
            {G,B,I,B,B,B},
            {A,B,C,B,B,B},
            {M,C,I,G,A,M}
            }
        str= "MAGIC"

Output :3
*/


public class count2dar{
    public static void main(String args[]) 
    { 
        char[][] grid = { {'B','B','M','B','B','B'},
                          {'C','B','A','B','B','B'},
                          {'I','B','G','B','B','B'},
                          {'G','B','I','B','B','B'},
                          {'A','B','C','B','B','B'},
                          {'M','C','I','G','A','M'} }; 
        System.out.println(wordSearch(grid,"MAGIC"));
    } 
    public static int wordSearch(char[][] board, String word) 
    {
        // Your Code goes here
        int found = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0) ){
                    found += dfs(board,i,j,0,word);
                }
            }
        }
        return found;
    }
    public static int dfs(char[][] board,int i,int j,int count,String word){
        int found =0;
        
        if(i>=0 && i<board.length && j>=0 && j<board[i].length && board[i][j]==word.charAt(count)){
            if(count ==0 ){
               System.out.print(i+" "+j+" ");
            }
            char temp = word.charAt(count);
            count++;
            board[i][j] = ' ';
            if(count == word.length()){
                System.out.println(i+" "+j);
                found =1;
            } else {
                
                found += dfs(board,i+1,j,count,word);
                found += dfs(board,i-1,j,count,word);
                found += dfs(board,i,j+1,count,word);
                found += dfs(board,i,j-1,count,word);
                
                
            }
            board[i][j] = temp;
        }
        
        return found;
    }
}

