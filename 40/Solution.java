class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> l = new ArrayList();
        List<List<Integer>> ret = new ArrayList();
        Arrays.sort(candidates);
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
        l.add(candidates[currIndex]);
        bt(l, candidates, currIndex + 1, target, currSum + candidates[currIndex], ret);
        l.remove(l.size() - 1);
        
        int index = currIndex + 1;
        while(index < candidates.length && candidates[index] == candidates[currIndex])
            index += 1;
        bt(l, candidates, index, target, currSum, ret);
        
    }
}