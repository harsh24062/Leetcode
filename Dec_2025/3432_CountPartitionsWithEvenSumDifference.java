class Solution {
    public int countPartitions(int[] nums) {
      int totalSum=0;
        for(int i:nums)totalSum+=i;
        int count=0;
        int curSum=0;
        for(int i=0;i<nums.length-1;i++){
            curSum+=nums[i];
            int rem=totalSum-curSum;
            if(Math.abs(rem-curSum)%2==0)count++;
        }
        return count;
    }
}
