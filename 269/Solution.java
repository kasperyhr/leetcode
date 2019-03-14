class Solution {
    Map<Integer, Set<Character>> indegree; 
    Map<Character, Set<Character>> inEdges;
    Map<Character, Set<Character>> outEdges;
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        
        // Initial Graph
        indegree = new HashMap();
        inEdges = new HashMap();
        outEdges = new HashMap();
        
        init(words);
        
        StringBuffer sb = topologicalSort();
        if(sb.length() == outEdges.keySet().size())
            return sb.toString();
        return "";
    }
    
    private StringBuffer topologicalSort(){
        StringBuffer sb = new StringBuffer();
        while(!indegree.get(0).isEmpty()){
            char c = indegree.get(0).iterator().next();
            indegree.get(0).remove(c);
            for(char d: outEdges.get(c)){
                int sz = inEdges.get(d).size();
                inEdges.get(d).remove(c);
                indegree.get(sz).remove(d);
                indegree.get(sz - 1).add(d);
            }
            sb.append(c);
        }
        return sb;
    }
    
    private void init(String[] words){
        indegree.put(0, new HashSet());
        for(String word: words){
            for(char c: word.toCharArray()){
                if(!inEdges.containsKey(c)){
                    inEdges.put(c, new HashSet());
                    outEdges.put(c, new HashSet());
                    indegree.get(0).add(c);
                }
            }
        }
        
        int i, j;
        char c1, c2;
        for(i = 1; i < words.length; i++){
            String s1 = words[i - 1];
            String s2 = words[i];
            for(j = 0; j < Math.min(s1.length(), s2.length()); j++){
                c1 = s1.charAt(j);
                c2 = s2.charAt(j);
                if(c1 != c2){
                    int sz = inEdges.get(c2).size();
                    inEdges.get(c2).add(c1);
                    outEdges.get(c1).add(c2);
                    indegree.get(sz).remove(c2);
                    
                    Set<Character> s = indegree.getOrDefault(sz + 1, new HashSet());
                    s.add(c2);
                    indegree.put(sz + 1, s);
                    break;
                }
            }
        }
    }
}