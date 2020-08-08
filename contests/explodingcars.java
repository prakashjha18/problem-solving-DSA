// { Driver Code Starts
// Initial Template for Java

/*
You are given an array cars[] of integers in a sequential order representing a car on a number line. For each car, 
its sign represent its direction ( + for the right direction and - for the left direction ) and its magnitude represents
its power to explode the other car.     
All cars are moving with the same speed and if two cars hit each other than the car with more power explodes the car
with less power. An explosion does not slow down the speed of the car and it continues to travel with the same speed.
So if any 2 cars are moving in the same direction they do not hit each other. Find the final state of the cars after 
all collisions between the cars have taken place. 
Note: There will be no car with magnitude zero and if two cars with same magnitude collide then both of them will 
explode.

Input:
The first line of the input contains T denoting the number of testcases. The first line of each test case
contains the size of array cars[] N and the second line of each test case contains elements of array cars[].

Output:
For each test case, on a new line, print the final state of the array cars[ ].

Your Task :
You don't have to take input. Complete the function final() that takes the parameter, N as the no. of cars, 
cars[] which contain power of the ith car and returns an array of the final state of the cars[]. 

Constraints:
1 <= T <= 100
1 <= N<= 105
-105 <= cars[i] <= 105

Example:
Sample Input-
2
3
100 10 -2
5 
3 -9 8 -8 9

Sample Output-
100 10
-9 9

Explanation-
In testcase 1, 10 and -2 cars hit each other and -2 car gets explodes by 10 .10 and 100 are in the same direction so they do not hit each other.
Similarly, in testcase 2, 8 collides with -8 and 3 collides with -9.
*/


import java.io.*;
import java.util.*;
  public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().trim().split(" ");
            int[] cars = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                cars[i] = Integer.parseInt(s[i]);
            }
            Solution sln = new Solution();
            ArrayList<Integer> ans = sln.finalSeq(cars, n);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> finalSeq(int cars[], int n) {
        // code here
        Stack<Integer> s  =new Stack<Integer>();
        int flag;
        for(int i=0;i<cars.length;i++){
            flag =0;
            while(!s.empty() && cars[i]<0 && s.peek()>0){
                if(s.peek()< -cars[i]){
                    s.pop();
                    continue;
                } else if(s.peek() == -cars[i]){
                    s.pop();
                } 
                flag =1;
                break;
            } 
            if(flag==0) s.push(cars[i]);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while (!s.empty()) {
            ans.add(s.peek());
            s.pop();
        }
        Collections.reverse(ans);
        
        return ans;
    }
}
