/*package whatever //do not write package name here */
//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room/0
// There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) 
// where S[i] is start time of meeting i and F[i] is finish time of meeting i.

// What is the maximum number of meetings that can be accommodated in the meeting room?

// Input:
// The first line of input consists number of the test cases. The description of T test 
// cases is as follows:
// The first line consists of the size of the array, second line has the array containing 
// the starting time of all the meetings each separated by a space, i.e., S [ i ]. And the 
// third line has the array containing the finishing time of all the meetings each separated
// by a space, i.e., F [ i ].

// Output:
// In each separate line print the order in which the meetings take place separated by a space.

// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 100
// 1 ≤ S[ i ], F[ i ] ≤ 100000

// Example:
// Input:
// 2
// 6
// 1 3 0 5 8 5
// 2 4 6 7 9 9
// 8
// 75250 50074 43659 8931 11273 27545 50879 77924
// 112960 114515 81825 93424 54316 35533 73383 160252  

// Output:
// 1 2 4 5
// 6 7 1

// Explanation:
// Testcase 1: Four meetings can held with given start and end timings.
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
	        StringBuffer sb = new StringBuffer();
	        sb.append(al.get(0).pos+1+" ");
	        int timelimit = al.get(0).end;
	        for(int i=1;i<n;i++){
	            if(al.get(i).start>= timelimit){
	                sb.append(al.get(i).pos+1+ " ");
	                timelimit=al.get(i).end;
	            }
	        }
	        System.out.println(sb);
	        
		}
	}
}
