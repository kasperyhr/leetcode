import java.util.*;
class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(n == 0){
            ret.add(0);
            return ret;
        }
        List<Integer> pre = grayCode(n - 1);
        ret.addAll(pre);
        
        Collections.reverse(pre);
        for(int a: pre){
            ret.add(a + (int)Math.pow(2, n - 1));
        }
        return ret;
    } 
}