class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n-1;

        int[] dp = new int[n];

        for(int i=0; i < n; i++){
            for(int j=1; j <= nums[i]; j++){
                if(i+j >= n) break;
                if(dp[i+j] == 0) 
                    dp[i+j] = dp[i]+1;
                else 
                    dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
            }
        }

        return dp[n-1];

    }
}