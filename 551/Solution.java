class Solution {
    public boolean checkRecord(String s) {
        int index = s.indexOf("A");
        if(index >= 0)
            if(s.indexOf("A", index + 1) >= 0)
                return false;
        if(s.indexOf("LLL") >= 0)
            return false;
        return true;
    }
}