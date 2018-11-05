class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack();
        Stack<Character> ch = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ')
                continue;
            if(c == '*' || c == '/' || c == '('){
                ch.push(c);
            }
            if(c == '+' || c == '-'){
                if(ch.size() != 0 && (ch.peek() == '+' || ch.peek() == '-'))
                    force_calc(nums, ch, false);
                ch.push(c);
            }
            if(c == ')'){
                force_calc(nums, ch, true);
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
            // p(nums, ch);
        }
        force_calc(nums, ch, true);
        return nums.pop();
    }
    
    private void calc(Stack<Integer> nums, Stack<Character> chars){
        while(chars.size() != 0 && chars.peek() != '(' && chars.peek() != '+' && chars.peek() != '-'){
            int num2 = nums.pop();
            int num1 = nums.pop();
            char c = chars.pop();
            int num = 0;
            if(c == '*'){
                num = num1 * num2;
            } else if(c == '/'){
                num = num1 / num2;
            }
            nums.push(num);
        }
    }
    
    private void force_calc(Stack<Integer> nums, Stack<Character> chars, boolean flag){
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
        if(flag && chars.size() != 0 && chars.peek() == '('){
            chars.pop();
            calc(nums, chars);
        }
    }
    
    private void p(Stack<Integer> s, Stack<Character> c){
        for(int i = 0; i < s.size(); i++){
            System.out.print(s.get(i) + " ");
        }
        for(int i = 0; i < c.size(); i++){
            System.out.print(c.get(i) + " ");
        }
        System.out.println();
        
    }
}