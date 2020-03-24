// Given an array A of size N, construct a Product Array P (of same size) such that P is equal to the product of all the elements of A except A[i].

// Input:
// The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line is N. The second line contains N elements separated by spaces. It is guranteed that the product of all the elements of the array will not exceed 1e18.

// Output:
// For every test case, print the product array in a new line.

// Your Task:
// You do not have to read input. Your task is to complete productExceptSelf() function and returns the Product vector P that holds product except for self at each index.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 1000
// 0 <= Ai <= 200

// Example:
// Input:
// 2
// 5
// 10 3 5 6 2
// 2
// 12 0
// Output:
// 180 600 360 300 900
// 0 12

public class ProductArray { 
    void productArray(int arr[], int n) 
    { 
  
        // Base case 
        if (n == 1) { 
            System.out.print("0"); 
            return; 
        } 
  
        int i, temp = 1; 
  
        /* Allocate memory for the product array */
        int prod[] = new int[n]; 
  
        /* Initialize the product array as 1 */
        for (int j = 0; j < n; j++) 
            prod[j] = 1; 
        for(i = 0;i < n; i++){
            prod[i]=temp;
            temp*=arr[i];
        }
        temp=1;
        for(i=n-1;i>=0;i--){
            prod[i]*=temp;
            temp*=arr[i];
        }
  
        /* print the constructed prod array */
        for (i = 0; i < n; i++) 
            System.out.print(prod[i] + " "); 
  
        return; 
    } 
  
    /* Driver program to test above functions */
    public static void main(String[] args) 
    { 
        ProductArray pa = new ProductArray(); 
        int arr[] = { 1, 2, 3, 4, 5 }; 
        int n = arr.length; 
        System.out.println("The product array is : "); 
        pa.productArray(arr, n); 
    } 
}
