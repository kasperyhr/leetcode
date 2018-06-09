class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> e = new ArrayList<Integer>();
        ret.add(e);
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> r = insertAll(ret, nums[i]);
            ret.addAll(r);
        }
        return ret;
    }
    
    public List<List<Integer>> insertAll(List<List<Integer>> l, int a){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(List<Integer> ll: l){
            ArrayList<Integer> lc = myclone(ll);
            lc.add(a);
            ret.add(lc);
        }
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