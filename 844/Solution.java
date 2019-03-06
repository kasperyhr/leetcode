class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '#'){
                if(sb1.length() > 0) sb1.deleteCharAt(sb1.length() - 1);
            } else sb1.append(S.charAt(i));
        }
        for(int j = 0; j < T.length(); j++){
            if(T.charAt(j) == '#'){
                if(sb2.length() > 0) sb2.deleteCharAt(sb2.length() - 1);
            } else sb2.append(T.charAt(j));
        }
        return sb1.toString().equals(sb2.toString());
    }
}