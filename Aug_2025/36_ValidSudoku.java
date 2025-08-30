class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    char ch=board[i][j];
                    board[i][j]='.';
                  if(!isValid(board,i,j,ch))return false;
                   board[i][j]=ch;
                }
            }
        }
        return true;
    }

    boolean isValid(char board[][], int row, int col, char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c)return false;
            if(board[row][i]==c)return false;

            // check for corresponding 3*3 matrix
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==c)return false;
        }

        return true;
    }
}
