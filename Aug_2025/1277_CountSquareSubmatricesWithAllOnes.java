class Solution {
    boolean func(int[][] matrix,int rowStart,int colStart,int rowEnd,int colEnd){
        if(rowEnd>=matrix.length || colEnd>=matrix[0].length)return false;
          for(int i=rowStart;i<=rowEnd;i++){
            for(int j=colStart;j<=colEnd;j++){
               if(matrix[i][j]==0)return false;
            }
          }
          return true;
    }
    public int countSquares(int[][] matrix) {
        int count=0;
        int m=matrix.length;  //row
        int n=matrix[0].length;  //col

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    int row=i;
                    int col=j;
                    while(func(matrix,i,j,row,col)){
                        count++;
                        row++;
                        col++;
                    }
                }
            }
        }
        return count;
    }
}
