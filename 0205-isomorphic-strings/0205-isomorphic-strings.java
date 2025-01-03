class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            mapS.putIfAbsent(s.charAt(i), t.charAt(i));
            mapT.putIfAbsent(t.charAt(i), s.charAt(i));

            if(mapS.get(s.charAt(i)) != t.charAt(i) || mapT.get(t.charAt(i)) != s.charAt(i)) return false;
        }

        return true;
    }
}