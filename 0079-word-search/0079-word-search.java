class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i < board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(isValid(i, j, 0, board, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, int index, char[][] board, String word){
        if(index == word.length()){
            return true;
        }

        if(i>=board.length || i < 0 || j >= board[0].length || j< 0) return false;
        
        if(board[i][j] == '#' || board[i][j] != word.charAt(index)) return false;
        
        char tmp = board[i][j];
        board[i][j] = '#';

        boolean found = 
            isValid(i+1, j, index+1, board, word) ||
            isValid(i, j+1, index+1, board, word) ||
            isValid(i-1, j, index+1, board, word) ||
            isValid(i, j-1, index+1, board, word);
        
        board[i][j] = tmp;
        return found;
    }
}