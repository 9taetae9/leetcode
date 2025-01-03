class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] charS = new int[256];
        int[] charT = new int[256];

        for(int i=0; i < s.length(); i++){
            char sc = s.charAt(i), tc = t.charAt(i);
            if(charS[sc] != charT[tc]){
                return false;
            }

            charS[sc] = i+1; charT[tc] = i+1;
        }
    
        return true;
    }
}