// memorization

class Solution {

   int func(int n, int x, int minR, int maxR,int dp[][]){
        if(n==0)return 1;
        if(minR>maxR)return 0;
        if(dp[n][minR]!=-1)return dp[n][minR];
        
        int result = (int)Math.pow(minR,x);
        int pick=0;
        //pick
        if(result<=n){
            pick = func(n-result,x,minR+1,maxR,dp);
        }
        
        //dont pick
        int dontpick = func(n,x,minR+1,maxR,dp);

        return dp[n][minR]=(pick+dontpick)%1000000007;
    }

    public int numberOfWays(int n, int x) {
        // System.out.print((int)Math.pow(n,1.0/x));
        int maxR=(int)Math.pow(n,1.0/x)+1;
        int dp[][] = new int[n+1][maxR+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }

        return func(n,x,1,maxR,dp);
    }
}
