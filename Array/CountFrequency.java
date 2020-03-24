// Given an array A[] of N positive integers which can contain integers from 1 to N where elements can be repeated or can be absent from the array. Your task is to count frequency of all elements from 1 to N.

// Note: Expected time complexity is O(n) with O(1) extra space.

// Input Format:
// First line of input contains an integer T denoting the number of test cases. For each test case, first line contains an integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

// Output Format:
// For each test case, output N space-separated integers denoting the frequency of each element from 1 to N.

// Your Task:
// You need to complete the function printfrequency and print frequency of each element. The newline is automatically added by the driver code.

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 107
// 1 <= A[i] <= 106

// Example:
// Input:
// 2
// 5
// 2 3 2 3 5
// 4
// 3 3 3 3

// Output:
// 0 2 2 0 1
// 0 0 4 0
class CountFrequency  
{ 
    // Function to find counts of all elements present in 
    // arr[0..n-1]. The array elements must be range from 
    // 1 to n 
    void printfrequency(int arr[], int n)  
    { 
        // Subtract 1 from every element so that the elements 
        // become in range from 0 to n-1 
        for (int j = 0; j < n; j++) 
            arr[j] = arr[j] - 1; 
  
        // Use every element arr[i] as index and add 'n' to 
        // element present at arr[i]%n to keep track of count of 
        // occurrences of arr[i] 
        for (int i = 0; i < n; i++) 
            arr[arr[i] % n] = arr[arr[i] % n] + n; 
  
        // To print counts, simply print the number of times n 
        // was added at index corresponding to every element 
        for (int i = 0; i < n; i++) 
            System.out.println(i + 1 + "->" + arr[i] / n); 
    } 
  
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        CountFrequency count = new CountFrequency(); 
        int arr[] = {2, 3, 3, 2, 5}; 
        int n = arr.length; 
        count.printfrequency(arr, n); 
    } 
} 
