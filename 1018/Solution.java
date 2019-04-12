class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int val = 0;
        for(int i: A){
            val *= 2;
            val += i;
            val %= 5;
            if(val == 0) res.add(true);
            else res.add(false);
        }
        return res;
    }
}