class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack();
        Stack<Character> ch = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ')
                continue;
            if(c == '+' || c == '-' || c == '('){
                ch.push(c);
            }
            if(c == ')'){
                ch.pop();
                calc(nums, ch);
            }
            if(c >= '0' && c <= '9'){
                int num = c - '0';
                while(++i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num *= 10;
                    num += s.charAt(i) - '0';
                }
                i--;
                nums.push(num);
                calc(nums, ch);
            }
        }
        return nums.pop();
    }
    
    private void calc(Stack<Integer> nums, Stack<Character> chars){
        while(chars.size() != 0 && chars.peek() != '('){
            int num2 = nums.pop();
            int num1 = nums.pop();
            char c = chars.pop();
            int num = 0;
            if(c == '+'){
                num = num1 + num2;
            } else if(c == '-'){
                num = num1 - num2;
            }
            nums.push(num);
        }
    }
}