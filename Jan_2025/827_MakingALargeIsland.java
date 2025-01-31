//https://www.youtube.com/watch?v=iCAC-QrQ-4A&t=9s

class Solution {

    int dfs(int row,int col,int grid[][], int group){
        if(row<0 || col<0 || row==grid.length || col==grid.length || grid[row][col]!=1)
        return 0;

        grid[row][col]=group;
        
    int left = dfs(row,col-1,grid,group);
    int right = dfs(row,col+1,grid,group);
    int up = dfs(row-1,col,grid,group);
    int down = dfs(row+1,col,grid,group);
   
   return 1+left+right+up+down;     
    }

    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int maxIsland=0;

        Map<Integer,Integer> map=new HashMap<>();
        int group=2;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int size=dfs(i,j,grid,group);
                    maxIsland=Math.max(size,maxIsland);
                    map.put(group,size);
                    group++;
                }
            }
        } 
      
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          if(grid[i][j]==0){
            
            int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
            Set<Integer> set=new HashSet<>();

            for(int d[]:dir){
              int row=i+d[0];
              int col=j+d[1];

               if(row>=0 && col>=0 && row<n && col<n && grid[row][col]!=0){
                set.add(grid[row][col]);
               }
            }

            int count=1;
            for(int k:set){
                count+=map.get(k);
            }
           maxIsland=Math.max(maxIsland,count);      
          }
        }
      }

        return maxIsland; 
    }
}
