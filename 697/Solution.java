class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] freq = new int[50000];
        int[] start = new int[50000];
        int[] end = new int[50000];
        int cnt = 0;
        List<Integer> a = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]] += 1;
            if(freq[nums[i]] == 1)
                start[nums[i]] = i;
            end[nums[i]] = i;
            if(freq[nums[i]] > cnt){
                a = new ArrayList();
                a.add(nums[i]);
                cnt += 1;
            } else if(freq[nums[i]] == cnt){
                a.add(nums[i]);
            }
        }
        int minLen = 50000;
        for(int x: a){
            if(minLen > end[x] - start[x] + 1)
                minLen = end[x] - start[x] + 1;
        }
        return minLen;
    }
}