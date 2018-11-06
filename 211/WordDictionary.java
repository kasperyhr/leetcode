class WordDictionary {

    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node('-');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.put(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return root.start(word, true);
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
            if(ch == '.'){
                for(int i = 0; i < 26; i++){
                    if(ns[i] != null && ns[i].start(s.substring(1), word))
                        return true;
                }
                return false;
            } else {
                if(ns[ch - 'a'] == null)
                    return false;
                return ns[ch - 'a'].start(s.substring(1), word);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */