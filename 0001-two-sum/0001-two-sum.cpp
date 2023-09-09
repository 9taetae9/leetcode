class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> output;
        int e=nums.size();
        for(int i=0; i<e-1; i++){
            for(int j=i+1; j<e; j++){
                if(nums[i]+nums[j]==target){
                    output.push_back(i);
                    output.push_back(j);
                    return output;
                }
            }
        }
        return output;
    }
};