class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        int len = 0;
        Stack<String> s = new Stack<String>();
        String ret = "";
        s.push("");
        for(String word: words){
            if(word.length() > s.peek().length() + 1)
                continue;
            if(word.length() == s.peek().length() + 1){
                if(word.equals(s.peek() + word.charAt(word.length() - 1))){
                    s.push(word);
                    if(word.length() > len){
                        len = word.length();
                        ret = word;
                    }
                }
                continue;
            }
            while(word.length() <= s.peek().length()) s.pop();
            if(word.equals(s.peek() + word.charAt(word.length() - 1))){
                s.push(word);
                if(word.length() > len){
                    len = word.length();
                    ret = word;
                }
            }
        }
        return ret;
    }
}