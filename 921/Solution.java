class Solution {
    public int minAddToMakeValid(String S) {
        int bal = 0;
        int ins = 0;
        for(char c: S.toCharArray()){
            if(c == '('){
                bal ++;
            } else {
                bal --;
                if(bal == -1){
                    bal ++;
                    ins ++;
                }
            }
        }
        return bal + ins;
    }
}