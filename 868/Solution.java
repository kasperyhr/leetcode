class Solution {
    public int binaryGap(int N) {
        int max = 0;
        String s = Integer.toBinaryString(N);
        int prev = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '1'){
                if(prev != -1)
                    max = Math.max(max, i - prev);
                prev = i;
            }
        }
        return max;
    }
}