// My approach -TC O(2n) , SC O(1)
class Solution {
    public int waysToSplitArray(int[] nums) {

       // TC O(n)
        long totalSum=0;
        for(int i:nums) totalSum+=i;
        
        int count=0;
        long curSum=0;

       // TC O(n)
       for(int i=0;i<nums.length-1;i++){
        curSum+=nums[i];
        totalSum-=nums[i];
        if(curSum>=totalSum)count++;
       }

        return count;
    }
}

