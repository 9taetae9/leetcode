class Solution {
    public int maxProfit(int[] prices) {
        int[] res = new int[prices.length-1];

        for(int i=0; i<res.length; i++){
            res[i] = prices[i+1] - prices[i];
        }

        int maxSoFar = 0;
        int ans = maxSoFar;

        for(int i=0; i<res.length; i++){
            int curr = res[i];
            maxSoFar = Math.max(curr, maxSoFar + curr);

            ans = Math.max(ans, maxSoFar);
        }

        return ans;
    }
}