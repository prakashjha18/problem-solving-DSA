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
     ListNode SortedMerge(ListNode headA, ListNode headB) {
        if(headA == null) return headB; 
        if(headB == null) return headA; 
          
        if(headA.val < headB.val)  
        { 
            headA.next = SortedMerge(headA.next, headB); 
            return headA; 
        } 
        else 
        { 
            headB.next = SortedMerge(headA, headB.next); 
            return headB; 
        } 
     }
    public ListNode mergeKLists(ListNode[] arr) {
        if(arr.length==0) return null;
        int last = arr.length-1;
        while (last != 0) { 
            int i = 0, j = last; 
            
            while (i < j) { 
                arr[i] = SortedMerge(arr[i], arr[j]); 
                System.out.print(i+"   "+j+"__");
                // consider next pair 
                i++; 
                j--; 
  
                if (i >= j) 
                    last = j; 
            } 
            System.out.print("break");
        } 
        return arr[0]; 
    }
}
