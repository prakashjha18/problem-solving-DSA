// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Permutation obj=new Permutation();
		    
		    String S=sc.nextLine();
		    
		    obj.permutation(S);
		    
		    System.out.println();
		}
		
	}
}
// } Driver Code Ends
//User function Template for Java


class Permutation
{
    public ArrayList<String> al1 = new ArrayList<>();
    public void permutation(String s)
    {
        //Your code here
        int l =0,r=s.length()-1;
        ArrayList<String> al = getPerm(s,l,r);
        Collections.sort(al);
        for(String s1:al)
            System.out.print(s1+" ");
    }
    public String swap(String s,int i,int j)
    {
        char[] ch = s.toCharArray();
        char t = ch[i];
        ch[i] = ch[j];
        ch[j]= t;
        return String.valueOf(ch);
    }
    public ArrayList<String> getPerm(String s,int l,int r)
    {
        if(l == r)
        {
            al1.add(s);
        }
        else {
            for(int i=l;i<=r;i++)
            {
                    s = swap(s,l,i);
                    getPerm(s,l+1,r);
                    s = swap(s,l,i);
            }
        }
        return al1;
    }
}
