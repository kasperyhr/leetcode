class Solution {
    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            m.put(A[i], m.getOrDefault(A[i], 0) + 1);
        }
        int cnt = 0;
        while(2 * cnt < A.length){
            int key = m.firstKey();
            int val = m.get(key);
            if(val == 1)
                m.remove(key);
            else
                m.put(key, val - 1);
            if(key < 0){
                if(key % 2 == 0 && m.containsKey(key / 2)){
                    val = m.get(key/2);
                    if(val == 1)
                        m.remove(key/2);
                    else
                        m.put(key/2, val-1);
                } else {
                    return false;
                }    
            } else {
                if(m.containsKey(key * 2)){
                    val = m.get(key*2);
                    if(val == 1)
                        m.remove(key*2);
                    else
                        m.put(key*2, val-1);
                } else {
                    return false;
                }
            }
            
            cnt++;
        }
        return true;
    }
}
