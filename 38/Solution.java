class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        StringBuffer sb = new StringBuffer("1");
        for(int i = 2; i <= n; i++){
            char prev = sb.charAt(0);
            int cnt = 1;
            StringBuffer newsb = new StringBuffer();
            for(int j = 1; j < sb.length(); j++){
                char c = sb.charAt(j);
                if(c == prev)
                    cnt++;
                else{
                    newsb.append(cnt);
                    newsb.append(prev);
                    prev = c;
                    cnt = 1;
                }
            }
            newsb.append(cnt);
            newsb.append(prev);
            sb = newsb;
        }
        
        return sb.toString();
    }
}