class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuffer sb = new StringBuffer(S);
        int ptr1 = 0;
        int ptr2 = S.length() - 1;
        while(ptr1 < ptr2){
            while(ptr1 < S.length() && !Character.isLetter(sb.charAt(ptr1)))
                ptr1++;
            while(ptr2 >= 0 && !Character.isLetter(sb.charAt(ptr2)))
                ptr2--;
            if(ptr1 < ptr2){
                char c1 = sb.charAt(ptr1);
                char c2 = sb.charAt(ptr2);
                sb.setCharAt(ptr1, c2);
                sb.setCharAt(ptr2, c1);
                ptr1++;ptr2--;
            }
        }
        return sb.toString();
    }
}