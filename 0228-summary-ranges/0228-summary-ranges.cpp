class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> s;
        if(nums.empty()) return s;
        
        int range_start = nums[0], range_end = nums[0];

        for(int i = 1; i < nums.size(); i++) {
            if(nums[i-1] + 1 == nums[i]) {
                range_end = nums[i];
            } else {
                addRange(s, range_start, range_end);
                range_start = nums[i];
                range_end = nums[i];
            }
        }
        addRange(s, range_start, range_end);
        return s;
    }

private:
    void addRange(vector<string>& s, int range_start, int range_end) {
        if(range_start == range_end) {
            s.push_back(to_string(range_start));
        } else {
            s.push_back(to_string(range_start) + "->" + to_string(range_end));
        }
    }
};
