// { Driver Code Starts

import java.util.*;
import java.io.*;
class SubSeq {
    public static boolean isSubSequence(ArrayList<Integer> v1, ArrayList<Integer> v2,
                                 int n, int m) {

        if (m == 0) return true;
        if (n == 0) return false;

        if (v1.get(n - 1) == v2.get(m - 1))
            return isSubSequence(v1, v2, n - 1, m - 1);

        return isSubSequence(v1, v2, n - 1, m);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(str[i]));
            }
            GfG g = new GfG();
            ArrayList<Integer> res = g.find3Numbers(a, n);

            // wrong format output
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            }

            if (res.isEmpty()) {
                System.out.println(0);
            } else if ((res.get(0) < res.get(1)) && (res.get(1) < res.get(2)) &&
                       isSubSequence(a, res, n, res.size())) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        }
    }
}// } Driver Code Ends
/*Complete the function below*/

class GfG {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> l =  new ArrayList<Integer>();
        // Add max values as placeholder for increasing pair.
        l.add(Integer.MAX_VALUE); l.add(Integer.MAX_VALUE);
        
        // Look for better increasing pair as well as bigger 3rd element
        for(int i=1; i<n; i++) {
            if(arr.get(i-1)<arr.get(i) && arr.get(i)<l.get(1)) {
                l.clear();
                l.add(arr.get(i-1)); l.add(arr.get(i));
            }
            if (arr.get(i)>l.get(1)){
                l.add(arr.get(i));
                return l;
            }
        }
        
        // If we are here means we did not find 3 sorted elements.
        // return empty list.
        l.clear();
        return l;
    }
}
