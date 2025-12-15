class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=0;
        int left=0,right=0;
        while(right<prices.length){
            if(right>0 && prices[right-1]-prices[right]!=1) left=right;
            ans=ans+(right-left+1);
            right++;
        }
        return ans;
    }
}
