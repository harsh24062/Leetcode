// my solution

class Solution {
    private int m,n;
    public int numSubmat(int[][] mat) {
        m=mat.length;
        n=mat[0].length;
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    // go check right
                    int k=j;
                    while(k<n){
                      if(mat[i][k]!=1)break;
                      count++;
                      k++;
                    }
                    //go to down
                    int l=i+1;
                    while(l<m){
                      if(mat[l][j]!=1)break;
                      count++;
                      l++;
                    }

 
                    for(int ni=i+1;ni<l;ni++){
                        if(j+1<n && mat[ni][j+1]==0)break;
                        for(int nj=j+1;nj<k;nj++){
                           if(mat[ni][nj]!=1){
                            k=nj;
                            break;
                           }
                           count++;
                        }
                    }

                    
                }
            }
        }

        return count;
    }
}
