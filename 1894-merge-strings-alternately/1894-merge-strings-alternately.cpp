class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string merged_str;
        string short_str, long_str;
        short_str =(word1.length()<word2.length()) ? word1 : word2;
        long_str =(word1.length()>word2.length()) ? word1 : word2;
        for(int i=0; i<short_str.length(); i++){
             merged_str+=word1[i];
             merged_str+=word2[i];
        }
        for(int i=short_str.length(); i<long_str.length(); i++){
            merged_str+=long_str[i];
        }
        return merged_str;
    }
};