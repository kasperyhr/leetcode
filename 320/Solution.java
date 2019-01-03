class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<String>();
        dfs(ret, 0, word.length(), new StringBuffer(), 0, word);
        return ret;
    }
    
    private void dfs(List<String> ret, int i, int N, StringBuffer sb, int cnt, String word){
        if(i == N){
            if(cnt > 0) ret.add(new StringBuffer(sb).append(cnt).toString());
            else ret.add(sb.toString());
            return;
        }
        dfs(ret, i+1, N, sb, cnt+1, word);
        StringBuffer sb1 = new StringBuffer(sb);
        if(cnt > 0) sb1.append(cnt);
        sb1.append(word.charAt(i));
        dfs(ret, i+1, N, sb1, 0, word);
    }
}