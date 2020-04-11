//       Given a number N, your task is to complete the function which generates all n-bit grey code sequences, a grey code sequence is a sequence such that successive patterns in it differ by one bit.

// Input:
// The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N.

// Output:
// For each test case in print the generated grey code sequences separated by space.

// Constraints:
// 1<=T<=10
// 1<=N<=10

// Example(To be used for expected output):
// Input:
// 2
// 2
// 1

// Output:
// 00 01 11 10
// 0 1
// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;

class GreyCode
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			GfG g = new GfG();
			g.generateCode(n);
			System.out.println();
		t--;
		}
	}
}// } Driver Code Ends
/*Prints the space separated n-bit gray codes sequence.
You are required to complete below method. */
class GfG
{
    void generateCode(int n)
    {
    	// base case  
        if (n <= 0)  
            return;  
      
        // 'arr' will store all generated codes  
        ArrayList<String> arr = new ArrayList<String> ();  
      
        // start with one-bit pattern  
        arr.add("0");  
        arr.add("1");  
      
        // Every iteration of this loop generates 2*i codes from previously  
        // generated i codes.  
        int i, j;  
        for (i = 2; i < (1<<n); i = i<<1)  
        {  
            // Enter the prviously generated codes again in arr[] in reverse  
            // order. Nor arr[] has double number of codes.  
            for (j = i-1 ; j >= 0 ; j--)  
                arr.add(arr.get(j));  
      
            // append 0 to the first half  
            for (j = 0 ; j < i ; j++)  
                arr.set(j, "0" + arr.get(j));  
      
            // append 1 to the second half  
            for (j = i ; j < 2*i ; j++)  
                arr.set(j, "1" + arr.get(j));  
        }  
      
        // print contents of arr[]  
        for (i = 0 ; i < arr.size() ; i++ )  
            System.out.print(arr.get(i)+" ");  
    }
}
