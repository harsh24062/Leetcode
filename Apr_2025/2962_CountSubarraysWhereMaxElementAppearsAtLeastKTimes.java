class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=0;
        for(int i:nums)max=Math.max(i,max);

        long ans=0;
        int n=nums.length;
        int countMax=0;

        int left=0,right=0;
        while(right<n){
            if(nums[right]==max)countMax++;
            while(countMax==k){
              ans+=n-right;
              if(nums[left]==max)countMax--;
              left++;
            }
            right++;
        }

        return ans;
    }
}
