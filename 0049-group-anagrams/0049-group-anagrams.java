class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); //키 : 정렬문자열, 값 : 원본 strs

        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sorted = new StringBuilder();
            for(int freq : count){
                sorted.append("#").append(freq);
            }
            
            String key = new String(sorted);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
        
    }
}