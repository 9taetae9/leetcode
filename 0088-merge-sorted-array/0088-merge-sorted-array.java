class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){ //nums1 []일때
            System.arraycopy(nums2, 0, nums1, 0, n);
            return ;
        }
        if(n == 0){ //nums1 []아니고 nums2 []일때
            return ;
        }
        
        int[] newNum = new int[m+n];
        int p = 0; int q = 0;
        for(int i=0; i<newNum.length; i++){
            if(p >= m) {
                newNum[i] = nums2[q++];
            }else if(q >= n){
                newNum[i] = nums1[p++];
            }else{
                newNum[i] = nums1[p] < nums2[q] ? nums1[p++] : nums2[q++];
            }
        }
        
        System.arraycopy(newNum, 0, nums1, 0, m + n);
        return ;
    }
}



//array nums1 array nums2
//non-decreasing => 중복허용 오름차순 
//m : nums1 원소 개수
//n : nums2 원소 개수
// 두개를 중복허용 오름차순으로 nums1에 합치기

//nums1 길이 m+n => m개뒤 n개 원소는 모두 0으로 setting
//nums2 길이 n

