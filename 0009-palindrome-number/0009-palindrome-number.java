class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String s = String.valueOf(x);
        int i = 0;
        int j = s.length()-1;
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++; j--;
        }

        return i >= j;
    }
}