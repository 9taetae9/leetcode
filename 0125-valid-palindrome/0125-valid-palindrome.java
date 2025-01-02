class Solution {
    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length()-1;
        s = s.toLowerCase();
        while(head < tail){
            if(!('a'<=s.charAt(head) && s.charAt(head)<='z' && !Character.isDigit(s.charAt(head)))){
                head++;
            }else if(!('a'<=s.charAt(tail) && s.charAt(tail) <='z'  && !Character.isDigit(s.charAt(tail)))){
                tail--;
            }else if(s.charAt(head) == s.charAt(tail)){
                head++; tail--;
            }else{
                return false;
            }
        }

        return true;
    }
}