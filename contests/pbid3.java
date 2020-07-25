// Dole Out Cadbury
// Problem Description
// You are a teacher in reputed school. During Celebration Day you were assigned a task to distribute Cadbury such that maximum children
//  get the chocolate. You have a box full of Cadbury with different width and height. You can only distribute largest square shape Cadbury. So 
//  if you have a Cadbury of length 10 and width 5, then you need to break Cadbury in 5X5 square and distribute to first child and then 
//  remaining 5X5 to next in queue

// Constraints
// 0<P<Q<1501

// 0<R<S<1501

// Input Format
// First line contains an integer P that denotes minimum length of Cadbury in the box

// Second line contains an integer Q that denotes maximum length of Cadbury in the box

// Third line contains an integer R that denotes minimum width of Cadbury in the box

// Fourth line contains an integer S that denotes maximum width of Cadbury in the box

// Output
// Print total number of children who will get chocolate.

// Timeout
// 1

// Explanation
// Example 1

// Input

// 5

// 7

// 3

// 4

// Output

// 24

// Explanation

// Length is in between 5 to 7 and width is in between 3 to 4.

// So we have 5X3,5X4,6X3,6X4,7X3,7X4 type of Cadbury in the box.

// If we take 5X3 :

// First, we can give 3X3 square Cadbury to 1st child .Then we are left with 3X2. Now largest square is 2X2 which will be given to next
//  child. Next, we are left with two  1X1 part of Cadbury which will be given to another two children.

// And so on


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class pbid3
{
	public static void main (String[] args)
	{
		// your code goes here
		
            Scanner sc = new Scanner(System.in);
            int minl=sc.nextInt();
            int maxl=sc.nextInt();
            int minw=sc.nextInt();
            int maxw=sc.nextInt();
            int max = Math.max(maxl,maxw);
            int dp[][] = new int[max+1][max+1];
            for(int j=1;j<=max;j++){
                for(int i=1;i<=max;i++){
                    //System.out.print(i+" "+j+"__");
                    if(i==j){
                        dp[i][j]=1;
                        break;
                    }
                    if(i==1 || j==1){
                        dp[i][j] = Math.max(i,j);
                    }
                    else{
                        int sqr = Math.min(i,j);
                        int tf = Math.abs(i-j);
                        int ar =Math.min(sqr,tf);
                        int ac = Math.max(sqr,tf);
                        dp[i][j] = dp[sqr][sqr]+dp[ar][ac];
                    }
                }
            }
            for(int i=1;i<=max;i++){
                for(int j=1;j<=max;j++){
                    System.out.print(dp[i][j]+"__");
                   
                }
                System.out.println();
            }
            int count =0;
            for(int i=minl;i<=maxl;i++){
                for(int j=minw;j<=maxw;j++){
                    //System.out.print(i+" "+j+"__");
                    int ar = Math.min(i,j);
                    int ac=Math.max(i,j);
                    count += dp[ar][ac];
                }
            }
            System.out.println(count+"\n");
    }
}
