import java.util.*;
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<String, String> morseStr = new HashMap<String, String>();
        for(int i = 0; i < words.length; i++){
            String m = "";
            for(int j = 0; j < words[i].length(); j++){
                m += arr[words[i].charAt(j) - 'a'];
            }
            morseStr.put(m, m);
        }
        return morseStr.size();
    }
}