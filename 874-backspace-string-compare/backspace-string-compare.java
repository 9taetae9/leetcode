class Solution {
    public boolean backspaceCompare(String s, String t) {
        return backspaceResult(s).equals(backspaceResult(t));
    }

    public static String backspaceResult(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '#'){
                st.push(s.charAt(i));
            }else if(!st.isEmpty()){
                st.pop();
            }   
        }
        String s_new = "";
        while(!st.isEmpty()){
            s_new += st.pop();
        }
        return s_new;
    }
}
