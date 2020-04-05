// { Driver Code Starts
import java.util.*;

class Matrix_In_Diagonal_Pattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n= sc.nextInt();
			int a[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j] = sc.nextInt();
				}
			}
			GfG g = new GfG();
			g.printMatrixDiagonal(a,n);
			System.out.println();
		t--;
		}
	}
}// } Driver Code Ends
class GfG
{
    /*You are required to complete this method */
    void printMatrixDiagonal(int mat[][], int n)
    {
        // Your code here
        int i = 0, j = 0; 
  
        // Direction is initially from down to up 
        boolean isUp = true; 
  
        // Traverse the matrix till all elements get traversed 
        for (int k = 0; k < n * n;) { 
            // If isUp = true then traverse from downward 
            // to upward 
            if (isUp) { 
                for (; i >= 0 && j < n; j++, i--) { 
                    //System.out.print(mat[i][j] +""+ i+""+j+""+"up "); 
                    System.out.print(mat[i][j] + " "); 
                    k++; 
                } 
  
                // Set i and j according to direction 
                if (i < 0 && j <= n - 1) 
                    i = 0; 
                if (j == n) { 
                    i = i + 2; 
                    j--; 
                } 
            } 
  
            // If isUp = 0 then traverse up to down 
            else { 
                for (; j >= 0 && i < n; i++, j--) { 
                    //System.out.print(mat[i][j] +""+ i+""+j+""+ "down "); 
                    System.out.print(mat[i][j] + " "); 
                    k++; 
                } 
  
                // Set i and j according to direction 
                if (j < 0 && i <= n - 1) 
                    j = 0; 
                if (i == n) { 
                    j = j + 2; 
                    i--; 
                } 
            } 
  
            // Revert the isUp to change the direction 
            isUp = !isUp; 
        } 
    }

}
