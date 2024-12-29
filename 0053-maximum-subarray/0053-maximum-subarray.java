class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int result = maxSoFar;

        for(int i=1; i < nums.length; i++){
            int curr = nums[i];
            maxSoFar = Math.max(curr, curr + maxSoFar);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}