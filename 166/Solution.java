class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator;
        long d = denominator;
        if(n == 0)
            return "0";
        StringBuffer sb = new StringBuffer();
        if(n < 0 && d < 0){
            n = Math.abs(n);
            d = Math.abs(d);
        }
        if(n < 0 || d < 0){
            n = Math.abs(n);
            d = Math.abs(d);
            sb.append("-");
        }
        sb.append(n / d);
        n %= d;
        if(n == 0)
            return sb.toString();
        sb.append('.');
        Map<Long, Integer> m = new HashMap<Long, Integer>();
        n *= 10;
        while(n != 0){
            if(m.containsKey(n)){
                sb.insert(m.get(n), "(");
                sb.append(')');
                break;
            }
            m.put(n, sb.length());
            sb.append(n / d);
            n %= d;
            n *= 10;
        }
        return sb.toString();
    }
}