class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        int maxLen=0;
        int curLen=0;

        for(int i=0;i<nums.length;i++){
           if(nums[i]>max){
            max=nums[i];
            curLen=0;
            maxLen=0;
           }
           if(nums[i]==max){
            curLen++;
           
           }else curLen=0;
            maxLen=Math.max(curLen,maxLen);
        }

        return maxLen;
    }
}
