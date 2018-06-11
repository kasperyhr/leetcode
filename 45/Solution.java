class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        int[] retArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            retArray[i] = Integer.MAX_VALUE;
        retArray[0] = 0;
        int index = 1;
        for(int i = 0; i < nums.length && retArray[nums.length - 1] == Integer.MAX_VALUE; i++){
            for(int j = index; j <= i + nums[i] && j < nums.length; j++){
                if(retArray[j] > retArray[i] + 1){
                    retArray[j] = retArray[i] + 1;
                    index += 1;
                }
            }
        }
        return retArray[nums.length - 1];
    }
}