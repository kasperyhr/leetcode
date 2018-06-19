class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList();
        generate(n, 0, 0, new StringBuilder(), ret);
        
        return ret;
    }
    
    private void generate(int n, int left, int right, StringBuilder sb, List<String> ret){
        if(left == n && right == n){
            ret.add(sb.toString());
            return;
        }
        
        if(right < left){
            sb.append(')');
            generate(n, left, right + 1, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(left < n){
            sb.append('(');
            generate(n, left + 1, right, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}