import java.util.Arrays; 
import java.util.Collections; 
//code to return Kth smallest element in an array using divide and conquer method - quick select algorithm
public class kthsmallest{
    static int partition(int[] array, int p, int q)
    {
        int pivot = q;
        int i=p-1;
        for(j = p; j <= q; j++){
            if(array[j]<=array[pivot]){
                i++;
                int temp = array[i];    
				array[i] = array[j];
				array[j] = temp;
            }
        }
        return i;
    }
    public static in kthsmallest(int[] arr, int l,int r, int k){
        if (k > 0 && k <= r - l + 1) { 
            int pos = partition(arr, l, r); 

            if (pos - l == k - 1) 
                return arr[pos]; 

            if (pos - l > k - 1) 
                return kthSmallest(arr, l, pos - 1, k); 

            return kthSmallest(arr, pos + 1, r, k - pos + l - 1); 
        }

        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) 
    { 
        int arr[] = new int[] { 12, 3, 5, 7, 4, 19, 26 }; 
        int k = 3; 
        System.out.println("K'th smallest element is " + kthSmallest(arr, 0, arr.length - 1, k)); 
    } 
}
