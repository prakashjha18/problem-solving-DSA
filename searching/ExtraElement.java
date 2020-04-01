// { Driver Code Starts
import java.util.*;
class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            GfG g = new GfG();
            System.out.println(g.findExtra(a, b, n));
        }
    }
}// } Driver Code Ends
/*Complete the function below*/
class GfG {
    public int findExtra(int A[], int B[], int n) {
        n=n-1;
        int index = n;  
        int left = 0, right = n - 1; 
        while (left <= right) { 
            int mid = (left+right) / 2; 
            if (arr2[mid] == arr1[mid]) 
                left = mid + 1; 
            else { 
                index = mid; 
                right = mid - 1; 
            } 
        } 
        return index; 
    }
}
