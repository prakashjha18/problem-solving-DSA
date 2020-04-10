// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static Scanner sc = new Scanner(System.in);
	public static void main (String[] args){
        int t;
    	t=sc.nextInt();
    	sc.nextLine();
    	while((t--)!=0){
    	    int n=sc.nextInt();
    	    sc.nextLine();
    	    String s = new String();
    	    s=sc.nextLine();
    	    StringBinary obj = new StringBinary();
    	    System.out.println(obj.binarySubstring(n, s));
    	}
	}
}// } Driver Code Ends
/*  Function to count the number of substrings 
*   starting and ending with 1
*   n: size of string
*   a: input string
*/
class StringBinary{
    public static int binarySubstring(int a, String str)
    {
        // Your code here
        int count =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')
                count++;
        }
        return (int)((count*(count-1))/2);
    }
}
