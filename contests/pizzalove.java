/*
There are N number of Pizza bowls and in each bowl there are ai pizzas . You can eat pizzas from 
any bowl but you cannot eat pizzas from two consecutive bowls . Find the maximum number of pizzas
you can eat.

Input:
First line of input contains a positive integer T denoting number of test cases. For each test case,
first line contains N denoting number of pizza bowls . Second line contains N space seperated integers 
where each of them denotes number of pizzas in ith bowl.

Output:
For each test case print the maximum number of pizzas you can eat.

Your Task:
This is a functional problem you don't need to take input just complete the function maxPizza() which 
accepts two parameters an integer N (number of bowls) and an array arr (contains number of pizzas in ith bowl) 
and returns the maximum number pizzas you can eat.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= ai <= 109

Example:
Input:
2
5
1 2 3 4 5
5
5 3 4 11 2
Output:
9
16

Explanation:
Testcase1: you can eat pizzas from bowl number 1, 3 and 5.
Testcase2: you can eat pizzas from bowl number 1 and 4.
*/

// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;
class GFG
{
    public static void main(String args[])throws ArrayIndexOutOfBoundsException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t > 0)
                {
                    int n , ans , i;
                    n = sc.nextInt();
                    int[] arr = new int[n];
                    for(i=0;i<n;i++)
                        arr[i] = sc.nextInt();
                    pizza p = new pizza() ;   
                    ans = p.maxPizza(n,arr);  
                    System.out.println(ans);
                    t--;
                }
        }
}// } Driver Code Ends


//User function Template for Java
class pizza
{
    int maxPizza(int n, int[] houses)
    {
        // code here.
        int length = houses.length;
	    
        if(length == 0){
            return 0;
        }
        
        // Initializing maxMoney[n+1] array
        int[] maxMoney = new int[length + 1];
        
        // Defining the base cases
        maxMoney[length] = 0;
        maxMoney[length - 1] = houses[length - 1];
        
        // Making the general recurrence relation
        for(int i = length - 2; i >= 0; i--){
            maxMoney[i] = Math.max(houses[i] + maxMoney[i + 2], maxMoney[i + 1]);
        }
        
        // Returning the maximum money that we can make from house no. 0 onwards
        return maxMoney[0];
        
    }
};
