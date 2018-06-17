class Solution {
    public String intToRoman(int num) {
        String s = "";
        String[] rm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums= {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for(int i = 0; i < nums.length; i++){
            while(num / nums[i] > 0){
                s += rm[i];
                num -= nums[i];
            }
        }
        return s;
        
    }
}