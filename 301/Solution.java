class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet();
        ArrayList<String> ret = new ArrayList();
        Queue<String> q = new LinkedList();
        
        set.add(s);
        q.offer(s);
        
        while(!q.isEmpty()){
            String t = q.poll();
            if(!ret.isEmpty() && ret.get(0).length() > t.length())
                break;
            if(isValid(t))
                ret.add(t);
            else {
                for(int i = 0; i < t.length(); i++){
                    if(t.charAt(i) != '(' && t.charAt(i) != ')')
                        continue;
                    String str = t.substring(0, i) + t.substring(i + 1);
                    if(set.contains(str))
                        continue;
                    set.add(str);
                    q.offer(str);
                }
            }
        }
        return ret;
    }
    
    private boolean isValid(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                cnt++;
            if(c == ')')
                cnt--;
            if(cnt < 0)
                return false;
        }
        if(cnt == 0)
            return true;
        return false;
    }
}