class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int cnt1 = 1;
        int cnt2 = 0;
        int ret = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) cnt1++;
            else if(nums[i] == nums[i - 1] + 1){
                if(cnt1 > 0 && cnt2 > 0)
                    ret = Math.max(cnt1 + cnt2, ret);
                cnt2 = cnt1;
                cnt1 = 1;
            } else {
                if(cnt1 > 0 && cnt2 > 0)
                    ret = Math.max(cnt1 + cnt2, ret);
                cnt2 = 0;
                cnt1 = 1;
            }
        }
        if(cnt1 > 0 && cnt2 > 0)
            return Math.max(cnt1 + cnt2, ret);
        return ret;
    }
}