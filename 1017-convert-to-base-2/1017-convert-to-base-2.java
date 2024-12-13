class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            sb.append(n&1); // 
            n = -(n>>1); // -2로 나누기
        }

        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }
}