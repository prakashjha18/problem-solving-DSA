// { Driver Code Starts
/*
Given a sorted linked list of distinct nodes (no two nodes have the same data) and an integer X. Count distinct 
triplets in the list that sum up to given integer X.

Input:The first line of input contains an integer T denoting number of test cases. For each test case, there 
are two lines of input. First line contains two integers size of linked list( N ) and the value X . Next line 
contains reversely sorted N integers.

Output:For each test case, print the count of triplets with given sum X .

Your Task:You have to complete the function countTriplets() which takes head pointer of sorted linked list and 
given value X as parameters and returns count of triplets.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= data of a node <= 104
1 <= x <= 5000

Example:
Input:

2
7 17
9 8 6 5 4 2 1
7 15
9 8 6 5 4 2 1
Output:

2
5
Explanation:
Test Case 1:  Head pointer pointing to link list 1-> 2->4->5->6->8->9 , Distinct triplets are ( 2,6,9) and (4,5,8)  
which have sum equal to X i.e 17.
*/

import java.util.*;
class Node{
    int data;
    Node next;
    
    Node(int a){
        data = a;
        next = null;
    }
    
}

class LinkedList{
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int x=sc.nextInt();
            Node head=null;
            for(int i=0;i<n;i++)
            {int a=sc.nextInt();
            if(head==null){
                head=new Node(a);
            }
            else
                insert(head,a);
            }
        
            Solve y = new Solve();
            System.out.println(y.countTriplets(head,x));
        }
    }
    public static Node insert(Node head,int a){
        if(head==null){
            return new Node(a);
        }
        head.next=insert(head.next,a);
        return head;
    }
    
}

// } Driver Code Ends


//User function Template for Java

class Solve
{
    static int countTriplets(Node head, int x) 
    { 
        //code here.
        Node ptr, ptr1, ptr2; 
        int count = 0; 
        
        HashMap<Integer,Node> um = new HashMap<Integer,Node>(); 
        for (ptr = head; ptr != null; ptr = ptr.next) 
            um.put(ptr.data, ptr);
            
        for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next) {
            for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) { 
       
                int p_sum = ptr1.data + ptr2.data; 
                if (um.containsKey(x - p_sum) && um.get(x - p_sum) != ptr1 
                    && um.get(x - p_sum) != ptr2) 
       
                    count++;   
            } 
        }
        return count/3;
    } 
}
