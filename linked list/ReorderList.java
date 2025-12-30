//Given a singly linked list: A0→A1→…→An-1→An, reorder it to: A0→An→A1→An-1→A2→An-2→…
//For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

// Reorder List
// Solved
// Medium
// Topics
// conpanies icon
// Companies
// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// Example 2:


// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
 
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
         if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast =head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = slow;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr = next;
        }

        //now merge
        ListNode first = head;
        ListNode second = prev;
        while(second.next != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            first = temp1;
            second.next = first;
            second = temp2;
        }
    }
}