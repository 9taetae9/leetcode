class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return list;
        }

        int threshold = nums.length / 3;

        HashMap<Integer,Integer> map = new HashMap<>(nums.length * 2/3 + 1);

        for(int num : nums){
            map.merge(num, 1, Integer::sum); //put, getOrDefault 동시 처리

            if(map.get(num)==threshold+1){
                list.add(num);
            }
        }
        
        return list;
    }
}