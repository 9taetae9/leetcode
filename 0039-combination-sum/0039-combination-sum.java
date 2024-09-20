class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, candidates, target, result);
        return result;
    }

    private static void backtrack(List<Integer> temp, int start, int[] candidates, int remain, List<List<Integer>> result){
        if(remain < 0){
            return ;
        }
        if(remain == 0){
            result.add(new ArrayList<>(temp));
            return ;
        }

        for(int i=start; i < candidates.length; i++){
            temp.add(candidates[i]);
            backtrack(temp, i, candidates, remain - candidates[i], result);
            temp.remove(temp.size()-1);
        }
    }
}