class Solution {
    public String addBinary(String a, String b) {
        while(a.length() < b.length()){
            a = "0" + a;
        }
        while(a.length() > b.length()){
            b = "0" + b;
        }
        String ret = "";
        char z = '0';
        for(int i = a.length() - 1; i >= 0; i--){
            char x = a.charAt(i);
            char y = b.charAt(i);
            ret = sum(x, y, z) + ret;
            z = carry(x, y, z);
        }
        if(z != '0')
            ret = '1' + ret;
        return ret;
    }
    
    public char xor(char a, char b){
        if(a == b)
            return '0';
        return '1';
    }
    
    public char and(char a, char b){
        if(a == '1' && b == '1')
            return '1';
        return '0';
    }
    
    public char or(char a, char b){
        if(a == '1' || b == '1')
            return '1';
        return '0';
    }
    
    public char sum(char a, char b, char c){
        return xor(xor(a, b), c);
    }
    
    public char carry(char a, char b, char c){
        return or(and(a, b), and(xor(a, b), c));
    }
    
}