class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        boolean checkNext = true;
        StringBuilder longPrefix = new StringBuilder();
        int i = 0;
        while(true){
            if(strs[0].length() - 1 < i) break;
            char temp = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() - 1 < i ||strs[j].charAt(i) != temp){
                    checkNext = false;
                }

            }
            if(!checkNext) break;
            i++;
            longPrefix.append(temp);
        }

        return longPrefix.toString();
    }
}