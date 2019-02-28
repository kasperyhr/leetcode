class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<String>();
        if(nums.length == 0){
            if(lower < upper)
                ret.add("" + lower + "->" + upper);
            else
                ret.add("" + lower);
            return ret;
        }
        int prev = nums[0];
        if(nums[0] > lower){
            if(nums[0] == lower + 1){
                ret.add("" + lower);
            } else {
                ret.add("" + lower + "->" + (nums[0] - 1));
            }
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == prev + 2){
                // System.out.println("" + (prev + 1));
                ret.add("" + (prev + 1));
            } else if(nums[i] - 2 > prev && nums[i] > prev + 2){
                // System.out.println("i: " + i + " " + (prev + 1) + "->" + (nums[i] - 1));
                ret.add("" + (prev + 1) + "->" + (nums[i] - 1));
            }
            prev = nums[i];
        }
        if(prev < upper){
            if(prev == upper - 1){
                // System.out.println("" + upper);
                ret.add("" + upper); 
            } else {
                // System.out.println("" + (prev + 1) + "->" + upper);
                ret.add("" + (prev + 1) + "->" + upper);
            }
        }
        return ret;
    }
}