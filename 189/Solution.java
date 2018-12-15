class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0)
            return;
        int cnt = 0;
        int index = 0;
        int num = nums[0];
        int g = gcd(nums.length, k);
        System.out.println(g);
        int h = g;
        while(h > 0){
            index = h;
            num = nums[index];
            cnt = 0;
            while(cnt < nums.length / g){
                index += k;
                index %= nums.length;
                num = num + nums[index];
                nums[index] = num - nums[index];
                num = num - nums[index];
                cnt += 1;
            }
            h--;
        }
        
    }
    private int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }
}