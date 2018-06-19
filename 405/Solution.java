class Solution {
    public String toHex(int num) {
        String ret = "";
        if(num == 0)
            return "0";
        while(num != 0){
            ret = toHex2(num & 15) + ret;
            num >>>= 4;
        }
        return ret;
    }
    
    public char toHex2(int num){
        switch(num){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return (char)('0' + num);
            default:
                return (char)('a' + num - 10);
        }
    }
}