class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        vector<int> nums2(nums.size());
        for(int i=0; i<nums.size(); i++){
            nums2[nums[i]]++;
        }
        for(int i=1; i<nums2.size(); i++){
            if(nums2[i]>=2) return i;
        }
        return 0;
    }
};