class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int result = nums[0] + nums[1] + nums[2]; // Initialize with first three elements
        int n = nums.size();

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Update result if sum is closer to target than previous result
                if (abs(target - sum) < abs(target - result)) {
                    result = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
};
//For each i, maintain two pointers left and right and move them based on the sum.
//If the sum is greater than the target, move the right pointer to the left (i.e., decrement right) to try and get a smaller sum.
//If the sum is less than the target, move the left pointer to the right (i.e., increment left) to try and get a bigger sum.
