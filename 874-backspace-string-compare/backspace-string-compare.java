class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = "";
        String t1 = "";

        for(String ch : s.split("")){
            if(ch.equals("#")){
                if(s1.length() > 0){
                    s1 = s1.substring(0, s1.length() - 1);
                } 
            } else {
                s1 += ch;
            }
        }

        for(String ch : t.split("")){
            if(ch.equals("#")){
                if(t1.length() > 0){
                    t1 = t1.substring(0, t1.length() - 1);
                } 
            } else {
                t1 += ch;
            }
        }

        return t1.equals(s1);
    }
}
