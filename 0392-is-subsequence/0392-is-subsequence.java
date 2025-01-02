class Solution {
    public boolean isSubsequence(String s, String t) {
        int len = 0;
        int start = 0;
        for(char c : s.toCharArray()){
            for(int i=start; i < t.length(); i++){
                if(c == t.charAt(i)) {
                    len++; start++;
                    break;
                } start++;
                if(i==t.length()-1) return false;
            }
        }

        return len == s.length();
    }
}