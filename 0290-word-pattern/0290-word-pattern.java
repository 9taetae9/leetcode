class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arrS = s.split(" ");
        if(pattern.length() != arrS.length) return false;

        Map<Character, String> map = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            map.putIfAbsent(pattern.charAt(i), arrS[i]);
            if(!map.get(pattern.charAt(i)).equals(arrS[i])) return false;
        }

        
        return map.values().stream().collect(Collectors.toSet()).size() == map.values().size();
    }
}