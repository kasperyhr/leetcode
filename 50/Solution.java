class Solution {
    public double myPow(double x, int n) {
        if(x == 1.0)
            return x;
        if(x == -1.0)
            return ((n & 1) == 0) ? 1.0 : -1.0;
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        if(n < 0 && x < 1)
            return 0.0;
        if(n == 1) return x;
        if(n == 0) return 1;
        return ((n & 1) == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}