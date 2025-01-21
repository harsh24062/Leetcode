  // logic  https://www.youtube.com/watch?v=7tV3ZMdPodQ
  // shashcode

class Solution {
    public long gridGame(int[][] grid) {

        int n=grid[0].length;
         
        long topTotalSum=0;

        for(int i=0;i<n;i++) topTotalSum+=grid[0][i];

        long bottomTotalSum=0;
        long robot2_points=Long.MAX_VALUE;

        for(int i=0;i<n;i++){
          
            topTotalSum-= grid[0][i];

            long max_points=Math.max(topTotalSum,bottomTotalSum);
            robot2_points=Math.min(max_points,robot2_points);

            bottomTotalSum+= grid[1][i];
        }

        return robot2_points;

    }
}
