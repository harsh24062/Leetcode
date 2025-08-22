class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int top=0,bottom=m-1;
        int left=0,right=n-1;

        // check top
        while(top<=bottom){
            boolean flag=false;
            for(int i=0;i<n;i++){ 
                if(grid[top][i]==1){flag=true; break;}
            }
            if(flag)break;
            top++;
        }
         if(top>bottom)return 0; 
        //check from bottom
        while(bottom>=top){
            boolean flag=false;
            for(int i=0;i<n;i++){
                if(grid[bottom][i]==1){flag=true; break;}
            }
            if(flag)break;
            bottom--;
        }
        

        // check for left

        while(left<=right){
            boolean flag=false;
            for(int i=top;i<=bottom;i++){
                if(grid[i][left]==1){flag=true; break;}
            }
            if(flag)break;
            left++;
        }
        if(left>right)return 0;

          while(left<=right){
            boolean flag=false;
            for(int i=top;i<=bottom;i++){
                if(grid[i][right]==1){flag=true; break;}
            }
            if(flag)break;
            right--;
        }

        //System.out.print(top+" "+bottom+" "+left+" "+right);

        int height=bottom-top+1;
        int length=right-left+1;
        return height*length;
    }
}
