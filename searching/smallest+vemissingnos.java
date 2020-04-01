// { Driver Code Starts
import java.util.*;

class smallest+vemissingnos
{   
    
    public static void main (String[] args) 
    {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int missing = new FindMissing().findMissing(arr,n);
			
			System.out.println(missing);
		}
    }
}// } Driver Code Ends
class FindMissing{
    
    // Function to find 
    static int findMissing(int A[], int size)
    {
       
       int m = Arrays.stream(A).max().getAsInt(); // Storing maximum value 
        if (m < 1) // In case all values in our array are negative 
        { 
            return 1; 
        } 
        if (A.length == 1) { 
  
            // If it contains only one element 
            if (A[0] == 1) { 
                return 2; 
            } 
            else { 
                return 1; 
            } 
        } 
        int i = 0; 
        int[] l = new int[m]; 
        for (i = 0; i < A.length; i++) { 
            if (A[i] > 0) { 
                if (l[A[i] - 1] != 1) // Changing the value status at the index of our list 
                { 
                    l[A[i] - 1] = 1; 
                } 
            } 
        } 
        for (i = 0; i < l.length; i++) // Encountering first 0, i.e, the element with least value 
        { 
            if (l[i] == 0) { 
                return i + 1; 
            } 
        } 
        // In case all values are filled between 1 and m 
        return i + 1; 
    }
}
