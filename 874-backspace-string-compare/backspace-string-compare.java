class Solution {
    public boolean backspaceCompare(String s, String t) {
        return removeHash(s).equals(removeHash(t));
    }

    public static String removeHash(String s){
        StringBuilder ans = new StringBuilder();

        int hashCount=0;
        for(int i=s.length()-1; i>=0; i--){
            if(hashCount>0 && s.charAt(i)!='#'){
                hashCount--;
                continue;
            }

            if(s.charAt(i) == '#'){
                hashCount++;
            }else{
                ans.insert(0,s.charAt(i));
            }

        }
        return ans.toString();
    }
}
