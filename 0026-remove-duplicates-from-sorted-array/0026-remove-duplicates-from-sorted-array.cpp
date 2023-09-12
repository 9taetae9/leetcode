class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        set<int> s;
        for(auto e:nums){
            s.insert(e);
        }
        int i=0;
        for(auto e:s){
            nums[i++]=e;
        }
        return s.size();
    }
};