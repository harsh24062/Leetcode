class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans=0;
        Arrays.sort(happiness);
        int count=0;

        for(int i=0;i<k;i++){
           long cur=happiness[happiness.length-1-i]-count;
           if(cur>0) ans+=cur;
           count++;
        }
         return ans;
    }
}
