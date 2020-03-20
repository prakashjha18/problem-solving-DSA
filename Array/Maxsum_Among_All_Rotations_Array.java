// { Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}
// } Driver Code Ends
class GfG
{
    int max_sum(int arr[], int n)
    {
    	int arrSum = 0;  // Stores sum of arr[i] 
        int currVal = 0;  // Stores sum of i*arr[i] 
        for (int i=0; i<arr.length; i++) 
        { 
            arrSum = arrSum + arr[i]; 
            currVal = currVal+(i*arr[i]); 
        } 
       
        // Initialize result as 0 rotation sum 
        int maxVal = currVal; 
       
        // Try all rotations one by one and find 
        // the maximum rotation sum. 
        for (int j=1; j<arr.length; j++) 
        { 
            currVal = currVal + arrSum-arr.length*arr[arr.length-j]; 
            if (currVal > maxVal) 
                maxVal = currVal; 
        } 
       
        // Return result 
        return maxVal; 
    }	
}
