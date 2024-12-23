class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] nums2 = new int[len];
        int shift = k % len;

        for(int i=0; i < len - shift ; i++){
            nums2[i+shift] = nums[i];
        }
        for(int i=len-shift; i<len; i++){
            nums2[i-(len-shift)] = nums[i];
        }

        System.arraycopy(nums2, 0, nums, 0, len);
    }
}