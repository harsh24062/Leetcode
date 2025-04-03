class Solution {
    public long maximumTripletValue(int[] nums) {

        long ans=0;
        long maxDiff=0;
        long maxI=0;

        for(int i:nums){
          ans=Math.max(ans,maxDiff*i);
          maxDiff=Math.max(maxDiff,maxI-i);
          maxI=Math.max(maxI,i);
        }

        return ans;
    }
}
