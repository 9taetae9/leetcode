class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target) return new int[]{0,0};

        int left = 0;
        int right = nums.length-1;

        int mid = (left + right) / 2;

        while(left <= right){
            int val = nums[mid];
            if(val == target){
                int i = checkLeft(nums, target, mid);
                int j = checkRight(nums, target, mid);
                return new int[]{i,j};
            }else if(val < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

            mid = (left + right) / 2;
        }

        return new int[]{-1,-1};
    }

    private int checkLeft(int[] nums, int target, int idx){
        int temp = 0;
        for(int i=idx-1; i >= 0; i--){
            temp = i;
            if(nums[i] != target){
                return i+1;
            }
        }
        return temp;
    }

    private int checkRight(int[] nums, int target, int idx){
        int temp = 0;
        for(int i=idx+1; i < nums.length; i++){
            temp = i;
            if(nums[i] != target){
                return i-1;
            }
        }
        return temp;
    }
}