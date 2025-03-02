class Solution {
    int[] dp = new int[46];
    
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        if(dp[n] != 0) return dp[n];

        dp[n] = climbStairs(n-1)+climbStairs(n-2);
        return dp[n];
    }
}

/*
dp[0] = 0
dp[1] = 1
dp[2] = dp[0] + dp[1]
...
dp[n] = dp[n-2] + dp[n-1]

*/