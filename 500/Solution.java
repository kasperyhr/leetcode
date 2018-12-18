class Solution {
    public String[] findWords(String[] words) {
        Set<Character> s1 = new HashSet<Character>();
        s1.add('Q');
        s1.add('W');
        s1.add('E');
        s1.add('R');
        s1.add('T');
        s1.add('Y');
        s1.add('U');
        s1.add('I');
        s1.add('O');
        s1.add('P');
        Set<Character> s2 = new HashSet<Character>();
        s2.add('A');
        s2.add('S');
        s2.add('D');
        s2.add('F');
        s2.add('G');
        s2.add('H');
        s2.add('J');
        s2.add('K');
        s2.add('L');
        Set<Character> s3 = new HashSet<Character>();
        s3.add('Z');
        s3.add('X');
        s3.add('C');
        s3.add('V');
        s3.add('B');
        s3.add('N');
        s3.add('M');
        List<String> ret = new ArrayList<String>();
        for(String s: words){
            int val = 0;
            for(int i = 0; i < s.length(); i++){
                char c = Character.toUpperCase(s.charAt(i));
                if(s1.contains(c))
                    val = (val | 4);
                else if(s2.contains(c))
                    val = (val | 2);
                else
                    val = (val | 1);
            }
            if(Integer.bitCount(val) <= 1)
                ret.add(s);
            
        }
        return ret.toArray(new String[ret.size()]);
    }
}