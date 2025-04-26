class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int maxI=-1,minI=-1;
        long ans=0;
        int left=-1;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]==minK){
                minI=i;
            }

            if(nums[i]==maxK){
                maxI=i;
            }

            if(nums[i]<minK || nums[i]>maxK){
                left=i;
            }

            if(minI!=-1 && maxI!=-1){
                int smallIndex=Math.min(minI,maxI);
                if(smallIndex-left>0){
                    ans+=smallIndex-left;
                }
            }
        }

        return ans;
    }
}
