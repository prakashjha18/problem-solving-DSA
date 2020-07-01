// { Driver Code Starts
// Given a string str, your task is to complete the function countPs which takes a string str as its
// only argument and returns an integer denoting the no of palindromic subsequence (need not necessarily be distinct) 
// which could be formed from the string str.

// Input:
// The first line of input contains an integer T, denoting the no of test cases then T test cases follow. 
// Each test case contains a string str.

// Output:
// For each test case output will be an integer denoting the no of palindromic subsequence which could be
// formed from the string str.

// Constraints:
// 1<=T<=100
// 1<=length of string str <=30

// Example(To be used only for expected output):
// Input:
// 2
// abcd
// aab

// Output:
// 4
// 4

// Explanation:
// For the first test case
// palindromic subsequence are : "a" ,"b", "c" ,"d"

// For second test case
// palindromic subsequence are :"a", "a", "b", "aa"
import java.util.*;
class Palindromic_Strings
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			GfG g  = new GfG();
			System.out.println(g.countPS(str));
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete below method */
class GfG
{
    int countPS(String str1)
    {
        if(str1.length()==1) return 1;
        //return 2;
        char[] str = str1.toCharArray();
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(j<str.length){
                    if(str[i]==str[j]){
                        T[i][j] = T[i+1][j] +T[i][j-1]+1;
                    }
                    else {
                        T[i][j] = T[i+1][j] +T[i][j-1] - T[i+1][j-1];
                    }
                }
            }
        }
        return T[0][str.length-1];
        
    }
}
