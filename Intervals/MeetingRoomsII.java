// Meeting Rooms II
// Solved
// Medium
// Topics
// conpanies icon
// Companies
// Hint
// Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

// Example 1:

// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: 2
// Example 2:

// Input: intervals = [[7,10],[2,4]]
// Output: 1
 
//Priority queue solution
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            if(!pq.isEmpty() && pq.peek() <= intervals[i][0]){
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}

//two pointer solution
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new  int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i =0;i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0, count =0;
        int s =0,e =0;

        while(s<intervals.length){
            if(start[s] < end[e]){
                s++;
                count=count + 1;
            } else {
                e++;
                count=count - 1;
            }
            res = Math.max(res,count);
        }
        return res;
       
    }
}