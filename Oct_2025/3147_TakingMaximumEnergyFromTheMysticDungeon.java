class Solution {
    int func(int index, int energy[], int k, int started, int dp[][]){
        if(index>=energy.length){
            if(started==0)return Integer.MIN_VALUE;
            return 0;
        }

        if(dp[index][started]!=Integer.MIN_VALUE)return dp[index][started];

        int pick = energy[index] + func(index+k,energy,k,1,dp);
         
        int dontPick = Integer.MIN_VALUE;
        if(started==0){
            dontPick = func(index+1,energy,k,0,dp);
        }
         
        return dp[index][started]=Math.max(pick,dontPick);
    }
    public int maximumEnergy(int[] energy, int k) {
        int dp[][] = new int[energy.length][2];
        for(int d[]:dp){
            Arrays.fill(d,Integer.MIN_VALUE);
        }
        return func(0,energy,k,0,dp); //1-> started, 0 -> did not started
    }
}
