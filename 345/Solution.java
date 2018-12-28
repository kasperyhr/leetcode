class Solution {
    public String reverseVowels(String s) {
        ArrayList<Integer> v = vowels(s);
        StringBuffer ret = new StringBuffer();
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(index < v.size() && v.get(index) == i)
                ret.append(s.charAt(v.get(v.size() - index++ - 1)));
            else
                ret.append(s.charAt(i));
        }
        return ret.toString();
    }
    
    public static ArrayList<Integer> vowels(String s){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' 
               || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
                ret.add(i);
        }
        return ret;
    }
}