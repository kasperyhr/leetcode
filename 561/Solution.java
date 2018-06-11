class Solution {
    public int arrayPairSum(int[] nums) {
        int[] nnums = mergeSort(nums);
        int ret = 0;
        for(int i = 0; i < nums.length; i += 2){
            ret += nnums[i];
        }
        return ret;
    }
    
    public static int[] mergeSort(int[] nums){
        if(nums.length < 2)
            return nums;
        int[] nums1 = new int[nums.length / 2];
        int[] nums2 = new int[nums.length - nums.length / 2];
        System.arraycopy(nums, 0, nums1, 0, nums1.length);
        System.arraycopy(nums, nums1.length, nums2, 0, nums2.length);
        nums1 = mergeSort(nums1);
        nums2 = mergeSort(nums2);
        return merge(nums1, nums2);
    }
    
    public static int[] merge(int[] arr1, int[] arr2){
        int i1 = 0;
        int i2 = 0;
        int[] ret = new int[arr1.length + arr2.length];
        for(int i = 0; i < ret.length; i++){
            if(i1 == arr1.length)
                ret[i] = arr2[i2++];
            else if(i2 == arr2.length)
                ret[i] = arr1[i1++];
            else if(arr1[i1] < arr2[i2])
                ret[i] = arr1[i1++];
            else
                ret[i] = arr2[i2++];
        }
        return ret;
    }
}