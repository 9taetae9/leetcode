class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] s_char =s.toCharArray();
        char[] t_char = t.toCharArray();
        Arrays.sort(s_char); Arrays.sort(t_char);
        for(int i=0; i<s.length(); i++){
            if(s_char[i] != t_char[i]) return false;
        }

        return true;
    }
}