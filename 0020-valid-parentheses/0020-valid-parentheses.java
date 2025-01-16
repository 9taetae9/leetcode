class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char temp = stack.pop();
                if(c == ')'){
                    if(temp != '(') return false;
                }else if(c == '}') {
                    if(temp != '{') return false;
                }else if(c == ']'){
                    if(temp != '[') return false;
                }
            }
            
        }
        return stack.isEmpty();
    }
}