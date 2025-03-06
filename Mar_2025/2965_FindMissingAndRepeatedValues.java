class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        boolean flag[]=new boolean[(n*n)+1];
        int ans[]=new int[2];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(flag[grid[i][j]])ans[0]=grid[i][j];
                flag[grid[i][j]]=true;
            }
        }

        for(int i=1;i<flag.length;i++){
            if(!flag[i]){
                ans[1]=i;
                break;
            }    
        }

        return ans; 
    }
}
