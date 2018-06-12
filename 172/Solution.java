class Solution {
    public int trailingZeroes(int n) {
        int level = 1;
        while(Math.pow(5, level) <= n){
            level += 1;
        }
        level -= 1;
        int[] arr = new int[level];
        while(level > 0){
            int div = n / ((int)Math.pow(5, level));
            int mod = n % ((int)Math.pow(5, level));
            for(int i = 0; i < level; i++){
                arr[i] += div;
            }
            level -= 1;
            n = mod;
        }
        int ret = 0;
        level = 1;
        for(int i = 0; i < arr.length; i++){
            ret += ((int)Math.pow(5, level - 1)) * arr[i];
            level += 1;
        }
        return ret;
    }
}