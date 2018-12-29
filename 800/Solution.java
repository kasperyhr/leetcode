class Solution {
    public String similarRGB(String color) {
        String ret = "#";
        ret += sim(color.substring(1,3)) + sim(color.substring(3,5)) + sim(color.substring(5));
        return ret;
    }
    
    private String sim(String s){
        int comp = Integer.MAX_VALUE;
        String ret = "";
        if(s.charAt(0) != '0'){
            char c = '9';
            if(s.charAt(0) != 'a'){
                c = (char)(s.charAt(0) - 1);
            }
            String ss = "" + c + c;
            int ss1 = dis(ss, s);
            if(ss1 < comp){
                comp = ss1;
                ret = ss;
            }
        }
        if(s.charAt(0) != 'f'){
            char c = 'a';
            if(s.charAt(0) != '9'){
                c = (char)(s.charAt(0) + 1);
            }
            String ss = "" + c + c;
            int ss1 = dis(ss, s);
            if(ss1 < comp){
                comp = ss1;
                ret = ss;
            }
        }
        char c = s.charAt(0);
        String ss = "" + c + c;
        int ss1 = dis(ss, s);
        if(ss1 < comp){
            comp = ss1;
            ret = ss;
        }
        return ret;
    }
    
    private int dis(String s1, String s2){
        int ret = 0;
        if(s1.compareTo(s2) > 0){
            if(s1.charAt(0) > s2.charAt(0))
                ret += 16;
            char c1 = s1.charAt(1);
            char c2 = s2.charAt(1);
            if(c1 >= 'a'){
                c1 = (char)(c1 - 'a' + '9' + 1);
            }
            if(c2 >= 'a'){
                c2 = (char)(c2 - 'a' + '9' + 1);
            }
            ret += c1 - c2;
        } else if(s1.compareTo(s2) < 0){
            if(s1.charAt(0) < s2.charAt(0))
                ret += 16;
            char c1 = s1.charAt(1);
            char c2 = s2.charAt(1);
            if(c1 >= 'a'){
                c1 = (char)(c1 - 'a' + '9' + 1);
            }
            if(c2 >= 'a'){
                c2 = (char)(c2 - 'a' + '9' + 1);
            }
            ret += c2 - c1;
        }
        return ret;
    }
}