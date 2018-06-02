class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        // if length is 3, we need index 1 which is 3/2
        double ret = 0;
        if(merged.length % 2 != 0)
            ret = merged[merged.length / 2];
        // if length is 4, we need index 1 and 2 which is length/2 - 1 and length/2
        else
            ret = (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2.0;
        return ret;
    }
    
    public int[] merge(int[] nums1, int[] nums2){
        int[] ret = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < ret.length; i++){
            if(index1 == nums1.length)
                ret[i] = nums2[index2++];
            else if(index2 == nums2.length)
                ret[i] = nums1[index1++];
            else if(nums1[index1] < nums2[index2])
                ret[i] = nums1[index1++];
            else
                ret[i] = nums2[index2++];
        }
        return ret;
    }
}