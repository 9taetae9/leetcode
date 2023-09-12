class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() == 0) return 0;  // handle edge case
        
        int pos = 0;  // position to insert next unique number
        
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] != nums[pos]) {
                pos++;
                nums[pos] = nums[i];
            }
        }
        return pos + 1;
    }
};
