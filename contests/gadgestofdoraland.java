/*package whatever //do not write package name here */
// In Doraland, people have unique Identity Numbers called D-id. Doraemon owns the most popular gadget shop in Doraland. Since his gadgets are in high demand and he has only K gadgets left he has decided to sell his gadgets to his most frequent customers only. In case two or more people have visited his shop the same number of time he gives priority to the customer with higher D-id. Find the D-ids of people he sells his K gadgets to.

// Input:
// The first line of input contains the number of test cases T. For each test case, there will be three lines of input. The first line contains the number N ie. the total number of times people visited the shop. Second line contains N space-separated integers denoting D-id's of people who visited the shop .The third line contains the integer K.

// Output:
// For each test case, print the D-id of top k people who purchased gadgets from Doraemon.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 105
// 1<= D-id <=104

// Example:
// Input:
// 2
// 6
// 1 1 1 2 2 3
// 2
// 8
// 1 1 2 2 3 3 3 4
// 2
// Output:
// 1 2
// 3 2 

// Explanation:
// TestCase 2: People with D-id 1 and 2 have visited shop 2 times Therefore, in this case, the answer includes the D-id 2 as 2 > 1.
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
        while (t > 0) {
            int n=Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String s1[]=br.readLine().split(" ");
            int G = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s1[i]);
            GfG g = new GfG();
            g.maxLen(arr, n,G);
            t--;
        }
	}
}
class MyComparator implements Comparator {

    Map map;
    
    public MyComparator(Map map) {
        this.map = map;
    }
    
    public int compare(Object o1, Object o2) {
        if((Integer)map.get(o2)==(Integer) map.get(o1)){
            return((Integer)o2-(Integer)o1);
        }
        return ((Integer) map.get(o2)-(Integer) map.get(o1));
    }
}
class GfG {
   
    public void maxLen(int arr[], int nums,int G) {
        if(G==0) {System.out.print(" ");return;}
        if(nums==1){ 
            System.out.print(arr[1]);
            return;
        }
        HashMap<Integer, Integer> mp = new HashMap<>(); 
  
        for (int i = 0; i < arr.length; i++) 
        { 
            mp.put(arr[i], mp.get(arr[i]) == null ? 1 : mp.get(arr[i]) + 1); 
        } 
        MyComparator comp=new MyComparator(mp);

        Map<Integer,Integer> newMap = new TreeMap<>(comp);
        newMap.putAll(mp);
        int p=0;
        for(int k : newMap.keySet()){
            p++;
            System.out.print(k+" ");
            if(p==G) break;
        }
        System.out.println();
    }
}
