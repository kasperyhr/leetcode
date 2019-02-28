class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        for(int i = 0; i < Math.min(s1.length, s2.length); i++){
            int v1 = Integer.parseInt(s1[i]);
            int v2 = Integer.parseInt(s2[i]);
            if(v1 > v2) return 1;
            if(v1 < v2) return -1;
        }
        
        for(int i = Math.min(s1.length, s2.length); i < Math.max(s1.length, s2.length); i++){
            int v = 0;
            if(s1.length < s2.length)
                v = Integer.parseInt(s2[i]);
            else
                v = Integer.parseInt(s1[i]);
            if(v > 0) return s1.length > s2.length ? 1 : -1;
        }
        
        return 0;
    }
}