// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 
// class Solution {
//      Boolean[] dp;
//     public boolean canJumpFromPosition(int position, int[] nums) {
//         if(position == nums.length -1){
//             return true;
//         }
//         if (dp[position] != null) {
//             return dp[position];
//         }
//         int farthestJump = Math.min(nums[position] + position, nums.length -1);
//         for(int nextPosition = position +1; nextPosition <= farthestJump; nextPosition++){
//             if(canJumpFromPosition(nextPosition, nums)){
//                 dp[nextPosition] = true;
//                 return true;
//             }
//         }

//         dp[position] = false;
//         return false;
//     }
//     public boolean canJump(int[] nums) {
//        dp = new Boolean[nums.length];
//        return canJumpFromPosition(0, nums);
//     }
// }

class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for(int position = n-2;position>=0;position--){
            int farthestJump = Math.min(n-1, position + nums[position]);
            for(int nextPosition=position +1;nextPosition<=farthestJump; nextPosition++){
                if(dp[nextPosition]){
                    dp[position] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}