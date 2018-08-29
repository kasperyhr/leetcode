class Solution {
    public String addStrings(String num1, String num2) {
        String s1 = num1;
        String s2 = num2;
        if(s1.length() == 0)
            return s2;
        if(s2.length() == 0)
            return s1;
        int a = s1.charAt(s1.length() - 1) - '0';
        int b = s2.charAt(s2.length() - 1) - '0';
        int sum = a + b;
        if(sum >= 10)
            return addStrings(addStrings(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)),"1") + Integer.toString(sum - 10);
        else
            return addStrings(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)) + Integer.toString(sum);        
    }
}