// Consider the following dictionary 
// { i, like, sam, sung, samsung, mobile, ice, 
//   cream, icecream, man, go, mango}

// Input: "ilikesamsungmobile"
// Output: i like sam sung mobile
//         i like samsung mobile

// Input: "ilikeicecreamandmango"
// Output: i like ice cream and man go
//         i like ice cream and mango
//         i like icecream and man go
//         i like icecream and mango

import java.util.*;
public class wordbreakback{
    public static void wordBreak(String str){
        List<String> list = Arrays.asList("mobile","samsung","sam","sung", 
        "man","mango", "icecream","and", 
        "go","i","love","ice","cream");
        Set<String> dict = new HashSet<>();
        dict.addAll(list);
        wordBreakUtil(str, str.length(), "",dict); 
    }
    public static void wordBreakUtil(String str, int n, String result,Set<String> dict){
        for(int i=1;i<=n;i++){
            String prefix = str.substring(0,i);
            if(dict.contains(prefix)){
                if(i==n){
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                wordBreakUtil(str.substring(i,n),n-i,result+prefix+" ",dict);
            }
        }
    }
    public static void main(String args[]){
        wordBreak("iloveicecreamandmango");
    }
}
