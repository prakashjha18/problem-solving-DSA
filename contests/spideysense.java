/*package whatever //do not write package name here */
// Spiderman is stuck in a difficult situation. His arch enemy the Green Goblin has planted several of his infamous 
// Pumpkin Bombs in various locations in a building. Help Spiderman activate his Spidey Sense and identify the impact zones. 
// He has a blue print of the building which is a M x N matrix that is filled with the characters ‘O’, ‘B’, and ‘W’ where: 
// ‘O’ represents an open space.
// ‘B’ represents a bomb.
// ‘W’ represents a wall.
// You have to replace all of the O’s (open spaces) in the matrix with their shortest distance from a bomb without 
// being able to go through any walls. Also, replace the bombs with 0 and walls with -1 in the resultant matrix. 
// If no path exists between a bomb and an open space replace the corresponding 'O' with -1.

// Input:
// First line of input contains number of testcases T. For each testcase, first line contains space separated M 
// and N respectively. Then M lines will follow containing N characters each.

// Output:
// Print the resultant integer matrix that denotes shortest distance of each open space cell from a 
// bomb in the blue print of the building.

// Constraints: 
// 0 <= T <= 50
// 1 <= M,N <= 10

// Example:
// Sample Input:
// 1
// 3 3
// O O O
// W B B
// W O O

// Sample Output:
//  2 1 1 
// -1 0 0 
// -1 1 1 

// Explanation:
// The walls at (1,0) and (2,0) are replaced by -1.
// The bombs at (1,1) and (1,2) are replaced by 0.
// The impact zone for the bomb at (1,1) includes open spaces at index (0,0), (0,1) and (2,1) with distance from
// bomb calculated as 2,1,1 respectively.
// The impact zone for the bomb at (1,2) includes open spaces at index (0,3) and (2,2) with distance from bomb 
// calculated as 1,1 respectively.
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static void main (String[] args) throws IOException{
		//code
		
		//Scanner in = new Scanner(System.in);
		FastReader in=new FastReader(); 
	    int tc = in.nextInt();
	    while(tc-->0)
	    {
	        int n=in.nextInt();
	        int m=in.nextInt();
	        int arr[][]=new int[n][m];
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	                switch(in.next().charAt(0))
	                {
	                    case 'O':arr[i][j]=Integer.MAX_VALUE;
	                            break;
	                    case 'B':arr[i][j]=0;
	                            break;
	                    case 'W':arr[i][j]=-1;
	                            break;
	                }
	            }
	        }
	        util(arr,n,m);
	    }
	}
	public static void util(int arr[][], int n,int m){
	    int []dx = new int[]{0,0,-1,1};
        int []dy = new int[]{-1,1,0,0};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int nodecount = q.size();
            while(nodecount-->0){
                int []cur = q.poll();
                for(int i=0;i<4;i++){
                    int x = dx[i]+cur[0];
                    int y = dy[i]+cur[1];
                    if(x>=0 && y>=0 && x<n&& y<m && arr[x][y]!=-1 && arr[x][y]>1+arr[cur[0]][cur[1]]){
                        q.add(new int[]{x,y});
                        arr[x][y]=1+arr[cur[0]][cur[1]];
                    }
                }
            }
        }
	    for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==Integer.MAX_VALUE)
                    System.out.print(-1+" ");
                else
                    System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
	}
}
