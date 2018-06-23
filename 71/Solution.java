class Solution {
    public String simplifyPath(String path) {
        String[] p = path.split("/");
        List<String> q = new ArrayList();
        for(int i = 0; i < p.length; i++){
            if(p[i].length() == 0 || p[i].equals("."))
                continue;
            if(p[i].equals("..")){
                if(q.size() == 0)
                    continue;
                else
                    q.remove(q.size() - 1);
            } else {
                q.add(p[i]);
            }
        }
        String ret = "";
        for(String s: q){
            ret += "/" + s;
        }
        if(ret.length() == 0)
            ret = "/";
        return ret;
    }
}