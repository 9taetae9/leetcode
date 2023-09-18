class Solution {
public:
    int singleNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end()); //정렬
        for(int i=1; i<nums.size(); i+=2){
            if(nums[i]!=nums[i-1])
            return nums[i-1];
        }
        return nums[nums.size()-1]; //마지막에 연속 두 원소 있을 경우
    }
};