class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int tmp=1;
        for(int i=1; i<nums.size(); i++){
            if(nums[i]==nums[i-1]){
                tmp++;
                if(tmp>2) {
                nums.erase(nums.begin()+i);
                i--; tmp--;
                }
            }else tmp=1;
        }
        return nums.size();
    }    
};
