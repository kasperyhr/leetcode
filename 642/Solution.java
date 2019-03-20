class TrieNode{
    char c;
    int cnt;
    Map<Character, TrieNode> children;
    String s;
    public TrieNode(){
        this((char)0);
    }
    
    public TrieNode(char c){
        this.c = c;
        cnt = 0;
        children = new HashMap();
        s = "";
    }
    
    public List<TrieNode> traverse(){
        List<TrieNode> ret = new ArrayList();
        if(cnt != 0){
            ret.add(this);
        }
        for(char c: children.keySet()){
            TrieNode n = children.get(c);
            ret.addAll(n.traverse());
        }
        return ret;
    }
}

class TrieTree{
    TrieNode root;
    
    public TrieTree(){
        root = new TrieNode();
    }
    
    public void insert(String s, int cnt){
        TrieNode cursor = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!cursor.children.containsKey(c)){
                cursor.children.put(c, new TrieNode(c));
            }
            TrieNode n = cursor.children.get(c);
            cursor = n;
        }
        cursor.cnt += cnt;
        cursor.s = s;
    }
    
    public List<String> search(String s){
        TrieNode cursor = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!cursor.children.containsKey(c)){
                return new ArrayList<String>();
            }
            TrieNode n = cursor.children.get(c);
            cursor = n;
        }
        List<TrieNode> nodes = cursor.traverse();
        Collections.sort(nodes, (a, b) -> {
            if(a.cnt == b.cnt){
                return a.s.compareTo(b.s);
            }
            return b.cnt - a.cnt;
        });
        List<String> ret = new ArrayList();
        for(int i = 0; i < Math.min(nodes.size(), 3); i++){
            ret.add(nodes.get(i).s);
        }
        return ret;
    }
}

class AutocompleteSystem {
    TrieTree tree;
    StringBuffer sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        tree = new TrieTree();
        sb = new StringBuffer();
        for(int i = 0; i < sentences.length; i++){
            tree.insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        if(c != '#'){
            sb.append(c);
            return tree.search(sb.toString());
        } else {
            tree.insert(sb.toString(), 1);
            sb = new StringBuffer();
            return new ArrayList<String>();
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */