class Solution {
     
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int cell[][]=new int[m][n];
        int unGuardcell= m*n -guards.length -walls.length;
        
        // 0 - unGuardCell
        // 1 - guardCell
        // 2 - wallCell
        // 3 - cell guarded by guardCell

        //mark guardCell
        for(int k[]:guards){
            cell[k[0]][k[1]]=1;
        }

        //mark wallCell
        for(int k[]:walls){
            cell[k[0]][k[1]]=2;
        }

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(cell[row][col]==1){
                   
                   //up
                   for(int i=row-1;i>=0;i--){
                     if(cell[i][col]==1 || cell[i][col]==2) break;
                     if(cell[i][col]==0){
                        unGuardcell--;
                        cell[i][col]=3;
                     }
                   }

                   //down
                   for(int i=row+1;i<m;i++){
                    if(cell[i][col]==1 || cell[i][col]==2) break;
                     if(cell[i][col]==0){
                        unGuardcell--;
                        cell[i][col]=3;
                     }
                   }
                
                   //left
                   for(int i=col-1;i>=0;i--){
                   if(cell[row][i]==1 || cell[row][i]==2) break;
                     if(cell[row][i]==0){
                        unGuardcell--;
                        cell[row][i]=3;
                     }
                   }

                   //right
                   for(int i=col+1;i<n;i++){
                      if(cell[row][i]==1 || cell[row][i]==2) break;
                     if(cell[row][i]==0){
                        unGuardcell--;
                        cell[row][i]=3;
                     }
                   }
                }
            }
        }

       return unGuardcell;
    }
}
