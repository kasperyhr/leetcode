class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        int low = 0;
        int high = height.length - 1;
        while(low < high){
            ret = Math.max(ret, Math.min(height[low], height[high]) * (high - low));
            if(height[low] < height[high])
                low += 1;
            else
                high -= 1;
        }
        return ret;
    }
}