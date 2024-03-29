/*
You are given two array A[] and B[]. Your task is to arrange elements of first array according to the order defined by 
second array. The first array contains integers which represent heights of persons and second array defines how many 
persons in front of him should stand with height greater than or equal to that person.

Input:
First line of input contains number of testcases T. For each testcase, there will be three lines, first of which will
contain an integer N denoting the size of the array. Second line contains N space separated integers for array A[] 
denoting the height of the persons and last line of the test case contains the arrangement array B[].

Output:
Print the result array showing the new height arrangement.

Your Task:
You don't need to read input or print output. Your task is to complete the function arrange() that takes array A,
array B, integer N as input parameters and returns a list of integers denoting the new arrangement of people according
to their heights. 

Constraints:
1 <= T <= 50
1 <= N <= 103
1 <= A[i] <= 104
1 <= B[i] <= N

Example:
Sample Input:
2
3 
3 2 1
0 1 1
6
5 3 2 6 1 4
0 1 2 0 3 2

Sample Output:
3 1 2
5 3 2 1 6 4 

Explanation:
Testcase 1: 
The output is :                 3 1 2
Corresponding B value:          0 1 1
0 people of greater or equal height in front of person of height 3. 
1 person of greater or equal height in front of person of height 1. 
1 person of greater or equal height in front of person of height 2.

Testcase 2: 
The output is :                 5 3 2 1 6 4 
Corresponding B value:          0 1 2 3 0 2
*/
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
            {
                int n , i;
                n = sc.nextInt();
                ArrayList<Integer> a = new ArrayList<Integer>();
                ArrayList<Integer> b = new ArrayList<Integer>();
                for(i=0;i<n;i++)
                    {
                        int temp = sc.nextInt();
                        a.add(temp);
                    }
                for(i=0;i<n;i++)
                    {
                        int temp = sc.nextInt();
                        b.add(temp);
                    }    
                
                Sol obj = new Sol();
                ArrayList<Integer> res = obj.arrange(a,b,n);   
                
                for(i=0;i<n;i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();    
            }
    }

}// } Driver Code Ends


//User function Template for Java
class Info{
	int a;
	int b;

	Info(int x,int y)
	{
		a = x;
		b = y;
	}
	
	public String toString(){
	    return a+" ";
	}
}
class Compare implements Comparator<Info>{ 
	public int compare (Info p1,Info p2 ){
	    int d1 = p1.b-p2.b;
	    int d2 = p2.a-p1.a;
	    if(p1.a == p2.a)
	        return d1;
	    else
	        return d2;
	}
}
class Sol
{
    ArrayList<Integer>arrange(ArrayList<Integer> A, ArrayList<Integer> B, int n)
    {
       // code here
       ArrayList<Info> result= new ArrayList<Info>();
        for(int i=0;i<n;i++){
           Info obj = new Info(A.get(i) , B.get(i) );
           result.add(obj);
        }
        Collections.sort(result,new Compare());
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++){
            ans.add(result.get(i).b,result.get(i).a);
            //System.out.print(result.get(i).a+" "+result.get(i).b+"__");
        }
        return ans;
    }
}
