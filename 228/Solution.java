class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if(nums.length == 0)
            return ret;
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= end + 1){
                end = nums[i];
            } else {
                if(start == end){
                    ret.add("" + start);
                } else {
                    ret.add("" + start + "->" + end);
                }
                start = end = nums[i];
            }
        }
        if(start == end){
            ret.add("" + start);
        } else {
            ret.add("" + start + "->" + end);
        }
        return ret;
    }
}