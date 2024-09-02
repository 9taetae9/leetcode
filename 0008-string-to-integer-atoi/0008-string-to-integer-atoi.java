class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        

        int sign = 1;
        int length = s.length();
        int index = 0;
        int res = 0;

        // Step 1: Ignore leading whitespace
        while(index < length && s.charAt(index) == ' '){
            index++;
        }
        // Check if we've reached the end of the string
        if(index == length) return 0;
        
        // Step 2: Check for sign
        if(s.charAt(index) == '-' || s.charAt(index) == '+'){
            sign = (s.charAt(index) == '+') ? 1 : -1;
            index++;
        }

        // Step 3: Convert number and avoid overflow
        while(index < length){
            int digit = s.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            index++;
        }

        return res * sign;

    }
}