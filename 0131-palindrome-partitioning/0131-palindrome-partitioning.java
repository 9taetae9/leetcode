class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(new ArrayList<>(),s, 0, result);
        return result;
    }

    private static void backtrack(List<String> temp, String s, int start, List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(temp));
        }

        for(int i=start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                temp.add(s.substring(start, i+1));
                backtrack(temp, s, i+1, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }

        return true;
    }
}