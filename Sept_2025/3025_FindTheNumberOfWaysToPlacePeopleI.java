class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,new Comparator<>(){
            public int compare(int a[],int b[]){
                if(a[1]!=b[1])return a[1]-b[1];
                else return b[0]-a[0];
            }
        });
    
        int count =0;

        for(int i=0;i<points.length;i++){
            // if(points[i][0]==0 || points[i][1]==0) continue;
            for(int j=i+1;j<points.length;j++){
                if(points[j][0]<=points[i][0]){
                    boolean flag=false;
                    for(int k=0;k<points.length;k++){
                        if(k==i || k==j)continue;
                        if(points[k][0]>=points[j][0] && points[k][0]<=points[i][0] && points[k][1]<=points[j][1] && points[k][1]>=points[i][1]){
                            flag=true;
                            break;
                        } 
                    }
                    if(!flag)count++;
                }
            }
        }

        return count;
    }
}
