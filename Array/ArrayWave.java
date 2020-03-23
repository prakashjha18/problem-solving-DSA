// { Driver Code Starts
import java.io.*;
import java.util.*;

class ArrayWave {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine().trim());// taking size of array
		    int arr[] = new int[n]; // declaring array of size n
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Wave obj = new Wave();
		    
		    
		    obj.convertToWave(arr, n);
		    
		    StringBuffer sb = new StringBuffer(); 
            for (int i = 0; i < n; i++) 
                sb.append(arr[i] + " "); 
                
		    System.out.println(sb); // print array
		}
	}
}


 // } Driver Code Ends
class Wave{

    //this solution works for unsorted too in o(n) time
    
    // Function to convert the given array to wave like array
    // arr: input array
    // n: size of the array
    static void swap(int arr[], int a, int b) 
    { 
        int temp = arr[a]; 
        arr[a] = arr[b]; 
        arr[b] = temp; 
    } 
    public static void convertToWave(int arr[], int n){
        
        for (int i = 0; i < n; i+=2) 
        { 
            // If current even element is smaller 
            // than previous 
            if (i>0 && arr[i-1] > arr[i] ) 
                swap(arr, i-1, i); 
  
            // If current even element is smaller 
            // than next 
            if (i<n-1 && arr[i] < arr[i+1] ) 
                swap(arr, i, i + 1); 
        } 
        
    }
    
}


// { Driver Code Starts.
  // } Driver Code Ends
