class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1) return 1;

        int maxSize = 1;
        
        boolean down = true;
        boolean up = true;

        int currSize = 1;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] < arr[i+1]){
                if(up){
                    currSize++;
                }else{
                    currSize = 2;
                }
                up = false; down = true;
            }else if(arr[i] > arr[i+1]){
                if(down){
                    currSize++;
                }else{
                    currSize = 2;
                }
                down = false; up = true;
            }else{
                currSize = 1;
                down = true; up = true;
            }
            maxSize = Math.max(maxSize, currSize);
        }

        return maxSize;
    }
}