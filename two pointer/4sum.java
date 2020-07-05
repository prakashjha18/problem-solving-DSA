/*Given an array nums of n integers and an integer target, are there elements a, b, c, 
and d in nums such that a + b + c + d = target? Find all unique quadruplets in the 
array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        int size = nums.length;
        for(int i=0;i<size-3;i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break;
            if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target)continue;
            if(i>0&&nums[i]==nums[i-1])continue; 
            for(int j=i+1;j<size-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)break;
                if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target)continue;
                if(j>i+1&&nums[j]==nums[j-1])continue; 
                int left = j+1;
                int right=size-1;
                while(left<right){
                    int sum = nums[i] +nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left] == nums[left+1]) left++;
                        while(left<right && nums[right] == nums[right-1]) right--;      
                        left++;
                        right--;
                    }
                    else if(sum<target) left++;
                    
                    else right--;
                    
                }
                while(j+1<size-2 && nums[j+1] ==nums[j]) ++j;
            }
            while(i+1<size-3 && nums[i+1] ==nums[i]) ++i;
        }
        return res;
    }
}
