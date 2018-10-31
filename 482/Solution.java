class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String[] ss = S.toUpperCase().split("-");
        StringBuffer sb = new StringBuffer();
        for(String s: ss){
            sb.append(s);
        }
        
        for(int i = sb.length() - K; i > 0; i = i - K){
            sb.insert(i, '-');
        }
        
        return sb.toString();
    }
}