class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Integer[] arr = new Integer[k];
        List<List<Integer>> ret = new ArrayList();
        if(k > n)
            return ret;
        bt(arr, 0, 1, n, k, ret);
        return ret;
    }
    
    private void bt(Integer[] arr, int currIndexInArr, int currNum, int n, int k, List<List<Integer>> ret){
        if(currIndexInArr == k){
            ret.add(new ArrayList<Integer>(Arrays.asList(arr)));
            return;
        }
        if(currNum > n)
            return;
        
        bt(arr, currIndexInArr, currNum + 1, n, k, ret);
        arr[currIndexInArr] = currNum;
        bt(arr, currIndexInArr + 1, currNum + 1, n, k, ret);
            
    }
    
}