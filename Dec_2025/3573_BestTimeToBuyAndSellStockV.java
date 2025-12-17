class Solution {
    static final long NEG_INF = -(long)1e15;
    long dp[][][];

   long solve(int i, int prices[], int k, int state) {
    if (i == prices.length || k == 0) {
        return state == 0 ? 0 : NEG_INF;
    }

    if(dp[i][k][state]!=0)return dp[i][k][state];

    if (state == 0) {
        return dp[i][k][state]= Math.max(
            solve(i+1,prices, k, 0),Math.max(
            -prices[i] + solve(i+1,prices, k, 1),
             prices[i] + solve(i+1,prices, k, 2))
        );
    }

    if (state == 1) {
        return dp[i][k][state]= Math.max(
            solve(i+1,prices, k, 1),
            prices[i] + solve(i+1,prices, k-1, 0)
        );
    }

    return dp[i][k][state]= Math.max(
        solve(i+1,prices, k, 2),
        -prices[i] + solve(i+1,prices, k-1, 0)
    );
}

    public long maximumProfit(int[] prices, int k) {
        dp = new long[prices.length][k+1][3];
        return solve(0,prices,k,0); //0-> neither bought and sell
                                   //1-> previously bought
    }                              //2-> previouslt sell
}
