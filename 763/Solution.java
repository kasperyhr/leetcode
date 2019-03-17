class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            arr[c - 'a'] = i;
        }
        
        List<Integer> l = new ArrayList();
        int j = 0;
        int len = -1;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            j = Math.max(j, arr[c - 'a']);
            if(j == i){
                l.add(j - len);
                len = j;
            }
        }
        return l;
    }
}