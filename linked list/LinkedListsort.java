// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new LinkedList().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends
//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class LinkedListsort
{
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null||head.next==null)
            return head;
        Node middle=getMiddle(head);
        Node nextOfMiddle=middle.next;
        middle.next=null;
        Node left=mergeSort(head);
        Node right=mergeSort(nextOfMiddle);
        Node sortedList= sortedMerge(left,right);
        return sortedList;
    }
    static Node getMiddle(Node head){
        if(head==null)
            return head;
        Node slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node sortedMerge(Node a,Node b){
        Node result=null;
        if(a==null)
            return b;
        if(b==null)
            return a;
        if(a.data<=b.data){
            result=a;
            result.next=sortedMerge(a.next,b);
        }else{
            result=b;
            result.next=sortedMerge(a,b.next);
            
        }
        return result;
    }
}


