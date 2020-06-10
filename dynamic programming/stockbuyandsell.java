// { Driver Code Starts
// The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

// Input: 
// First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days. 

// Output:
// For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

// User Task:
// The task is to complete the function stockBuySell() which finds the days of buying and selling stock and print them. The newline is automatically added by the driver code.

// Expected Time Complexity : O(N)
// Expected Auxiliary Space: O(N)

// Constraints:
// 1 <= T <= 100
// 2 <= N <= 103
// 0 <= Ai <= 104

// Example
// Input:
// 5
// 7
// 100 180 260 310 40 535 695
// 10
// 23 13 25 29 33 19 34 45 65 67
// 5
// 4 2 2 2 4
// 5
// 5 5 5 5 5
// 9
// 57 69 12 59 5 9 29 29 99

// Output:
// (0 3) (4 6)
// (1 4) (5 9)
// (3 4)
// No Profit
// (0 1) (2 3) (4 8)

// Explanation:
// Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit. Now, we buy stock on day 4 and sell it on day 6.
// Testcase 2: We can buy stock on day 1, and sell it on 4th day, which will give us maximum profit. Now, we buy stock on day 5 and sell it on day 9.
// Testcase 3: We can buy stock on day 3, and sell it on 4th day, which will give us maximum profit.
// Testcase 4: We cannot sell any stock that will give us profit as the price remains same.
// Testcase 5: Buy on day 0 and sell on day 1. Then buy on day 2 and sell on day 3. Next, buy on day 4 and sell on day 8.
import java.io.*;
import java.util.*;

class Interval {
    int buy;
    int sell;
}

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Stock obj = new Stock();
		    
		    obj.stockBuySell(arr, n);
		    System.out.println();
		}
	}
}
// } Driver Code Ends


/*
class Interval {
    int buy;
    int sell;
}*/

class Stock{

    // Function to find the buy and sell days and print them
    static void stockBuySell(int price[], int n) {
        
        // Your code here
        StringBuffer str = new StringBuffer();
        
        if(n==1){
            return ;
        }
        
        ArrayList<Interval> sol = new ArrayList<Interval>();
        int i=0, cnt=0;
        while (i < n-1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n-1) && (price[i+1] <= price[i])){
                i++;
            }
            // If we reached the end, break as no further solution possible
            if (i == n-1){
                break;
            }
            Interval e = new Interval();
            e.buy = i++;
 
            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i-1]))
                i++;
 
            // Store the index of maxima
            e.sell = i-1;
            sol.add(e);
            // Increment count of buy/sell pairs
            cnt++;
        }
        if(cnt==0){
            str.append("No Profit");
        } else {
            for(int j=0; j<sol.size(); j++){
                str.append("(" + sol.get(j).buy + " " + sol.get(j).sell +") ");
            }
        }
        System.out.print(str);
    } 
    
}


