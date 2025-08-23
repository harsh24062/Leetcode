class Solution {

    int findSum(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;
        int result=Integer.MAX_VALUE;

        // case 1_divide - Top, Left bottom, Right bottom
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
              int top = minArea(0,i-1,0,n-1,grid);
              int leftB = minArea(i,m-1,0,j-1,grid);
              int rightB = minArea(i,m-1,j,n-1,grid);
              result = Math.min(result,top+leftB+rightB);
            }
        }

         // case 2_divide - bottom, Left top, Right top
          for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
              int bottom = minArea(i,m-1,0,n-1,grid);
              int leftT = minArea(0,i-1,0,j-1,grid);
              int rightT = minArea(0,i-1,j,n-1,grid);
              result = Math.min(result,bottom+leftT+rightT);
            }
        }

        // case 3_ slice 3 by row wise -> top + middle + bottom

        for(int i=1;i<m-2;i++){
          for(int j=i+1;j<m;j++){
           int top = minArea(0,i-1,0,n-1,grid);
           int middle = minArea(i,j-1,0,n-1,grid);
           int bottom = minArea(j,m-1,0,n-1,grid);
           result = Math.min(result,top+middle+bottom);
          }
        }
       
       return result;
    }

    int minArea(int rowS, int rowE, int colS, int colE,int grid[][]){
    
        while(rowS<=rowE){
            boolean flag=false;
            for(int i=colS;i<=colE;i++){
                if(grid[rowS][i]==1){
                    flag=true;
                    break;
                }
            }
            if(flag)break;
            rowS++;
        }

        if(rowS>rowE)return 0;
         while(rowS<=rowE){
            boolean flag=false;
            for(int i=colS;i<=colE;i++){
                if(grid[rowE][i]==1){
                    flag=true;
                    break;
                }
            }
            if(flag)break;
            rowE--;
        }

         while(colS<=colE){
            boolean flag=false;
            for(int i=rowS;i<=rowE;i++){
                if(grid[i][colS]==1){
                    flag=true;
                    break;
                }
            }
            if(flag)break;
            colS++;
        }

        if(colS>colE)return 0;

       while(colS<=colE){
            boolean flag=false;
            for(int i=rowS;i<=rowE;i++){
                if(grid[i][colE]==1){
                    flag=true;
                    break;
                }
            }
            if(flag)break;
            colE--;
        } 
        
        return (colE-colS+1)*(rowE-rowS+1);
    }

    public int minimumSum(int[][] grid) {
       
        int  result = findSum(grid); 
        int[][] rotatedGrid = rotateClockWise(grid);
        result = Math.min(result, findSum(rotatedGrid));
        return result;
    }

       private int[][] rotateClockWise(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rotatedGrid = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedGrid[j][m - i - 1] = grid[i][j];
            }
        }
        return rotatedGrid;
    }
}
