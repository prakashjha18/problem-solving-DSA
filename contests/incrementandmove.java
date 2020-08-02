You are given a linked list containing N elements. Yor task it to do the following:

If two consecutive nodes of the linked list have the same data and the node next to them has the data equal to 100, 
then change the value of the first node to 100 and increment the value of the second node by 10%( floor value).
Once you are done doing the above with the whole list, just transfer all the nodes with 100 values to the end of
the linked list.
*Note : Please write your code using Linked List only otherwise your code will be rejected.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines. First line 
contains number of nodes N and second line contains values of the nodes.

Output:
Print the list after modification in the format mentioned in the sample output below.

Constraints:
1 <=T<=100
1 <= N <= 100
0 <= LL elements <= 1000

Example:
Input:
2
6
1 1 100 2 3 7
6
100 100 100 100 100 7

Output:
1-> 2-> 3-> 7-> 100-> 100
110-> 7-> 100-> 100-> 100-> 100

Explanation:
For testcase1: We have 6 elements. Here 1 and 1 are equal and previous to a 100. So change the value of the first 1 to 
100 and increment second 1's value to 10% floor of 1. So 1+floor(1*(10/100))=1+0=1. So the transitory list is 100 1 100
2 3 7. Now transfer all 100 to the end. So the final list is 1 2 3 7 100 100.


import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node next;
   Node(int x){
        data=x;
        next=null;
    }
}


class GFG {
    
    public static void traverseChange(Node head){
        Node temp= head;
        
        while(temp!=null && temp.next!=null && temp.next.next!=null){
            if(temp.data==temp.next.data && temp.next.next.data==100){
                temp.data=100;
                temp.next.data= temp.next.data+(int)(Math.floor( 0.1* temp.next.data));
                  temp=temp.next.next.next;
            }
            else{
                temp=temp.next;
            }
            
          
        }
        
        Node t2= head;
        while(t2!=null&& t2.next!=null){
            if(t2.data==100){
                Node t= t2.next;
                while(t!=null &&t.data==100){
                    t=t.next;
                }
                if(t==null)
                    break;
                t2.data=t.data;
                t.data=100;
            }
            t2=t2.next;
        }
        Node tx=head;
        while(tx.next!=null){
            System.out.print(tx.data+ "-> ");
            tx=tx.next;
        }
        System.out.println(tx.data);
    }
    
    
	public static void main (String[] args) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		for(int y=0; y<t ; ++y){
		    int len= s.nextInt();
		    Node head= null;
		    Node tail=null;
		    for(int i=0; i< len ; ++i){
		        int x= s.nextInt();
		        Node tmp= new Node(x);
		        if(head==null){
                    head=tmp;
                    tail=head;
		        }
		        else{
		            tail.next=tmp;
		            tail=tail.next;
		        }
		    }
		    traverseChange(head);
		}
	}
}
