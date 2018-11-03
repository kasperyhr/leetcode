class Solution {
    public int trap(int[] height) {
        int lowIdx = 0;
        int highIdx = height.length - 1;
        int maxLow = 0;
        int maxHigh = 0;
        int ret = 0;
        while(lowIdx < highIdx){
            if(height[lowIdx] < height[highIdx]){
                if(height[lowIdx] > maxLow)
                    maxLow = height[lowIdx];
                else
                    ret += maxLow - height[lowIdx];
                lowIdx++;
            } else {
                if(height[highIdx] > maxHigh)
                    maxHigh = height[highIdx];
                else
                    ret += maxHigh - height[highIdx];
                highIdx--;
            }
        }
        return ret;
    }
}