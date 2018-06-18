class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0)
            return 0;
        int ret = 0;
        int k = 1;
        while(n >= k && k > 0){
            k <<= 1;
        }
        k >>>= 1;
        while(k > 0){
            if((m & k) == (n & k))
                ret |= (m & k);
            else
                return ret;
            k >>>= 1;
        }
        return ret;
    }
}