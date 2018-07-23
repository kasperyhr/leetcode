class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].charAt(0) >= '0' && tokens[i].charAt(0) <= '9')
                s.push(Integer.parseInt(tokens[i]));
            else if(tokens[i].charAt(0) == '-' && tokens[i].length() > 1)
                s.push(Integer.parseInt(tokens[i]));
            else{
                int num2 = s.pop();
                int num1 = s.pop();
                int num = 0;
                if(tokens[i].equals("+")){
                    num = num1 + num2;
                } else if(tokens[i].equals("-")){
                    num = num1 - num2;
                } else if(tokens[i].equals("*")){
                    num = num1 * num2;
                } else {
                    num = num1 / num2;
                }
                s.push(num);
            }
            // System.out.println(s.peek());
        }
        return s.pop();
    }
}