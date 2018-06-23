class Solution {
    public int triangleNumber(int[] nums) {
        int cnt = 0;
        if(nums.length < 3)
            return cnt;
        Arrays.sort(nums);
        int pt0 = 0;
        while(pt0 < nums.length && nums[pt0] == 0)
            pt0 += 1;
        int pt1 = pt0 + 1;
        int pt2 = pt0 + 2;
        for(; pt0 < nums.length; pt0++){
            pt1 = pt0 + 1;
            pt2 = pt0 + 2;
            while(pt1 < nums.length - 1){
                if(pt1 == pt2)
                    pt2 += 1;
                cnt += (pt2 - pt1) - 1;
                while(pt2 < nums.length && nums[pt0] + nums[pt1] > nums[pt2]){
                    pt2 += 1;
                    cnt += 1;
                }
                pt1 += 1;
            }
        }
        return cnt;
    }
}