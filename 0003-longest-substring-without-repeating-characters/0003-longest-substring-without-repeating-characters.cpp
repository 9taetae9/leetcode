class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> charMap;
        int Max = 0;
        int start = 0;

        for (int end = 0; end < s.size(); ++end) {
            if (charMap.find(s[end]) != charMap.end()) {
                start = max(start, charMap[s[end]] + 1);  
                // Jump start pointer directly past the last occurrence
            }
            charMap[s[end]] = end; // Update or insert the character's position
            Max = max(Max, end - start + 1);  // Update the max length
        }
        return Max;
    }
};