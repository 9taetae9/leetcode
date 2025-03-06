class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;

        int maxPos = 0;

        for(int i=0; i<nums.length; i++){
            
            if(i > maxPos){
                return false;
            }

            maxPos = Math.max(maxPos, i+nums[i]);

            if(maxPos >= nums.length-1) return true;
        }

        return false;
        
    }
}