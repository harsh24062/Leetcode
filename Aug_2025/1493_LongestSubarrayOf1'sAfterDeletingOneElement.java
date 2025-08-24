class Solution {
    public int longestSubarray(int[] nums) {
        
        boolean zero=false;
        int max=0;
        int left=0,right=0;
        while(right<nums.length){
            if(nums[right]==0){
             if(!zero){
                zero=true;
             }else{
                while(nums[left]!=0){
                    left++;
                }
                left++;
             }
            }
            max=Math.max(max,right-left);
            right++;
        }
        
        return max;
    }
}
