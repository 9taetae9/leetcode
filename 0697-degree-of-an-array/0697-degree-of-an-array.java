class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new int[]{1, i, i}); //int[]{freq, start, end}
            }else{
                int[] info = map.get(nums[i]);
                info[0]++;
                info[2] = i;
            }
        }

        int maxFreq = 1;
        int minLength = 50000;

        for(int[] info : map.values()){
            if(maxFreq < info[0]){
                minLength = info[2] - info[1] + 1;
                maxFreq = info[0];
            }else if(maxFreq ==  info[0] && minLength > info[2] - info[1] + 1){
                minLength = info[2] - info[1] + 1;
            }
        }

        return minLength;
    }
}