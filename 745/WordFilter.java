class WordFilter {
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        TrieNode.insert(root, "#", 0);
        for(int w = 0; w < words.length; w++){
            String word = words[w];
            for(int i = 0; i <= word.length(); i++){
                String s = word.substring(i) + "#" + word;
                TrieNode.insert(root, s, w);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String s = suffix + "#" + prefix;
        return TrieNode.f(root, s);
    }
}

class TrieNode{
    TrieNode[] children;
    int w;
    TrieNode(){
        children = new TrieNode[27]; 
        w = 0;
    }
    
    static int f(TrieNode p, String s){
        for(char c: s.toCharArray()){
            int idx = getIdx(c);
            if(p.children[idx] == null){
                return -1;
            }
            p = p.children[idx];
        }
        return p.w;
    }
    
    static void insert(TrieNode p, String s, int w){
        for(char c: s.toCharArray()){
            int idx = getIdx(c);
            if(p.children[idx] == null){
                p.children[idx] = new TrieNode();
            }
            p = p.children[idx];
            p.w = w;
        }
    }
    
    static int getIdx(char c){
        if(c == '#')
            return 26;
        return c - 'a';
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */