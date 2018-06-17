class Solution {
    public String numberToWords(int num) {
        String ret = "";
        if(num == 0)
            ret += "Zero ";
        String[] ones = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String[] tens = {"Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String[] teens = {"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        if(num >= 1000000000){
            int tmp = num / 1000000000;
            ret += smallNum(tmp) + "Billion ";
            num %= 1000000000;
        }
        if(num >= 1000000){
            int tmp = num / 1000000;
            ret += smallNum(tmp) + "Million ";
            num %= 1000000;
        }
        if(num >= 1000){
            int tmp = num / 1000;
            ret += smallNum(tmp) + "Thousand ";
            num %= 1000;
        }
        if(num > 0){
            ret += smallNum(num);
        }
        return ret.trim();
    }
    
    public static String smallNum(int num){
        String[] ones = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String[] tens = {"Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String[] teens = {"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String ret = "";
        if(num >= 100){
            int index = num / 100;
            ret += ones[index - 1] + "Hundred ";
            num %= 100;
        }
        if(num >= 20 || num == 10){
            int index = num / 10;
            ret += tens[index - 1];
            num %= 10;
        }
        if(num >= 11 && num <= 19){
            int index = num - 10;
            ret += teens[index - 1];
            num = 0;
        }
        if(num > 0){
            ret += ones[num - 1];
        }
        return ret;
    }
}