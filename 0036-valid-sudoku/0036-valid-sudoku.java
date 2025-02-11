class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[10];
        //check rows
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                if(!visited[board[i][j]-'0']){
                    visited[board[i][j]-'0'] = true;
                }else{
                    return false;
                }
            }
            Arrays.fill(visited,false);
        }
        //check columns
        for(int j=0; j<9; j++){
            for(int i=0; i<9; i++){
                if(board[i][j] == '.') continue;
                if(!visited[board[i][j]-'0']){
                    visited[board[i][j]-'0'] = true;
                }else{
                    return false;
                }
            }
            Arrays.fill(visited,false);
        }
        //check sub boxes
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                for(int p=0; p < 3; p++){
                    for(int q=0; q<3; q++){
                        if(board[i+p][j+q] == '.') continue;
                        if(!visited[board[i+p][j+q]-'0']){
                            visited[board[i+p][j+q]-'0'] = true;
                        }else{
                            return false;
                        }
                    }
                }
                Arrays.fill(visited,false);
            }
        }


        return true;
    } 
}