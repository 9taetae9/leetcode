class Solution {
    public int removeDuplicates(int[] nums) {
        int newIdx = 0;
        for(int i=0; i<nums.length;){
            int temp = nums[i];
            nums[i] = 10001;
            i++;
            nums[newIdx] = temp;
            newIdx++;

            if(i < nums.length && temp == nums[i]){
                nums[i] = 10001;
                i++;
                nums[newIdx] = temp;
                newIdx++;
                if(i >= nums.length) {
                    return newIdx;
                }
                while(i < nums.length && temp == nums[i]) i++;
            }
        }
        return newIdx;
    }
}