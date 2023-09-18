class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        int n = nums.size();

        if (n < 4) return result;

        for (int i = 0; i < n - 3; ++i) {
            // Avoid duplicate numbers in the 1st position
            if (i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i + 1; j < n - 2; ++j) {
                // Avoid duplicate numbers in the 2nd position
                if (j > i + 1 && nums[j] == nums[j-1]) continue;

                int left = j + 1, right = n - 1;
                while (left < right) {
                    long long int sum = static_cast<long long int>(nums[i]) + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.push_back({nums[i], nums[j], nums[left], nums[right]});
                        // Avoid duplicate numbers in the 3rd and 4th positions
                        while (left < right && nums[left] == nums[left + 1]) ++left;
                        while (left < right && nums[right] == nums[right - 1]) --right;
                        ++left; --right;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }
        return result;
    }
};
//[ <===1st pos===>  ][<==== 2nd pos  ===> ][ <=== 3rd pos ===> ][ <=== 4th pos ===>]
//[ 연속된 동일 한  값 ][ 연속된 동일 한  값 ][ 연속된 동일 한  값 ][ 연속된 동일 한  값 ]
//이를 skip한다면 Set을 사용할 이유가 없음!
//for루프는 continue로 중복 방지! while 루프 (left, right는 left++, right--해가며 중복 방지)
