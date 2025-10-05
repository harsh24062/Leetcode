class Solution {
    int m, n;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE); // Pacific left
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE); // Atlantic right
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE); // Pacific top
            dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE); // Atlantic bottom
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        visited[r][c] = true;
        for (int[] d : dirs) {
            dfs(heights, visited, r + d[0], c + d[1], heights[r][c]);
        }
    }
}
