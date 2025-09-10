
// dp - memo
class Solution {
    int mod=1000000007; 
    int func(int start,int n , int delay, int forget, int dp[]){
        if(dp[start]!=-1)return dp[start];
        int count=0;
        for(int i=start+delay;i<start+forget;i++){
            if(i>n)break;
            if(i+forget>n)count++;
            count=(count+func(i,n,delay,forget,dp))%mod;
        }
        return dp[start]=count;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int res = func(1,n,delay,forget,dp);
        return (1+forget>n?res+1:res);
    }
}


// tabulation 

class Solution {
    int mod=1000000007; 

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int dp[] = new int[n+1+delay];

        for(int start=n;start>=1;start--){
            int count=0;
        for(int i=start+delay;i<start+forget;i++){
            if(i>n)break;
            if(i+forget>n)count++;
            count=(count+dp[i])%mod;
        }
          dp[start]=count;
        }

        return (1+forget>n?dp[1]+1:dp[1]);
    }
}
