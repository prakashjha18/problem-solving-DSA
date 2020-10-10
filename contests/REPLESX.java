import java.util.*;
import java.lang.*;
import java.io.*;

/*

You are given an array of N integers A1,A2,…,AN and three more integers X,p, and k.

An operation on the array is defined to be: replace the k-th smallest integer in the array with any integer you want.

Output the minimum number of operations you must perform on the array (possibly 0 operations) to make the p-th
smallest element of the array equal to X. If it is impossible to do so output −1.

Note: the k-th smallest number in an array is the k-th number from the left when the array is sorted in non-decreasing order.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains four integers N,X,p,k respectively.
The second line contains N space-separated integers A1,A2,…,AN.
Output
For each test case, print a single line containing one integer ― the minimum number of operations 
you must perform to make X the p-th smallest element or −1 if its impossible to do so.

Constraints
1≤T≤100
1≤p,k≤N
0≤X≤109
The sum of N over all test cases does not exceed 4∗105
0≤Ai≤109 for each valid i
Subtasks
Subtask #1 (10 points): N≤5
Subtask #2 (40 points): The sum of N over all test cases does not exceed 3∗103
Subtask #3 (50 points): Original constraints

Example Input
2
5 4 3 4
4 9 7 0 8
2 25 1 2
100 20
Example Output
1
-1
Explanation
Example case 1:

We can perform one operation in the array. Take the k-th smallest integer of the current array (which is 8 in this case)
and replace it with 0. The array then becomes [4,9,7,0,0] which now makes 4 as the 3rd smallest number of the array.
Example case 2:

It is impossible to make 25 as the smallest number of the array. */

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
    		Reader sc=new Reader(); 
    		int t = sc.nextInt();
    		while(t-->0){
    		    int n = sc.nextInt();
    		    int x = sc.nextInt();
    		    int p = sc.nextInt();
    		    int k = sc.nextInt();
    		    int arr[] = new int[n];
    		    for(int i=0;i<n;i++){
    		        arr[i] = sc.nextInt();
    		    }
    		    Arrays.sort(arr);
    		    p=p-1;
    		    k=k-1;
    		    
    		    //System.out.println(p+"__"+k);
    		    if(arr[p]==x){
    		        System.out.println(0);
    		    }
    		    else if(p==k){
    		        if(arr[p]<x){
    		            int start = p+1;
    		            while(start<n){
    		                if(arr[start]>=x){
    		                    break;
    		                } else {
    		                    start++;
    		                }
    		            }
    		            System.out.println(start-p);
    		        } else {
    		            int start = p-1;
    		            while(start>=0){
    		                if(arr[start]<=x){
    		                    break;
    		                } else {
    		                    start--;
    		                }
    		            }
    		            System.out.println(p-start);
    		        }
    		    } else if(p<k){
    		        if(arr[p]<x){
    		           System.out.println(-1);
    		        } else {
    		            int start = p-1;
    		            while(start>=0){
    		                if(arr[start]<=x){
    		                    break;
    		                } else {
    		                    start--;
    		                }
    		            }
    		            System.out.println(p-start);
    		        }
    		    } else{
    		        if(arr[p]<x){
    		            int start = p+1;
    		            while(start<n){
    		                if(arr[start]>=x){
    		                    break;
    		                } else {
    		                    start++;
    		                }
    		            }
    		            System.out.println(start-p);
    		        } else {
    		             System.out.println(-1);
    		        }
    		    }
    		}
		}
		catch(Exception e){}
	}
}
