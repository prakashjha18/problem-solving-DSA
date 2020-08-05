
// Given an array of infinite length and two integers M and N which are co-primes, the task is to find the number of 
// positions that cannot be visited starting from the first position 0, when in a single move from arr[i], either arr[i + M]
// or arr[i + N] can be reached. 
// Note : The largest index X that can’t be obtained using any combination of M & N can be found out using Frobenium Number 
// where X = (M * N) – M – N

// Input:
// First line of input contains number of testcases T. For each testcase, there will be one lines each containing n 
// and m separated by a space.

// Output:
// Print the number of positions that cannot be visited.

// Your Task:
// The task is to complete the function countUnvisited() that takes n and m as input and returns an integer value.

// Constraints: 
// 1 <= T <= 100
// 2 <= N,M <= 500

// Example:
// Sample Input:
// 3
// 2 5
// 2 7
// 25 7

// Sample Output:
// 2
// 3
// 72

// Explanation:
// Testcase 1:
// From index 0, the indices that can be visited are
// 0 + 2 = 2
// 0 + 2 + 2 = 4
// 0 + 5 = 5
// 0 + 2 + 2 + 2 = 6
// 0 + 2 + 5 = 7
// 0 + 2 + 2 + 2 + 2 = 8
// 0 + 2 + 2 + 5 = 9
// 0 + 5 + 5 = 10
// 1 and 3 are the only indices that cannot be visited.

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

 // } Driver Code Ends
//User function Template for Java

public static int countUnvisited(int n, int m)
    {
        int X = (m * n) - m - n;

        HashSet<Integer> hash_set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        hash_set.add(X);

        int count = 0;
        while (!queue.isEmpty()) {

            int curr = queue.poll();
            count++;
            
            int key = curr-m;
            if (key > 0 && hash_set.contains(key)==false ) {
                queue.add(key);
                hash_set.add(key);
            }
            
            key = curr - n;
            if (key > 0 && hash_set.contains(key)==false) {
                queue.add(key);
                hash_set.add(key);
            }
        }

        return count;
    }



// { Driver Code Starts.
     public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(countUnvisited(n, m));
            t--;
        }
    } 
}  // } Driver Code Ends
