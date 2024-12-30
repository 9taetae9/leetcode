class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int original = x;
        int reversed = 0;

        while(original != 0){
            int digit = original % 10;
            reversed = 10 * reversed + digit;
            original /= 10;
        }

        return x == reversed;
    }
}