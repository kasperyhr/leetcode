class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            List<Integer> ret = new ArrayList();
            ret.add(1);
            return ret;
        }
        Integer[] arr = new Integer[rowIndex + 1];
        for(int i = 0; i <= rowIndex; i++){
            for(int j = i; j >= 0; j--){
                if(arr[j] == null)
                    arr[j] = 1;
                else if(j == 0)
                    arr[j] = 1;
                else
                    arr[j] = arr[j - 1] + (arr[j] == null ? 0 : arr[j]);
            }
        }
        return Arrays.asList(arr);
    }
}