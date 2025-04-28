class Solution {
    public long countSubarrays(int[] nums, long k) {

        //sliding window
        long ans=0;
        int left=0,right=0;
        int n=nums.length;
        long sum = 0;
        
        while(right<n){
          sum+=nums[right];

          long score = (sum)*(right-left+1);
          while(score>=k && left<=right){
            sum-=nums[left];
            left++;
            score=(sum)*(right-left+1);
          }

          ans+=right-left+1;
          right++;
        }

        return ans;
    }
}
