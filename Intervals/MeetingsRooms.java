// . Meeting Rooms
// Solved
// Easy
// Topics
// conpanies icon
// Companies
// Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

// Example 1:

// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: false
// Example 2:

// Input: intervals = [[7,10],[2,4]]
// Output: true
 

class Solution {
    // public boolean canAttendMeetings(int[][] intervals) {
    //     if(intervals.length ==0){
    //         return true;
    //     }
    //     Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));
    //     int prev = intervals[0][1];
    //     for(int i =1;i<intervals.length; i++){
    //         if(intervals[i][0]< prev){
    //             return false;
    //         } else{
    //             prev = intervals[i][1];
    //         }
    //     }
    //     return true;
    // }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]){
                return false;
            }
        }
        return true;
    }
}