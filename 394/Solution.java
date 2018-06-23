class Solution {
    public String decodeString(String s) {
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                int k = 0;
                while(c >= '0' && c <= '9'){
                    k *= 10;
                    k += c - '0';
                    c = s.charAt(++i);
                }
                int bk = 1;
                i += 1;
                String rec = "";
                while(bk > 0){
                    c = s.charAt(i);
                    if(c == '['){
                        bk += 1;
                        rec += c;
                    } else if(c == ']'){
                        bk -= 1;
                        if(bk > 0)
                            rec += c;
                        else
                            break;
                    } else {
                        rec += c;
                    }
                    i += 1;
                }
                String rep = decodeString(rec);
                for(int j = 0; j < k; j++){
                    ret += rep;
                }
            } else {
                ret += c;
            }
        }
        return ret;
    }
}