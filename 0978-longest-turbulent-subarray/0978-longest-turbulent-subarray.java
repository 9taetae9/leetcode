class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxSize = 1;
        int up = 1, down = 1;

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] < arr[i+1]){
                up = down + 1;
                down = 1;
            }else if(arr[i] > arr[i+1]){
                down = up + 1;
                up = 1;
            }else{
                up = 1;
                down = 1;
            }
            maxSize = Math.max(maxSize, Math.max(up, down));
        }
        return maxSize;
    }
}