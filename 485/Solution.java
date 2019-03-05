class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int curr = 0;
        for(int num: nums){
            if(num == 1) curr++;
            else{
                cnt = Math.max(cnt, curr);
                curr = 0;
            }
        }
        return Math.max(curr, cnt);
    }
}