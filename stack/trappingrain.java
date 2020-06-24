//https://leetcode.com/problems/trapping-rain-water/
class Solution {
    // public int trap(int[] height) {
    //     int left = 0, right = height.length- 1;
    // int ans = 0;
    // int left_max = 0, right_max = 0;
    // while (left < right) {
    //     if (height[left] < height[right]) {
    //         if(height[left] >= left_max){
    //             left_max = height[left];
    //         } else {
    //             ans += (left_max - height[left]);
    //         }
    //         ++left;
    //     }
    //     else {
    //         if(height[right] >= right_max){
    //             right_max = height[right];
    //         } else {
    //             ans += (right_max - height[right]);
    //         }
    //         --right;
    //     }
    // }
    // return ans;
    // }
    public int trap(int[] height) {
        int ans=0;
        int current = 0;
        Stack<Integer> st = new Stack<>();
        while(current<height.length){
            while(!st.isEmpty() && height[current]>height[st.peek()]){
                int top = st.pop();
                if(st.isEmpty()) break;
                int distance = current - st.peek() -1;
                int b_h = Math.min(height[current],height[st.peek()]) - height[top];
                ans +=(distance*b_h);
            }
            st.push(current++);
        }
        return ans;
    }
}
