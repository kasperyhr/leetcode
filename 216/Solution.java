class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> l = new ArrayList();
        List<List<Integer>> ret = new ArrayList();
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bt(l, candidates, 0, n, 0, k, ret);
        return ret;        
    }
    
    private void bt(List<Integer> l, int[] candidates, int currIndex, int target, int currSum, int k, List<List<Integer>> ret){
        if(target == currSum){
            if(l.size() == k)
                ret.add(new ArrayList(l));
            return;
        }
        
        if(currSum > target)
            return;
        if(currIndex == candidates.length)
            return;
        if(l.size() > k)
            return;
        l.add(candidates[currIndex]);
        bt(l, candidates, currIndex + 1, target, currSum + candidates[currIndex], k, ret);
        l.remove(l.size() - 1);
        
        bt(l, candidates, currIndex + 1, target, currSum, k, ret);
        
    }

}