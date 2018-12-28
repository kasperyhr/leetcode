class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int ret = 0;
        while(target > 0)
            target -= ++ret;
        return target % 2 == 0 ? ret : ret + 1 + ret % 2;
    }
}