class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Preprocessing the data
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);    
        }
        if(!wordList.contains(endWord)){
            return new ArrayList<List<String>>();
        }
        // Then we need to figure out the edges between each word.
        Map<String, List<String>> edges = findEdges(wordList);
        /* First we need to define the distance 
        from the endWord for each word in the wordList
        and we need to have a hashmap to collect those data
        */
        Map<String, Integer> dist = bfs(endWord, wordList, edges);
        if(!dist.containsKey(beginWord)){
            return new ArrayList<List<String>>();
        }
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        dfs(beginWord, endWord, edges, dist, ret, curr);
        return ret;
    }
    
    private void p(Map<String, List<String>> m){
        for(String key: m.keySet()){
            System.out.print("key: " + key + " ");
            p(m.get(key));
        }
    }
    
    private void p(List<String> l){
        System.out.print("[");
        for(int i = 0; i < l.size(); i++){
            System.out.print(l.get(i));
            if(i != l.size() - 1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    
    private Map<String, List<String>> findEdges(List<String> wordList){
        Map<String, List<String>> ret = new HashMap<>();
        Map<String, List<String>> possibleEdges = new HashMap<>();
        
        //Initialize ret
        for(String word: wordList){
            ret.put(word, new ArrayList<String>());
        }
        
        for(String word: wordList){
            for(int i = 0; i < word.length(); i++){
                String modifiedString = word.substring(0, i) + "?" + word.substring(i + 1);
                possibleEdges.putIfAbsent(modifiedString, new ArrayList<>());
                possibleEdges.get(modifiedString).add(word);
            }
        }
        
        for(String key: possibleEdges.keySet()){
            List<String> pairs = possibleEdges.get(key);
            if(pairs.size() > 1){
                for(String s1: pairs){
                    for(String s2: pairs){
                        if(!s1.equals(s2)){
                            ret.get(s1).add(s2);
                        }
                    }
                }
            }
        }
        
        return ret;
    }
    
    private Map<String, Integer> bfs(String word, List<String> wordList, Map<String, List<String>> edges){
        Map<String, Integer> ret = new HashMap<>();
        
        Queue<String> q = new LinkedList<>();
        int level = 0;
        q.add(word);
        ret.put(word, level);
        
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                String s = q.poll();
                
                List<String> nextWords = edges.get(s);
                for(String nextWord: nextWords){
                    if(!ret.containsKey(nextWord)){
                        q.add(nextWord);
                        ret.put(nextWord, level);
                    }
                }
            }
        }
        
        return ret;
    }
    
    private void dfs(String beginWord, String endWord, Map<String, List<String>> edges, Map<String, Integer> dist, List<List<String>> res, List<String> curr){
        int level = dist.get(beginWord);
        
        if(level == 0){
            res.add(new ArrayList<String>(curr));
            return;
        }
        
        for(String nextWord: edges.get(curr.get(curr.size() - 1))){
            if(dist.get(nextWord) == level - 1){
                curr.add(nextWord);
                dfs(nextWord, endWord, edges, dist, res, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}