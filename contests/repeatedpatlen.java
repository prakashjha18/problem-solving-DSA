// { Driver Code Starts
//Initial Template for Java

// Ted is a pro coder , but today he is very busy in doing college assignments . He needs your help to complete a task .
// The task is as follow:-
// Given two positive integers A and B denoting numerator and denomenator of a fraction . You need to count the length
// of repeated pattern of digits in decimal part of A/B .

// Input:
// First line of input contains an integer T denoting number of test cases . For each test case , there will be two 
// space seperated positive integers A and B .

// Output:
// For each test case print the length of repeated pattern of digits in decimal part of A/B.

// Task:
// This is a functional problem , you don't need to take input just complete the function findCount() which accepts 
// two integers A and B as parameters and return the length of repeated pattern of digits in decimal part of A/B.

// Constraints:
// 1 <= T <= 100
// 1 <= A , B <= 10000

// Example:
// Input:
// 3
// 1 2
// 22 7
// 8 4
// Output:
// 0
// 6
// 0

// Explanation:
// Testcase1: 1/2 = 0.5 since there is no repetition in decimal part of 1/2 therefore ans is 0.
// Testcase2: 22/7 = 3.142857142857142857.... length of repeating pattern in decimal part is 6 .
// Testcase3: 8/4 = 2 , since 4 completly divides 8 there is no decimal part.

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t > 0)
                {
                    int p,q,count;
                    p = sc.nextInt();
                    q = sc.nextInt();
                    find g = new find();
                    count = g.findRepeat(p,q);
                    System.out.println(count);
                    t--;
                }
            
        }
}// } Driver Code Ends


//User function Template for Java

class find
{
    int findRepeat(int num , int den)
    {
        StringBuilder res = new StringBuilder();
        
        res.append(num / den);
        num %= den;
        
        if (num == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                //System.out.print(map);
                return res.length()-index;
            }
            else {
                map.put(num, res.length());
            }
        }
        
        return 0;
    }
}
