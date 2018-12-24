class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0)
            return false;
        double v = Math.sqrt(num);
        if(v == (int) v)
            return true;
        return false;
    }
}