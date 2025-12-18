class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long prefix[] = new long[n];
        long pro_prefix[] = new long[n];

        prefix[0]=(long)prices[0];
        pro_prefix[0]=(long)prices[0]*strategy[0];
        for(int i=1;i<n;i++){
            prefix[i]=(long)prices[i]+prefix[i-1];
            pro_prefix[i]=(long)prices[i]*strategy[i] +  pro_prefix[i-1];
        }

        long ans = pro_prefix[n-1];
        int left=0,right=k-1;
        while(right<n){
            long leftSum_p = (left>0)?pro_prefix[left-1]:0;
            long rightSum_p = pro_prefix[n-1]-pro_prefix[right];
            int mid = (left+right+1)/2;

            long middleSum = prefix[right]-prefix[mid-1];
            ans=Math.max(ans,leftSum_p+rightSum_p+middleSum);
            left++;
            right++;
        }
        return ans;
    }
}
