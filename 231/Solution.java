class Solution {
    public boolean isPowerOfTwo(int n) {
        int chk = 0;
        if(n < 0)
            return false;
        for(int i = 0; i < 32; i++){
            chk += (n >> i) & 1;
        }
        return chk == 1 ? true : false;
    }
}