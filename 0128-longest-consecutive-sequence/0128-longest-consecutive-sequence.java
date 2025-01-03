class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int streaks = 1;
        int max = 1;
        for(int i=0; i < nums.length - 1; i++){
            if(nums[i+1] == nums[i]){
                continue;
            }else if(nums[i+1] - nums[i] == 1){
                streaks++;
                max = Math.max(max, streaks);
            }else{
                streaks = 1;
            }
        }

        return max;
    }
}