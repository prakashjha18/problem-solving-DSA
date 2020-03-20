// Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes . Now Given an array your task is to complete the function findEquilibrium which returns the index of the first Equilibrium point in the array. The function takes  two arguments. The first argument is the array A[ ] and the second argument is the size of the array A.

// Input Format:
// The first line of input takes an integer T denoting the no of test cases, then T test cases follow. The first line of each test case is an integer N denoting The size of the array . Then in the next line are N space separated values of the array. 

// Output Format:
// For each test case output will be the equilibrium index of the array .If no such index exist output will be -1.

// Task :
// Your task is to complete the function (findEquilibrium) below and return the index with required return type.

// Constraints:
// 1<=T<=100
// 1<=N<=105
// -1000<=A[]<=1000

// Example(To be used only for expected output):
// Input
// 2
// 4
// 1 2 0 3
// 4
// 1 1 1 1
// { Driver Code Starts
import java.util.*;
class Equlibriumindex{
public static void main(String[] args)
 {
	 Scanner sc = new Scanner(System.in);
	 int T = sc.nextInt();
		while(T-- > 0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.findEquilibrium(a,n));
		}
}
}// } Driver Code Ends
/*Complete the function below*/
class GfG
{
            public static int findEquilibrium(int arr[], int n)
            {
                
                int sum = 0; // initialize sum of whole array 
                int leftsum = 0; // initialize leftsum 
          
                /* Find sum of the whole array */
                for (int i = 0; i < n; ++i) 
                    sum += arr[i]; 
          
                for (int i = 0; i < n; ++i) { 
                    sum -= arr[i]; // sum is now right sum for index i 
          
                    if (leftsum == sum) 
                        return i; 
          
                    leftsum += arr[i]; 
                } 
          
                /* If no equilibrium index found, then return 0 */
                return -1; 
            }
}
