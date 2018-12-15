class Solution {
    Map<Integer, Long> m;
    private static final int MOD = 1000000007;
    public int threeSumMulti(int[] A, int target) {
        m = new HashMap<Integer, Long>();
        for(int i = 0; i < A.length; i++){
            m.put(A[i], (long) (m.getOrDefault(A[i], 0L) + 1L));
        }
        int ret = threeSum(A, target);
        return ret;
    }
    
    private int threeSum(int[] nums, int target) {
        int ret = 0;
        if(nums.length < 3)
            return ret;
        Arrays.sort(nums);
        if(nums[0] + nums[1] + nums[2] > target)
            return ret;
        if(nums.length >= 3 && nums[0] + nums[1] + nums[2] == target){
            ret += cnt(nums[0], nums[1], nums[2]) % MOD;
            return ret;
        }
        for(int i = 0; i < nums.length; i++){
            int pt1 = i + 1;
            int pt2 = nums.length - 1;
            while(pt1 < pt2 && pt2 > i && pt1 < nums.length){
                if(nums[pt1] + nums[pt2] + nums[i] < target)
                    pt1 += 1;
                else if(nums[pt1] + nums[pt2] + nums[i] > target)
                    pt2 -= 1;
                else{
                    ret += cnt(nums[pt1], nums[pt2], nums[i]);
                    ret %= MOD;
                    // System.out.println(nums[pt1] + " " + nums[pt2] + " " + nums[i] + " " + ret);
                    int pt3 = pt1 + 1;
                    while(pt3 < nums.length && nums[pt3] == nums[pt1])
                        pt3 += 1;
                    int pt4 = pt2 - 1;
                    while(pt4 > i && nums[pt4] == nums[pt2])
                        pt4 -= 1;
                    pt1 = pt3;
                    pt2 = pt4;
                }       
            }
            int j = i + 1;
            while(j < nums.length && nums[i] == nums[j])
                j += 1;
            i = j - 1;
        }
        return ret;
    }
    
    private int cnt(int a, int b, int c){
        long ret = 0;
        if(a == b && b == c){
            ret = m.get(a) * (m.get(a) - 1) * (m.get(a) - 2) / 6;
        } else if(a == b){
            ret = m.get(a) * (m.get(a) - 1) * m.get(c) / 2; 
        } else if(a == c){
            ret = m.get(a) * (m.get(a) - 1) * m.get(b) / 2;
        } else if(b == c){
            ret = m.get(a) * m.get(b) * (m.get(b) - 1) / 2;
        } else {
            ret = m.get(a) * m.get(b) * m.get(c);
        }
        return (int) (ret % MOD);
    }
}