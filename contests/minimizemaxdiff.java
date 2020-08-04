// { Driver Code Starts
//Initial Template for Java
/*
Minimize Max difference between adjacent elements by inserting k new elements
You are given an array arr[ ], of n integers. Minimize the max difference the between pairs of adjacent 
array elements by inserting at most k elements in the array.

Input:
First line of input consists of number of test cases T. Then T test cases follow. In each test case, the 
first line holds the integer n, representing the size of array. Second line contains the n space separates
values of array arr[ ]. Third line of test case holds the integer k.

Output:
The minimized max difference of adjacent array elements is printed in a new line for each test case.

Your task:
Your task is to complete the function minimizedMaxDiff() and return the value to be printed.

Constraints:
T <= 100
2 <= n <= 104
1 <= arr[i] <= 103
1 <= k <= 105

Example:
Input:
2
6
66 31 99 76 38 76
5
7
2 3 5 6 4 4 4
2
Output:
23
1
Explanation:
Testcase 1:
After 5 insertions, array can be transformed as follows:
66 51 31 54 77 99 76 59 38 60 76
Max differnece between adjacent elements here is 99-76 = 23

Testcase 2:
After 2 insertions, array can be transformed as follows:
2 3 4 5 6 5 4 4 4
Max difference here between adjacent elements is 1
*/



import java.util.*;
import java.math.*;

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            int arr[] = new int[n];
            
            for(int i=0;i<n;i++)
            {
                arr[i] = Integer.parseInt(sc.next());
            }
            
            int k = Integer.parseInt(sc.next());
            Solution T = new Solution();
            
            System.out.println(T.minimizedMaxDiff(arr, n, k));
            
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int minimizedMaxDiff(int arr[], int n, int k)
    {
        // Write your code here
        int max_adj_dif = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++) 
        max_adj_dif = Math.max(max_adj_dif, 
                      Math.abs(arr[i] -  
                               arr[i + 1])); 
        if (max_adj_dif == 0) 
            return 0; 
            
        int best = 1; 
        int worst = max_adj_dif; 
        int mid, required;
        
        while(best<worst){
            mid=(best+worst)/2;
            required=0;
            for(int i=0;i<n-1;i++){
                required += (Math.abs(arr[i] -  
                                  arr[i + 1]) - 
                                     1) / mid; 
            }
            if (required > k) 
                best = mid + 1;
            else
                worst = mid;
        }
        return worst; 
    }
}
