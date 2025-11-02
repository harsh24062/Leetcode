class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        // 0-> unGuarded, 1-> wall, 2-> guard , 3-> guarded my guard
        int grid[][] = new int[m][n];
        int unGuardedCell = m*n;
        
        for(int guard[]:guards){
            grid[guard[0]][guard[1]]=2;
            unGuardedCell--;
        }
        for(int wall[]:walls){
            grid[wall[0]][wall[1]]=1;
            unGuardedCell--;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    //left
                    for(int k=j-1;k>=0;k--){
                        if(grid[i][k]==2 || grid[i][k]==1)break;
                        if(grid[i][k]==0){
                            unGuardedCell--;
                            grid[i][k]=3;
                        }
                    }
                    //right
                    for(int k=j+1;k<n;k++){
                        if(grid[i][k]==2 || grid[i][k]==1)break;
                        if(grid[i][k]==0){
                            unGuardedCell--;
                            grid[i][k]=3;
                        }
                    }
                    //up
                     for(int k=i-1;k>=0;k--){
                        if(grid[k][j]==2 || grid[k][j]==1)break;
                        if(grid[k][j]==0){
                            unGuardedCell--;
                            grid[k][j]=3;
                        }
                     }
                    //down
                     for(int k=i+1;k<m;k++){
                        if(grid[k][j]==2 || grid[k][j]==1)break;
                        if(grid[k][j]==0){
                            unGuardedCell--;
                            grid[k][j]=3;
                        }
                     }
                }
            }
        }

        return unGuardedCell;
    }
}
