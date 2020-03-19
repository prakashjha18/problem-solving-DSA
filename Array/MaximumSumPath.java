// Given two sorted arrays A and B. The task is to complete the function max_path_sum that takes 4 argument, the first two arguments represent the 2 arrays A[] and B[] and the last two arguments l1, l2 denote the size of array A and B respectively. The function returns the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays .

// Note: You can switch from one array to another array only at common elements.

// Input:
// The first line of input contains an integer T denoting the no of test cases . Then T cases follow.
// Each test case contains 3 lines. The first line contains two space separated integers l1 and l2 denoting the length of the two sorted array A and B. In the second line is the space separated values of array A and in the third line are space separated values of array B.

// Output:
// For each test case the output is the max sum obtained in such fashion .

// Constraints:
// 1 <= T <= 100
// 1 <= N, M <= 105
// 1 <= A[], B[] <= 106

// Example:
// 2
// 5 4
// 2 3 7 10 12
// 1 5 7 8 
// 3 3
// 1 2 4
// 1 2 7

// Output
// 35 
// 10
class MaximumSumPath  
{ 
    // Utility function to find maximum of two integers 
    int max(int x, int y)  
    { 
        return (x > y) ? x : y; 
    } 
  
    // This function returns the sum of elements on maximum path 
    // from beginning to end 
    int maxPathSum(int ar1[], int ar2[], int m, int n)  
    { 
        // initialize indexes for ar1[] and ar2[] 
        int i = 0, j = 0; 
  
        // Initialize result and current sum through ar1[] and ar2[]. 
        int result = 0, sum1 = 0, sum2 = 0; 
  
        // Below 3 loops are similar to merge in merge sort 
        while (i < m && j < n)  
        {
            // Add elements of ar1[] to sum1 
            if (ar1[i] < ar2[j]) 
                sum1 += ar1[i++]; 
              
            // Add elements of ar2[] to sum2 
            else if (ar1[i] > ar2[j]) 
                sum2 += ar2[j++]; 
  
            // we reached a common point 
            else
            { 
                // Take the maximum of two sums and add to result 
                result += max(sum1, sum2); 
  
                // Update sum1 and sum2 for elements after this 
                // intersection point 
                sum1 = 0; 
                sum2 = 0; 
  
                // Keep updating result while there are more common 
                // elements 
                while (i < m && j < n && ar1[i] == ar2[j])  
                { 
                    result = result + ar1[i++]; 
                    j++; 
                } 
            } 
        } 
  
        // Add remaining elements of ar1[] 
        while (i < m) 
            sum1 += ar1[i++]; 
          
        // Add remaining elements of ar2[] 
        while (j < n)  
            sum2 += ar2[j++]; 
  
        // Add maximum of two sums of remaining elements 
        result += max(sum1, sum2); 
  
        return result; 
    } 
  
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        MaximumSumPath sumpath = new MaximumSumPath(); 
        int ar1[] = {2, 3, 7, 10, 12}; 
        int ar2[] = {1, 5, 7, 8 }; 
        int m = ar1.length; 
        int n = ar2.length; 
        System.out.println("Maximum sum path is :" +  
                                       sumpath.maxPathSum(ar1, ar2, m, n)); 
    } 
} 
