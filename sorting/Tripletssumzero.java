// { Driver Code Starts
import java.util.*;
class Tripletssumzero{
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


class Triplet
{
    // Function to check if triplet is present 
    // arr[]: input array
    // n: size of the array
	public boolean findTriplets(int arr[] , int n)
    {
        for (int i = 0; i < n - 1; i++)  
        { 
            // Find all pairs with sum equals to 
            // "-arr[i]" 
            HashSet<Integer> s = new HashSet<Integer>(); 
            for (int j = i + 1; j < n; j++)  
            { 
                int x = -(arr[i] + arr[j]); 
                if (s.contains(x))  
                { 
                    return true; 
                }  
                else 
                { 
                    s.add(arr[j]); 
                } 
            } 
        } 
  
        
            return false;
       
    }
}
