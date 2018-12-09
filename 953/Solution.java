class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        String[] words_copy = new String[words.length];
        for(int i = 0; i < words.length; i++){
            words_copy[i] = words[i];
        }
        Arrays.sort(words_copy, new Comparator<String>() {
            public int compare(String s1, String s2) {
                for(int i = 0; i < s1.length(); i++){
                    if(i >= s2.length())
                        return 1;
                    if(s1.charAt(i) == s2.charAt(i))
                        continue;
                    return order.indexOf(s1.charAt(i)) - order.indexOf(s2.charAt(i));
                }
                if(s2.length() > s1.length())
                    return -1;
                return 0;
            }
        });
        for(int i = 0; i < words.length; i++){
            if(!words_copy[i].equals(words[i]))
                return false;
        }
        return true;
        
    }
}