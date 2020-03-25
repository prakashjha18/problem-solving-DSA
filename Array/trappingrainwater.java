//     Given n non-negative integers representing an elevation map where the width of each bar is 1,
//     compute how much water it is able to trap after raining.


// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
// In this case, 6 units of rain water (blue section) are being trapped. 

// Example:

// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// { Driver Code Starts
import java.io.*;
import java.util.*;

class trappingrainwater {

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
		    
		    Trap obj = new Trap();
		    
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends


class Trap{
    
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) { 
        int ans=0;
        int left =0,right=n-1;
        int left_max=0,right_max=0;
        while(left<right){
            if(arr[left]<arr[right]){
                if(arr[left]>=left_max){
                    left_max=arr[left];
                } else {
                    ans+=(left_max-arr[left]);
                }
                left++;
            } 
            else {
                if(arr[right] >= right_max){
                right_max = arr[right];
            } else {
                ans += (right_max - arr[right]);
            }
            right--;
            }
        }
        return ans;
    } 
}

