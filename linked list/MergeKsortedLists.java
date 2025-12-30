// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

 

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []
 
//using subsitute array
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        List<Integer> arrList = new ArrayList<>();
        int i = 0;
        for(int j=0;j<lists.length;j++){
            ListNode temp = lists[j];
            while(temp!=null){
                arrList.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(arrList);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int j = 0;j<arrList.size();j++){
            curr.next = new ListNode(arrList.get(j));
            curr = curr.next;
        }
        return dummy.next;
    }
}

//approach 2
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
            System.out.println(i + "_" + j);
            // (i, j) forms a pair 
            while (i < j) { 
                // merge List i with List j and store 
                // merged list in List i 
                arr[i] = SortedMerge(arr[i], arr[j]); 
  
                // consider next pair 
                i++; 
                j--; 
                System.out.println("NEW"+ i + " " + j);
  
                // If all pairs are merged, update last 
                if (i >= j) 
                    last = j; 
            } 
        } 
  
        return arr[0]; 
    }
}