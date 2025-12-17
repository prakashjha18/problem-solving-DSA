// Example 1:

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
// Example 2:

// Input: nums = [0,1,0,3,2,3]
// Output: 4
// Example 3:

// Input: nums = [7,7,7,7,7,7,7]
// Output: 1
 

// Constraints:

// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
 

// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?


import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(num > sub.get(sub.size() -1)){
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }   
        }
        
        return sub.size();
        
    }
    private int binarySearch(ArrayList<Integer> sub, int num){
        int left = 0;
        int right =sub.size()-1;

        while(left <  right){
            int mid = (left+right)/2;
            if(sub.get(mid) == num) return mid;

            if(sub.get(mid)>num ) {
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
}
