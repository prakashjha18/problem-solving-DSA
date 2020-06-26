// { Driver Code Starts
//Initial Template for Java
// Hashing is very useful to keep track of the frequency of the elements in a list.

// You are given an array of integers. You need to print the non-repeated elements as they appear in the array.

// Input:
// The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains n denoting the size of the array. The second line contains n elements of the array.

// Output:
// For each testcase, in a new line, print the non-repeated elements in the order they appear in the array.

// Your Task:
// You don't need to read input or print anything. You only need to complete the function printNonRepeated() that takes arr and n as parameters and return the array which has the distinct elements in same order as they appear in input array. The newline is appended automatically by the driver code.

// Expected Time Complexity: O(n).
// Expected Auxiliary Space: O(n).

// Constraints:
// 1 <= T <= 100
// 1 <= n <= 103
// 0 <= arri <= 107

// Examples:
// Input:
// 2
// 10
// 1 1 2 2 3 3 4 5 6 7
// 5
// 10 20 40 30 10
// Output:
// 4 5 6 7
// 20 40 30

// Explanation:
// Testcase 1: 4, 5, 6 and 7 are the only elements which is having only 1 frequency and hence, Non-repeating.
// Testcase 2: 20, 40, 30 are the only elements which is having only 1 frequency and hence, Non-repeating.
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- >0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n=Integer.parseInt(str[0]);
            int arr[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            ArrayList<Integer> v = new Hashing().printNonRepeated(arr, n);
            
            for(int i=0;i<v.size();i++){
                System.out.print(v.get(i)+" ");
            }
            
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Hashing
{
    static ArrayList<Integer> printNonRepeated(int arr[], int n2)
    {
        // add your code here
        ArrayList<Integer> arrt = new ArrayList<>();
        LinkedHashMap<Integer, Integer> count = new LinkedHashMap<>();
        for (int n: arr) {
                count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue()==1)
                arrt.add(entry.getKey());
        }
        return arrt;
    }
}

