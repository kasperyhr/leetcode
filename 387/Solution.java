class Solution {
    public int firstUniqChar(String s) {
        int ret = -1;
        for(int i = 0; i < 26; i++){
            int index = s.indexOf('a' + i);
            if(index < 0)
                continue;
            int index2 = s.indexOf('a' + i, index + 1);
            if(index2 < 0){
                if(ret == -1 || index < ret)
                    ret = index;
            }
        }
        return ret;
    }
}