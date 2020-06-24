//https://leetcode.com/problems/largest-rectangle-in-histogram/
//Input: [2,1,5,6,2,3]
//Output: 10
class Solution {
    public int largestRectangleArea(int[] input) {
        Stack<Integer> stack = new Stack<>(); 
        int maxArea = 0;
        int area = 0;
        int i=0;
        while(i< input.length){
            if(stack.isEmpty() || input[stack.peek()] <= input[i]){
                stack.push(i++);
            }else{
                int top = stack.pop();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peek() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peek() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
