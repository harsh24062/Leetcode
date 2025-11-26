// dp
class Solution {
    private int m,n;
    int func(int row,int col, int[][] grid, int k, int sum){
       if(row == m || col == n) return 0;
       if(row == m-1 && col == n-1){
         if((sum+grid[row][col])%k==0)return 1;
         return 0;
       }
       //down
       int down = func(row+1,col,grid,k,(sum+grid[row][col])%k);
       //right
       int right = func(row,col+1,grid,k,(sum+grid[row][col])%k);

       return down+right;
    }
    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        
        return func(0,0,grid,k,0);
    }
}


// memorization
class Solution {
    private int m,n;
    int func(int row,int col, int[][] grid, int k, int sum,int dp[][][]){
       if(row == m || col == n) return 0;
       if(row == m-1 && col == n-1){
         if((sum+grid[row][col])%k==0)return 1;
         return 0;
       }
       if(dp[row][col][sum]!=0)return dp[row][col][sum];
       //down
       int down = func(row+1,col,grid,k,(sum+grid[row][col])%k,dp);
       //right
       int right = func(row,col+1,grid,k,(sum+grid[row][col])%k,dp);

       return dp[row][col][sum]=(down+right)%1000000007;
    }
    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int dp[][][] = new int[m][n][k+1];
        return func(0,0,grid,k,0,dp);
    }
}



// tabulation 
class Solution {
 
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m+1][n+1][k+1];
        
        // return statement from memo
        for(int remain = 0;remain<k;remain++){
            dp[m-1][n-1][remain] = (remain+grid[m-1][n-1])%k==0?1:0;
        }

        for(int row=m-1;row>=0;row--){
            for(int col=n-1;col>=0;col--){
                if(row==m-1 && col==n-1)continue;
                for(int remain = 0; remain<k;remain++){
                    //down
                    int down = dp[row+1][col][(remain+grid[row][col])%k];
                    //right
                    int right = dp[row][col+1][(remain+grid[row][col])%k];

                    dp[row][col][remain]=(down+right)%1000000007;
                }
            }
        }

      
        return dp[0][0][0];
    }
}
