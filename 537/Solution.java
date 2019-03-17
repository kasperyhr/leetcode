class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        int aReal = Integer.parseInt(as[0]);
        int bReal = Integer.parseInt(bs[0]);
        int aComp = Integer.parseInt(as[1].substring(0, as[1].length() - 1));
        int bComp = Integer.parseInt(bs[1].substring(0, bs[1].length() - 1));
        int retReal = aReal * bReal - aComp * bComp;
        int retComp = aReal * bComp + aComp * bReal;
        String ret = Integer.toString(retReal) + "+" + Integer.toString(retComp) + "i";
        return ret;
    }
}