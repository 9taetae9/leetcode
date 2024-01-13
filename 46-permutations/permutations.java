class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), permutations );
        return permutations;
    }

    public void backtrack(int[] nums, List<Integer> current, List<List<Integer>> permutations){
        if(current.size() == nums.length ){ //goal reached
            permutations.add(new ArrayList<>(current));
            return ;
        }

        for(int i=0; i<nums.length; i++){
            if(current.contains(nums[i])){
                continue;
            }
            
            current.add(nums[i]);
            backtrack(nums, current, permutations);
            current.remove(current.size()-1);
        }
    }
}