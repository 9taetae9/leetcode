class Solution {
    static HashMap<Character, List<String>> map = new HashMap<>();
    static{
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> comb = new ArrayList<>();
        if(digits == null || digits.length() == 0) return comb;
        
        combineLetters(comb, digits, "", 0);
        return comb;
    }

    private void combineLetters(List<String> result, String digits, String current, int index){
        if(index == digits.length()){
            result.add(current);
            return ;
        }

        char c = digits.charAt(index);
        List<String> letters = map.get(c);


        for(String letter : letters){
            combineLetters(result, digits, current + letter, index+1);
        }
        return ;
    }

    
}

