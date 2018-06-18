class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList();
        for(int i = 0; i <= num && i < 5; i++){
            List<String> hours = hourList(i);
            List<String> mins = minList(num - i);
            // System.out.println(i + " " + (num - i));
            for(String h: hours){
                for(String m: mins){
                    ret.add(h + ":"  + m);
                }
            }
        }
        return ret;
    }
    
    public List<String> hourList(int n){
        List<String> ret = new ArrayList();
        for(int i = 0; i < 12; i++){
            if(Integer.bitCount(i) == n)
                ret.add(Integer.toString(i));
        }
        return ret;
    }
    
    public List<String> minList(int n){
        List<String> ret = new ArrayList();
        for(int i = 0; i < 60; i++){
            if(Integer.bitCount(i) == n)
                ret.add(String.format("%1$02d", i));
        }
        return ret;
    }
}