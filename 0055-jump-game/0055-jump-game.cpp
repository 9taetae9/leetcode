class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size()==1) return true;
            
        int prev_pos=nums.size()-1;
        int curr_pos=nums.size()-2;
        while(1){
            if(curr_pos+nums[curr_pos]>=prev_pos){
                if(curr_pos==0) return true;
                prev_pos=curr_pos; 
                curr_pos=prev_pos-1; 
            }
            else if(curr_pos>0){
                curr_pos--;
            }
            else return false;
        }
        
    }
};
// [2,3,1,1,4]
// 1.curr_pos+nums[curr_pos]>= last_pos; => ok!
// 2.if(i+nums[i] >=curr_pos) curr_pos=i; 