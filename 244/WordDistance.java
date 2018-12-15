class WordDistance {

    Map<String, List<Integer>> m;
    public WordDistance(String[] words) {
        m = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            List<Integer> l = m.getOrDefault(words[i], new LinkedList<Integer>());
            l.add(i);
            m.put(words[i], l);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = m.get(word1);
        List<Integer> l2 = m.get(word2);
        int p1 = l1.get(0);
        int p2 = l2.get(0);
        int i1 = 0;
        int i2 = 0;
        int ret = Math.abs(p1 - p2);
        while(i1 != l1.size() - 1 || i2 != l2.size() - 1){
            if(p1 < p2 && i1 != l1.size() - 1 || i2 == l2.size() - 1){
                i1++;
                p1=l1.get(i1);
            } else {
                i2++;
                p2=l2.get(i2);
            }
            ret = Math.min(ret, Math.abs(p1 - p2));
        }
        return ret;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */