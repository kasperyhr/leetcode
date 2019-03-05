class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> ret = new ArrayList<Integer>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else{
                ret.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] arr = new int[ret.size()];
        for(int k = 0; k < arr.length; k++){
            arr[k] = ret.get(k);
        }
        return arr;
    }
}