class Solution {
    public int minTimeToReach(int[][] moveTime) {

        int n = moveTime.length;
        int m = moveTime[0].length;
        
         int minTime[][]=new int[n][m];
        for(int mT[]:minTime){
            Arrays.fill(mT,Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0,2});
        minTime[0][0]=0; 

        int directions[][] = {{1,0},{-1,0},{0,-1},{0,1}};

        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            
            int time = arr[0];
            int row = arr[1];
            int col = arr[2];
            int last = arr[3];

            if(row==n-1 && col==m-1) return time;

            for(int dir[]:directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m){
                    int diff = Math.max(0,moveTime[newRow][newCol]-time);
                     
                    int newLast=(last==1)?2:1;

                    int newTime = diff+newLast+time;

                    if(newTime<minTime[newRow][newCol]){
                       minTime[newRow][newCol] = newTime;
                       pq.offer(new int[]{newTime,newRow,newCol,newLast});
                    }
                }
            }
        }
       return -1;
       
    }
} 
