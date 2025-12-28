class Solution {
    public int countNegatives(int[][] grid) {
     int count=0;
     for(int i=0;i<grid.length;i++){
        for(int j=grid[0].length-1;j>=0;j--){
            if(grid[i][j]>=0)break;
            count++;
        }
     }   
     return count;
    }
}

// binary search

class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            int left = 0, right = cols - 1;
            int firstNeg = cols; // default: no negatives

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (grid[i][mid] < 0) {
                    firstNeg = mid;
                    right = mid - 1; // move left
                } else {
                    left = mid + 1;
                }
            }

            count += cols - firstNeg;
        }

        return count;
    }
}
