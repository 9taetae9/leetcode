class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        
        vector<int> tri_v;
        set<vector<int>> tri_set;
        
        sort(nums.begin(), nums.end());//to use two point approach more effciently.
        for(int i=0; i<nums.size(); i++){
            if(i>0 && nums[i]==nums[i-1]) continue;//skip duplicates of nums[i]
            int left=i+1, right=nums.size()-1;//size()-1 is maximum valid index! 
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                tri_set.insert({nums[i],nums[left],nums[right]});
                //tri_v.push_back(nums[i]);
                //tri_v.push_back(nums[left]);
                //tri_v.push_back(nums[right]);
                //sort(tri_v.begin(), tri_v.end());
                //tri_set.insert(tri_v);
                //tri_v.clear();

                //while(left<right && nums[left]==nums[left+1]) left++;
                //while(left<right && nums[right]==nums[right-1]) right--;
                left++;
                right--;
            } else if(sum<0){
                left++; 
            } else{
                right--; 
            }
            }
        }
        vector<vector<int>> tri_vec(tri_set.begin(), tri_set.end());
        return tri_vec;
    }
};