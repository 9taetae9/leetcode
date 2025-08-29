import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for(char c : t.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c, 0)+1);
        }


        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int minStart = 0;
        int formed = 0;
        int required = targetMap.size();
        Map<Character, Integer> windowMap = new HashMap<>();

        while(right < s.length()){
            
            char charRight = s.charAt(right);
            windowMap.put(charRight, windowMap.getOrDefault(charRight, 0)+1);

            if(targetMap.containsKey(charRight) 
            && windowMap.get(charRight).intValue() == targetMap.get(charRight).intValue()){
                formed++;
            }

            while(left <= right && formed == required){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                // move left pointer
                char charLeft = s.charAt(left);
                windowMap.put(charLeft, windowMap.get(charLeft)-1);
            
                if(targetMap.containsKey(charLeft)
                 && windowMap.get(charLeft).intValue() < targetMap.get(charLeft).intValue()){
                    formed--;
                }

                left++;
            }
        
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}