class Solution {
    public void reverseWords(char[] str) {
        for(int i = 0; i < str.length / 2; i++){
            char c = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = c;
        }
        reverse(str, 0);
    }
    private void reverse(char[] s, int i){
        if(i >= s.length)
            return;
        int j = i + 1;
        while(j < s.length && s[j] != ' ')
            j++;
        int k = j-1;
        while(i < k){
            char c = s[i];
            s[i] = s[k];
            s[k] = c;
            i++;
            k--;
        }
        reverse(s, j+1);
    }
}