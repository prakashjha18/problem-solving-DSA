// { Driver Code Starts
import java.io.*;

class kadanealgo {
    
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
		    
		    Kadane obj = new Kadane();
		    
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

// } Driver Code Ends
class Kadane{
    
    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int a[], int n){
        
        int max_so_far = a[0]; 
        int curr_max = a[0]; 
  
        for (int i = 1; i < n; i++) 
        { 
            curr_max = Math.max(a[i], curr_max+a[i]); 
            max_so_far = Math.max(max_so_far, curr_max); 
        } 
           return max_so_far; 
        
    }
    
}

