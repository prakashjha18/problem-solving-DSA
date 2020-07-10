class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int target =0;
//         List<List<Integer>> res = new ArrayList<>();
//         if(nums == null || nums.length<3){
//             return res;
//         }
//         Arrays.sort(nums);
//         int size = nums.length;
//         for(int i=0;i<size-2;i++){
//             if((nums[i]+nums[i+1]+nums[i+2] )>target) break;
//             int left = i+1;
//             int right=size-1;
//             if(i>0&&nums[i]==nums[i-1])continue;
//             while(left<right){
//                 int sum = nums[i] +nums[left]+nums[right];
//                 if(sum==target){
//                     res.add(Arrays.asList(nums[i],nums[left],nums[right]));
//                     while(left<right && nums[left] == nums[left+1]) left++;
//                     while(left<right && nums[right] == nums[right-1]) right--;      
//                     left++;
//                     right--;
//                 }
//                 else if(sum<target) left++;

//                 else right--;

//             }
//         }
//         return res;
//     }
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }
}
        
    
