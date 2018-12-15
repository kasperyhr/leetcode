public class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String ret = "";
        for(int i = 0; i < arr.length; i++){
            if(arr[arr.length - 1 - i].length() > 0)
          		ret += arr[arr.length - 1 - i] + " ";
        }
        ret = ret.trim();
        return ret;
    }
}