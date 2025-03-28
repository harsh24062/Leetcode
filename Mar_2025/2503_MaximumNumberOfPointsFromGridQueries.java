class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {

        int m = grid.length;
        int n = grid[0].length;

        int k = queries.length;
        int result[] = new int[k];

        //[queries[i],i]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[] { queries[i], i });
        }

        int points = 0;

        // [row,col,grid[row][col]]
        PriorityQueue<int[]> pq_grid = new PriorityQueue<>((a, b) ->a[2]-b[2]);
        pq_grid.offer(new int[] { 0, 0, grid[0][0] });

        boolean visited[][] = new boolean[m][n];
        visited[0][0] = true;

        int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int arr[] = pq.poll();
            int num = arr[0];
            int index = arr[1];

            while (!pq_grid.isEmpty() && pq_grid.peek()[2] < num) {
                int arr_grid[] = pq_grid.poll();
                points++;
                int row = arr_grid[0];
                int col = arr_grid[1];
                for (int d[] : dir) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && !visited[newRow][newCol]) {
                        pq_grid.offer(new int[] { newRow, newCol, grid[newRow][newCol] });
                        visited[newRow][newCol] = true;
                    }
                }
            }

            result[index] = points;

        }

        return result;
    }
}
