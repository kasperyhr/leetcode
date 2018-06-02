class Solution {
    public int reverse(int x) {
        boolean neg = x < 0;
        x = Math.abs(x);
        if(x < 0)
            return 0;
        String y = reverse(Integer.toString(x));
        long z = Long.parseLong(y);
        if(z > Integer.MAX_VALUE)
            return 0;
        x = Integer.parseInt(y);
        if(neg)
            x = -x;
        return x;
    }
    
    public static String reverse(String s){
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            ret = s.charAt(i) + ret;
        }
        return ret;
    }
}