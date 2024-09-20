class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] queens = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                queens[i][j] = '.';
            }
        }

        backtrack(queens, 0, result);

        return result;
    }

    private static void backtrack(char[][] queens, int row, List<List<String>> result){
        if(row == queens.length){
            result.add(constructBoard(queens));
            return ;
        }

        for(int col = 0; col < queens.length; col++){
            if(isSafe(row, col, queens)){
                queens[row][col] = 'Q';
                backtrack(queens, row + 1, result);
                queens[row][col] = '.';
            }
        }

    }

    private static boolean isSafe(int row, int col, char[][] queens){
        for(int i=0; i < row; i++){
            if(queens[i][col] == 'Q') return false;
        }

        for(int i = row - 1, j = col - 1; i>=0 && j >= 0; i--, j--){
            if(queens[i][j] == 'Q') return false;
        }

        for(int i = row - 1, j = col + 1; i>=0 && j < queens.length; i--, j++){
            if(queens[i][j] == 'Q') return false;
        }

        return true;
    }

    private static List<String> constructBoard(char[][] queens){
        List<String> list = new ArrayList<>();
        for(char[] res : queens){
            list.add(new String(res));
        }
        return list;
    }
}