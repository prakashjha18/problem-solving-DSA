// { Driver Code Starts
//Initial Template for Java
//https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1/?track=Amazon-backtracking&batchId=192
// Example:
// Input:
// 2
// 3
// 2 3 4
// 3
// 3 4 5
// Output:
// adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi
// dgj dgk dgl dhj dhk dhl dij dik dil egj egk egl ehj ehk ehl eij eik eil fgj fgk fgl fhj fhk fhl fij fik fil

import java.util.*;
import java.io.*;
import java.lang.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();
             new PhoneDigit().possibleWords(arr, n);
             System.out.println();
              
        }
    }
}
// } Driver Code Ends
//User function Template for Java

class PhoneDigit
{
    static String codes[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static ArrayList<String> getKPC(String str){
        if(str.length()==0){
            ArrayList<String> br = new ArrayList<String>();
            br.add("");
            return br;
        }
        char ch=str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rr= getKPC(ros);
        ArrayList<String> mr=new ArrayList<String>();
        for(String rstr:rr){
            String code =  codes[ch-'0'];
            for(int i=0;i<code.length();i++){
                char chcode = code.charAt(i);
                //System.out.print(chcode+rstr+"  ");
                mr.add(chcode+rstr);
            }
        }
        return mr;
    }
    static void possibleWords(int arr[], int N)
    {
         String str = "";
            for(int i = 0; i < N; i++)
              str += arr[i];
        ArrayList<String> mr = getKPC(str);
        Collections.sort(mr); // arrange all possible strings lexicographically
              for(String s: mr)
                System.out.print(s + " ");
    }
}


