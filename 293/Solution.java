class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new ArrayList<String>();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i - 1) == '+'){
                String str = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                ret.add(str);
            }
        }
        return ret;
    }
}