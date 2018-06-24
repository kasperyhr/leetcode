class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = Math.min(46340, x);
        int mid = (low + high) / 2;
        while(high > low){
            mid = (low + high) / 2;
            if(mid * mid > x)
                high = mid - 1;
            else if((mid + 1) * (mid + 1) <= x)
                low = mid + 1;
            else
                return mid;
        }
        return low;
    }
    
}