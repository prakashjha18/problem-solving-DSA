// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class queueoperations { 
    
    public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int inputN = inputLine.length;
		    GfgQueue gq = new GfgQueue();
		    try{
    		    for(int i=0, k=0; i<n; i++){
    		        if(inputLine[k].equals("i")){
    		            k++;
    		            gq.enqueue(Integer.parseInt(inputLine[k]));
    		            k++;
    		        }
    		        if(inputLine[k].equals("h")){
    		            k++;
    		            gq.front();
    		        }
    		        if(inputLine[k].equals("r")){
    		            k++;
    		            gq.dequeue();
    		        }
    		        if(inputLine[k].equals("f")){
    		            k++;
    		            gq.find(Integer.parseInt(inputLine[k]));
    		            k++;
    		        }
    		        if(k==inputN)break;
    		    }
		    } catch (ArrayIndexOutOfBoundsException ex){
		        continue;
		    }
		}
	}
}// } Driver Code Ends


//User function Template for Java
class GfgQueue {
    Queue<Integer> q = new LinkedList<>();
    void enqueue(int x){
        // Code here
        q.add(x);
    }
    void dequeue(){
        // code here
        q.poll();
    }
    void front(){
        // Code here
        int x = q.peek();
        System.out.println(x);
    }
    void find(int x){
        if(q.contains(x)){
        System.out.println("Yes");
        } else {
        System.out.println("No");
        }
    }
}
