class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n != t.length()) return false;

        int[] alpha = new int[26];

        for(int i=0; i < n; i++){
            alpha[s.charAt(i)-'a']++;
            alpha[t.charAt(i)-'a']--;
        }

        for(int a : alpha){
            if(a!=0) return false;
        }

        return true;
    }
}