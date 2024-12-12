class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNum = new int[m+n];
        int idx1 = 0; int idx2 = 0;
        int idx = 0;

        while(idx1 < m && idx2 < n){
            newNum[idx++] = nums1[idx1] < nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
        }

        while(idx1 < m){
            newNum[idx++] = nums1[idx1++];
        }

        while(idx2 < n){
            newNum[idx++] = nums2[idx2++];
        }        

        System.arraycopy(newNum, 0, nums1, 0, m+n);
    }
}



//array nums1 array nums2
//non-decreasing => 중복허용 오름차순 
//m : nums1 원소 개수
//n : nums2 원소 개수
// 두개를 중복허용 오름차순으로 nums1에 합치기

//nums1 길이 m+n => m개뒤 n개 원소는 모두 0으로 setting
//nums2 길이 n

