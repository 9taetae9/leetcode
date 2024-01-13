class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, permutations, 0);
        
        return permutations;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> permutations, int start){
        if(start == nums.length){  // Goal reached
            // List<Integer> permutation = new ArrayList<>();
            // for(int e : nums){
            //     permutation.add(e);
            // }
            
            List<Integer> permutation = Arrays.stream(nums).boxed().collect(Collectors.toList());
            permutations.add(new ArrayList<>(permutation));  //add solution to result
            return ;
        }
        
        for(int i=start; i<nums.length; i++){// nums.length => number of choices(NB_CHOICES)
            swap(nums, start, i);  //make choice
            backtrack(nums,permutations, start+1); //backtrack
            swap(nums, start, i);  //undo choice
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
    }
}