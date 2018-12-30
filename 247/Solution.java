class Solution {
    Map<Character, Character> m;
    public List<String> findStrobogrammatic(int n) {
        List<String> ret = new ArrayList<String>();
        m = new HashMap<Character, Character>();
        m.put('1','1');
        m.put('6','9');
        m.put('9','6');
        m.put('8','8');
        m.put('0','0');
        if(n == 0)
            return ret;
        if(n == 1){
            ret.add("1"); ret.add("0"); ret.add("8");
            return ret;
        }
        List<StringBuffer> l = make((n + 1) >> 1, true, n % 2 != 0);
        ret = rev(l, n % 2 != 0);
        return ret;
    }
    
    private List<String> rev(List<StringBuffer> l, boolean mid){
        List<String> ret = new ArrayList<String>();
        if(mid){
            for(StringBuffer sb: l){
                StringBuffer nsb = new StringBuffer(sb).reverse().deleteCharAt(0);
                for(int i = 0; i < nsb.length(); i++){
                    nsb.setCharAt(i, m.get(nsb.charAt(i)));
                }
                sb.append(nsb);
                ret.add(sb.toString());
            }
        } else {
            for(StringBuffer sb: l){
                StringBuffer nsb = new StringBuffer(sb).reverse();
                for(int i = 0; i < nsb.length(); i++){
                    nsb.setCharAt(i, m.get(nsb.charAt(i)));
                }
                sb.append(nsb);
                ret.add(sb.toString());
            }
        }
        return ret;
    }
    
    private List<StringBuffer> make(int n, boolean first, boolean mid){
        List<StringBuffer> ret = new ArrayList<StringBuffer>();
        if(n == 1){
            ret.add(new StringBuffer("1"));
            ret.add(new StringBuffer("8"));
            if(!mid){
                ret.add(new StringBuffer("6"));
                ret.add(new StringBuffer("9")); 
            }
            if(!first)
                ret.add(new StringBuffer("0")); 
            return ret;
        }
        List<StringBuffer> get = make(n - 1, false, mid);
        for(StringBuffer s: get){
            ret.add(new StringBuffer(s).insert(0, '1'));
            ret.add(new StringBuffer(s).insert(0, '6'));
            ret.add(new StringBuffer(s).insert(0, '8'));
            ret.add(new StringBuffer(s).insert(0, '9'));
            if(!first)
                ret.add(new StringBuffer(s.toString()).insert(0, '0'));
        }
        return ret;
    }
}