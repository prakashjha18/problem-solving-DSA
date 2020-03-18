// Input Format:
// The first line of input contains an integer T denoting the number of test cases . Then T test cases follow . Each test case contains a single integer N denoting the number.

// Output Format:
// For each test case, there will be a new line containing an integer where all zero's are converted to 5.

// Your Task:
// Your task is to complete the function convertFive() which takes an integer N as an argument and replaces all zeros in the number N with 5. Your function should return the converted number.

// Constraints:
// 1 <= T <= 100
// 1 <= n <= 10000

// Example:
// Input
// 2
// 1004
// 121
// Ouput
// 1554
// 121
// Explanation:
// Test Case 1: There are two zeroes in "1004", on replacing all zeroes with 5, the new number will be 1554.
// { Driver Code Starts
import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}// } Driver Code Ends
class GfG {
    int convertfive(int n) {
        // Your code here
        int radix = 1;
        int fives = 0;
        int lowOrder = 0;
        while (radix < n){
            if ((n % (radix*10)) - lowOrder == 0){
                fives += 5*radix;
            }
            radix *= 10;
            lowOrder = n % radix;
        }
        return n + fives;
    }
}
