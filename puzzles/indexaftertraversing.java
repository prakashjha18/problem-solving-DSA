// https://www.geeksforgeeks.org/find-index-after-traversing-a-permutation-array-of-1-to-n-by-k-steps/
// Java implementation to find the  
// index after traversing the index  
// array K times  
class GFG{ 
      
// Function to find the index after  
// traversing the index array K times 
public static int findIndexAfterKTrav(int[] arr,  
                                      int n, int k) 
{  
    k = k % n;  
    int indi = 1;  
          
    // Loop to traverse the index  
    // array K times  
    while (k > 0) 
    {  
        indi = arr[indi - 1];  
        k--;  
    }  
    return arr[indi - 1];  
}  
  
// Driver code 
public static void main(String[] args)  
{ 
    int n = 4, k = 5;  
    int[] arr = { 3, 2, 4, 1 };  
      
    // Function Call  
    System.out.print(findIndexAfterKTrav(arr, n, k)); 
} 
} 
  
