class Solution {
    static int total;
    int[] queens;
    public int totalNQueens(int n) {
        queens = new int[n];
        total = 0;
        backtrack(0, queens);

        return total;
    }

    private static void backtrack(int row, int[] queens){
        if(row == queens.length){
            total++;
            return ;
        }

        for(int col = 0; col < queens.length; col++){
            if(isSafe(row, col, queens)){
                queens[row] = col;
                backtrack(row+1, queens);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] queens){
        for(int i=0; i<row; i++){
            if(queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)){
                return false;
            }
        }

        return true;
    }
}