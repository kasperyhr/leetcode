class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int typedLen = typed.length();
        int nameLen = name.length();
        if(typedLen < nameLen) return false;
        if(typedLen == nameLen && typed.equals(name)) return true;
        if(typedLen == nameLen && !typed.equals(name)) return false;
        if(nameLen == 0) return false;
        char c1 = name.charAt(0);
        char c2 = typed.charAt(0);
        if(c1 != c2) return false;
        int i = 1;
        int j = 1;
        for(; i < nameLen; i++) if(name.charAt(i) != c1) break;
        for(; j < typedLen; j++) if(typed.charAt(j) != c2) break;
        if(i <= j) return isLongPressedName(name.substring(i), typed.substring(j));
        return false;
    }
}