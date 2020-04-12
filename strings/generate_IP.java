// { Driver Code Starts


import java.util.*;
class generate_IP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            for (String u : str) {
                System.out.println(u);
            }
        }
    }
}// } Driver Code Ends
/*complete the Function*/

class Solution {
    public ArrayList<String> genIp(String s) {
        // code here
        int n = s.length();
        ArrayList<String> res = new ArrayList<>();
        if (n < 4 || n > 12) return res; // edge case
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3 && i + j < n - 1; j++) {
                for (int k = 1; k <= 3 && i + j + k < n; k++) {
                    if (n - i - j - k > 3) continue; // 4th part is too big
                    int a = Integer.parseInt(s.substring(0, i));
                    int b = Integer.parseInt(s.substring(i, i + j));
                    int c = Integer.parseInt(s.substring(i + j, i + j + k));
                    int d = Integer.parseInt(s.substring(i + j + k));
                    if (a<= 255 && b <= 255 && c <= 255 && d <= 255) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(a).append(".").append(b).append(".") .append(c).append(".").append(d);
                        if (sb.length() == n + 3) // check case "00" -> 0.
                            res.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }
}
