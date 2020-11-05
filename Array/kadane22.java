// { Driver Code Starts
import java.io.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Kadane obj = new Kadane();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

// } Driver Code Ends


class Kadane{
    
    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int arr[], int n){
        
        // Your code here
        int max_so_far = Integer.MIN_VALUE,
        max_ending_here = 0,start = 0,
        end = 0,s = 0;
        
        for(int i=0;i<n;i++){
            max_ending_here+=arr[i];
            if(max_so_far<max_ending_here){
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if(max_ending_here < 0){
                max_ending_here=0;
                s=i+1;
            }
        }
        
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
        return max_so_far;
        
    }
    
}


// input:
// -2, -3, 4, -1, -2, 1, 5, -3

// output:
// Maximum contiguous sum is 7
// Starting index 2
// Ending index 6

