class Solution {
    public String largestNumber(int[] nums) {
        Integer[] val = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) val[i] = nums[i];
        Arrays.sort(val, (a, b) -> (int)(Long.parseLong("" + b + a) - Long.parseLong("" + a + b)));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) if(sb.length() != 0 || val[i] != 0) sb.append(val[i]);
        if(sb.length() == 0) sb.append(0);
        return sb.toString();
    }
}