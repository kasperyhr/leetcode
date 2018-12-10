class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> ret = dfs(s, 0);
        List<String> my_ret = new LinkedList<String>();
        for(List<String> l: ret){
            String str = l.get(0);
            for(int i = 1; i < 4; i++){
                str+=".";
                str+=l.get(i);
            }
            my_ret.add(str);
        }
        return my_ret;
    }
    
    private boolean valid(String str){
        if(str.length() == 0 || str.length() > 3)
            return false;
        if(str.charAt(0) == '0' && str.length() > 1)
            return false;
        int i = Integer.parseInt(str);
        if(i <= 255)
            return true;
        return false;
    }
    
    private List<List<String>> dfs(String s, int cnt){
        List<List<String>> ret = new LinkedList<List<String>>();
        if(cnt == 3){
            if(valid(s)){
                List<String> l = new LinkedList<String>();
                l.add(s);
                ret.add(l);
            }
        } else {
            if(s.length() == 0)
                return ret;
            if(s.length() > 3 && valid(s.substring(0, 3))){
                String sub = s.substring(0, 3);
                List<List<String>> l = dfs(s.substring(3), cnt + 1);
                for(List<String> ll: l){
                    ll.add(0, sub);
                }
                ret.addAll(l);
            }
            if(s.length() > 2 && valid(s.substring(0, 2))){
                String sub = s.substring(0, 2);
                List<List<String>> l = dfs(s.substring(2), cnt + 1);
                for(List<String> ll: l){
                    ll.add(0, sub);
                }
                ret.addAll(l);
            }
            if(s.length() > 1 && valid(s.substring(0, 1))){
                String sub = s.substring(0, 1);
                List<List<String>> l = dfs(s.substring(1), cnt + 1);
                for(List<String> ll: l){
                    ll.add(0, sub);
                }
                ret.addAll(l);
            }
        }
        return ret;
    }
}