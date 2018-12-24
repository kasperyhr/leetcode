class Solution {
    public boolean judgeSquareSum(int c) {
        if(c < 0)
            return false;
        if(c == 0)
            return true;
        if(c % 4 == 3)
            return false;
        if(c % 4 == 0)
            return judgeSquareSum(c / 4);
        for(long i = 0; i * i < c; i++){
            double v = Math.sqrt(c - i * i);
            if(v == (int) v)
                return true;
        }
        return false;
    }
}