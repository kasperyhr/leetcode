class Solution {
    public int countDigitOne(int n) {
        int ret = 0;
        long val = 10;
        while(n >= (int)(val / 10)){
            ret += (int)((n / val) * (val / 10) + Math.min(Math.max(n % val - val / 10 + 1, 0), val / 10));
            // System.out.println((n / val) + " " + (val / 10) + " " + (n % val) + " " + (val / 10));
            val *= 10;
        }
        return ret;
    }
}