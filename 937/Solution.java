class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] str1 = a.split(" ", 2);
            String[] str2 = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
            
            if(!isDigit1 && !isDigit2){
                int cmp = str1[1].compareTo(str2[1]);
                if(cmp == 0) cmp = str1[0].compareTo(str2[0]);
                return cmp;
            }
            return isDigit1? (isDigit2? 0: 1): -1;
        });
        return logs;
    }
}