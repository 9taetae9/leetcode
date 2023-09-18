class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int output=0;
        for(auto v: nums){
            output^=v;
        }
        return output;
    }
};

//xor(^연산자)
//a ^ 0 = a
//a ^ a = 0