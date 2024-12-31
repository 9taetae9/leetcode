class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] alpha;

        int answer = 0;
        for(String w : words){
            boolean canFormed = true;

            if(w.length() > chars.length()) continue;
            alpha = new int[26];
            for(char c : chars.toCharArray()){
                ++alpha[c-'a'];
            }
            for(char c : w.toCharArray()){
                if(alpha[c-'a'] == 0) {
                    canFormed = false;
                    break;
                }
                --alpha[c-'a'];
            }
            if(canFormed) answer += w.length();
        }

        return answer;
    }
}