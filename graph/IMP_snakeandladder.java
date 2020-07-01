/*package whatever //do not write package name here */
//https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem/0
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class qentry { 
        int v; 
        int dist;
    } 
    static int getMinDiceThrows(int move[], int n)  
    { 
        // for(int x:move){
        //     System.out.print(x+" ");
        // }
        int visited[] = new int[n+1]; 
        Queue<qentry> q = new LinkedList<>(); 
        qentry qe = new qentry(); 
        qe.v = 1; 
        qe.dist = 0; 
  
        // Mark the node 0 as visited and enqueue it. 
        visited[0] = 1; 
        q.add(qe); 
  
        // Do a BFS starting from vertex at index 0 
        while (!q.isEmpty()){ 
            qe = q.remove(); 
            int v = qe.v; 
            
            if (v == n ) 
                break; 
            for (int j = v + 1; j <= (v + 6) && j <= n; j++)  { 
                // If this cell is already visited, then ignore 
                if (visited[j] == 0) { 
                    qentry a = new qentry(); 
                    a.dist = (qe.dist + 1); 
                    visited[j] = 1; 
  
                    if (move[j] != -1) 
                        a.v = move[j]; 
                    else
                        a.v = j; 
                    q.add(a); 
                } 
            } 
        } 
        //System.out.print(q.size());
        return qe.dist; 
    } 
  
	public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
		int N=30;
		int t=sc.nextInt();
		while(t-->0){
		    int moves[] = new int[31]; 
            for (int i = 0; i <= 30; i++) 
                moves[i] = -1; 
            int x =sc.nextInt();
            for(int i=0;i<x;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                moves[a] =b;
            }
            System.out.println(getMinDiceThrows(moves, N)); 
		}
	}
}
