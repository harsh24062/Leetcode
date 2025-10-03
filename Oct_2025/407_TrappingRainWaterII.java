class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        boolean visited[][] = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        // add corner
        //add row corner
        for(int i=0;i<m;i++){
          pq.offer(new int[]{heightMap[i][0],i,0});
          pq.offer(new int[]{heightMap[i][n-1],i,n-1});
          visited[i][0]=true;
          visited[i][n-1]=true;
        }
        //add column corner
         for(int i=1;i<n-1;i++){
          pq.offer(new int[]{heightMap[0][i],0,i});
          pq.offer(new int[]{heightMap[m-1][i],m-1,i});
          visited[0][i]=true;
          visited[m-1][i]=true;
        }

        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};

        int waterCount = 0;
        while(!pq.isEmpty()){
          int arr[]=pq.poll();
          int height=arr[0];
          int row=arr[1];
          int col=arr[2];
          
          for(int d[]:dir){
            int newRow = row+d[0];
            int newCol = col+d[1];

            if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && !visited[newRow][newCol]){
                waterCount+=Math.max(height-heightMap[newRow][newCol],0);
                visited[newRow][newCol]=true;
                int newHeight = Math.max(height,heightMap[newRow][newCol]);
                pq.offer(new int[]{newHeight,newRow,newCol});
            }
          }
        }

        return waterCount;
    }
}
