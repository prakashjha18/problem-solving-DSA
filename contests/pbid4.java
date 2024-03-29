// Petrol Pump
// Problem Description
// A big group of students, starting a long journey on different set of vehicles need to fill petrol in their vehicles.

// As group leader you are required to minimize the time they spend at the petrol pump to start the journey at the earliest. 
// You will be given the quantity of petrol (in litres) that can be filled in each vehicle. There are two petrol vending machines
//  at the petrol pump. You need to arrange the vehicles in such a way that they take shortest possible time to fill all the vehicles 
//  and provide the time taken in seconds as output. Machine vends petrol @ 1litre/second.

// Assume that there is no time lost between switching vehicles to start filling petrol.

// Constraints
// 1<= Number of vehicles < 50.

// 0 <= Quantity of petrol required in any vehicle <= 200

// Input Format
// First line will provide the quantity of petrol (separated by space) that can be filled in each vehicle.

// Output
// Shortest possible time to fill petrol in all the vehicles.

// Timeout
// 1

// Explanation
// Example 1

// Input

// 1 2 3 4 5 10 11 3 6 16

// Output

// 31

// Explanation

// First Petrol vending machine will cater to vehicles taking - 16, 6, 4, 3, 2 litres of petrol (Total 31 sec)

// Second machine will cater to vehicles taking - 11, 10, 5, 3, 1 litres of petrol (Total 30 sec)

// Example 2

// Input

// 25 30 35 20 90 110 45 70 80 12 30 35 85

// Output

// 335

// Explanation

// First Petrol vending machine will cater to vehicles taking - 80, 45, 35, 30, 25, 12, 85, 20 litres of petrol.

// Second machine will cater to vehicles taking - 90, 70, 35, 30, 110 litres of petrol. Since second machine will take more time, 
// total time to fill petrol in all vehicles will be 335 seconds.


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class pbid4
{
    static int findMin(int arr[], int n) 
    { 
        // Calculate sum of all elements 
        int sum = 0;  
        for (int i = 0; i < n; i++) 
            sum += arr[i]; 
      
        // Create an array to store  
        // results of subproblems 
        boolean dp[][] = new boolean[n + 1][sum + 1]; 
      
        // Initialize first column as true.  
        // 0 sum is possible  with all elements. 
        for (int i = 0; i <= n; i++) 
            dp[i][0] = true; 
      
        // Initialize top row, except dp[0][0],  
        // as false. With 0 elements, no other  
        // sum except 0 is possible 
        for (int i = 1; i <= sum; i++) 
            dp[0][i] = false; 
      
        // Fill the partition table  
        // in bottom up manner 
        for (int i = 1; i <= n; i++) 
        { 
            for (int j = 1; j <= sum; j++) 
            { 
                // If i'th element is excluded 
                dp[i][j] = dp[i - 1][j]; 
      
                // If i'th element is included 
                if (arr[i - 1] <= j) 
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]]; 
            } 
        } 
      
        // Initialize difference of two sums.  
        int diff = Integer.MAX_VALUE; 
          
        // Find the largest j such that dp[n][j] 
        // is true where j loops from sum/2 t0 0 
        for (int j = sum / 2; j >= 0; j--) 
        { 
            // Find the  
            if (dp[n][j] == true) 
            { 
                diff = sum - 2 * j; 
                return sum-j;
            } 
        } 
        return diff; 
    } 
	public static void main (String[] args)
	{
		// your code goes here
		
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while (scanner.hasNextInt())
          list.add(scanner.nextInt());
        int[] arr = list.stream().mapToInt(i->i).toArray();
        
        System.out.print(findMin(arr,arr.length));
       
    }
}
