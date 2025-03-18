class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLen=0;
        int left=0,right=0;
        int mask=0;

        while(right<nums.length){
          
          while((mask & nums[right])!=0){
              mask^=nums[left];
              left++;
            }

           mask|=nums[right];
           maxLen=Math.max(maxLen,right-left+1);
           right++;
        }

        return maxLen;
    }
}

