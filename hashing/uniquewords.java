// { Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String A = br.readLine();
                    String B = br.readLine();
                    Sol obj = new Sol();
                    ArrayList<String> res = obj.uniqueWords(A, B);
                    for(String i : res)
                        System.out.print(i + " ");
                    System.out.println();
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    ArrayList<String> uniqueWords(String A , String B)
    {
        Map<String, Integer> count = new HashMap<>();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        ArrayList<String> ans = new ArrayList<>();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);
        Collections.sort(ans);
        return ans;
    }
}
