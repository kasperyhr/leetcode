class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> l = new ArrayList();
        List<List<Integer>> ret = new ArrayList();
        bt(l, candidates, 0, target, 0, ret);
        return ret;
    }
    
    private void bt(List<Integer> l, int[] candidates, int currIndex, int target, int currSum, List<List<Integer>> ret){
        if(target == currSum){
            ret.add(new ArrayList(l));
            return;
        }
        
        if(currSum > target)
            return;
        if(currIndex == candidates.length)
            return;
        
        bt(l, candidates, currIndex + 1, target, currSum, ret);
        l.add(candidates[currIndex]);
        
        bt(l, candidates, currIndex, target, currSum + candidates[currIndex], ret);
        l.remove(l.size() - 1);
    }
}