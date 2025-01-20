// my approach

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // {numberIngrid,[row,col]} 
        HashMap<Integer,int[]> map=new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }

        int rows[] = new int[m];
        int cols[] = new int[n];

        for(int i=0;i<arr.length;i++){
            int paintedRowCol[]=map.get(arr[i]);

            int row = paintedRowCol[0];
            int col = paintedRowCol[1];

            rows[row]++;
            cols[col]++;

            if(rows[row]==n || cols[col]==m) return i;
        }

        return -1;
    }
}
