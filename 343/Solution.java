class Solution {
    public int integerBreak(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        if(n == 4)
            return 4;
        int x = n / 3;
        int y = n % 3;
        int ret = 1;
        if(y == 1){
            for(int i = 0; i < x - 1; i++){
                ret *= 3;
            }
            ret *= 4;
        } else {
            for(int i = 0; i < x; i++){
                ret *= 3;
            }
            ret *= (y == 0)?1:y;
        }
        return ret;
    }
}