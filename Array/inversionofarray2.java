
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n=Integer.parseInt(br.readLine());
		    long a[]=new long[n];
		    String s[]=br.readLine().split(" ");
		    for(int i=0;i<s.length;i++)
		    a[i]=Long.parseLong(s[i]);
		    
		    System.out.println(countInversions(a,0,n-1));
		}
	}
	public static long countInversions(long[] a,int low,int high)
	{
	    long count=0;
	    if(low<high)
	    {
	        int mid=(low+high)/2;
	        count+=countInversions(a,low,mid);
	        count+=countInversions(a,mid+1,high);
	        count+=crossInversions(a,low,mid,high);
	    }
	    return count;
	}
	public static long crossInversions(long a[],int low,int mid,int high)
	{
	    int n1=mid-low+1;
	    int n2=high-mid;
	    long l[]=new long[n1];
	    long r[]=new long[n2];
	    
	    for(int i=0;i<n1;i++)
	      l[i]=a[low+i];
	      
	    for(int i=0;i<n2;i++)
	      r[i]=a[mid+1+i];
	      
	    long ans=0;  
	    int left=0,right=0,k=low;
	    
	    while(left<n1 && right<n2)
	    {
	        if(l[left]<=r[right])
	        a[k++]=l[left++];
	        else
	        {
	           ans+=(n1-left);
	           a[k++]=r[right++];
	        }
	    }
	    
	    while(left<n1)
	    a[k++]=l[left++];
	    
	    while(right<n2)
	    a[k++]=r[right++];
	    
	    return ans;
	}
}
