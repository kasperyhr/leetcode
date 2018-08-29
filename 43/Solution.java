class Solution {
    public String multiply(String num1, String num2) {
        ArrayList<String> a = new ArrayList();
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.length() < num2.length()){
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        for(int i = 0; i <= 9; i++){
            a.add(m(num1, i));
        }
        // p(a);
        ArrayList<String> sum = new ArrayList();
        for(int i = num2.length() - 1; i >= 0; i--){
            if(num2.charAt(i) == '0')
                continue;
            sum.add(a.get(num2.charAt(i) - '0') + zero(num2.length() - 1 - i));
        }
        // p(sum);
        String ret = "0";
        for(String s: sum){
            ret = add(s, ret);
        }
        return ret;
    }
    
    private void p(ArrayList<String> a){
        for(String s: a)
            System.out.print(s + " ");
        System.out.println();
    }

    
    private String add(String s1, String s2){
        if(s1.length() == 0)
            return s2;
        if(s2.length() == 0)
            return s1;
        int a = s1.charAt(s1.length() - 1) - '0';
        int b = s2.charAt(s2.length() - 1) - '0';
        int sum = a + b;
        if(sum >= 10)
            return add(add(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)),"1") + Integer.toString(sum - 10);
        else
            return add(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)) + Integer.toString(sum);
    }
    
    private String m(String s, int i){
        if(i == 0)
            return "0";
        if(i == 1)
            return s;
        String ret = "";
        int carry = 0;
        for(int j = s.length() - 1; j >= 0; j--){
            carry += (s.charAt(j) - '0') * i;
            ret = Integer.toString(carry % 10) + ret;
            
            carry /= 10;
        }
        if(carry > 0)
            ret = Integer.toString(carry) + ret;
        return ret;
    }
    
    private String zero(int n){
        String s = "";
        for(int i = 0; i < n; i++) s += "0";
        return s;
    }
    
}