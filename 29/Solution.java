class Solution {
    public int divide(int dividend, int divisor) {
        int ret = 0;
        int flag = 1;
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) flag = -1;
        long end = Math.abs((long)dividend);
        long sor = Math.abs((long)divisor);
        while(end >= sor){
            long tmp = sor, n = 1;
            while(end >= (tmp << 1)){
                tmp <<= 1;
                n <<= 1;
            }
            ret += n;
            end -= tmp;
        }
        return ret * flag;
    }
}