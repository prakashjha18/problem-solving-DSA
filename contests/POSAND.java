import java.util.*;
import java.lang.*;
import java.io.*;

/*
A permutation p1,p2...pN of {1,2,...,N} is beautiful if pi&pi+1 is greater than 0 for every 1≤i<N .
You are given an integer N, and your task is toconstruct a beautiful permutation of length N or determine that it's impossible.

Note that a&b denotes the bitwise AND of a and b.

Input:
First line will contain T, number of testcases. Then the testcases follow. Each testcase contains a single line of input, an integer N.

Output:
For each test case output −1 if there is no suitable permutation of length N, otherwise output N integers in a single 
line which form a beautiful permutation. If there are multiple answers output any of them.

Constraints
1≤N≤105
The sum of N over all test cases does not exceed 106
Subtasks
50 points : 1≤N,T≤9
50 points : Original constraints
Sample Input:
3
4
3
5
Sample Output:
-1
1 3 2
2 3 1 5 4
*/
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
    static boolean poweroftwo(int x){
         return x!=0 && ((x&(x-1)) == 0);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
    		Reader sc=new Reader(); 
    		int t = sc.nextInt();
    		while(t-->0){
    		    int n=sc.nextInt();
    		    //ArrayList<Integer> a = new ArrayList<Integer>();
    		    StringBuilder a 
                    = new StringBuilder();
    		    if(n==1){
    		        a.append(1+" ");
    		    }
    		    if(poweroftwo(n) && n!=1){
    		        System.out.println(-1);
    		        continue;
    		    } 
		        if(n>=3){
		            a.append(2+" ");
		            a.append(3+" ");
		            a.append(1+" ");
		        }
		        if(n>3 && !poweroftwo(n)){
		            int i=4;
		            while(i<=n){
		                if(poweroftwo(i)){
		                     a.append((i+1)+" ");
		                     a.append(i+" ");
		                     i=i+2;
		                } else {
		                    a.append(i+" ");
		                    i=i+1;
		                }
		            }
		        }
		        
		        System.out.println(a);
    		    
    		}
		}
		catch(Exception e){}
	}
}
