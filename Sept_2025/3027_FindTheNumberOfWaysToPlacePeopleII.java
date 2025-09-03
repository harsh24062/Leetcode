class Solution {
    public int numberOfPairs(int[][] points) {
        
         Arrays.sort(points,new Comparator<>(){
            public int compare(int a[],int b[]){
               if(a[0]!=b[0])return a[0]-b[0];
               else return b[1]-a[1];
            }
        });

        int count = 0;
        
        for(int i=0;i<points.length;i++){
            int maxY=Integer.MIN_VALUE; 
         for(int j=i+1;j<points.length;j++){
             if(points[j][1]>maxY && points[j][1]<=points[i][1]){
                count++;
             }
             if(points[i][1]>=points[j][1])
             maxY=Math.max(maxY,points[j][1]);
         }
        }
        
        return count;
    }
}
