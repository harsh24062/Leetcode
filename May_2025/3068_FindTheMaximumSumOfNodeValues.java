class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        int count=0;
        long minLoss = Long.MAX_VALUE;
        for(int i:nums){
            if((i^k)>i){
                count++;
                sum+=(i^k);
            }else{
                sum+=i;
            }
            minLoss=Math.min(minLoss,Math.abs(i-(i^k)));
        }

        if(count%2==0) return sum;
        return sum-minLoss;
    }
}
