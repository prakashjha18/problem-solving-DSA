// Chefina has two sequences A1,A2,…,AN and B1,B2,…,BN. She views two sequences with length N as identical if,
// after they are sorted in non-decreasing order, the i-th element of one sequence is equal to the i-th element
// of the other sequence for each i (1≤i≤N).

// To impress Chefina, Chef wants to make the sequences identical. He may perform the following operation 
// zero or more times: choose two integers i and j (1≤i,j≤N) and swap Ai with Bj. The cost of each such
// operation is min(Ai,Bj).

// You have to find the minimum total cost with which Chef can make the two sequences identical.

// Input
// The first line of the input contains a single integer T denoting the number of test cases. 
// The description of T test cases follows.
// The first line of each test case contains a single integer N.
// The second line contains N space-separated integers A1,A2,…,AN.
// The third line contains N space-separated integers B1,B2,…,BN.
// Output
// For each test case, print a single line containing one integer ― the minimum cost, or −1 if 
// no valid sequence of operations exists.

// Constraints
// 1≤T≤2,000
// 1≤N≤2⋅105
// 1≤Ai,Bi≤109 for each valid i
// the sum of N over all test cases does not exceed 2⋅106
// Subtasks
// Subtask #1 (15 points):

// T≤20
// N≤20
// Subtask #2 (85 points): original constraints

// Example Input
// 3
// 1
// 1
// 2
// 2
// 1 2
// 2 1
// 2
// 1 1
// 2 2
// Example Output
// -1
// 0
// 1
// Explanation
// Example case 1: There is no way to make the sequences identical, so the answer is −1.

// Example case 2: The sequence are identical initially, so the answer is 0.

// Example case 3: We can swap A1 with B2, which makes the two sequences identical, so the answer is 1.



import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{   public static long utilx(long min,ArrayList<Long> arr1,ArrayList<Long> arr2,HashMap<Long, Long> count1,HashMap<Long, Long> count2,HashMap<Long, Long> total){
        
        if(count1.equals(count2)){
            return 0;
        }
        for(Map.Entry<Long,Long> entry:total.entrySet()){
            if(entry.getValue()%2==1)
                return -1;
        }
        ArrayList<Long> temparr1 = new ArrayList<Long>();
        ArrayList<Long> temparr2 = new ArrayList<Long>();
        for(Map.Entry<Long,Long> entry:total.entrySet()){
            long x=entry.getKey();
            long count =0;
            if(count1.containsKey(x) && count2.containsKey(x)){
                count = Math.abs(count1.get(x) -count2.get(x))/2l;
                if(count1.get(x)>count2.get(x)){
                    for(long i=0l;i<count;i++){
                        temparr1.add(x);
                    }
                }
                else if(count1.get(x)<count2.get(x)){
                    for(long i=0l;i<count;i++){
                        temparr2.add(x);
                    }
                }else {}
            }
            else if(count1.containsKey(x)){
                count =count1.get(x)/2l;
                for(long i=0l;i<count;i++){
                    temparr1.add(x);
                }
            } else if(count2.containsKey(x)){
                count =count2.get(x)/2l;
                for(long i=0l;i<count;i++){
                    temparr2.add(x);
                }
            }
            
        }
        long swaps =0;
        Collections.sort(temparr1);
        Collections.sort(temparr2);
        for(int i=0,j=temparr2.size()-1;i<temparr1.size();i++,j--){
            swaps+=Math.min((2l*min),Math.min(temparr1.get(i),temparr2.get(j)));
        }
        return swaps;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
    		Scanner sc = new Scanner(System.in);
    		int t = sc.nextInt();
    		while(t-->0){
    		    int n=sc.nextInt();
    		    ArrayList<Long> arr1 = new ArrayList<Long>();
    		    ArrayList<Long> arr2 = new ArrayList<Long>();
    		    HashMap<Long, Long> count1 = new HashMap<>();
                HashMap<Long, Long> count2 = new HashMap<>();
                HashMap<Long, Long> total = new HashMap<>();
                Long min=Long.MAX_VALUE;
    		    for(int i=0;i<n;i++){
    		        long a = sc.nextLong();
    		        if(a<min){
    		            min=a;
    		        }
    		        arr1.add(a);
    		        count1.put(a, count1.getOrDefault(a, 0l) + 1);
    		        total.put(a, total.getOrDefault(a, 0l) + 1);
    		    }
    		    for(int i=0;i<n;i++){
    		        long b = sc.nextLong();
    		        if(b<min){
    		            min=b;
    		        }
    		        arr2.add(b);
    		        count2.put(b, count2.getOrDefault(b, 0l) + 1);
    		        total.put(b, total.getOrDefault(b, 0l) + 1);
    		    }
    		    System.out.println(utilx(min,arr1,arr2,count1,count2,total));
    		}
		}
		catch(Exception e){}
	}
}
