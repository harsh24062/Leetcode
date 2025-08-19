class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        
        int left=0,right=0;

        while(right<nums.length){
            if(nums[right]!=0){
                right++;
                left=right;
            }else{
                ans+=right-left+1;
                right++;
            }
        }

        return ans;
    }
}
