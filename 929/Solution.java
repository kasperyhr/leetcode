class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<String>();
        for(int i = 0; i < emails.length; i++){
            s.add(newMail(emails[i]));
        }
        return s.size();
    }
    
    private String newMail(String email){
        String[] strs = email.split("@");
        String[] first = strs[0].split("\\.");
        String concat = "";
        for(int i = 0; i < first.length; i++){
            concat += first[i];
        }
        return concat.split("\\+")[0] + "@" + strs[1];
    }
}