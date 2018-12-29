class LogSystem {
    TreeMap<Long, Integer> m;
    public LogSystem() {
        m = new TreeMap<Long, Integer>();
    }
    
    public void put(int id, String timestamp) {
        m.put(convert(timestamp, "Second", true), id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        long t1 = convert(s, gra, true);
        long t2 = convert(e, gra, false);
        t1--;
        List<Integer> ret = new ArrayList<Integer>();
        while(m.higherKey(t1) != null && m.higherKey(t1) < t2) {
            ret.add(m.get(m.higherKey(t1)));
            t1 = m.higherKey(t1);
        }
        return ret;
    }
    
    private long convert(String t, String g, boolean s){
        String[] ss = t.split(":");
        long ret = 0;
        ret += Integer.parseInt(ss[0]) - 1999L;
        if(g.equals("Year")){
            if(!s) ret+=1;
            ret *= 12 * 31 * 24 * 60 * 60;
            return ret;
        }
        ret *= 12;
        ret += Integer.parseInt(ss[1]) - 1;
        if(g.equals("Month")){
            if(!s) ret+=1;
            ret *= 31 * 24 * 60 * 60;
            return ret;
        }
        ret *= 31;
        ret += Integer.parseInt(ss[2]) - 1;
        if(g.equals("Day")){
            if(!s) ret+=1;
            ret *= 24 * 60 * 60;
            return ret;
        }
        ret *= 24;
        ret += Integer.parseInt(ss[3]);
        if(g.equals("Hour")){
            if(!s) ret+=1;
            ret *= 60 * 60;
            return ret;
        }
        ret *= 60;
        ret += Integer.parseInt(ss[4]);
        if(g.equals("Minute")){
            if(!s) ret+=1;
            ret *= 60;
            return ret;
        }
        ret *= 60;
        ret += Integer.parseInt(ss[5]);
        if(g.equals("Second")){
            if(!s) ret+=1;
        }
        return ret;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */