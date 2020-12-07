import java.util.*;
/*
Given a string, we have to find out all subsequences of it. A String is a subsequence of a given String, 
that is generated by deleting some character of a given string without changing its order.
Examples: 

Input : abc
Output : a, b, c, ab, bc, ac, abc

Input : aaa
Output : a, aa, aaa
*/




//Method 1
/*
public class printallsubseq{
    static List<String> al = new ArrayList<>();

    public static void main(String[] args){
        String s = "abc";
        findsubsequence(s,"");
        System.out.println(al);
    }
    public static void findsubsequence(String s,String ans){
        if(s.length()==0){
            al.add(ans);
            return;
        }
        findsubsequence(s.substring(1),ans+s.charAt(0));
        findsubsequence(s.substring(1),ans);
    }
}
*/

//METHOD 2
/*
public class printallsubseq{
    static HashSet<String> st = new HashSet<>();
    static void subsequence(String str){
        for(int i=0;i<str.length();i++){
            for(int j=str.length();j>i;j--){
                String sub_str = str.substring(i,j);

                if(!st.contains(sub_str))
                    st.add(sub_str);
                
                for(int k=1;k<sub_str.length()-1;k++){
                    StringBuilder sb = new StringBuilder(sub_str);

                    sb.deleteCharAt(k);
                    if (!st.contains(sb));
                        subsequence(sb.toString());
                }
            }
        }
    }

    public static void main(String[] args){
        String s = "abc";
        subsequence(s);
        System.out.println(st);
    }
}
*/


//METHOD 3
public class printallsubseq{
    static List<String> al = new ArrayList<>();
    static void printSubSeqRec(String str, int n,int index, String curr){
        if(index==n)
            return;
        if( curr !=null && !curr.trim().isEmpty()){
            al.add(curr);
        }
        for(int i=index+1;i<n;i++){
            curr+=str.charAt(i);
            printSubSeqRec(str,n,i,curr);
            curr=curr.substring(0,curr.length()-1);
        }
    }

    static void printSubSeq(String str){
        int index = -1;
        String curr = "";
 
        printSubSeqRec(str, str.length(), index, curr);
    }
 
    // Driver code
    public static void main(String[] args){
        String str = "cabd";
        printSubSeq(str);
        System.out.println(al);
    }
}
