// Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. Then the next line contains n space separated integers forming the array. The last line of input contains an integer k.

// Output:
// Print the count of elements in array that appear more than n/k times.

// User Task:
// The task is to complete the function countOccurence() which returns count of elements with more than n/k times appearance.

// Constraints:
// 1 <= T <= 102
// 1 <= N <= 104
// 1 <= a[i] <= 106
// 1 <= k <= N

// Example:
// Input:
// 2
// 8
// 3 1 2 2 1 2 3 3
// 4
// 4
// 2 3 3 2
// 3
// Output:
// 2
// 2

// Explanation:
// Testcase 1: In the given array, 3 and 2 are the only elements that appears more than n/k times.
// Testcase 2: In the given array, 3 and 2 are the only elements that appears more than n/k times. So the count of elements are 2.
// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class morenbykoccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new CountElement().countOccurence(arr, n, k));
        }
    }
}
// } Driver Code Ends
class CountElement {

    // Function to find element with count more than n/k times
    // arr: input array
    public int countOccurence(int[] arr, int n, int k) {
        int count=n/k;
        int ele=0;
        Set<Integer> hash_Set = new HashSet<Integer>(); 
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hash_Set.add(arr[i]);
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            } else {
                hm.put(arr[i],1);
            }
        }
        Object[]setarr = hash_Set.toArray();
        for(int i=0;i<setarr.length;i++){
            if(hm.get(setarr[i])>count){
                ele++;
            }
        }
        return ele;
    }
}
