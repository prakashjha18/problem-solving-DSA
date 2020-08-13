// { Driver Code Starts
//Initial Template for Java
/*
You are the head of the Amazon Parcel Store where at most K parcel can be kept. If (K+1)th  parcel comes to 
the store then you will remove the first parcel that came earlier to the store. There is priority A[i] that
is associated with all the parcel you have to tell what is the maximum priority parcel that is present in
the parcel store at every time on new parcel arrival ( after having K - 1 parcel ) in the store.
Note: We have to tell the maximum priority of the parcel after storing the new parcel in the store. 

Input:
The first line contains the number of test cases T.
For each test cases, You are given two space-separated integers the size of an array N and the capacity 
of the Parcel Store K.
The next line contains the N space-separated integers denoting the priority of ith parcel.

User Task:
As it is a functional problem. So, you don't need to worry about the input you just have to complete the 
function parcel_store() which takes parameter arr representing an array, size of an array N and store capacity 
K and print the answer it function itself, doesn't return anything.

Output:
Print the maximum priority parcel that is kept in the store on every new parcel entry.

Constraints:
1 <= T <= 500
1 <= N <= 105
1 <= K <= N
1 <= A[i] <= 109

Example:
Sample Input:
2
5 2
10 5 1 2 7
7 3
10 7 1 4 3 1 3

Sample Output:
10 5 2 7
10 7 4 4 3

Explanation:
For test case1:
1st parcel arrival: When parcel 1st come to store its not Kth parcel so print nothing.
2nd parcel arrival: When parcel 2nd come to store it is Kth parcel so we will print maximum priority
of parce till now i.e 10.
3rd parcel arrival: Now store have [5 , 1] parcels so maximum pariority among them is 5.
and so on...
*/



import java.io.*;
import java.util.*;

public class GfG { 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
	    
		Scanner Sc = new Scanner(System.in);
		int t = Sc.nextInt();
		while(t-- > 0){
    		int n = Sc.nextInt();
    		int k = Sc.nextInt();
    		
    		int arr[] = new int[n+1];
    		for(int i=0;i<n;i++){
    		    arr[i] = Sc.nextInt();
    		}
    		Amazon g = new Amazon();
    		g.parcel_store(arr,n,k);
		    System.out.println();
		}
	} 
} 
// } Driver Code Ends


//User function Template for Java

// You have to complete the function parcel_store which have parameters array, size of array and the capacity of store.
// Don't need to print nextline after printing answer. As driver code handle it for you.

class Amazon{
    
    static void parcel_store(int arr[], int n, int k) 
	{ 
		//int n=arr.length;
        Deque<Integer> qi = new LinkedList<Integer>(); 
        List<Integer> arrl = new ArrayList<Integer>();
        int i; 
        for (i = 0; i < k; ++i) { 
            while(!qi.isEmpty() && arr[i]>=arr[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        for(;i<arr.length;++i){
            //System.out.print(arr[qi.peek()]+" ");
            arrl.add(arr[qi.peek()]);
            while(!qi.isEmpty() && qi.peek()<=i-k)
                qi.removeFirst();
            while(!qi.isEmpty() && arr[i]>=arr[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        for(int j=0;j<arrl.size();j++){
            System.out.print(arrl.get(j)+" ");
        }
        
	}
	
}
