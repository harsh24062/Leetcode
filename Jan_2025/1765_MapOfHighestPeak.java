class Solution {
    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        // [height,row,col]
        Queue<int[]> pq= new  LinkedList<>();

        int highestPeak[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(isWater[i][j]==1){
                 pq.offer(new int[]{0,i,j});
                 visited[i][j]=true;
               }
            }
        }

        int dis[][]={{0,1},{0,-1},{1,0},{-1,0}};  // direction

        while(!pq.isEmpty()){
            int arr[] = pq.poll();

            int height= arr[0];
            int row = arr[1];
            int col = arr[2];

            for(int d[]:dis){
               int nextRow = d[0] + row;
               int nextCol = d[1] + col;
               int newHeight = height + 1;

               if(nextRow>=0 && nextRow<m && nextCol>=0 && nextCol<n && !visited[nextRow][nextCol]){
                highestPeak[nextRow][nextCol] = newHeight;
                pq.offer(new int[]{newHeight,nextRow,nextCol});
                visited[nextRow][nextCol]=true;
               }

            }

        }

     return highestPeak;
    }
}
