//     Given a Linked list of size N, the list is in alternating ascending and descending orders. Your task is to complete the function sort() that sorts the given linked list in non-decreasing order.

// Input:
// The function takes a single argument as input the reference pointer to the head of the linked list.
// There are T test cases and for each test case the function will be called separately.

// Output:
// For each test case function should return reference pointer to the head of the new linked list.

// User Task:
// The task is to complete the function sort() which should sort the linked list in non-decreasing order.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= A[] <= 103

// Example:
// Input:
// 2
// 6
// 1 9 2 8 3 7
// 5
// 13 99 21 80 50

// Output:
// 1 2 3 7 8 9
// 13 21 50 80 99



// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    obj.show(head);
		}
	}
}
// } Driver Code Ends
/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    public void show(Node x){
        while(x!=null){
            System.out.print(x.data+" ");
            x=x.next;
        }
        System.out.println();
    }
    void splitList(Node Ahead, Node Dhead, Node head){ 
        Node ascn = Ahead; 
        Node dscn = Dhead; 
        Node curr = head; 
        while (curr != null){ 
            ascn.next = curr; 
            ascn = ascn.next; 
            curr = curr.next; 
            if (curr != null){ 
                dscn.next = curr; 
                dscn = dscn.next; 
                curr = curr.next; 
            } 
        } 
        ascn.next = null; 
        dscn.next = null; 
    } 
    public Node reverseList(Node Dhead){ 
        Node prev = null;
        Node curr = Dhead;
        Node temp = Dhead;
        while(curr!=null){
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            
        }
        return prev;
    } 
    public Node mergeList(Node head1, Node head2){ 
        if (head1 == null) return head2; 
        if (head2 == null) return head1; 
        if (head1.data < head2.data){ 
            head1.next = mergeList(head1.next, head2); 
            return head1;
        } 
        else{ 
            head2.next = mergeList(head1, head2.next); 
            return head2;
        } 
    } 
    public Node sort(Node head){
        Node Ahead = new Node(0), Dhead = new Node(0); 
        splitList(Ahead, Dhead,head);  
        Ahead = Ahead.next; 
        Dhead = Dhead.next; 
        Dhead = reverseList(Dhead); 
        head = mergeList(Ahead,Dhead); 
        return head;
   }


}
