class Trie {
    
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('-');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.put(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.start(word, true);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.start(prefix, false);
    }
    
    class Node{
        char c;
        Node[] ns;
        boolean word = false;
        Node(char c){
            this.c = c;
            ns = new Node[26];
        }
        
        void put(String s){
            if(s.length() == 0){
                word = true;
                return;
            }
            char ch = s.charAt(0);
            if(ns[ch - 'a'] == null)
                ns[ch - 'a'] = new Node(ch);
            ns[ch - 'a'].put(s.substring(1));
        }
        
        boolean start(String s, boolean word){
            if(s.length() == 0){
                if(word)
                    return this.word;
                return true;
            }
            char ch = s.charAt(0);
            if(ns[ch - 'a'] == null)
                return false;
            return ns[ch - 'a'].start(s.substring(1), word);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */