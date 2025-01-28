// by dfs

class Solution {
    int m=0;
    int n=0;

    int dfs(int row, int col, int[][] grid, boolean visited[][]){

        if(row<0 || col<0 || row==m || col==n || visited[row][col] || grid[row][col]==0){
            return 0;
        }

       visited[row][col]=true; 
      
        return (grid[row][col] + dfs(row,col-1,grid,visited) + dfs(row,col+1,grid,visited) + dfs(row+1,col,grid,visited) + dfs(row-1,col,grid,visited));
    }

    public int findMaxFish(int[][] grid) {
      int ans=0;

       m=grid.length;
       n=grid[0].length;

      boolean visited[][] = new boolean[m][n];

      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(!visited[i][j] && grid[i][j]>0){
            ans=Math.max(ans,dfs(i,j,grid,visited));
            }
        }
      }

      return ans;
    }
}



