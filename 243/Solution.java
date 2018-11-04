class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ptr1 = 0;
        int ptr2 = 0;
        int diff = Integer.MAX_VALUE;
        for(; ptr1 < words.length; ptr1++){
            if(words[ptr1].equals(word1))
                break;
        }
        for(; ptr2 < words.length; ptr2++){
            if(words[ptr2].equals(word2))
                break;
        }
        diff = Math.min(diff, Math.abs(ptr1 - ptr2));
        while(ptr1 < words.length && ptr2 < words.length){
            if(ptr1 < ptr2){
                while(++ptr1 < words.length){
                    if(words[ptr1].equals(word1))
                        break;
                }
            } else {
                while(++ptr2 < words.length){
                    if(words[ptr2].equals(word2))
                        break;
                }
            }
            if(ptr1 < words.length && ptr2 < words.length)
                diff = Math.min(diff, Math.abs(ptr1 - ptr2));
        }
        return diff;
    }
}