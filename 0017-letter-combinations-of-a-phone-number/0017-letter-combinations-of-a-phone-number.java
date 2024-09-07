class Solution {
    private static final String[] LETTERS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()){
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        combineLetters(new StringBuilder(), 0, digits, result);

        return result;
    }

    private void combineLetters(StringBuilder current, int index, String digits, List<String> result){
        if(index == digits.length()){
            result.add(current.toString());
            return ;
        }
        
        int digit = digits.charAt(index) - '0';
        String letters = LETTERS[digit];

        
        for(char letter : letters.toCharArray()){
            current.append(letter);
            combineLetters(current, index+1, digits, result);
            current.setLength(current.length() - 1);
        }

        return ;
    }

    
}

