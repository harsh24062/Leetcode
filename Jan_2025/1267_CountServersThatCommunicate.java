// my approach

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count=0;

        // check rows

        for(int i=0;i<m;i++){
            int serverFound=-1;
            int server=0;
            for(int j=0;j<n;j++){
             if(serverFound==-1 && grid[i][j]==1) { serverFound=j;  }
             
             if(grid[i][j]==1) {server++; grid[i][j]=-1; }
              
            }
            if(server==1){
             server=0;
             grid[i][serverFound]=1;
            }
            count+=server;
        }

        // check cols

        for(int i=0;i<n;i++){    //cols
            int server=0;
            boolean usedServer=false;
            for(int j=0;j<m;j++)   //rows
            {
              if(grid[j][i]==-1) usedServer=true;

              else if(grid[j][i]==1){
                server++;

              }
            }

            if(usedServer || server>1) count+=server;
        }


        return count;
    }
}
