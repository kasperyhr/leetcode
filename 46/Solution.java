import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ret.add(a);
        for(int i = 0; i < nums.length; i++){
            ret = interleave(ret, nums[i]);
        }
        return ret;
    }
    
    public static ArrayList<List<Integer>> interleave(ArrayList<List<Integer>> l, int e){
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(List<Integer> ll: l){
            ret.addAll(insertAnyWhere(ll, e));
        }
        return ret;
    }
    
    public static ArrayList<List<Integer>> insertAnyWhere(List<Integer> l, int e){
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(int i = 0; i < l.size(); i++){
            ArrayList<Integer> ll = myclone(l);
            ll.add(i, e);
            ret.add(ll);
        }
        ArrayList<Integer> ll = myclone(l);
        ll.add(e);
        ret.add(ll);
        return ret;
    }
    
    public static ArrayList<Integer> myclone(List<Integer> l){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i: l){
            ret.add(i);
        }
        return ret;
    }
}