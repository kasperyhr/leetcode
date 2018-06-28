class Solution {
    public boolean isPalindrome(int x) {
        return x >= 0 && x == reverse(x);
    }
    
    private int reverse(int x){
        int ret = 0;
        while(x != 0){
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }
}