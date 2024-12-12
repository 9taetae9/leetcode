class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int threshold = nums.length / 3;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() > threshold){
                list.add(e.getKey());
            }
        }

        return list;
    }
}