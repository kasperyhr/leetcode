class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int cnt = 1;
        Queue<String> q = new ArrayDeque();
        q.add(beginWord);
        Set<String> wl = new HashSet<String>(wordList);
        if(!wl.contains(endWord)) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String s = q.remove();
                char[] chs = s.toCharArray();
                for(int j = 0; j < chs.length; j++){
                    char ch = chs[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        chs[j] = c;
                        String s2 = new String(chs);
                        if(s2.equals(endWord))
                            return cnt + 1;
                        if(wl.contains(s2)){
                            q.add(s2);
                            wl.remove(s2);
                        }
                    }
                    chs[j] = ch;
                }
            }
            cnt += 1;
        }
        return 0;
    }
}