class Solution {

    private int m,n,index;
    private int ans[];

    void func(int row, int col, int dir, int mat[][]){
       
        if(row>=m || col>=n)return;
        
        // go up
        if(dir==1){
            int i=row;
            int j=col;
            while(i>=0 && j<=n-1){
                ans[index]=mat[i][j];
                index++;
                if(i!=0 && j!=n-1){
                 i--;
                 j++;
                }else break;
                
            }

            if(j==n-1)func(i+1,j,-1,mat);
            else func(i,j+1,-1,mat);
        }
        else{
            int i=row;
            int j=col;
            while(i<=m-1 && j>=0){
                ans[index]=mat[i][j];
                index++;
                if(i!=m-1 && j!=0){
                 i++;
                 j--;
                }else break;
            }

            if(i==m-1)func(i,j+1,1,mat);
            else func(i+1,j,1,mat);
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {

        m=mat.length;
        n=mat[0].length;
        index=0;
        ans = new int[m*n];
        
        // 1-> Go Up , -1 -> Go Down
        func(0,0,1,mat);
        return ans;   
    }
}
