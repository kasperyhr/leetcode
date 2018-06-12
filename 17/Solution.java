class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ret = new ArrayList<String>();
        
        if(digits.length() == 0){
            return ret;
        }
        return letterComb2(digits);
    }
    
    public static List<String> letterComb2(String digits) {
        ArrayList<String> ret = new ArrayList<String>();
        
        if(digits.length() == 0){
            ret.add("");
            return ret;
        }
        List<String> arr = letterComb2(digits.substring(0, digits.length() - 1));
        char[] arr2 = new char[3];
        char c = digits.charAt(digits.length() - 1);
        switch(c){
            case '2':
                arr2[0] = 'a';
                arr2[1] = 'b';
                arr2[2] = 'c';
                break;
            case '3':
                arr2[0] = 'd';
                arr2[1] = 'e';
                arr2[2] = 'f';
                break;
            case '4':
                arr2[0] = 'g';
                arr2[1] = 'h';
                arr2[2] = 'i';
                break;
            case '5':
                arr2[0] = 'j';
                arr2[1] = 'k';
                arr2[2] = 'l';
                break;
            case '6':
                arr2[0] = 'm';
                arr2[1] = 'n';
                arr2[2] = 'o';
                break;
            case '7':
                arr2 = new char[4];
                arr2[0] = 'p';
                arr2[1] = 'q';
                arr2[2] = 'r';
                arr2[3] = 's';
                break;
            case '8':
                arr2[0] = 't';
                arr2[1] = 'u';
                arr2[2] = 'v';
                break;
            case '9':
                arr2 = new char[4];
                arr2[0] = 'w';
                arr2[1] = 'x';
                arr2[2] = 'y';
                arr2[3] = 'z';
                break;
            default:
                arr2 = new char[0];
                break;
        }
        for(int i = 0; i < arr2.length; i++){
            ret.addAll(addChar(arr, arr2[i]));
        }
        return ret;
    }
    
    public static List<String> addChar(List<String> arr, char c){
        ArrayList<String> ret = new ArrayList<String>();
        for(String s: arr){
            ret.add(s + c);
        }
        return ret;
    }
}