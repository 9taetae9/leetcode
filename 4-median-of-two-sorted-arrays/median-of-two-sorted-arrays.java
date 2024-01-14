class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] new_nums = new int[len1+len2];

        for(int i=0; i<len1; i++){
            new_nums[i]=nums1[i];
        }

        for(int i=0; i<len2; i++){
            new_nums[len1+i] = nums2[i];
        }

        Arrays.sort(new_nums);
        if(new_nums.length%2 == 1){
            return (double)new_nums[new_nums.length/2];
        }

        return ((double)new_nums[new_nums.length/2-1]+(double)new_nums[new_nums.length/2])/2;
    }
}