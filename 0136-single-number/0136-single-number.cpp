class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_map<int,int> a;
        for(auto x: nums)
        a[x]++;
        for(auto z:a)
        if(z.second==1)
        return z.first;
        return -1;
    }
};

//xor(^연산자)
//a ^ 0 = a
//a ^ a = 0