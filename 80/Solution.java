class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr = 1;
        int cnt = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i])
                cnt += 1;
            else
                cnt = 1;
            nums[ptr] = nums[i];
            // System.out.println("i: " + i + " cnt: " + cnt);
            while(cnt >= 2){
                i++;
                if(i == nums.length)
                    break;
                else if(nums[i - 1] != nums[i]){
                    cnt = 1;
                    i -= 1;
                } else
                    cnt += 1;
            }
            ptr += 1;
        }
        return ptr;
    }
}