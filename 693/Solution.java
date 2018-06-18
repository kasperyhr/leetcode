class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n == 0)
            return true;
        int msk = n & 3;
        if(msk == 0 || msk == 3)
            return false;
        for(int i = 0; i < 32; i += 2){
            if((n >> i) > 0){
                if( ((n >> i) & 3) != msk)
                    return false;
            } else {
                return true;
            }
        }
        return true;
    }
}