// { Driver Code Starts
import java.lang.Math;
import java.util.*;
class UniqueRows{
public static void main(String[] args)
 {  Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			int[][] a=new int [r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			g.printMat(a,r,c);
			System.out.println();
		}
 }
}// } Driver Code Ends
/*Complete the given function*/
class GfG
{
    public static void printMat(int arr[][], int row,int col)
    {
        //add code here.
        HashSet<String> set = new HashSet<String>(); 
  
        for(int i = 0; i < row; i++) 
        { 
            String s = ""; 
              
            for(int j = 0; j < col; j++)  
                s += String.valueOf(arr[i][j])+" "; 
            s=s+"$";
            if(!set.contains(s)) { 
                set.add(s); 
                System.out.print(s); 
                  
            } 
        } 
    }
}
