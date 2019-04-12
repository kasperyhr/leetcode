class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        char prev = '#';
        int idx = -1;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(c != prev){
                if(i - idx >= 3){
                    List<Integer> l = new ArrayList<>();
                    l.add(idx);
                    l.add(i - 1);
                    res.add(l);
                }
                prev = c;
                idx = i;
            }
        }
        int i = S.length();
        if(i - idx >= 3){
            List<Integer> l = new ArrayList<>();
            l.add(idx);
            l.add(i - 1);
            res.add(l);
        }

        return res;
    }
}