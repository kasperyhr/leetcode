class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())
            return false;
        int index1 = -1;
        int index2 = -1;
        int[] arr = new int[26];
        boolean flag = false;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) != B.charAt(i)){
                if(index2 >= 0)
                    return false;
                else if(index1 >= 0)
                    index2 = i;
                else
                    index1 = i;
            } else {
                arr[A.charAt(i) - 'a'] += 1;
                if(arr[A.charAt(i) - 'a'] > 1)
                    flag = true;
            }
        }
        if(index1 == -1){
            return flag;
        }
        if(index2 == -1)
            return false;
        if(A.charAt(index1) == B.charAt(index2) && A.charAt(index2) == B.charAt(index1))
            return true;
        else
            return false;
        
    }
}