class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> sub = new HashSet<String>();
        Set<String> ret = new HashSet<String>();
        for(int i = 0; i < s.length() - 9; i++){
            String substr = s.substring(i, i + 10);
            if(sub.contains(substr)){
                ret.add(substr);
            } else {
                sub.add(substr);
            }
        }
        return new LinkedList(ret);
    }
}
