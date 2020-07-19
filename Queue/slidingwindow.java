// Given an array nums, there is a sliding window of size k which is moving from the very left of the
// array to the very right. You can only see the k numbers in the window. Each time the sliding window
// moves right by one position. Return the max sliding window.

// Follow up:
// Could you solve it in linear time?

// Example:

// Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
// Output: [3,3,5,5,6,7] 
// Explanation: 

// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7



class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n=arr.length;
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
        arrl.add(arr[qi.peek()]);
        int ar[] = new int[arrl.size()];
        for(int j=0;j<arrl.size();j++){
            ar[j] =arrl.get(j);
        }
        return ar;
    }
}
