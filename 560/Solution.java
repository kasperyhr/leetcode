class Solution {
    public int subarraySum(int[] nums, int k) {
        int N = nums.length;
        int[] prefixSum = new int[N + 1];
        int cnt = 0;
        
        for(int i = 0; i < N; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        for(int i = 0; i <= N; i++){
            for(int j = i + 1; j <= N; j++){
                if(prefixSum[j] - prefixSum[i] == k)
                    cnt++;
            }
        }
        
        return cnt;
    }
}