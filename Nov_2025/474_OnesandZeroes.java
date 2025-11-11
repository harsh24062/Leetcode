class Solution {

    private int size;
    private int ones[];
    private int zeros[];

    void findOneZero(String s, int index){
        int one=0,zero=0;

        for(char c:s.toCharArray()){
            if(c=='0')zero++;
            else one++;
        }

        ones[index]=one;
        zeros[index]=zero;
    }

    int largestSubset(int index, int m,int n, int dp[][][]){
        if(index>=size)return 0;
        
        if(dp[index][m][n]!=0)return dp[index][m][n];

        //pick
        int pick=0;
        if(ones[index]<=n && zeros[index]<=m){
            pick = 1 + largestSubset(index+1, m-zeros[index], n - ones[index],dp);
        }
        
        // dontPick
        int dontPick = largestSubset(index+1,m,n,dp);

        return dp[index][m][n]=Math.max(pick,dontPick);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        size = strs.length;
        ones = new int[size];
        zeros = new int[size];

        for(int i=0;i<size;i++){
           findOneZero(strs[i],i);
        }

        int dp[][][] = new int[size][m+1][n+1];
        
        return largestSubset(0,m,n,dp);

    }
}
