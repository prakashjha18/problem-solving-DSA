// { Driver Code Starts
// Initial Template for Java

/*
Harry loves playing. He even has a special set of cards to play with. Each card has a single integer.
The number on the card can be positive, negative and can even be equal to zero. Today, he is playing 
a game in which he needs to distribute the 3 cards to each member playing the game. In this game, the
player whose sum of integers in the cards has a maximum absolute difference with 0 wins the game.
Harry being a clever boy thinks to distribute these cards in such a way to a player that the total sum
of integers of his/her cards equals 0. Can you tell him that in how many unique ways he can do such a 
thing to a player?   

Input:
The first line of the input contains T denoting the number of testcases. First line of each test case 
contains the number of cards N and the second line of each test case contains the integer on each card.

Output:
For each test case, on a new line ,print the number of ways in which he can distribute cards to a player
such that the total sum of integers of his/her cards equals 0

Your Task :
You don't have to take input. Complete the function Ways() that takes the parameter,n as the number of
cards and a which contains the list of integers representing integer on each card. The function returns the 
number of ways in which he can distribute cards to a player such that the total sum of integers of his/her 
cards equals 0. The printing is done by the driver code. 

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Sample Input-
2
7
-1 0 1 1 2 -1 -4
7
-1 1 2 4 1 -2 -3

Sample Output-
2
3

Explanation-
Testcase1- (-1,0,1) and (-1,-1,2) are the 2 unique ways in which he can do so. */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            int n = ob.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ob.nextInt();
            }
            int c = Solution.ways(a, n);
            System.out.println(c);
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    static int ways(int num[], int n) {
        // code here
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res.size();
    }
}
