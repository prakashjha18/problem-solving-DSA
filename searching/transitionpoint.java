// { Driver Code Starts
import java.util.*;
//You are given a sorted array containing only numbers 0 and 1. Find the transition point efficiently. Transition point is a point where "0" ends and "1" begins.
//Note that, if there is no "1" exists, print -1.
class transitionpoint {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}// } Driver Code Ends

class GfG {
    int transitionPoint(int arr[], int n) {
          int l=0;
          int h=n-1;
          int mid=0;
          while(l<=h){
              mid =(l+h)/2;
              if(arr[mid]==1 && arr[mid-1]==0)
                return mid;
              else{
                  if(arr[mid-1]==1)
                    h=mid-1;
                  else
                    l=mid+1;
              }
            
          }
          return -1;
    }
}
