class Solution {
    Set<Integer> s = new HashSet();
    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        if(s.contains(n))
            return false;
        s.add(n);
        int val = 0;
        while(n != 0){
            val += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(val);
    }
}