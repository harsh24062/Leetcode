// approach -https://www.youtube.com/watch?v=TzsbIDtTlsQ&t=2367s
class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int m=heightMap.length;
        int n=heightMap[0].length;

        int waterStored=0; // result;
   
       boolean visited[][]= new boolean[m][n];

       //[height,row,col]
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

       //store boundary height in pq and mark them visited

       for(int i=0;i<n;i++){
        pq.offer(new int[]{heightMap[0][i],0,i});
        pq.offer(new int[]{heightMap[m-1][i],m-1,i});
        visited[0][i]=true;
        visited[m-1][i]=true;
       }

        for(int i=1;i<m-1;i++){
        pq.offer(new int[]{heightMap[i][0],i,0});
        pq.offer(new int[]{heightMap[i][n-1],i,n-1});
        visited[i][0]=true;
        visited[i][n-1]=true;
       }

       int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};

       while(!pq.isEmpty()){
        int arr[]=pq.poll();
        int height=arr[0];
        int row=arr[1];
        int col=arr[2];

         for(int d[]:dir){
          int nextRow= row + d[0];
          int nextCol= col + d[1];

            if(nextRow>=0 && nextCol>=0 && nextRow<m && nextCol<n && !visited[nextRow][nextCol]){
                waterStored+=Math.max(height-heightMap[nextRow][nextCol],0);

                visited[nextRow][nextCol]=true;
                int newHeight=Math.max(height,heightMap[nextRow][nextCol]);
                pq.offer(new int[]{newHeight,nextRow,nextCol});
            }
         }

       }

      return waterStored;
    }
}
