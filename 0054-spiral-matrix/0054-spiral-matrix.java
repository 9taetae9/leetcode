class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();

        int top = 0, bot = matrix.length-1, left = 0, right = matrix[0].length-1;

        while(top <= bot && left <= right){
            if(left <= right){
                int i = left;
                while(i <= right){
                    arr.add(matrix[top][i++]);
                }
            }else break;
            top++;

            if(top <= bot){
                int i = top;
                while(i <= bot){
                    arr.add(matrix[i++][right]);
                }
            }else break;
            right--;

            if(left <= right){
                int i = right;
                while(i >= left){
                    arr.add(matrix[bot][i--]);
                }
            }else break;
            bot--;

            if(top <= bot){
                int i = bot;
                while(i >= top){
                    arr.add(matrix[i--][left]);
                }
            }
            left++;
        } 

        return arr;
    }
}