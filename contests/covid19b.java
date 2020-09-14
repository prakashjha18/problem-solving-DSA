/*
There are N athletes (numbered 1 through N) in a line. For each valid i, the i-th athlete 
starts at the position i and his speed is Vi, i.e. for any real number t≥0, the position
of the i-th athlete at the time t is i+Vi⋅t.

Unfortunately, one of the athletes is infected with a virus at the time t=0. This virus
only spreads from an infected athlete to another whenever their positions are the same at
the same time. A newly infected athlete may then infect others as well.

We do not know which athlete is infected initially. However, if we wait long enough, 
a specific set of athletes (depending on the athlete that was infected initially) will 
become infected. Your task is to find the size of this set, i.e. the final number of 
infected people, in the best and worst possible scenario.

Input
The first line of the input contains a single integer T denoting the number of test 
cases. The description of T test cases follows.
The first line of each test case contains a single integer N.
The second line contains N space-separated integers V1,V2,…,VN.
Output
For each test case, print a single line containing two space-separated integers ― 
the smallest and largest final number of infected people.

Constraints
1≤T≤104
3≤N≤5
0≤Vi≤5 for each valid i
Subtasks
Subtask #1 (1 point): N=3
Subtask #2 (99 points): original constraints

Example Input
4
3
1 2 3
3
3 2 1
3
0 0 0
3
1 3 2
Example Output
1 1
3 3
1 1
1 2
Explanation
Example case 1: No two athletes will ever have the same position, so the virus cannot spread.

Example case 2: It does not matter who is initially infected, the first athlete
would always spread it to everyone.

Example case 3: The athletes are not moving, so the virus cannot spread.

Example case 4: The best possible scenario is when the initially infected athlete
is the first one, since he cannot infect anyone else. In the worst possible scenario,
eventually, the second and third athletes are infected. */


import java.util.*;
import java.lang.*;
import java.io.*;

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
            public static Integer findMin(List<Integer> list) 
	    { 

		// check list is empty or not 
		if (list == null || list.size() == 0) { 
		    return Integer.MAX_VALUE; 
		} 

		// return minimum value of the ArrayList 
		return Collections.min(list); 
	    } 

	    // function return maximum value in an unsorted 
	    //  list in Java using Collection 
	    public static Integer findMax(List<Integer> list) 
	    { 

		// check list is empty or not 
		if (list == null || list.size() == 0) { 
		    return Integer.MIN_VALUE; 
		} 

		// return maximum value of the ArrayList 
		return Collections.max(list); 
	    } 
	    public static void rec(double a[][],HashSet<Integer> s,int p,int n, double t){
		for(int i=0;i<n;i++){
		    if (a[p][i] > t)
		    {
			s.add(i);
			rec(a, s, i, n, a[p][i]);
		    }
		}
	    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
    		Reader sc=new Reader(); 
    		int t = sc.nextInt();
    		while(t-->0){
    		    int N = sc.nextInt();
    		    int[] arr = new int[N];
    		    for(int i=0;i<N;i++){
    		        arr[i]=sc.nextInt();
    		    }
    		    int min = N,max=1;
    		    for(int i=0;i<N;i++){
    		        int cases =1,vs=arr[i],vg=arr[i];
    		        for(int j=i+1;j<N;j++){
    		            if(arr[j]<arr[i]){
    		                if(vs>arr[j]){
    		                    vs=arr[j];
    		                }
    		            }
    		        }
    		        for(int j=0;j<i;j++){
    		            if(arr[j]>vs){
    		                cases++;
    		            } 
    		            if(vg<arr[j]){
    		                vg=arr[j];
    		            }
    		        }
    		        for(int j=i+1;j<N;j++){
    		            if(arr[j]<vg){
    		                cases++;
    		            }
    		        }
    		        //System.out.print(cases+" ");
    		        if(max<cases){
    		            max=cases;
    		        }
    		        if(min>cases){
    		            min=cases;
    		        }
    		    }
    		    System.out.println(min+" "+max);
    		}
		}
		catch(Exception e){}
		// Method 2 using backtracking
		try{
    		Reader sc=new Reader(); 
    		int t = sc.nextInt();
    		while(t-->0){
    		    int n = sc.nextInt();
    		    double a[][] = new double[n][n];
    		    int ar[] = new int[n];
    		    for(int i=0;i<n;i++){
    		        ar[i]=sc.nextInt();
    		    }
    		    double d1;
    		    for(int i=0;i<n;i++){
    		        for(int j=0;j<n;j++){
    		            a[i][j] = 0;
    		        }
    		    }
    		    
    		    for(int i=0;i<n;i++){
    		        for(int j=0;j<n;j++){
    		            if (ar[i] == ar[j])
                        {
                            a[i][j] = -1;
                        }
                        else
                        {
                            double up = (i-j);
                            double dp = ar[j]-ar[i];
                            d1 = (double)(up / dp);
                            if (d1 <= 0)
                            {
                                a[i][j] = -1;
                            }
                            else
                            {
                                a[i][j] = d1;
                            }
                        }
    		        }
    		    }
    		  HashSet<Integer> s = new HashSet<Integer>();
    		  List<Integer> v = new ArrayList<Integer>();
    		  for(int i=0;i<n;i++){
    		      s.add(i);
    		      rec(a,s,i,n,0);
    		      v.add(s.size());
    		      s.clear();
    		  }
    		  System.out.println(findMin(v) +" "+findMax(v));
    		}
		}
		catch(Exception e){}
	}
}
