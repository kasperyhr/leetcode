class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9)
                digits[i] = 0;
            else{
                digits[i] += 1;
                return digits;
            }
        }
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        return ret;
    }
}