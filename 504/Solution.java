class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        String ret = "";
        boolean flag = false;
        if(num < 0){
            num = -num;
            flag = true;
        }
        while(num != 0){
            ret = (num % 7) + ret;
            num /= 7;
        }
        if(flag){
            ret = "-" + ret;
        }
        return ret;
    }
}