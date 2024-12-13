class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return list;
        }

// 1단계: 후보 탐색
        int can1 = 0; int can2 = 0;
        int cnt1 = 0; int cnt2 =0;

        for(int num : nums){
            if(num == can1){
                cnt1++;
            }else if(num == can2){
                cnt2++;
            }else if(cnt1 == 0){
                can1 = num;
                cnt1=1;
            }else if(cnt2 == 0){
                can2 = num;
                cnt2=1;
            }else{
                cnt1--;
                cnt2--;
            }
        }

// 2단계 : 후보 검증
        cnt1 = 0; cnt2 = 0;
        for(int num : nums){
            if(num == can1) {
                cnt1++; 
            }else if(num == can2){
                cnt2++;
            }
        }

// 3단계 : 결과 생성
        if(cnt1 > nums.length / 3) list.add(can1);
        if(cnt2 > nums.length / 3) list.add(can2);

        return list;
    }
}