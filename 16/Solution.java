class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ret = Integer.MAX_VALUE;
        if(nums.length < 3)
            return 0;
        Arrays.sort(nums);
        if(nums[0] + nums[1] + nums[2] > target)
            return nums[0] + nums[1] + nums[2];
        if(nums.length >= 3 && nums[0] + nums[1] + nums[2] == target){
            return target;
        }
        for(int i = 0; i < nums.length; i++){
            int pt1 = i + 1;
            int pt2 = nums.length - 1;
            while(pt1 < pt2 && pt2 > i && pt1 < nums.length){
                if(nums[pt1] + nums[pt2] + nums[i] < target){
                    ret = Math.min(Math.abs(ret), Math.abs((nums[pt1] + nums[pt2] + nums[i]) - target)) == Math.abs(ret) ? ret : (nums[pt1] + nums[pt2] + nums[i]) - target;
                    pt1 += 1;
                } else if(nums[pt1] + nums[pt2] + nums[i] > target){
                    ret = Math.min(Math.abs(ret), Math.abs((nums[pt1] + nums[pt2] + nums[i]) - target)) == Math.abs(ret) ? ret : (nums[pt1] + nums[pt2] + nums[i]) - target;
                    pt2 -= 1;
                } else {
                    return target;
                }       
            }
            int j = i + 1;
            while(j < nums.length && nums[i] == nums[j])
                j += 1;
            i = j - 1;
        }
        return ret + target;        
    }
}