class TrieNode{
    char c;
    TrieNode[] children;
    String word;
    
    public TrieNode(char c){
        this.c = c;
        children = new TrieNode[26];
        word = null;
    }
    
    public TrieNode(){
        children = new TrieNode[26];
        word = null;
    }
    
    public static void insert(TrieNode p, String word){
        char[] chars = word.toCharArray();
        
        for(char c: chars){
            p = getChildTrieNode(p, c);
        }
        
        p.word = word;
    }
    
    public static TrieNode getChildTrieNode(TrieNode root, char c){
        int idx = (int) (c - 'a');
        if(root.children[idx] == null){
            root.children[idx] = new TrieNode(c);
        }
        
        return root.children[idx];
    }
}

class Solution {
    Map<String, List<String>> memo;
    TrieNode root;
    public Solution(){
        memo = new HashMap<>();
        root = new TrieNode();
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String word: wordDict){
            TrieNode.insert(root, word);
        }
        return dfs(s);
    }
    
    public List<String> dfs(String s){
        if(memo.containsKey(s))
            return memo.get(s);
        
        List<String> res = new ArrayList<String>();
        TrieNode cursor = root;
        
        int i;
        for(i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int idx = c - 'a';
            if(cursor.children[idx] == null)
                break;
            cursor = cursor.children[idx];
            if(cursor.word != null){
                String appendString = s.substring(0, i + 1);
                if(i == s.length() - 1){
                    res.add(appendString);
                    break;
                }
                
                List<String> ls = dfs(s.substring(i + 1));
                int j;
                
                appendString += " ";
                for(String str: ls){
                    res.add(appendString + str);
                }
            }
        }
        
        memo.put(s, res);
        return memo.get(s);
    }
}