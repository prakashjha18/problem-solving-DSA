// { Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Triplet g=new Triplet();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}// } Driver Code Ends
/*Complete the function below*/


class Tripletsumzero2
{
    // Function to check if triplet is present 
    // arr[]: input array
    // n: size of the array
	public boolean findTriplets(int arr[] , int n)
    {
        boolean found = false; 
        Arrays.sort(arr); 
        for (int i=0; i<n-2; i++) { 
            // initialize left and right 
            int l = i + 1; 
            int r = n - 1; 
            int x = arr[i]; 
            while (l < r) { 
                if (x + arr[l] + arr[r] == 0) { 
                    l++; 
                    r--; 
                    return true; 
                } 
                else if (x + arr[l] + arr[r] < 0) 
                    l++; 
                else
                    r--; 
            } 
        } 
        return false;
        }
}
