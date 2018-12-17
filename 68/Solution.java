class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> ll = new ArrayList<List<String>>();
        List<String> l = new ArrayList<String>();
        l.add(words[0]);
        ll.add(l);
        int currLen = words[0].length();
        for(int i = 1; i < words.length; i++){
            if(currLen + 1 + words[i].length() > maxWidth){
                l = new ArrayList<String>();
                ll.add(l);
                currLen = 0;
            } else {
                currLen += 1;
            }
            l.add(words[i]);
            currLen += words[i].length();
        }
        List<String> ret = new ArrayList<String>();
        for(int i = 0; i <= ll.size() - 2; i++){
            l = ll.get(i);
            StringBuffer sb = new StringBuffer();
            sb.append(l.get(0));
            if(l.size() == 1){
                while(sb.length() < maxWidth){
                    sb.append(' ');
                }
            } else {
                int j = 1;
                int len = 0;
                int len1 = 0;
                int idxj = 0;
                for(; j < l.size(); j++){
                    len += l.get(j).length();
                }
                int spacing = maxWidth - len - l.get(0).length();
                len1 = spacing / (l.size() - 1) + 1;
                idxj = spacing % (l.size() - 1) + 1;
                j = 1;
                for(; j < l.size(); j++){
                    for(int k = 0; k < ((j >= idxj) ? len1 - 1 : len1); k++){
                        sb.append(' ');
                    }
                    sb.append(l.get(j));
                }
            }
            ret.add(sb.toString());
        }
        int i = ll.size() - 1;
        l = ll.get(i);
        StringBuffer sb = new StringBuffer();
        sb.append(l.get(0));
        int j = 1;
        while(j < l.size()){
            sb.append(' ');
            sb.append(l.get(j++));
        }
        while(sb.length() < maxWidth)
            sb.append(' ');
        ret.add(sb.toString());
        return ret;
    }
}