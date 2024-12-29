class Solution {
    public int alternatingSubarray(int[] nums) {
        int len = nums.length;
        boolean isExist = false;
        boolean start = false;
        int maxLen = 1;
        int curr = 1, prev = 0;
        for(int i=0; i<len-1; i++){
            int c = nums[i+1]-nums[i];
            if(c == 1){
                isExist = true; start = true;
                if(curr == 1){
                    curr++; 
                }else if(prev == -1){
                    curr++;
                }else{
                    curr = 2;
                }
                prev = 1;
            }else if(c==-1 && start){
                if(curr == 1){
                    curr++;
                }else if(prev == 1){
                    curr++;
                }else{
                    curr = 2;
                }
                 prev = -1;
            }else{
                curr = 1; prev = c;
                start = false;
            }

            maxLen = Math.max(maxLen, curr);
        }

        return isExist ? maxLen : -1;
    }
}