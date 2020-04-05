// { Driver Code Starts
import java.util.*;
import java.lang.*;
class MaxRect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[1000][1000];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();
            GfG g = new GfG();

            System.out.println(g.maxArea(a, m, n));
        }
    }
}
// } Driver Code Ends
/*Complete the function given below*/
class GfG {
    public int maxHistogram(int input[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
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
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
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
                area = input[top] * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    public int maxArea(int input[][], int m, int n) {
        // add code here.
        int temp[] = new int[input[0].length];
        //MaximumHistogram mh = new MaximumHistogram();
        int maxArea = 0;
        int area = 0;
        for(int i=0; i < input.length; i++){
            for(int j=0; j < temp.length; j++){
                if(input[i][j] == 0){
                    temp[j] = 0;
                }else{
                    temp[j] += input[i][j];
                }
            }
            area = maxHistogram(temp);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
