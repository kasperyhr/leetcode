class Solution {
    public String countOfAtoms(String formula) {
        return atoms(formula).toString();
    }
    
    private MyHashMap atoms(String s){
        MyHashMap ret = new MyHashMap();
        String atom = "";
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                ret.add(atom, cnt);
                atom = "" + c;
                cnt = 0;
            } else if (c >= 'a' && c <= 'z'){
                atom += c;
            } else if (c >= '0' && c <= '9'){
                cnt = cnt * 10 + (c - '0');
            } else {
                ret.add(atom, cnt);
                cnt = 0;
                
                // ((OH)20)10
                int p = 1;
                String rec = "";
                i++;
                while(p > 0){
                    c = s.charAt(i++);
                    if(c == '('){
                        p += 1;
                    } else if(c == ')'){
                        p -= 1;
                    }
                    if(p == 0)
                        break;
                    rec += c;
                }
                while(i < s.length()){
                    c = s.charAt(i++);
                    if(c >= '0' && c <= '9'){
                        cnt = cnt * 10 + (c - '0');
                    } else {
                        i = i - 2;
                        break;
                    }
                }
                MyHashMap mhm = atoms(rec);
                mhm.multiply(cnt);
                ret.addAll(mhm);
                atom = "";
                cnt = 0;
            }
        }
        
        ret.add(atom, cnt);
        return ret;
    }
    
    class MyHashMap{
        TreeMap<String, Integer> h = new TreeMap();
        void add(String K, int V){
            if(K.length() == 0)
                return;
            if(V == 0)
                V = 1;
            if(h.containsKey(K)){
                h.put(K, h.get(K) + V);
            } else {
                h.put(K, V);
            }
        }
        
        void multiply(int V){
            for (Map.Entry<String, Integer> item : h.entrySet()) {
                String key = item.getKey();
                h.put(key, h.get(key) * V);
            }
        }
        
        void addAll(MyHashMap mhm){
            for (Map.Entry<String, Integer> item : mhm.h.entrySet()) {
                add(item.getKey(), item.getValue());
            }
        }
        
        public String toString(){
            String ret = "";
            Map.Entry<String, Integer> e = h.firstEntry();
            while(e != null){
                ret += e.getKey();
                if(e.getValue() != 1)
                    ret += e.getValue();
                e = h.higherEntry(e.getKey());
            }
            return ret;
        }
    }
}
