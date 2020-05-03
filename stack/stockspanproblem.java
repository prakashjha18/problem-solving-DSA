//The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
//The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
//For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class stockspanproblem
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            int s[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            new solve().calculateSpan(a, n, s);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends


class solve{
    
    // Function to calculate span
    // price[]: input array
    public static void calculateSpan(int price[], int n, int S[])
    {
        // Your code here
        Stack<Integer>st=new Stack<>();
        st.push(0);
        int j=0;
        S[j++]=1;
        for(int i=1;i<n;i++){
            if(price[st.peek()]<=price[i]){
                while(!st.empty()&&price[st.peek()]<=price[i]){
                    st.pop();
                }
                if(st.empty()){
                    S[j++]=i+1;
                    st.push(i);
                    continue;
                }
            }
            S[j++]=i-st.peek();
            st.push(i);  
        }
    }
    
}
