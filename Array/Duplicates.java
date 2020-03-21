// { Driver Code Starts
import java.util.Scanner;
class Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            GfG g = new GfG();
            g.printDuplicates(a, n);
            System.out.println();
        }
    }
}// } Driver Code Ends
/*Complete the function below*/
class GfG {
    public static void printDuplicates(int arr[], int n) {
        java.util.HashMap<String,Integer> map=new java.util.HashMap<>();
           Integer temp;
           boolean flag=false;
           for(int i=0;i<n;i++){
               temp=map.get(String.valueOf(arr[i]));
               if(temp==null)
                    map.put(String.valueOf(arr[i]),1);
                else if((int)temp==1) {
                        flag=true;
                        System.out.print(arr[i]+" ");
                        map.put(String.valueOf(arr[i]),2);
                    }
           }
           if(!flag)
              System.out.print(-1);
        
    }
}
