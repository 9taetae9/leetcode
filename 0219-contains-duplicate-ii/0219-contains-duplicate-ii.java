class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        return IntStream.range(0, nums.length)
            .anyMatch(i -> {
                if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                    return true;
                }
                map.put(nums[i], i);
                return false;
            });
    }
}