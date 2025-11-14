class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int ans[][] = new int[n][n];
        
        for(int q[]:queries){
            int i1=q[0];
            int j1=q[1];
            int i2=q[2];
            int j2=q[3];

            ans[i1][j1]++;
            if(i2+1<n)ans[i2+1][j1]--;
            if(i2+1<n && j2+1<n)ans[i2+1][j2+1]++;
            if(j2+1<n)ans[i1][j2+1]--;
        }

        //col wise sum
        for(int j=0;j<n;j++){
            for(int i=1;i<n;i++){
              ans[i][j]+=ans[i-1][j];
            }
        }
        //row wise sum
         for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
              ans[i][j]+=ans[i][j-1];
            }
        }

        return ans;
    }
}
