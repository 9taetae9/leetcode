class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, new ArrayList<>(), result, n, k);
        return result;
    }

    private static void backtrack(int start, List<Integer> list, List<List<Integer>> result, int n, int k){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return ;
        } 

        for(int i=start; i<=n; i++){
            list.add(i);
            backtrack(i+1, list, result, n, k);
            list.remove(list.size()-1);   
        }
    }
}