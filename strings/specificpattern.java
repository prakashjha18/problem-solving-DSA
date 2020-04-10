// Given a dictionary of words and a pattern. Every character in the pattern is uniquely mapped to a character in the dictionary. The task is to complete a function findMatchedWords(dict,pattern) that returns a vector of strings matching with given pattern. The function takes two argument the first argument is an array of strings dict which denote the dictionary and the second argument is the pattern to match.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Each testcase contains 3 lines. The first line contains an integer N denoting the number of strings in the dictionary,second line N space separated strings denoting the strings of the dictionary. The third line contains pattern.

// Output:
// The output for each test case will be the space separated strings that matches the given pattern in lexicographical order.

// User Task:
// Since this is a functional problem you don't have to worry about input, you just have to complete the function findMatchedWords()

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10

// Input
// 1
// 4
// abb abc xyz xyy
// foo

// Output
// abb xyy

// Explanation
// Testcase 1: In the above test case xyy and abb have same character at index 1 and 2 like the pattern.
// { Driver Code Starts
import java.util.*;
public class specificpattern
{	public static void main(String[] args)
    {Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-- != 0)
        {
            int n=sc.nextInt();
            ArrayList<String> s = new ArrayList<String>(n);
            for (int i=0;i<n;i++)
            {
            s.add(sc.next());
            }

            String tt;
            tt=sc.next();
            GfG g=new GfG();
            ArrayList<String> res =g.findMatchedWords(s, tt);
                    Collections.sort(res);
            for (int i = 0;i < res.size();i++)
            {
            System.out.print(res.get(i)+" ");
            }
            System.out.println();

        }
    }
}// } Driver Code Ends
/*Complete the provided function*/
class GfG{
    public static boolean check(String a,String pattern){
        Map<Character, Character> map = new HashMap<>();
        
        if(a.length()!=pattern.length()){
            return false;
        } 
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(a.charAt(i))) {
                    return false;
                }
            } else {
                map.put(c, a.charAt(i));    
                set.add(a.charAt(i));
                //value.add(dict.get(i));
            }
        }
        if (set.size() != map.keySet().size()) {
            return false;
        }
        return true;
        }
    
    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
    {
        ArrayList<String> value = new ArrayList<String>();
        //ArrayList<String> value = new ArrayList<String>();
        for(int i=0;i<dict.size();i++){
            if(check(dict.get(i),pattern)){
                value.add(dict.get(i));
            }
        }
        return value;
    }
}
