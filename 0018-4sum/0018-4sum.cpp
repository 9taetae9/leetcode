class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        set<vector<int>> set_vec;
        sort(nums.begin(),nums.end());
        int vec_size=nums.size();
        vector<vector<int>> output;
        if (vec_size < 4) return output;
        long long int sum_of_last_4 = static_cast<long long int>(nums[vec_size-4]) + static_cast<long long int>(nums[vec_size-3]) + static_cast<long long int>(nums[vec_size-2]) + static_cast<long long int>(nums[vec_size-1]);
if(sum_of_last_4 < target) return output;
              
        for(int i=0; i<=vec_size-4; i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
//Skipping Duplicate Numbers:
//One important thing I've missed is skipping over duplicate
//numbers in main i and j loops to avoid processing the same 
//combination again. For example, if nums[i] is the same as 
//nums[i-1], then you should continue to the next iteration. 
//Do the same for j.
            for(int j=i+1; j<=vec_size-3; j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
//Inner Loop Start Point: inner loop for j always starts at 
//1. However, it should start at i + 1 to ensure that 
//j is always after i, ensuring unique combinations.
//"nums[j]==nums[j-1]" works for all cases except when j is i + 1. 
//In that case, if nums[i + 1] is the same as nums[i], 
//it will skip that iteration, which it shouldn't.
                int left=j+1, right=vec_size-1;
                while(left<right){
                    long long int total = static_cast<long long int>(nums[i]) + static_cast<long long int>(nums[j]) + static_cast<long long int>(nums[left]) + static_cast<long long int>(nums[right]);
                    if(total==target){ 
                    set_vec.insert({nums[i],nums[j],nums[left],nums[right]});
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                    }else if(total<target) left++;
                    else right--; 
                }
            }
        }
        
        for(auto v:set_vec){
            output.push_back(v);
        }
        return output;
    }
};