// Given two linked list of size N1 and N2 respectively of distinct elements, your task is to complete the function countPairs(), which returns the count of all pairs from both lists whose sum is equal to the given value X.

// Input:
// The function takes three arguments as input, reference pointer to the head of the two linked list (head1 and head2), and an variable X.
// There will be T test cases and for each test case the function will be called separately.
// Note : All elements in a linked list are unique.

// Output:
// For each test case the function should return the count of all the pairs from both lists whose sum is equal to the given value X. 

// Constraints:
// 1<=T<=100
// 1<=N1,N2<=10000
// 1<=X<=10000

// Example:
// Input:
// 2
// 6
// 1 2 3 4 5 6
// 3
// 11 12 13
// 15
// 4
// 7 5 1 3
// 4
// 3 5 2 8
// 10

// Output:
// 3
// 2
// { Driver Code Starts
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class count_pairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n1 = sc.nextInt();
            Integer arr1[] = new Integer[n1];

            for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();

            int n2 = sc.nextInt();
            Integer arr2[] = new Integer[n2];

            for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();

            LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
            LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));

            int x = sc.nextInt();
            GfG gfg = new GfG();
            System.out.println(gfg.countPairs(head1, head2, x));
        }
    }
}// } Driver Code Ends
// your task is to complete this function

/*
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
*/

class GfG {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
        // add your code here
        int count = 0; 
           
        HashSet<Integer> us = new HashSet<Integer>(); 
           
        // insert all the elements of 1st list 
        // in the hash table(unordered_set 'us') 
        Iterator<Integer> itr1 = head1.iterator(); 
        while (itr1.hasNext()) 
        { 
            us.add(itr1.next());     
             
        } 
          
        Iterator<Integer> itr2 = head2.iterator(); 
        // for each element of 2nd list 
        while (itr2.hasNext())     
        { 
            // find (x - head2->data) in 'us' 
            if (!(us.add(x - itr2.next()))) 
                count++; 
                 
        } 
          
        // required count of pairs      
        return count; 
        
    }
}
