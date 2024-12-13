import java.util.*;
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int idx1 = arr1.length - 1;
        int idx2 = arr2.length - 1;

        ArrayList<Integer> list = new ArrayList<>();

        int carry = 0;
        while(idx1 >= 0 || idx2 >= 0 || carry != 0){
            if(idx1 >= 0) carry += (arr1[idx1--] & 1);
            if(idx2 >= 0) carry += (arr2[idx2--] & 1);

            list.add(carry & 1);
            carry = -(carry >> 1);
        }

        while(list.size() > 1 && list.get(list.size()-1)==0){
            list.remove(list.size()-1);
        }

        Collections.reverse(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}