class Solution {
    public int arrangeCoins(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        long v = (long) (Math.floor(Math.sqrt(n)));
        while(v * (v + 1) <= 2 * (long)n)
            v++;
        v--;
        return (int)v;
    }
}