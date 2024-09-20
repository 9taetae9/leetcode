class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[6];
        backtrack(new ArrayList<>(), nums, visited, result);
        return result;
    }

    private static void backtrack(List<Integer> temp, int[] nums, boolean[] visited, List<List<Integer>> result){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return ;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(nums[i]);
                backtrack(temp, nums, visited, result);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}