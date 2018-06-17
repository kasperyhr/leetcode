class Solution {
    public int integerReplacement(int n) {
        int ret = 0;
        while(n != 1 && n != -1){
            n = ((n & 1) == 0) ? n >> 1 : n == 3 ? n - 1 : ((((n + 1) ^ (n - 1)) & (n - 1)) == 0) ? n - 1 : n + 1;
            ret += 1;
        }
        return ret;
    }
}