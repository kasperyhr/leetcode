class Solution {
    public int romanToInt(String s) {
        char[] chs = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        HashMap<Character, Integer> m = new HashMap();
        m.put('M', 1000);
        m.put('D', 500);
        m.put('C', 100);
        m.put('L', 50);
        m.put('X', 10);
        m.put('V', 5);
        m.put('I', 1);
        
        int ret = 0;
        for(int i = 0; i < chs.length; i++){
            while(s.indexOf(chs[i]) >= 0){
                int index = s.indexOf(chs[i]);
                for(int j = 0; j < index; j++){
                    ret -= m.get(s.charAt(j));
                }
                ret += m.get(s.charAt(index));
                s = s.substring(index + 1);
            }
        }
        return ret;
    }
}