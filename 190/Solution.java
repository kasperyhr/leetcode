public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for(int i = 0; i < 32; i++){
            ret |= ((n >> i) & 1) << (31 - i);
        }
        return ret;
    }
}