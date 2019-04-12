class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int a: A){
            sum += a;
        }
        if(sum % 3 != 0) return false;
        sum /= 3;
        boolean flag1 = false;
        boolean flag2 = false;
        int val = 0;
        for(int a: A){
            val += a;
            if(val == sum)
                flag1 = true;
            else if(val == 2 * sum && flag1)
                return true;
        }
        return false;
    }
}