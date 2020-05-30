// Input
// 2
// banana ban
// geeksforgeeks ge
// Output
// 3
// 6
// Explanation:
// (i) For first test case  S = banana, T = ban there are 3 sub-sequences which are [ban], [ba n], [b an].
// (ii) For second test case S = geeksforgeeks, T=ge there are 6 sub-sequences which are  [ge], [ ge], [g e], [g e] [g e] and [ g e].
// { Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			GfG g = new GfG();
			System.out.println(g.subsequenceCount(S,T));
			t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method*/
class GfG
{
    int  subsequenceCount(String S, String T)
    {
	// Your code here	
	     int[][] mem = new int[T.length()+1][S.length()+1];

    // filling the first row: with 1s
    for(int j=0; j<=S.length(); j++) {
        mem[0][j] = 1;
    }
    
    // the first column is 0 by default in every other rows but the first, which we need.
    
    for(int i=0; i<T.length(); i++) {
        for(int j=0; j<S.length(); j++) {
            if(T.charAt(i) == S.charAt(j)) {
                mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
            } else {
                mem[i+1][j+1] = mem[i+1][j];
            }
        }
    }
    // for(int i=0; i<=T.length(); i++) {
    //     for(int j=0; j<=S.length(); j++) {
    //         System.out.print(mem[i][j]+" ");
    //     }
    //     System.out.println();
    // }
    return mem[T.length()][S.length()];
    }
}
