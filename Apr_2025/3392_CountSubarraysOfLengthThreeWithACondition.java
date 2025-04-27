class Solution {
    public int countSubarrays(int[] nums) {

        int n = nums.length;
        int ans = 0;
        
        for(int i=0;i<=n-3;i++){
            int sum = nums[i]+nums[i+2];
            if(nums[i+1]%2==0 && sum==nums[i+1]/2)ans++;
        }

        return ans;
    }
}
