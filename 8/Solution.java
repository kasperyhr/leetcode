class Solution {
    public int myAtoi(String str) {
        long num = 0;
        boolean neg = false;
        boolean start = false;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == ' ' && !start)
                continue;
            else if(c == '+' && !start){
                start = true;
                continue;
            } else if(c == '-' && !start){
                start = true;
                neg = true;
                continue;
            } else if(c >= '0' && c <= '9'){
                start = true;
                num *= 10;
                num += c - '0';
            } else {
                if(neg)
                    return (int) (0 - num);
                return (int)num;
            }
            
            if (num > Integer.MAX_VALUE && !neg)
                return Integer.MAX_VALUE;
            if (neg){
                num = - num;
                if(num < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                num = - num;
            }
        }
        if(neg)
            return (int) (0 - num);
        return (int) num;
    }
}