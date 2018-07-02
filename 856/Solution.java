class Solution {
    public int scoreOfParentheses(String S) {
        if(S.length() == 0)
            return 0;
        if(S.length() == 2)
            return 1;
        int cnt = 0;
        int start = 0;
        int end = -1;
        int index = 0;
        int ret = 0;
        while(index < S.length()){
            if(S.charAt(index) == '(')
                cnt += 1;
            else
                cnt -= 1;
            if(cnt == 0){
                end = index;
                // System.out.println(S.substring(start, end + 1));
                ret += score(S.substring(start, end + 1));
                start = end + 1;
            }
            index++;
        }
        return ret;
    }
    
    private int score(String s){
        if(s.length() == 2)
            return 1;
        return 2 * scoreOfParentheses(s.substring(1, s.length() - 1));
    }
}
