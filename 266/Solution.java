class Solution {
    static final int SIZE = 256;
    public boolean canPermutePalindrome(String s) {
        int[] chars = new int[SIZE];
        for(int i = 0; i < s.length(); i++){
            chars[s.charAt(i)] += 1;
        }
        int sum = 0;
        for(int i = 0; i < SIZE; i++){
            sum += (chars[i] % 2);
        }
        return sum < 2;
    }
}
