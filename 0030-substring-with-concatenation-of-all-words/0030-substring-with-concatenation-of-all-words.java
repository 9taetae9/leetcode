import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if(s.length() < totalLen){
            return result;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for(String word : words){
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for(int i=0; i<wordLen; i++){
            slideWindow(s, i, wordLen, wordCount, totalLen, wordMap, result);
        }

        return result;
    }

    private void slideWindow(String s, int start, int wordLen, int wordCount, int totalLen, Map<String,Integer> wordMap, List<Integer> result){
        int left = start;
        int count = 0;
        Map<String, Integer> windowMap = new HashMap<>();

        for(int right = start; right <= s.length() - wordLen; right+= wordLen){
            String rightWord = s.substring(right, right+wordLen);

            if(wordMap.containsKey(rightWord)){
                windowMap.put(rightWord, windowMap.getOrDefault(rightWord, 0)+1);
                count++;
    
                while(windowMap.get(rightWord) > wordMap.get(rightWord)){
                    // 개수 맞을 때까지 왼쪽 단어 삭제
                    String leftWord = s.substring(left, left + wordLen);
                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if(count == wordCount){
                    result.add(left);
                    String leftWord = s.substring(left, left + wordLen);
                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                    count--;
                    left+= wordLen;
                }

            }else{
                windowMap.clear();
                count = 0;
                left = right + wordLen;
            }
        }
    }
}