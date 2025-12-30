// Remove Nth Node From End of List
// Solved
// Medium
// Topics
// conpanies icon
// Companies
// Hint
// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode currentNode = head;
        while(currentNode!=null){
            currentNode = currentNode.next;
            length++;
        }

        if(length == n){
            return head.next;
        }
        int nodeBeforeRemovedIndex =length - n  -1;
        currentNode = head;
        for(int i = 0;i<nodeBeforeRemovedIndex; i++){
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return head;
        

    }
}

// approach 2
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;
        ListNode nodeBeforeHeadRemoval = head;
        
        for(int i=0; i<n ;i++){
            currentNode = currentNode.next;
        }
        if(currentNode == null){
            return head.next;
        }
        while(currentNode.next != null){
            currentNode = currentNode.next;
            nodeBeforeHeadRemoval = nodeBeforeHeadRemoval.next;
        }
        
        nodeBeforeHeadRemoval.next = nodeBeforeHeadRemoval.next.next;
        return head;

    }
}