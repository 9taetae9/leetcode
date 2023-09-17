class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int result; //for the closest sum
        int min_distance=20000; //minimum dist
        int sum;
        for(int i=0; i<nums.size(); i++){
            int left=i+1,right=nums.size()-1;
            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum==target) return sum;
                int distance=abs(target-sum);
                if(min_distance>distance) {
                    min_distance=distance;
                    result=sum;
                    if(sum>target) right--;
                    else left++;
                }else{
                    if(sum>target) right--;
                    else left++; 
                }
            }  
        }
        return result;  
    }
};