class Solution {
    public String toGoatLatin(String S) {
        String[] s = S.split(" ");
        return rule3(s).toString().trim();
    }
    
    private StringBuilder rule3(String[] s){
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            ret.append(rule12(s[i]));
            for(int j = 0; j <= i; j++){
                ret.append('a');
            }
            ret.append(' ');
        }
        return ret;
    }
    
    private String rule12(String s){
        char c = s.charAt(0);
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return s + "ma";
            default:
                return s.substring(1) + s.charAt(0) + "ma";
        }
    }
}