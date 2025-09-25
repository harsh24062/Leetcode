class Solution {

    int func(int row, int index, List<List<Integer>> triangle, int dp[][]){
       if(row==triangle.size() || index==triangle.get(row).size())return 0;
       if(dp[row][index]!=Integer.MAX_VALUE)return dp[row][index];
       int firstMove = func(row+1,index,triangle,dp) + triangle.get(row).get(index);
       int secondMove = func(row+1,index+1,triangle,dp) + triangle.get(row).get(index);

       return dp[row][index]=Math.min(firstMove,secondMove);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][triangle.get(n-1).size()];
        for(int d[]:dp){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        return func(0,0,triangle,dp);
    }
}
