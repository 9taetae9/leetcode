class Solution {
    public int alternatingSubarray(int[] nums) {
        int maxLen = -1;
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                int currentLen = 2;
                int j = i + 1;
                
                while (j < n - 1 && nums[j + 1] == nums[j - 1]) {
                    currentLen++;
                    j++;
                }
                
                maxLen = Math.max(maxLen, currentLen);
                i = j - 1;  // j부터 시작
            }
        }
        
        return maxLen;
    }
}