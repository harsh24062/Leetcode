class Solution {
    boolean func(int grid[][],int row,int col){

        // make sure that there are no repeating values
        Set<Integer> set=new HashSet<>();
       for(int i=row;i<row+3;i++){
         for(int j=col;j<col+3;j++){
            if(grid[i][j]>9 || grid[i][j]==0)return false;
           if(set.contains(grid[i][j])) return false;
           set.add(grid[i][j]);
         }
       }

       //colsum
      int colsum1=grid[row][col]+grid[row+1][col]+grid[row+2][col];
      int colsum2=grid[row][col+1]+grid[row+1][col+1]+grid[row+2][col+1];
      int colsum3=grid[row][col+2]+grid[row+1][col+2]+grid[row+2][col+2];
      if(colsum1!=colsum2 || colsum1!=colsum3 || colsum2!=colsum3)return false;

       //rowsum
       int rowsum1=grid[row][col]+grid[row][col+1]+grid[row][col+2];
      int rowsum2=grid[row+1][col]+grid[row+1][col+1]+grid[row+1][col+2];
      int rowsum3=grid[row+2][col]+grid[row+2][col+1]+grid[row+2][col+2];
      if(rowsum1!=rowsum2 || rowsum1!=rowsum3 || rowsum2!=rowsum3)return false;
       //two daigonal
    int d1=grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
    int d2=grid[row][col+2]+grid[row+1][col+1]+grid[row+2][col];
    if(d1!=d2)return false;
  return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length<3 || grid[0].length<3)return 0;
        int count=0;
        for(int i=0;i<=grid.length-3;i++){  // matrix i+3 tak hoga
            for(int j=0;j<=grid[0].length-3;j++){
              if(func(grid,i,j)) count++;
            }
        }
        return count;
    }
}
