class Solution {
    public int[] singleNumber(int[] nums) {
        int xor1 = 0;
        for(int i = 0; i < nums.length; i++) xor1 ^= nums[i];
        int bit = 0;
        while((xor1 & (1 << bit)) == 0) bit++;
        bit = (1 << bit);
        int[] ret = new int[2];
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & bit) == 0)
                ret[0] ^= nums[i];
            else
                ret[1] ^= nums[i];
        }
        return ret;
    }
}