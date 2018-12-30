class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> m = new HashMap<Character, Character>();
        m.put('6', '9');
        m.put('9', '6');
        m.put('1', '1');
        m.put('8', '8');
        m.put('0', '0');
        for(int i = 0; i * 2 < num.length(); i++){
            if(m.get(num.charAt(i)) == null || m.get(num.charAt(i)) != num.charAt(num.length() - i - 1))
                return false;
        }
        return true;
    }
}