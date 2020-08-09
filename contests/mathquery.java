// { Driver Code Starts
//Initial Template for Java
/*
You are given an integer N. You have to count how many possible combinations of numbers from 1 to N 
(excluding 1 and N). which are dividing the number N and after multiplication exactly equal to the value N.
For Example: Let suppose, I have a number 12 and the number that divides 12 between 1 to 12 are 2, 3, 4, 6 
we can form N by multiply 2*6, 3*4 and 2*2*3. So, there are 3 possible combinations for number 12.
Note: We will not consider 1 and N we will try to find the combinations in between them.

Input:
First-line contains the T number of test cases.
For each test case, there is an integer N.

Output:
Print the number of combinations possible.

Constraints:
1 <= T <= 103
1 <= N <= 106

Example:

Sample Input:
3
12
8
32

Sample Output:

3
2
6 

Explanation:
For test case 1:  For value 12 we have 3 combinations in total.
[ [2, 6], [2, 2, 3], [3, 4] ]

For test case 2: For value 8 we have only 2 combinations:
[ [2, 2, 2] , [2, 4] ]

*/
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0)
		{
		    int n=ob.nextInt();
		    Solution ab=new Solution();
		    int c=ab.getFactors(n);
		    System.out.println(c);
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    int ans;
    int getFactors(int n)
    {
    //code here
        ans=0; // it's a global variable
        
        ArrayList<Integer> l=new ArrayList<Integer>(n);
        
        if(n==1){
            return ans;
        }
        
        int i=2;
        while(i*i<=n){
            // if i is a factor of n
            if(n%i==0){
                if(n/i==i){
                    l.add(i);
                }
                else{
                    l.add(i);
                    l.add(n/i);
                }
            }
            i=i+1;
        }
        
        Collections.sort(l);
        find(l,n,0);
        return ans;
    }
    void find(ArrayList<Integer> l,int n,int index)
    {
        if(n==1){
            ans=ans+1;
            return;
        }
        
        else if(n<1){
            return;
        }
        for(int i=index;i<l.size();i++){
            if(n%l.get(i)==0){
                find(l,n/l.get(i),i);
            }
        }
    }
}

