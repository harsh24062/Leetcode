class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        int ans[][]=new int[n][n];
        
        //bottom left daigonal
        for(int row=0;row<n;row++){
            //non-increase
            PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
            int i=row;
            int j=0;
            while(i<n && j<n){
                pq.offer(grid[i][j]);
                i++;
                j++;
            }
            i=row;
            j=0;
            while(!pq.isEmpty()){
                ans[i][j]=pq.poll();
                i++; j++;
            }
        }

        //top right daigonal

        for(int col=1;col<n;col++){
            //increase
            PriorityQueue<Integer> pq=new PriorityQueue<>();
             int i=0;
            int j=col;
            while(i<n && j<n){
                pq.offer(grid[i][j]);
                i++;
                j++;
            }
            i=0;
            j=col;
            while(!pq.isEmpty()){
                ans[i][j]=pq.poll();
                i++; j++;
            }
        }

        return ans;
    }
}
