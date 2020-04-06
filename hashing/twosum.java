// { Driver Code Starts
// Initial Template for Java
// Given an array of N positive integers and another number X. Determine whether or not there exist two elements in A whose sum is exactly X.

// Input:
// The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains N denoting the size of array and X denoting the given number . The second line of each test case contains N space separated integers as array input.

// Output:
// Print "Yes" if there exist two elements in A whose sum is exactly X, else "No" (without quotes).

// Your Task :
// You only need to implement keypair function. Do not read input, instead use the arguments given in the function and return 1 for "Yes" and 0 for "No". 

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 105
// 1 ≤ A[i] ≤ 105
// 1 ≤ X ≤ 2*105

// Example:
// Input:
// 2
// 6 16
// 1 4 45 6 10 8
// 5 10
// 1 2 4 3 6
// Output:
// Yes
// Yes

// Explanation:
// Testcases 1: 10 and 6 are numbers making a pair whose sum is equal to 16.
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] nx = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nx[0]);
            int x = Integer.parseInt(nx[1]);
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            if (sln.keypair(a, n, x) == true) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}// } Driver Code Ends
// User function Template for Java

class twosum {
    public boolean keypair(int[] arr, int n, int sum) {
        // code here
         HashSet<Integer> s = new HashSet<Integer>(); 
        for (int i = 0; i < arr.length; ++i) { 
            int temp = sum - arr[i]; 
  
            // checking for condition 
            if (s.contains(temp)) { 
                //System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")"); 
                return true;
            } 
            s.add(arr[i]); 
        } 
        return false;
    }
}
