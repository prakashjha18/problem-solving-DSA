// JAVA Code For Chocolate Distribution 
// Problem
/*
Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable 
number of chocolates. There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet 
with minimum chocolates is minimum.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of 
three lines. The first line of each test case contains an integer N denoting the number of packets. Then next line contains N space separated 
values of the array A denoting the values of each packet. The third line of each test case contains an integer m denoting the no of students.

Output:
For each test case in a new line print the minimum difference.

Constraints:
1 <= T <= 100
1 <=N<= 107
1 <= Ai <= 1018
1 <= M <= N

Example:
Input:
2
8
3 4 1 9 56 7 9 12
5
7
7 3 2 4 9 12 56
3

Output:
6
2
*/
import java.util.*;
 
class GFG {
     
    // arr[0..n-1] represents sizes of
    // packets. m is number of students.
    // Returns minimum difference between
    // maximum and minimum values of 
    // distribution.
    static int findMinDiff(int arr[], int n, 
                                    int m)
    {
        // if there are no chocolates or 
        // number of students is 0
        if (m == 0 || n == 0)
            return 0;
      
        // Sort the given packets
        Arrays.sort(arr);
      
        // Number of students cannot be
        // more than number of packets
        if (n < m)
           return -1;
      
        // Largest number of chocolates
        int min_diff = Integer.MAX_VALUE;
      
        // Find the subarray of size m 
        // such that difference between 
        // last (maximum in case of 
        // sorted) and first (minimum in
        // case of sorted) elements of 
        // subarray is minimum.
         
        for (int i = 0; i + m - 1 < n; i++)
        {
            int diff = arr[i+m-1] - arr[i];
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
    }
     
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
        int arr[] = {12, 4, 7, 9, 2, 23,
                    25, 41, 30, 40, 28,
                    42, 30, 44, 48, 43,
                   50};
                    
        int m = 7;  // Number of students
         
        int n = arr.length;
        System.out.println("Minimum difference is "
                + findMinDiff(arr, n, m));
             
    }
}
