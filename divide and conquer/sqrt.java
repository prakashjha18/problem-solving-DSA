class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) 
            return x; 
  
        // Do Binary Search for floor(sqrt(x)) 
        int start = 1, end = x, ans=0; 
        while (start <= end) 
        { 
            int mid = start + (end - start) / 2;
  
            // If x is a perfect square 
            if (mid*mid == x) 
                return mid; 
  
            if (mid <= x/mid) 
            { 
                start = mid + 1; 
                ans = mid; 
            } 
            else   // If mid*mid is greater than x 
                end = mid-1; 
        } 
        return ans; 
    }
}
