/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class input
{
	int start;
	int end;
	int pos;
	input(int s, int e, int p)
	{
		start = s;
		end = e;
		pos = p;
	}
	
}
class SortEnd implements Comparator<input> 
{ 
    public int compare(input a, input b) 
    { 
        return a.end - b.end; 
    } 
}
class GFG {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while(t-->0){
		    int n = Integer.parseInt(bf.readLine());
	        ArrayList<input> al = new ArrayList<input>();
	        String s[] = bf.readLine().trim().split(" ");
	        String f[] = bf.readLine().trim().split(" ");
	        
	        for(int i=0 ; i<n ; i++)
	        {
	            input obj = new input(Integer.parseInt(s[i]), Integer.parseInt(f[i]), i);
	            al.add(obj);         
	        }
	        Collections.sort(al, new SortEnd());
	        int count =1;
	        int timelimit = al.get(0).end;
	        for(int i=1;i<n;i++){
	            if(al.get(i).start>= timelimit){
	                count++;
	                timelimit=al.get(i).end;
	            }
	        }
	        System.out.println(count);
	        
		}
	}
}
