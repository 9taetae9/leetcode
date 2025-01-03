class Solution {
    public boolean isHappy(int n) {
        Map<String, Integer> map = new HashMap<>();

        while(!map.containsKey(String.valueOf(n))){
            String s = String.valueOf(n);
            int sum = 0;
            for(int i=0; i<s.length(); i++){
                int d =  s.charAt(i) - '0';
                sum += d * d;
            }
            if(sum == 1 || sum == 7) return true;
            if(sum < 10) return false;
            n = sum;
            map.put(s, n);
        }

        return false;
    }
}